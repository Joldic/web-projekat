INSERT INTO FITNESS_CENTAR(ADRESA, BROJ_TELEFONA_CENTRALE, E_MAIL, NAZIV) VALUES ('Slobodana bajica', '021-222-333', 'mind@gmail.com', 'Mind and Muscle');

INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (true, '2000-04-30','joldicnenad13@gmail.com', 'Nenad', '1234-56789', 'NenadJ','nenad123','Joldic', 0, 0 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (true, '2001-03-31','peraperic@gmail.com', 'Pera', '423-42342', 'Pera','perica123','Peric', 0, 2 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (true, '2000-08-13','stevanmilicic@gmail.com', 'Stevan', '333-555', 'Stevica','hemija1234','Milicic', 0, 1 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (false, '2000-02-15','lukalucic@gmail.com', 'Luka', '331-3565', 'Lune','luka1234','Lucic', 0, 1 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (true, '1999-05-11','nikolija@gmail.com', 'Nikolija', '101-101', 'nikolija','highlife','Popovic', 0, 1 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (false, '1990-01-11','dado@gmail.com', 'Dado', '323-522', 'dadoP','dado123','Polumenta', 0, 1 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (false, '2000-05-30','aleksastankovic@gmail.com', 'Aleksa', '1234-56711', 'aleksas','aleksa123','Stank', 0, 2 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (false, '1998-04-30','severina@gmail.com', 'Severina', '1234-789', 'severina','severina123','Kojic', 0, 2 , 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, E_MAIL, IME, KONTAKT_TELEFON, KORISNICKO_IME, LOZINKA, PREZIME, PROSECNA_OCENA, ULOGA, FITNESS_CENTAR_ID) VALUES (false, '2001-02-11','vlada@gmail.com', 'Vlada', '1234-089', 'vonta','vlada123','Matovic', 0, 2 , 1);



INSERT INTO SALA(KAPACITET, OZNAKA_SALE, FITNESS_CENTAR_ID) VALUES(100, 'A1', 1);
INSERT INTO SALA(KAPACITET, OZNAKA_SALE, FITNESS_CENTAR_ID) VALUES(90, 'A2', 1);

INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Fitness', 'mrsavljenje', 'funkcionalni', 90, 5);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Cardio', 'izdrzljivost', 'maraton', 120, 2);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Cardio', 'izdrzljivost', 'maraton', 120, 5);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('CrossFit', 'snaga', 'kondicioni', 30, 2);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Joga', 'fleksibilnost', 'pilates', 45, 5);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Fitness', 'mrsavljenje', 'kardio', 60, 3);
INSERT INTO TRENING(NAZIV, OPIS, TIP_TRENINGA, TRAJANJE, KORISNIK_ID) VALUES('Fitness', 'snaga', 'funkcionalni', 10, 2);

INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(3, 2000, '2021-6-18T12:00', 1, 1, 1);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(1, 5000, '2021-6-18T11:00', 1, 1, 2);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(2, 5000,'2021-6-19T13:00', 1, 2, 1);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(17, 1000,'2021-6-20T20:00', 1, 2, 2);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(3, 3000,'2021-6-20T16:00', 1, 1, 6);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(3, 3000,'2021-6-21T07:00', 1, 1, 4);
INSERT INTO TERMIN(BROJ_PRIJAVLJENIH_CLANOVA, CENA, VREME_TERMINA, FITNESS_CENTAR_ID, SALA_ID, TRENING_ID) VALUES(3, 3000, '2021-6-17T22:00', 1, 1, 1);

INSERT INTO PRIJAVA(OCENA, ODRADJEN, KORISNIK_ID, TERMIN_ID) VALUES(0, true, 2, 1);
INSERT INTO PRIJAVA(OCENA, ODRADJEN, KORISNIK_ID, TERMIN_ID) VALUES(0, false, 2, 2);
INSERT INTO PRIJAVA(OCENA, ODRADJEN, KORISNIK_ID, TERMIN_ID) VALUES(0, true, 2, 3);
INSERT INTO PRIJAVA(OCENA, ODRADJEN, KORISNIK_ID, TERMIN_ID) VALUES(0, false,2, 5);
