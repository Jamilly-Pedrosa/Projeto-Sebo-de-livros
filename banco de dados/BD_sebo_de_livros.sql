-- Conecte-se a sebo_db antes de rodar o restante

-- tabela usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(150) UNIQUE,
  cpf VARCHAR(20),
  papel VARCHAR(20) NOT NULL CHECK (papel IN ('ADMIN','CLIENTE')),
  criado_em TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- tabela livros
CREATE TABLE IF NOT EXISTS livros (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  autor VARCHAR(255),
  genero VARCHAR(50),
  estado VARCHAR(20) NOT NULL CHECK (estado IN ('NOVO','BOM','REGULAR','RUIM')),
  preco_compra NUMERIC(10,2),
  preco_venda NUMERIC(10,2),
  quantidade INTEGER DEFAULT 1,
);

-- tabela transacoes
CREATE TABLE IF NOT EXISTS transacao (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    livro_id INTEGER NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('COMPRA','VENDA')),         -- 'COMPRA' ou 'VENDA'
    quantidade INTEGER NOT NULL DEFAULT 1,
    valor_total NUMERIC(10,2) NOT NULL,
    data_transacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES cliente(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_livro
        FOREIGN KEY (livro_id)
        REFERENCES livro(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

-- dados iniciais de exemplo
INSERT INTO usuarios (nome, email, cpf, papel, senha)
VALUES ('Admin Default', 'admin@sebo.local', '00000000000', 'ADMIN')
ON CONFLICT (email) DO NOTHING;

INSERT INTO usuarios (nome, email, cpf, papel)
VALUES ('Cliente Exemplo', 'cliente@sebo.local', '11111111111', 'CLIENTE')
ON CONFLICT (email) DO NOTHING;

INSERT INTO livros (titulo, autor, genero, estado, preco_compra, preco_venda, quantidade)
VALUES
('O Senhor dos Anéis', 'J. R. R. Tolkien', 'fantasia', 'BOM', 10.00, 25.00, 3),
('Dom Casmurro', 'Machado de Assis', 'literatura', 'REGULAR', 4.00, 12.00, 2)
ON CONFLICT DO NOTHING;
