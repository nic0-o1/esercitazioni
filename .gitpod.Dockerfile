FROM gitpod/workspace-full

RUN sudo apt-get update \
    && sudo apt-get install -y sudo apt-get install language-pack-it \
    && sudo rm -rf /var/lib/apt/lists/*

