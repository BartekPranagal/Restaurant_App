INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Margherita','ciasto, sos pomidorowy, ser, oregano',15.50,true,true);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Capriciosa','ciasto, sos pomidorowy, ser, szynka, pieczarki, oregano',23.20,false,false);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Parma','ciasto, sos pomidorowy, ser mozzarella, szynka dojrzewająca, bazylia świeża, oregano',21.80,true,false);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Campione','ciasto, sos pomidorowy, ser, szynka, kabanosy, boczek wędzony, salami, oregano',21.40,false,false);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Decoro','ciasto, sos pomidorowy, ser, szynka, pieczarki, papryka konserwowa, czosnek, oregano',22.50,true,true);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Napoletana','ciasto, sos pomidorowy, ser, salami, oliwki zielone, papryczki jalapenos, oregano',23.50,false,false);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Di Pesce','ciasto, sos pomidorowy, ser, krewetki tygrysie, papryczki chilli, czosnek, natka pietruszki',23.50,true,false);
INSERT into Pizza(NAME,DESCRIPTION,PRICE,SALE,VEGE) VALUES ('Nachos Pizza Hot','ciasto, sos pomidorowy, ser, salami pepperoni, papryczki jalapenos, nachosy ,oregano',25.50,false,false);

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

