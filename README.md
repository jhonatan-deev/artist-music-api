
---

# 🎵 Screen Sound - API de Artistas e Músicas

O **Screen Sound** é uma aplicação desenvolvida em **Java com Spring Boot** que permite o gerenciamento de artistas e músicas com persistência em banco de dados relacional.

O sistema realiza o cadastro de artistas e músicas, garantindo integridade dos dados através de relacionamentos JPA e validações no banco de dados.

Além disso, o projeto foi estruturado seguindo boas práticas de arquitetura em camadas:

* Model (Entidades)
* Repository
* Service (Regras de negócio)
* Controller / Menu

---

## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

---

## 🏗 Estrutura do Projeto

O sistema possui duas entidades principais:

### 🎤 Artista

* id
* nome (único)
* tipo (SOLO, DUPLA, BANDA)
* lista de músicas

### 🎶 Música

* id
* nome
* relacionamento ManyToOne com Artista

O relacionamento é do tipo **1:N (Um artista pode ter várias músicas)**.

---

## 🔐 Regras de Negócio

* O nome do artista é único no banco de dados.
* O tipo do artista é armazenado como ENUM (STRING).
* Cada música pertence obrigatoriamente a um artista.
* O sistema garante integridade através de:

    * Constraint UNIQUE
    * Foreign Key
    * EnumType.STRING

---

## 📌 Funcionalidades

* Cadastrar artista
* Cadastrar música
* Listar músicas
* Buscar músicas por artista

---

## 🗄 Banco de Dados

O projeto utiliza PostgreSQL com geração automática das tabelas via Hibernate (`ddl-auto=update`).

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

* Prática de modelagem relacional com JPA
* Aplicação de relacionamentos 1:N
* Uso de Enum no banco de dados
* Estruturação de regras de negócio no Service
* Organização de projeto em camadas

---