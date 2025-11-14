# Gerenciador de Jogadores e Times
Projeto acadêmico full-stack (Backend + Frontend) desenvolvido para a disciplina de Programação Web.
A aplicação consiste em uma API RESTful construída com Spring Boot que gerencia um banco de dados PostgreSQL, e uma interface de usuário (Frontend) construída com HTML e Bootstrap, servida diretamente pelo Spring. O sistema permite o gerenciamento completo (CRUD) de times de futebol e seus respectivos jogadores.

## Funcionalidades Principais
- Gestão de Times (CRUD):
- Listar todos os times.
- Adicionar um novo time.
- Editar um time existente
- Excluir um time, com regra de negócio
- Gestão de Jogadores (CRUD):
- Listar jogadores.
- Adicionar um novo jogador
- Editar um jogador existente.
- Excluir um jogador.
- Navegação: Interface de múltiplas páginas
- Segurança: A senha do banco de dados não está no código, sendo carregada via Variáveis de Ambiente.

## Tecnologias Utilizadas
### Backend:
- Java 25 (JDK)
- Spring Boot
- Maven
- PostgreSQL

### Frontend
- HTML5
- Bootstrap 5
- JavaScript

## Ferramentas
- IntelliJ IDEA
- DBeaver
- Postman

## Configuração e Execução do Projeto
###  Pré-Requisitos
- Java 25 (JDK): O projeto foi compilado com o Java 25.
- Maven: Necessário para gerenciar as dependências.
- Acesso ao Banco: O projeto está configurado para um servidor PostgreSQL específico, conforme os requisitos da disciplina.

### Configuração do Banco de Dados
- O Spring (via Hibernate) criará automaticamente as tabelas (jogador e time) na primeira execução, graças à configuração ddl-auto=update.
- Banco (Database): aula
- Esquema (Schema): bryan_parreiras 

### Configuração da Senha
   Este projeto não armazena a senha do banco no código por motivos de segurança (spring.datasource.password=${DB_PASSWORD}).
Para rodar o projeto no IntelliJ IDEA, você deve configurar a variável de ambiente.


Bryan Parreiras Cruz