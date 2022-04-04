insert into INTERVENANT (type ,id,adresse,nom,prenom,email,tel,mp) values ('formateur',1,'4rue des bouleaux','Bob','noblewomen','Bob@bobleprenom.ff','008865444','bob');
insert into INTERVENANT (type ,id,adresse,nom,prenom,email,tel,mp) values ('coordinateur',2,'5rue des bouleaux','Bub','lebub','bub@bobleprenom.fr','0145879745','coucou');
insert into INTERVENANT (type ,id,adresse,nom,prenom,email,tel,mp) values ('formateur',3,'11rue des bouleaux','Bernard','Cruise','Bernard@cruise.ff','0645877988','ledoo');


insert into CENTRE (id,NOM_CENTRE,ADRESSE_CENTRE,CODES_POSTAL,ville) values (1,'Champlain','45 rue des bordes','94470','chennevieres');
insert into CENTRE (id,NOM_CENTRE,ADRESSE_CENTRE,CODES_POSTAL,ville) values (2,'Cachan','45 rue Wilson','94210','Cachan');

insert into CENTRE_COORDINATEURS (CENTRES_ID, COORDINATEURS_ID) values ( 1,2 );


insert into FORMATION(id,TYPE_FORMATION) VALUES ( 1,'CDA');
insert into FORMATION(id,TYPE_FORMATION) VALUES ( 2,'DWWM');

insert into REAC (id,DATE_DEBUT, DUREE, LIEN, FORMATION_ID) VALUES (1, '2020-01-01',1,'http:afpa.fr',1 );
insert into REAC (id,DATE_DEBUT, DUREE, LIEN, FORMATION_ID) VALUES ( 2,'2022-01-01',2,'http:afpa.fr',2 );

insert into ACTIVITE (id,ACTIVITES_TYPES,NUM_ORDRE, REAC_ID) VALUES (1, 'developper la partie front-end',1,1 );
insert into ACTIVITE (id,ACTIVITES_TYPES,NUM_ORDRE, REAC_ID) VALUES (2, 'developper la partie back-end',2,2 );

insert into COMPETENCE (id,NOM, num_Fiche_Competence, ACTIVITE_ID ) VALUES (1, 'concevoir une application en couches',10,1 );
insert into COMPETENCE (id,NOM,num_Fiche_Competence, ACTIVITE_ID) VALUES (2, 'developper la partie front-end',20,2 );

insert into SESSION (id,date_debut,date_fin,coordinateur_id,centre_id,formation_id) values (1,'2022-09-25','2023-07-25',2,1,1);
insert into SESSION (id,date_debut,date_fin,coordinateur_id,centre_id,formation_id) values (2,'2021-08-21','2022-06-21',2,2,2);

insert into SEANCE (id,DATE_DU_JOUR, DEROULEMENT, DUREE, OBJECTIF_PEDA, SUPPORT_USE, FORMATEUR_ID, SESSION_ID) VALUES ( 1,'2022-03-09','tres bien',4,'ils vont reussir','baeldung',3,2 );
insert into SEANCE (id,DATE_DU_JOUR, DEROULEMENT, DUREE, OBJECTIF_PEDA, SUPPORT_USE, FORMATEUR_ID, SESSION_ID) VALUES ( 2,'2022-03-19','tres bien',3,'reussir cette competence','baeldung',1,1 );

insert into SESSION_FORMATEURS (SESSIONS_ID, FORMATEURS_ID) values ( 1,1 );
insert into SESSION_FORMATEURS (SESSIONS_ID, FORMATEURS_ID) values ( 2,3 );


insert into COMPETENCE_SEANCES (COMPETENCES_ID, SEANCES_ID) VALUES ( 1,1 );
insert into COMPETENCE_SEANCES (COMPETENCES_ID, SEANCES_ID) VALUES ( 2,2 );



