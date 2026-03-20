# 🚀 Projet Microservices - Architecture & CI/CD avec Helm

Ce projet présente une architecture microservices complète, conteneurisée avec **Docker**, orchestrée par **Kubernetes** via **Helm**, et déployée automatiquement avec **GitHub Actions**.

## 🏗️ Architecture des Services
Le projet est composé de 6 microservices Spring Boot :
* **Config Service** : Serveur de configuration centralisé.
* **Discovery Service** : Annuaire de services (Netflix Eureka).
* **Gateway Service** : Point d'entrée unique (API Gateway).
* **Catalogue Service** : Gestion des produits.
* **Commande Service** : Gestion des commandes clients.
* **Paiement Service** : Gestion des transactions.

## 📦 Technologies utilisées
* **Java 17 / Maven** : Développement et build.
* **Docker** : Création des images de conteneurs.
* **Kubernetes (Minikube)** : Orchestration locale.
* **Helm** : Gestionnaire de paquets pour le déploiement Kubernetes (Charts).
* **GitHub Actions** : Pipeline CI/CD automatisé.

## ⚙️ Pipeline CI/CD
Le workflow `.github/workflows/deploy-helm.yml` automatise les étapes suivantes à chaque push sur `main` :
1. **Build** : Compilation des fichiers JAR avec Maven.
2. **Docker Build** : Création des images Docker pour chaque service.
3. **Docker Push** : Envoi des images sur [Docker Hub](https://hub.docker.com/u/ton_pseudo).
4. **Helm Deploy** : Préparation du déploiement sur le cluster.

## 🚀 Installation locale (Helm)
Pour déployer l'ensemble de l'architecture manuellement :
```bash
helm install config ./charts/config-service
# ... répéter pour les autres services
