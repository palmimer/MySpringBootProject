insert into BLOGGER (name,email,registration_date) values ('Gyula','gyula@pipike.com',CURRENT_TIMESTAMP())
insert into BLOGGER (name,email,registration_date) values ('Ubulka','ubi@savanyu.com',CURRENT_TIMESTAMP())
insert into STORY (title,content,latest_updated,blogger_id) values ('Első teszt','Teszt tartalom',CURRENT_TIMESTAMP(),(select id from BLOGGER where name='Gyula'))
insert into STORY (title,content,latest_updated,blogger_id) values ('Az én sztorim','Figyeljetek, nagyon érdekes sztorim van!',CURRENT_TIMESTAMP(),(select id from BLOGGER where name='Ubulka'))