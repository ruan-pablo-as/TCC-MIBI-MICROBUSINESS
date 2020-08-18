CREATE TABLE Empresa (
    pkidempresa SERIAL PRIMARY KEY,
    nomeemp VARCHAR (198),
    cnpj VARCHAR,
    enderecoemp VARCHAR,
    numeroenderecoemp VARCHAR,
    complementoemp VARCHAR,
    numerofixoemp BIGINT,
    numerowhats BIGINT,
    emailemp VARCHAR,
    numerowhats1 BIGINT,
    numerowhats2 BIGINT,
    fkidmunicipio BIGINT REFERENCES Municipio(pkidmunicipio),
    UNIQUE (pkidempresa, cnpj, numerowhats, numerowhats2, numerowhats1, emailemp, numerofixoemp)
);
CREATE TABLE Produto (
    pkidproduto BIGINT PRIMARY KEY UNIQUE,
    titulo VARCHAR,
    descricao VARCHAR,
    fkidempresa BIGINT REFERENCES Empresa(pkidempresa),
    preco REAL
);
CREATE TABLE Servico (
    pkidservico BIGINT PRIMARY KEY UNIQUE,
    titulo VARCHAR,
    descricao VARCHAR,
    fkidempresa BIGINT REFERENCES Empresa(pkidempresa),
    preco REAL
);
CREATE TABLE Usuario (
    pkidusuario SERIAL PRIMARY KEY,
    nome VARCHAR,
    sobrenome VARCHAR,
    email VARCHAR,
    senha VARCHAR,
    fkidempresa BIGINT REFERENCES Empresa(pkidempresa),
    fkidmunicipio BIGINT REFERENCES Municipio(pkidmunicipio),
    UNIQUE (pkidusuario, email)
);