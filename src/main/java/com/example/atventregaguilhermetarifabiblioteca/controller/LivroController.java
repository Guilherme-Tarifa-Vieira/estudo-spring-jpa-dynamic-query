package com.example.atventregaguilhermetarifabiblioteca.controller;

import com.example.atventregaguilhermetarifabiblioteca.entity.Livro;
import com.example.atventregaguilhermetarifabiblioteca.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @Autowired
    LivroRepository livrosRepository;


    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro livro) {
        Livro livroRegister = this.livrosRepository.save(livro);
        return ResponseEntity.status(201).body(livroRegister);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {

        List<Livro> livros = this.livrosRepository.findAll();

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@Valid @PathVariable long id) {
        return ResponseEntity.of(this.livrosRepository.findById(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<Livro> buscarPorNome(@RequestParam String nome) {

        return ResponseEntity.of(this.livrosRepository.findByNome(nome));

    }

//    @GetMapping("/escritor")
//    public ResponseEntity<List<Livro>> buscarPorEscritor(@RequestParam Escritor e) {
//
//        List<Livro> livrosFiltrados = this.livrosRepository.findByEscritorIgnoreCase(e);
//
//
//        if (livrosFiltrados.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//
//        return ResponseEntity.status(200).body(livrosFiltrados);
//    }

    @GetMapping("/periodo/{data}")
    public ResponseEntity<List<Livro>> buscarPorDataAte(@PathVariable LocalDate data) {

        List<Livro> livrosFiltrados = this.livrosRepository.findByDataLancamentoLessThanEqual(data);


        if (livrosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(livrosFiltrados);
    }

    @GetMapping("/premios")
    public ResponseEntity<List<Livro>> buscarSomenteIndicados() {


        List<Livro> livrosFiltrados = this.livrosRepository.findByPremioTrue();

        if (livrosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(livrosFiltrados);
    }

    @GetMapping("/sem-premios/quantidade")
    public ResponseEntity<Integer> contarSomenteNaoPremiados() {

        int count = this.livrosRepository.countByPremioFalse();
        return ResponseEntity.status(200).body(count);
    }

    @GetMapping("/valor/{data}/maior-menor")
    public ResponseEntity<List<Livro>> buscarLivrosCustoOrdemDec(@PathVariable LocalDate data) {

        List<Livro> livrosFiltrados = this.livrosRepository.findByDataLancamentoLessThanEqualOrderByValorDesc(data);

        if (livrosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }


        return ResponseEntity.status(200).body(livrosFiltrados);
    }

    @GetMapping("/valor/{data}/menor-maior")
    public ResponseEntity<List<Livro>> buscarLivrosCustoOrdemAsc(@PathVariable LocalDate data) {

        List<Livro> livrosFiltrados = this.livrosRepository.findByDataLancamentoLessThanEqualOrderByValorAsc(data);

        if (livrosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }


        return ResponseEntity.status(200).body(livrosFiltrados);
    }
}
