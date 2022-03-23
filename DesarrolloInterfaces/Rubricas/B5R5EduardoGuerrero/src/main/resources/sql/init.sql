CREATE TABLE IF NOT EXISTS Autores (
    ID bigint auto_increment PRIMARY KEY,
    nombre varchar(50),
    fNac date
);

CREATE TABLE IF NOT EXISTS Libros (
    ID bigint auto_increment PRIMARY KEY,
    titulo varchar(50),
    isbn varchar(50),
    autorID bigint REFERENCES Autores (ID)
);