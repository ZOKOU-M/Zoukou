package fr.umontpellier.iut.commandes;

import net.dv8tion.jda.api.entities.Message;

/**
 * Commande
 */

/**
 * <b>Commande est l'interface qui représente une commande du bot discord</b>
 * <p>
 * Pour voir un exemple de commande : {@link Help}
 * </p>
 * 
 * @version 1.0
 */
public interface Commande {

    public void executer(Message messageRecue);
}