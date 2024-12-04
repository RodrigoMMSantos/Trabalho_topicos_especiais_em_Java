CREATE TABLE matriculas (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT,
    turma_id INT,
    FOREIGN KEY (aluno_id) REFERENCES alunos(id),
    FOREIGN KEY (turma_id) REFERENCES turmas(id)
);
