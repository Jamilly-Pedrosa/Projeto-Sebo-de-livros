# 📚 Sistema de Sebo de Livros

## Contexto

O **Sistema de Sebo de Livros** é um projeto desenvolvido para a disciplina de **Projetos de Software** com o objetivo de desenvolver um sistema de computador no padrão MVC e conectado a um banco de
dados relacional, executável pelo terminal.

## **🎯** Objetivo

Gerenciar livros, usuários e transações de compra e venda de um sebo de livros virtual via **linha de comando**, com armazenamento persistente em banco de dados PostgreSQL.

## Atores e Funcionalidades

### 👩‍💼 Administrador

- Gerenciar livros, clientes e transações
- Definir preços de compra e venda com base no estado de conservação do livro

### 👤 Cliente

- Consultar livros disponíveis.
- Comprar livros do sebo.
- Vender livros para o sebo, com preço definido de acordo com o estado de conservação (novo, bom, regular, ruim).

## 🧩 Aplicação do Padrão MVC

O sistema foi desenvolvido seguindo o padrão de arquitetura MVC (Model-View-Controller), que tem como objetivo separar as responsabilidades da aplicação em três camadas principais, tornando o código mais organizado, reutilizável e fácil de manter

### Model (Modelo)

A camada Model representa as entidades e regras de negócio do sistema.
Ela é responsável por armazenar os dados e definir os comportamentos que envolvem a lógica principal do domínio.

📂 Local no projeto: entidades/ e transacao/

📘 Principais classes:

- Livro
- Cliente
- Administrador
- Transacao

Essas classes contêm os atributos, métodos e cálculos que refletem a estrutura dos objetos do sistema.

### View (Visão)

A camada View é responsável pela interação com o usuário, exibindo opções e mensagens, e recebendo as entradas via terminal.

📂 Local no projeto: sistema/

🖥️ Principais classes:

- MenuInicial
- MenuAdministrador
- MenuCliente

Essas classes exibem os menus do sistema e encaminham as ações do usuário para os controladores (Controllers).

### Controller (Controlador)

A camada Controller atua como um intermediário entre a View e o Model, processando as ações do usuário e coordenando as operações de CRUD.

📂 Local no projeto: gerenciamento/

⚙️ Principais classes:

- GerenciamentoLivros
- GerenciamentoClientes
- GerenciamentoTransacao

Essas classes são responsáveis por executar as operações de cadastrar, listar, editar e remover registros, além de manipular os dados em listas (ArrayList).
  
## Tecnologias Utilizadas

- **Java** (Programação Orientada a Objetos)
- **PlantUML** (diagrama de caso de uso)
- **Markdown Preview Mermaid Support** (diagrama de classes)
- **Git e GitHub** (versionamento e documentação)
- **Figma** (protótipo das funcionalidades do sistema)
