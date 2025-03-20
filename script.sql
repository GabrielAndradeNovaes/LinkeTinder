CREATE DATABASE linketinder;

CREATE TABLE candidatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    pais VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    descricao TEXT,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    nome_empresa VARCHAR(150) NOT NULL,
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    email_corporativo VARCHAR(150) UNIQUE NOT NULL,
    descricao TEXT,
    pais VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE competencias (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE candidatos_competencias (
    id_candidato INT REFERENCES candidatos(id) ON DELETE CASCADE,
    id_competencia INT REFERENCES competencias(id) ON DELETE CASCADE,
    PRIMARY KEY (id_candidato, id_competencia)
);

CREATE TABLE vagas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    id_empresa INT REFERENCES empresas(id) ON DELETE CASCADE,
    local VARCHAR(100) NOT NULL
);

CREATE TABLE vagas_competencias (
    id_vaga INT REFERENCES vagas(id) ON DELETE CASCADE,
    id_competencia INT REFERENCES competencias(id) ON DELETE CASCADE,
    PRIMARY KEY (id_vaga, id_competencia)
);

CREATE TABLE curtidas (
    id SERIAL PRIMARY KEY,
    id_candidato INT REFERENCES candidatos(id) ON DELETE CASCADE,
    id_empresa INT REFERENCES empresas(id) ON DELETE CASCADE,
    UNIQUE (id_candidato, id_empresa)
);

INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, cep, descricao, senha)
VALUES
('pedro', 'Silva', '1995-08-12', 'pedro@gmail.com', '123.456.789-01', 'Brasil', '12345-678', 'Programador fullstack apaixonado por tecnologia.', 'senha123'),
('João', 'Pereira', '1992-05-23', 'joao.pereira@gmail.com', '987.654.321-00', 'Brasil', '54321-987', 'Engenheiro de software com experiência em backend.', 'senha456');

INSERT INTO empresas (nome_empresa, cnpj, email_corporativo, descricao, pais, cep, senha)
VALUES
('soft', '11.222.333/0001-44', 'contato@soft.com', 'Empresa líder no desenvolvimento de ERPs para restaurantes.', 'Brasil', '11111-222', 'senha789'),
('Tech Solutions', '44.555.666/0001-88', 'rh@techsolutions.com', 'Consultoria de tecnologia com foco em inovação.', 'Brasil', '33333-444', 'senha000');

INSERT INTO competencias (nome)
VALUES
('Java'), ('Python'), ('Groovy'), ('Spring Boot'), ('Angular');

INSERT INTO candidatos_competencias (id_candidato, id_competencia)
VALUES
(1, 1),
(1, 2),
(2, 4);

INSERT INTO vagas (nome, descricao, id_empresa, local)
VALUES
('Desenvolvedor Backend', 'Vaga para atuar com Java e Spring Boot.', 1, 'São Paulo, SP'),
('Desenvolvedor Frontend', 'Precisamos de um especialista em Angular.', 2, 'Rio de Janeiro, RJ');

INSERT INTO vagas_competencias (id_vaga, id_competencia)
VALUES
(1, 1),
(1, 4),
(2, 5);

-- Simulando curtidas (matches)
INSERT INTO curtidas (id_candidato, id_empresa)
VALUES
(1, 1),
(2, 2);