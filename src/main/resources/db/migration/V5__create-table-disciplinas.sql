CREATE TABLE disciplinas (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    codigo VARCHAR(20),
    curso_id INT,
    professor_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id),
    FOREIGN KEY (professor_id) REFERENCES professores(id)
);
