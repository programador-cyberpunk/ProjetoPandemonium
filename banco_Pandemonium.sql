DROP DATABASE IF EXISTS banco_pandemonium;
CREATE DATABASE banco_pandemonium;
USE banco_pandemonium;

CREATE TABLE usuarios(
 id INT AUTO_INCREMENT PRIMARY KEY,
 senha VARCHAR(200) NOT NULL,
 email VARCHAR(200) NOT NULL,
 telefone INT (17) NOT NULL,
 auth_secret VARCHAR(50) -- lembra da porra do 2FA
);
 
	CREATE TABLE armazenamento(
		id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(200) NOT NULL,
        usuario VARCHAR(200) NOT NULL,
        arquivos VARCHAR(200) NOT NULL,
        dataCriacao DATE
    );
    
    CREATE TABLE audio(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeOriginal VARCHAR(200) NOT NULL,
    tipoConteudo VARCHAR(200) NOT NULL,
    tamanho FLOAT,
    duracao FLOAT,
    dataEnvio DATE
    );
	CREATE TABLE pasta(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    dataCriacao DATE
    );
 