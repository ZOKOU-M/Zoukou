package fr.umontpellier.iut.commandes;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * <b>RepertoireCommandes est la classe qui répertorie toutes les commandes du
 * bot.</b>
 * <p>
 * Elle est caractérisée par :
 * </p>
 * <ul>
 * <li>Une {@code HashMap} qui associe un mot {@code String} à une
 * {@code Commande}</li>
 * </ul>
 * <p>
 * À noter que {@link #REPERTOIRE_DES_COMMANDES} est automatiquement initialisé
 * en static.
 * </p>
 * 
 * @see HashMap
 * @see Commande
 * 
 * @version 1.0
 */
public class RepertoireCommandes {

    /**
     * Répertoire des commandes. Ce répertoire relie un mot-clé à une commande.
     * 
     * @see HashMap
     * @see Commande
     */
    private static final Map<String, Commande> REPERTOIRE_DES_COMMANDES = Map.ofEntries(//
            entry("help", new Help())// Attention le string doit toujours être en minuscule
    );

    /**
     * Retourne la commande associée au premier mot contenue dans le message
     * 
     * @param msg {@code  MessageReceivedEvent} message reçue par un serveur Discord
     * 
     * @return {@code Commande}
     * 
     * @see RepertoireCommandes#REPERTOIRE_DES_COMMANDES
     * @see java.util.HashMap#get(java.lang.Object)
     * @see RepertoireCommandes#getPremierMotDuMessage(MessageReceivedEvent)
     */
    public static Commande getCommande(MessageReceivedEvent msg) {
        String motClef = getPremierMotDuMessage(msg);
        return REPERTOIRE_DES_COMMANDES.get(motClef);
    }

    /**
     * Retourne le premier mot contenu dans le message reçu du serveur
     * 
     * @param msg {@code MessageReceivedEvent} Message reçu du serveur
     * 
     * @return {@code String} Premier mot du message
     * 
     * @see MessageReceivedEvent#getMessage()
     * @see net.dv8tion.jda.api.entities.Message#getContentRaw()
     */
    private static String getPremierMotDuMessage(MessageReceivedEvent msg) {
        return msg.getMessage().getContentRaw().substring(1).split(" ")[0].toLowerCase();
    }

    private RepertoireCommandes() {
        throw new IllegalStateException("Class utilitaire");
    }

}