
CREATE TABLE Bebida
(
  id          INT NULL    ,
  cafe_id     INT NULL    ,
  refresco_id INT NULL    ,
  PRIMARY KEY (id)
);

CREATE TABLE Cafe
(
  id          INT          NULL    ,
  nomProducto VARCHAR(255) NOT NULL,
  cantidad    INT          NOT NULL,
  precio      FLOAT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Cliente
(
  id      INT          NULL    ,
  nombre  VARCHAR(255) NOT NULL,
  logeado BOOLEAN      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Comida
(
  idComida    INT          NULL    ,
  nomProducto VARCHAR(255) NOT NULL,
  cantidad    INT          NOT NULL,
  precio      FLOAT        NOT NULL,
  PRIMARY KEY (idComida)
);

CREATE TABLE Consumicion
(
  idConsumicion   INT NULL    ,
  cliente_id      INT NULL    ,
  comida_idComida INT NULL    ,
  bebida_id       INT NULL    ,
  PRIMARY KEY (idConsumicion)
);

CREATE TABLE Pedido
(
  numPedido                 INT NULL    ,
  trabajador_id             INT NULL    ,
  consumicion_idConsumicion INT NULL    ,
  PRIMARY KEY (numPedido)
);

CREATE TABLE Refresco
(
  id          INT          NULL    ,
  nomProducto VARCHAR(255) NOT NULL,
  cantidad    INT          NOT NULL,
  precio      FLOAT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Trabajador
(
  id        INT          NULL    ,
  nombre    VARCHAR(255) NOT NULL,
  apellidos VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Usuario
(
  id        INT          NULL    ,
  nombre    VARCHAR(255) NOT NULL,
  apellidos VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email    VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

	
ALTER TABLE Bebida
  ADD CONSTRAINT FK_Cafe_TO_Bebida
    FOREIGN KEY (cafe_id)
    REFERENCES Cafe (id);

ALTER TABLE Bebida
  ADD CONSTRAINT FK_Refresco_TO_Bebida
    FOREIGN KEY (refresco_id)
    REFERENCES Refresco (id);

ALTER TABLE Consumicion
  ADD CONSTRAINT FK_Cliente_TO_Consumicion
    FOREIGN KEY (cliente_id)
    REFERENCES Cliente (id);

ALTER TABLE Consumicion
  ADD CONSTRAINT FK_Comida_TO_Consumicion
    FOREIGN KEY (comida_idComida)
    REFERENCES Comida (idComida);

ALTER TABLE Consumicion
  ADD CONSTRAINT FK_Bebida_TO_Consumicion
    FOREIGN KEY (bebida_id)
    REFERENCES Bebida (id);

ALTER TABLE Pedido
  ADD CONSTRAINT FK_Trabajador_TO_Pedido
    FOREIGN KEY (trabajador_id)
    REFERENCES Trabajador (id);

ALTER TABLE Pedido
  ADD CONSTRAINT FK_Consumicion_TO_Pedido
    FOREIGN KEY (consumicion_idConsumicion)
    REFERENCES Consumicion (idConsumicion);

