INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(1,'Cafe solo', 3,2);
INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(2,'Cafe con leche', 3,2);
INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(3,'Cafe cortado', 3,2);
INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(4,'Cafe capuccino', 3,2);
INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(5,'Cafe con hielo', 3,2);
INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(0,'nulo', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(0,'nulo', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(1,'Coca-Cola', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(2,'Kas Naranja', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(3,'Kas Limon', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(4,'Aquarius Naranja', 1,1);
INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(5,'Aquarius Limon', 1,1);
INSERT INTO COMIDA (ID, CANTIDAD , NOM_COMIDA  , PRECIO ) VALUES(0, 0 , 'nulo' , 0);
INSERT INTO BEBIDA  (ID, CANTIDAD , PRECIO , CAFE_ID , REFRESCO_ID  ) VALUES(0, 0 , 0 , 0 , 0);
INSERT INTO CONSUMICION (ID, NOMBRE_CONSUMICION , PRECIO , BEBIDA_ID , COMIDA_ID ) VALUES(0, 'nulo' , 0 , 0 , 0);
INSERT INTO TRABAJADOR (ID, APELLIDOS , EMAIL , NOMBRE , PASSWORD ) VALUES(0, 'Doe' , 'worker@mail.es' , 'Jane ' , 1234);
INSERT INTO USUARIO (ID, APELLIDOS , EMAIL , NOMBRE , PASSWORD ) VALUES(0, 'Doe' , 'user@mail.es' , 'John ' , 12345);
-- INSERT INTO CAFE(ID,nomCafe , CANTIDAD , PRECIO ) VALUES(0,'Cafe nulo', 1,1);
-- INSERT INTO REFRESCO(ID,nomRefresco , CANTIDAD , PRECIO ) VALUES(3,'Coca-Cola', 3,2);
-- INSERT INTO BEBIDA(ID,NOMBRE , PRECIO, CAFE_ID , REFRESCO_ID) VALUES(1,'Coca-Cola', 2 , 1,3);
-- INSERT INTO BEBIDA(ID, CAFE_ID , REFRESCO_ID) VALUES(1, 1 ,3);
