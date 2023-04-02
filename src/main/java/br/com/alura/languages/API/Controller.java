package br.com.alura.languages.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {

    @Autowired
    private Repository repo;
    
    @GetMapping ("/linguagem")
    public String getContent() {
        return "<h1>Oi Java.</h1>";
    }

    // Create
    @PostMapping ("/api-linguagens")
    public ResponseEntity<Languages> postLanguages(@RequestBody Languages newLang) {
        return new ResponseEntity<> (repo.save(newLang), HttpStatus.CREATED);
    }

    // Read all
    @GetMapping ("/api-linguagens")
    public List<Languages> getLanguages() {
        return repo.findAll();
    }

    // Read by ID
    @GetMapping ("/api-linguagens/{id}")
    public Languages getLanguageById(@PathVariable String id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Update by ID
    @PutMapping ("/api-linguagens/{id}")
    public Languages setLanguageById(@PathVariable String id, @RequestBody Languages setLang) {
        repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return repo.save(setLang);
    }

    // Delete by ID
    @DeleteMapping ("/api-linguagens/{id}")
    public void removeLanguageById(@PathVariable String id) { 
        repo. deleteById(id);
    }
}
