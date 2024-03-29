DROP TABLE UTILISATEUR;
DROP TABLE IDENTIFIANT;

CREATE TABLE IDENTIFIANT (LOGIN VARCHAR(32), MDP VARCHAR(32));
CREATE TABLE UTILISATEUR (LOGIN VARCHAR(32), MDP VARCHAR(32),NOM VARCHAR(32), PRENOM VARCHAR(32), TELDOM VARCHAR(32), TELPOR VARCHAR(32), ADRESSE VARCHAR(32), CP DECIMAL(5), VILLE VARCHAR(32), EMAIL VARCHAR(64), TELPRO VARCHAR(32), PRIMARY KEY(NOM));

INSERT INTO EFREI.UTILISATEUR (NOM, PRENOM, TELDOM, TELPOR, ADRESSE, CP, VILLE, EMAIL, TELPRO)
    VALUES ('Dupont', 'Pierre', '0154789632', '0635287456', '852 avenue de la chance', 89652, 'Bordeaux', 'Pierre.dupont@gmail.com', '0856325632');
INSERT INTO EFREI.UTILISATEUR (NOM, PRENOM, TELDOM, TELPOR, ADRESSE, CP, VILLE, EMAIL, TELPRO)
    VALUES ('James', 'Franck', '0125789634', '0635262626', '46 rue de la paix', 45236, 'Marseille', 'frank@hotmail.fr', '0896325478');
INSERT INTO EFREI.UTILISATEUR (NOM, PRENOM, TELDOM, TELPOR, ADRESSE, CP, VILLE, EMAIL, TELPRO)
    VALUES ('Hector', 'Man', '0125586936', '0636584712', '789 rue de france', 45612, 'Paris', 'pae@live.fr', '0856321478');
INSERT INTO EFREI.UTILISATEUR (NOM, PRENOM, TELDOM, TELPOR, ADRESSE, CP, VILLE, EMAIL, TELPRO)
    VALUES ('Carole', 'Jonhson', '0143589745', '0636696956', '4 impasse de la rue', 78945, 'Toulouse', 'crole@gmail.com', '0528963614');

INSERT INTO EFREI.IDENTIFIANT (LOGIN, MDP)
    VALUES ('admin', 'efreijee');
