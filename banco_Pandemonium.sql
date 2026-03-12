CREATE DATABASE Pandemonium;
USE Pandemonium;

CREATE TABLE usuarios(
 id INT AUTO_INCREMENT PRIMARY KEY,
 senha VARCHAR(200) NOT NULL,
 email VARCHAR(200) NOT NULL,
 telefone INT (17) NOT NULL,
 nome_musica VARCHAR(200) NOT NULL,
 nome_banda VARCHAR(200) NOT NULL,
 nivel_acesso VARCHAR(20),
 auth_secret VARCHAR(50) -- lembra da porra do 2FA
);

CREATE TABLE Instrumentos(

-- eu pensei em vc aqui colocar nao so o nome pra vc se exibir, mas tbm qual linha, guitarra lead ,rythm, solo ou drive
 guitarra VARCHAR(200) NOT NULL,
 baixo VARCHAR (200) NOT NULL,
 bateria VARCHAR(200) NOT NULL,
 banjo VARCHAR(200) NOT NULL,
 piano VARCHAR(200) NOT NULL,
 trompete VARCHAR(200) NOT NULL,
 batuque VARCHAR(200) NOT NULL,
 teclado VARCHAR(200) NOT NULL,
 tambor VARCHAR(200) NOT NULL,
 teremim VARCHAR(200) NOT NULL,
 orgao VARCHAR(200) NOT NULL,
 vocal VARCHAR(200) NOT NULL,
 violao VARCHAR(200) NOT NULL,
 viola VARCHAR(200) NOT NULL,
 sintetizador VARCHAR(200) NOT NULL,
 -- fiz tudo o que lembrei caraio
 pedal VARCHAR(100) NOT NULL
 );
 drop table guitarra;
 drop table violao;
 drop table baixo;
 drop table banjo;
 drop table bateria;
 drop table viola;
 drop table teclado;
 drop table piano;
 drop table orgao;
 drop table pedal;
 drop table bateria;
	CREATE TABLE 
 
 