
insert into intervenant (type ,id,nom,prenom,email,tel,mp) values ('Formateur',1,'Bob','noblewomen','Bob@bobleprenom.ff','008865444','bob');
insert into intervenant (type ,id,nom,prenom,email,tel,mp) values ('Coordinateur',2,'Bub','lebub','bub@bobleprenom.fr','0145879745','coucou');
insert into centre (id,NOM_CENTRE,ADRESSE_CENTRE,CODES_POSTAL,ville) values (1,'Champlain','45 rue des bordes','94470','chennevieres');
insert into FORMATION(id,TYPE_FORMATION,CENTRE_ID) VALUES ( 1,'CDA',1 );
insert into session (id,date_debut,date_fin,centre_id,formation_id) values (1,'2021-08-21','2022-06-21',1,1);
insert into ACTIVITE (ACTIVITES_TYPES, ACTIVITES_ID) VALUES ( 1,1 );
insert into COMPETENCE (NOM, ACTIVITE_ID) VALUES ( 'concevoir une application en couches',1 );

insert into REAC (DATE_DEBUT, DUREE, LIEN, FORMATION_ID) VALUES ( '2020-01-01',1,'http:afpa.fr',1 );
insert into SEANCE (DATE_DU_JOUR, DEROULEMENT, DUREE, OBJECTIF_PEDA, SUPPORT_USE, FORMATEUR_ID, SESSION_ID) VALUES ( '2022-03-09','tres bien',3,'reussir cette competence','baeldung',1,1 );
insert into SESSION_FORMATEURS (SESSIONS_ID, FORMATEURS_ID) values ( 1,1 );
insert into COMPETENCE_SEANCES (COMPETENCES_ID, SEANCES_ID) VALUES ( 1,1 );
insert into CENTRE_COORDINATEURS (CENTRES_ID, COORDINATEURS_ID) values ( 1,1 );

insert into intervenant (type ,id,nom,prenom,email,tel,mp) values ('Formateur',4,'Bernard','Cruise','Bernard@cruise.ff','0645877988','ledoo');
insert into intervenant (type ,id,nom,prenom,email,tel,mp) values ('Coordinateur',3,'Booba','leduc','mommy@msn.fr','0168974674','kassou');
insert into centre (id,NOM_CENTRE,ADRESSE_CENTRE,CODES_POSTAL,ville) values (2,'Cachan','45 rue Wilson','94210','Cachan');
insert into FORMATION(id,TYPE_FORMATION,CENTRE_ID) VALUES ( 2,'DWWM',2 );
insert into session (id,date_debut,date_fin,centre_id,formation_id) values (2,'2021-08-21','2022-06-21',2,2);
insert into ACTIVITE (ACTIVITES_TYPES, ACTIVITES_ID) VALUES ( 2,2 );
insert into COMPETENCE (NOM, ACTIVITE_ID) VALUES ( 'developper la partie front-end',2 );

insert into REAC (DATE_DEBUT, DUREE, LIEN, FORMATION_ID) VALUES ( '2022-01-01',2,'http:afpa.fr',2 );
insert into SEANCE (DATE_DU_JOUR, DEROULEMENT, DUREE, OBJECTIF_PEDA, SUPPORT_USE, FORMATEUR_ID, SESSION_ID) VALUES ( '2022-03-09','tres bien',4,'ils vont reussir','baeldung',2,2 );
insert into SESSION_FORMATEURS (SESSIONS_ID, FORMATEURS_ID) values ( 2,2 );
insert into COMPETENCE_SEANCES (COMPETENCES_ID, SEANCES_ID) VALUES ( 2,2 );
insert into CENTRE_COORDINATEURS (CENTRES_ID, COORDINATEURS_ID) values ( 2,2 );

insert into intervenant (type ,id,nom,prenom,email,tel,mp) values ('Formateur',6,'Moulin','Timothee','timo@bmoulin.fr','0645878898','ccledoo');


