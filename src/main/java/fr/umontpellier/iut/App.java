package fr.umontpellier.iut;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.Compression;

/**
 * <b>App est la classe qui permet d'exécuter le bot.</b>
 * 
 * @version 1.0
 */
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private static final JDABuilder DISCORD_BOT_BUILDER = new JDABuilder(AccountType.BOT)
            .addEventListeners(new GestionnaireEvents()).setCompression(Compression.NONE);

    public static void main(String[] args) {
        verifieArguments(args);
        JDABuilder builder = DISCORD_BOT_BUILDER.setToken(args[0]);
        login(builder);
    }

    private static void verifieArguments(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Veuillez mettre en argument le token du bot discord");
        }
    }

    private static void login(JDABuilder builder) {
        try {
            for (int i = 0; i < 10; i++)
                builder.useSharding(i, 10).build();
        } catch (javax.security.auth.login.LoginException e) {
            LOG.error("Un problème est survenu lors de la connexion.\n Veuillez récrire le token :", e);
            corrigerToken(builder);
            login(builder);
        }
    }

    private static void corrigerToken(JDABuilder builder) {
        Scanner in = new Scanner(System.in);
        builder.setToken(in.next());
        in.close();
    }
}
