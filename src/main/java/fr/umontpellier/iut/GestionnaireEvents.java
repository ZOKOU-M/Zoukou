package fr.umontpellier.iut;

import fr.umontpellier.iut.commandes.Commande;
import fr.umontpellier.iut.commandes.RepertoireCommandes;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * <b>GestionnaireEvents est la classe qui gére tous les évenements du bot.</b>
 * 
 * @see ListenerAdapter
 * 
 * @version 1.0
 */
public class GestionnaireEvents extends ListenerAdapter {

    /**
     * La désignation du bot. Cette variable représente le caractère qui permet
     * d'appeler le bot.
     * 
     * Exemple : !help Pour déclancher la commande help du bot.
     * 
     * @see GestionnaireEvents#botEstAppeleParUtilisateur(MessageReceivedEvent)
     */
    private static final char DESIGNATION_BOT = '!';

    /**
     * Exécute la commande choisie par l'utilisateur, s'il en a fait la demande.
     * 
     * @param event {@code MessageReceivedEvent} Recéption du message d'un serveur
     *              discord
     * 
     * @see GestionnaireEvents#botEstAppeleParUtilisateur(MessageReceivedEvent)
     * @see Commande#executer(net.dv8tion.jda.api.entities.Message)
     * @see RepertoireCommandes#getCommande(MessageReceivedEvent)
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (botEstAppeleParUtilisateur(event)) {
            Commande cmd = RepertoireCommandes.getCommande(event);
            if (cmd != null)
                cmd.executer(event.getMessage());
        }
    }

    /**
     * Retourne vrai, si le premier caractère du message correspond à la désignation
     * du bot et s'il n'est l'utilisateur qui envoie le message n'est pas un bot.
     * 
     * @param event {@code MessageReceivedEvent} message reçue par un serveur
     *              discord
     * 
     * @return {@code boolean}
     * 
     * @see GestionnaireEvents#DESIGNATION_BOT
     * @see GestionnaireEvents#onMessageReceived(MessageReceivedEvent)
     */
    private boolean botEstAppeleParUtilisateur(MessageReceivedEvent event) {
        return !event.getAuthor().isBot() && event.getMessage().getContentRaw().charAt(0) == DESIGNATION_BOT;
    }

}
