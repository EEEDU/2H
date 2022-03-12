create table IF NOT EXISTS Alumno(
	id bitint auto_increment PRIMARY KEY,
	nombre varchar(25),
	clase bigint,
	voto int
);

create table IF NOT EXISTS Clase(
	id bigint auto_increment,
	nombre varchar(25)
);

 ALTER TABLE Alumno
    ADD FOREIGN KEY (clase) 
    REFERENCES Clase(id);
    
INSERT INTO Clase (nombre)
VALUES ('1H'),
       ('2H');
    
INSERT INTO Alumno (nombre, clase, voto )
VALUES ('Victor', 1, 0),
       ('Alberto', 2, 0),
       ('Borja', 1, 0),
       ('Jorge', 2, 0),
       ('Sergio', 1, 0),
       ('Guillermo', 2, 0);
