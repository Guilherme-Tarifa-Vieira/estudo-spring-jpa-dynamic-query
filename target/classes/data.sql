INSERT INTO escritor
    (nome, ano_nascimento)
VALUES ('Stephen King', 1965),
       ('J.R.R Tolkien', 1902),
       ('J.K Rowling', 1985),
       ('Rick Riordan', 1960),
       ('Andre Piper', 1990);
INSERT INTO livro
    (nome, escritor_id, data_lancamento, valor, premio)
VALUES ('O iluminado', 1, '1997-06-11', 75.00, true),
       ('Salem', 1, '1990-07-18', 55.00, true),
       ('Carrie, a estranha', 1, '1975-10-14', 20.00, true),
       ('Harry Potter, relíquias da morte', 3, '2005-09-08', 34.99, true),
       ('Percy Jackson e o ladrão de raios', 4, '2006-10-06', 19.99, false),
       ('O Silmarillion', 2, '1945-06-20', 399.99, true),
       ('O Hobbit', 2, '1930-07-16', 200.00, true),
       ('Senhor dos anéis, a sociedade do anel', 2, '1945-12-25', 15.00, true),
       ('Os condenados', 5, '1958-05-28', 40.00, false),
       ('O demonologista', 5, '1990-09-19', 32.99, false);
