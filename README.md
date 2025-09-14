# Billeterie Electronique - JO 2024

![Angular](https://img.shields.io/badge/Angular-21-c50836?logo=angular) ![TypeScript](https://img.shields.io/badge/TypeScript-5-3178c6?logo=typescript) ![TailwindCSS](https://img.shields.io/badge/Tailwind_CSS-3-38B2AC?logo=tailwind-css) ![Java](https://img.shields.io/badge/java-17-e32c2d?java) ![SpringBoot](https://img.shields.io/badge/SpringBoot-3-74bb13?logo=springBoot) ![MariaDB](https://img.shields.io/badge/MariaDB-12-4e629a?logo=mariadb)

> **Note** : Ce projet est un projet d'étude dans le cadre de mon Bachelor :
> **Développeur d'une solution digitale en JAVA**
> 
> ⚠️ Ce n'est pas l'application officelle pour les Jeux Olympiques 2024.

## 🌟 Fonctionnalités Principales

-   **Authentification Utilisateur** : Inscription, connexion et gestion de session sécurisées.
-   **Achat de Billets** : Les utilisateurs peuvent parcourir les événements, ajouter des billets à leur panier et finaliser leur commande.
-   **Design Responsive** : Entièrement optimisé pour les ordinateurs de bureau, tablettes et appareils mobiles.
-   **Profils Utilisateurs** : Les utilisateurs authentifiés peuvent consulter leur profil et l'historique de leurs achats.
-   **Tableau de Bord Administrateur** : Une interface dédiée pour que les administrateurs puissent gérer les événements et les utilisateurs.
-   **E-Tickets avec QR Codes** : Génération de QR codes uniques pour chaque billet afin de faciliter la validation.
-   **Contrôle d'Accès Basé sur les Rôles** :
    -   **Visiteur** : Peut parcourir les événements et les offres de billets (aucune authentification demandée).
    -   **Utilisateur** : Peut acheter des billets et gérer son compte (authentification obligatoire).
    -   **Admin** : A un contrôle total sur les données de la plateforme (authentification obligatoire).


## 🛠️ Stack Technique

### Frontend
-   **Framework** : [Angular 20](https://angular.dev/) avec [TypeScript](https://www.typescriptlang.org/)
-   **Outil de Build** : [Vite](https://vitejs.dev/)
-   **Styling** : [Tailwind CSS](https://tailwindcss.com/) avec des composants [Shadcn/ui](https://ui.shadcn.com/)
-   **UI/UX** : [Lucide Angular](https://lucide.dev/guide/packages/lucide-angular) pour les icônes.


### Backend
-   **Framework** : [Spring Boot](https://spring.io/projects/spring-boot) (Java 17)
-   **Base de Données** : [MariaDB](https://mariadb.org/)

## 🚀 Démarrage

### Prérequis

-   [Node.js](https://nodejs.org/en/) (v ou supérieure)
-   [Java](https://www.oracle.com/fr/java/technologies/downloads/) (v17 ou supérieure)


### Installation & Configuration

1. **Configurez le Frontend :**

    **Clonez le dépôt :**
    ```bash
    git clone https://github.com/Damtab83/
    cd JO2024Front
    npm install
    ```

2. **Configurez le Backend :**

    **Clonez le dépôt :**
    ```bash
    git clone https://github.com/Damtab83/JO_2024.git
    cd JO2024
    mvn install
    ```
   



------------------------------------------------------------------------------------------------------------------------------

2.  **Configurez le Frontend :**
    ```bash
    # Installez les dépendances
    npm install

    # Créez un fichier .env à la racine du projet et ajoutez vos variables Supabase
    touch .env
    ```
    Votre fichier `.env` pour le frontend doit contenir :
    ```env
    VITE_SUPABASE_URL="VOTRE_URL_SUPABASE"
    VITE_SUPABASE_ANON_KEY="VOTRE_CLE_ANON_SUPABASE"
    ```

3.  **Configurez le Backend :**
    Naviguez vers le dossier du backend et créez un environnement virtuel.
    ```bash
    cd backend-jo
    python -m venv venv
    source venv/bin/activate  # Sur Windows, utilisez `venv\Scripts\activate`

    # Installez les dépendances Python
    pip install -r requirements.txt

    # Créez un fichier .env dans le dossier `backend-jo`
    touch .env
    ```
    Votre fichier `.env` pour le backend doit contenir vos identifiants Supabase :
    ```env
    SUPABASE_URL="VOTRE_URL_SUPABASE"
    SUPABASE_KEY="VOTRE_CLE_SERVICE_ROLE_SUPABASE"
    DATABASE_URL="VOTRE_URL_DATABASE_SUPABASE"
    SECRET_KEY="VOTRE_CLE_SECRETE_JWT" # Générez une clé secrète robuste
    ```

### Lancement de l'Application

1.  **Démarrez le Frontend  :**
    Depuis le dossier racine :
    ```bash
    npm run dev
    ```
    Le frontend sera accessible à l'adresse `http://localhost:5173`. (ou sur le port 8080 si le port 5173 est occupé)

2.  **Démarrez le Backend  :**
    Depuis le dossier `JO2024` (avec l'environnement virtuel activé) :
    ```bash
    uvicorn main:app --reload
    ```
    L'API backend sera accessible à l'adresse `http://localhost:8000`.

## 🏗️ Structure du Projet

```
.
├── JO2024/         # Code source du backend Spring Boot
│   ├── .mvn/           
│   ├── src/                
│       ├── main/          
│           └── java/          
│               └── com.dam.jo2024/
│                   ├── api-ws/         # Controller de l'API
│                   ├── pojo/           # Entitiés
│                   ├── repositories/
│                   ├── services/
│                   ├── ws/             # Controller de la vue client
│                   ├── Jo2024Application       # Point d'entrée de l'application
│                   └── ServletInitializer
│           └── resources/
│       └── HELP.md/
│       └── popm.xml
│       └── README.md
└── External Librairies

```

## 🔐 Authentification & Sécurité

L'application s'appuie sur **Supabase** pour un système d'authentification robuste et sécurisé.
-   **Sessions JWT** : Gestion de session sécurisée à l'aide de JSON Web Tokens.
-   **Hachage de Mots de Passe** : Les mots de passe des utilisateurs sont automatiquement hachés.
-   **Row Level Security (RLS)** : Des politiques de sécurité au niveau des lignes de la base de données PostgreSQL sont appliquées pour garantir que les utilisateurs ne peuvent accéder qu'à leurs propres données. Ceci est configuré directement dans le tableau de bord Supabase.

---

N'hésitez pas à contribuer à ce projet en ouvrant des issues ou des pull requests.
- Authentification
- Panier d'achat
- Préférences utilisateur

## 🛡️ Sécurité

- Protection CSRF
- Validation des données
- Tokens JWT

## 📦 Production

Pour construire l'application pour la production :

```bash
npm run build
```

Les fichiers de production seront générés dans le dossier `dist/`.


## Note importante

Ce site a été réalisé dans le cadre d’un projet scolaire. Toutes les informations qu’il contient sont fictives et ont été volontairement modifiées afin d’éviter toute confusion avec des sources officielles.
Les droits relatifs au contenu original appartiennent exclusivement aux propriétaires du site officiel des Jeux Olympiques.
Pour toute information authentique, veuillez consulter le site officiel des Jeux Olympiques de Paris 2024 (déjà passés) : https://www.olympics.com/cio/paris-2024