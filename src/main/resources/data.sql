INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Margherita','ciasto, sos pomidorowy, ser, oregano',20.90,29.90,44.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Capriciosa','ciasto, sos pomidorowy, ser, szynka, pieczarki, oregano',24.90,33.90,47.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Parma','ciasto, sos pomidorowy, ser mozzarella, szynka dojrzewająca, bazylia świeża, oregano',25.90,36.90,49.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Campione','ciasto, sos pomidorowy, ser, szynka, kabanosy, boczek wędzony, salami, oregano',25.90,36.90,49.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Decoro','ciasto, sos pomidorowy, ser, szynka, pieczarki, papryka konserwowa, czosnek, oregano',26.90,37.90,50.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Napoletana','ciasto, sos pomidorowy, ser, salami, oliwki zielone, papryczki jalapenos, oregano',27.90,38.90,51.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Di Pesce','ciasto, sos pomidorowy, ser, krewetki tygrysie, papryczki chilli, czosnek, natka pietruszki',27.90,38.90,51.90);
INSERT into Pizza(NAME,DESCRIPTION,SMALL_PRICE,MEDIUM_PRICE,BIG_PRICE) VALUES ('Nachos Pizza Hot','ciasto, sos pomidorowy, ser, salami pepperoni, papryczki jalapenos, nachosy ,oregano',28.90,41.90,59.90);

insert into orders(ORDER_TYPE) values (1);
insert into orders(ORDER_TYPE) values (1);
insert into orders(ORDER_TYPE) values (0);

insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (1,1);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (1,8);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (1,7);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (2,1);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (2,4);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (2,5);
insert into ORDER_PIZZA(ORDER_ID,PIZZA_ID) values (2,1);

insert into USERS (ADRESS,FIRST_NAME,LAST_NAME,ACTIVE,LOGIN,EMAIL,PASSWORD) values ('Lubelska 27','Artur','Dolny',true,'trolololo666','abc@gmail.com','zaq12wsx');
