INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(1,'Cafe solo',2);
INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(2,'Cafe con leche',2);
INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(3,'Cafe cortado',2);
INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(4,'Cafe capuccino',2);
INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(5,'Cafe con hielo',2);
INSERT INTO CAFE(ID,nomCafe , PRECIO ) VALUES(0,'nulo',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(0,'nulo',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(1,'Coca-Cola',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(2,'Kas Naranja',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(3,'Kas Limon',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(4,'Aquarius Naranja',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(5,'Aquarius Limon',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(6,'Coca-Cola Zero',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(7,'Coca-Cola Light',1);
INSERT INTO REFRESCO(ID,nomRefresco , PRECIO ) VALUES(8,'Nestea',1);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(0 , 'nulo' , 0);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(1 , 'macarrones' , 7);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(2 , 'tarta de queso' , 3.5);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(3, 'ensalada' , 5);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(4 , 'porcion de pizza' , 2.5);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(5, 'hamburguesa' , 6);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(6, 'bocadillo' , 6);
INSERT INTO COMIDA (ID , NOM_COMIDA  , PRECIO ) VALUES(7 , 'croissant' , 2.5);

-- INSERT INTO BEBIDA  (ID, CANTIDAD , PRECIO , CAFE_ID , REFRESCO_ID  ) VALUES(0, 0 , 0 , 0 , 0);

-- INSERT INTO CONSUMICION (ID, NOMBRE_CONSUMICION , PRECIO , BEBIDA_ID , COMIDA_ID ) VALUES(0, 'nulo' , 0 , 0 , 0);
INSERT INTO TRABAJADOR (ID, APELLIDOS , EMAIL , NOMBRE , PASSWORD ) VALUES(0, 'Doe' , 'worker@mail.es' , 'Jane ' , '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');
INSERT INTO USUARIO (ID, APELLIDOS , EMAIL , NOMBRE , PASSWORD ) VALUES(0, 'Doe' , 'user@mail.es' , 'John ' , '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');
INSERT INTO USUARIO (ID, APELLIDOS , EMAIL , NOMBRE , PASSWORD ) VALUES(1111, 'Doe' , 'hola@gmail.com' , 'John ' , '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');
-- INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(0,'Cafe nulo', 1,1);
-- INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(3,'Coca-Cola', 3,2);
-- INSERT INTO BEBIDA(ID,NOMBRE , PRECIO, CAFE_ID , REFRESCO_ID) VALUES(1,'Coca-Cola', 2 , 1,3);
-- INSERT INTO BEBIDA(ID, CAFE_ID , REFRESCO_ID) VALUES(1, 1 ,3);
