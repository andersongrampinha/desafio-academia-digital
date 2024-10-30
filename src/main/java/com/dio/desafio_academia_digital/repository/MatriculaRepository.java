package com.dio.desafio_academia_digital.repository;

import com.dio.desafio_academia_digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    /**
     *
     * @param bairro bairro referência para o filtro
     * @return lista de alunos matriculados que residem no bairro passado como parâmetro
     */
    @Query(value = "SELECT m.aluno_id,  a.nome, a.data_de_nascimento, a.cpf, a.bairro,  m.id, m.data_da_matricula " +
            "FROM tb_matriculas m " +
            "INNER JOIN tb_alunos a ON m.aluno_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true)
    //@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    //List<Matricula> findByAlunoBairro(String bairro);
}
