![GitHub Actions](https://github.com/DevLab-umontp/template-DiscordBot/workflows/Java%20CI%20with%20Maven/badge.svg)
[![JavaDoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://mathieusoysal.github.io/stats/template-discordbot)
# ![](ressources/devicon.png) Template Discord Bot
Créer votre propre bot Discord en quelques clics en récupérant le template !

[![](https://dabuttonfactory.com/button.png?t=Utiliser+le+template&f=Open+Sans-Bold&ts=14&tc=444&hp=20&vp=10&c=11&bgt=unicolored&bgc=f3f3f3&bs=2&bc=999&shs=1&shc=eee&sho=sw)](http://use.template-discordbot.umontp.fr/)
## Prérequis : 

- [Java SE 11 ou plus](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
- [Maven](https://maven.apache.org/)
- [Avoir obtenu le token de son bot](https://discord.com/developers/applications)

## Commande à effectuer pour lancer le bot : 

- `mvn clean compile assembly:single`
- `java -jar fichier.jar TOKEN_DU_BOT`

## Rapide tuto pour ajouter une commande au sein du bot
Le but du tuto est d'ajouter une commande *ping* au sein du bot, qui devra renvoyer le message *"pong!"*.

### Première étape créer la class `Ping`

Rendez-vous dans le dossier qui se nomme *commandes* et créez-y le fichier `Ping.java`

Au sein du fichier placez-y le code suivant : 

```java
package fr.umontpellier.iut.commandes;

import net.dv8tion.jda.api.entities.Message;

public class Ping implements Commande {

    @Override
    public void executer(Message messageRecue) {
        messageRecue.getChannel().sendMessage("pong!").queue();
    }

}
```

> Il est primordial que la class implémente l'interface *Commande*

### Deuxième étape associer un texte à la commande

Dans notre cas nous voulons que notre bot lance la commande lorsqu'il reçois le message "ping".

Pour cela rendez-vous dans le fichier `RepertoireCommandes.java` et ajoutez à la *ligne 39* le code suivant : 
```java
        entry("ping", new Ping()),
```

### Finiis
Et voilà le résultat, une fois le bot [lancé](https://github.com/DevLab-umontp/template-DiscordBot/#commande-%C3%A0-effectuer-pour-lancer-le-bot-) : 

![image](https://user-images.githubusercontent.com/43273304/107413672-4c151c00-6b11-11eb-98f4-e8e4ada5452a.png)

À vous de laisser libre cours à votre imagination pour ajouter une multitude de nouvelles fonctionnalités.
