package com.example.atventregaguilhermetarifabiblioteca.repository;

import com.example.atventregaguilhermetarifabiblioteca.entity.Livro;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@EnableAutoConfiguration
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByNome(String nome);

//    List<Livro> findByEscritorIgnoreCase(Escritor e);


    List<Livro> findByDataLancamentoLessThanEqual(LocalDate data);

    List<Livro> findByPremioTrue();

    int countByPremioFalse();

    List<Livro> findByDataLancamentoLessThanEqualOrderByValorDesc(LocalDate data);

    List<Livro> findByDataLancamentoLessThanEqualOrderByValorAsc(LocalDate data);


}
