# 📚 Sistema de Sebo de Livros

## Contexto

O Sistema de Sebo de Livros é um projeto desenvolvido para a disciplina de Projetos de Software, com foco em aplicar o padrão de arquitetura MVC e criar um modelo de banco de dados relacional que represente a estrutura de persistência do sistema.

Atualmente, o sistema funciona via linha de comando, utilizando coleções em Java para manipular os dados. O banco de dados PostgreSQL foi desenvolvido como modelo conceitual e relacional para representar como a persistência funcionaria caso fosse integrada futuramente ao sistema.

## **🎯** Objetivo

Gerenciar livros, usuários e transações de compra e venda de um sebo de livros virtual, permitindo operações de administração e uso de clientes através de menus interativos.

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


## 🗄️ Modelo de Banco de Dados Relacional (PostgreSQL)

Como parte da Entrega 03, foi criado um modelo relacional representando a persistência do sistema, possuindo três relacionamentos entre tabelas, conforme solicitado.

### Objetivos do Banco de Dados
- Representar usuários e seus papéis (ADMIN/CLIENTE)
- Armazenar livros e seus estados de conservação
- Registrar transações de compra e venda
- Garantir integridade referencial entre entidades
  
### Estrutura das Tabelas

#### Tabela usuarios
Armazena administradores e clientes, diferenciados pelo campo `papel`.

#### Tabela livros
Contém informações sobre livros disponíveis para compra e venda.

#### Tabela transacoes
Registra operações de compra/venda entre clientes e o sebo.

### Relacionamentos

1. `usuarios (CLIENTE)` → `transacoes`
2. `livros` → `transacoes`
3. Regras de papel e integridade para diferenciar administrador e cliente

Esses relacionamentos garantem rastreabilidade e consistência entre as operações.

## Tecnologias Utilizadas

- **Java (POO)** — lógica e estrutura do sistema
- **PostgreSQL** — modelagem do banco de dados
- **PlantUML** — diagramação de caso de uso
- **Mermaid (Markdown)** — diagrama de classes
- **Git e GitHub** — versionamento e documentação
- **Figma** — protótipo das telas e fluxo visual
