package fr.umontpellier.iut.commandes;

import net.dv8tion.jda.api.entities.Message;

/**
 * Commande Help
 * 
 * @see Commande
 * 
 * @version 1.0
 */

/**
 * <b>Help est la classe représentant une commande "help" du bot Discord.</b>
 * 
 * @see Commande
 * 
 * @version 1.0
 */
public class Help implements Commande {

    /**
     * Envoie un message dans le channel où le message a été reçu.
     * 
     * @param messageRecue {@code Message}
     * 
     * @see Message#getChannel()
     * @see net.dv8tion.jda.api.entities.MessageChannel#sendMessage(CharSequence)
     */
    @Override
    public void executer(Message messageRecue) {
        String reponse = " La demande d'aide a été entendue.";
        messageRecue.getChannel().sendMessage(reponse).queue();
    }

}
