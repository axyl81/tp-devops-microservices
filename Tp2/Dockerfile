FROM ubuntu:22.04

# Installation des dépendances de base
RUN apt-get update && apt-get install -y \
    curl \
    conntrack \
    docker.io \
    sudo

# Installation de kubectl (le volant pour piloter Kubernetes)
RUN curl -LO https://dl.k8s.io/release/v1.29.0/bin/linux/amd64/kubectl \
    && install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

# Installation de minikube (le cluster local)
RUN curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
    && install minikube-linux-amd64 /usr/local/bin/minikube

CMD ["/bin/bash"]