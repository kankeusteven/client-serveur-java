# Application Client–Serveur Java

Application réseau client–serveur développée en Java dans le cadre du cursus ingénieur à l'ESEO Vélizy.  
Elle illustre les principes de communication réseau, de gestion des connexions et de déploiement distribué.

---

## Fonctionnalités

- Serveur multi-clients via sockets TCP
- Échange de messages en temps réel entre client et serveur
- Gestion des connexions et déconnexions propres
- Architecture modulaire et versionnée avec Git

---

## Architecture


---

## Technologies utilisées

| Technologie | Usage |
|-------------|-------|
| Java 17     | Langage principal |
| Sockets TCP | Communication réseau |
| Threads     | Gestion multi-clients |
| Git / GitHub | Versioning et collaboration |

---

## Lancer le projet

### Prérequis
- Java 17+
- Git

### Étapes

```bash
# Cloner le repo
git clone https://github.com/kankeusteven/client-serveur-java.git
cd client-serveur-java

# Compiler
javac Server.java
javac Client.java

# Lancer le serveur (dans un terminal)
java Server

# Lancer le client (dans un autre terminal)
java Client
```

---

## Ce que j'ai appris

- Implémentation de la communication TCP avec `java.net.Socket`
- Gestion de plusieurs clients simultanés avec des threads
- Organisation d'un projet en équipe avec Git (branches, pull requests)
- Débogage d'incidents réseau (ports, connexions refusées)

---

## Auteur

**Steven Nomessi** — Étudiant Ingénieur Cloud & Infrastructure, ESEO Vélizy  
[LinkedIn](https://linkedin.com/in/steven-nomessi) · [GitHub](https://github.com/kankeusteven)
