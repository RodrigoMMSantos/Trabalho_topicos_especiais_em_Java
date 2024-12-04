CREATE TABLE turmas (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ano INT,
    semestre INT,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
