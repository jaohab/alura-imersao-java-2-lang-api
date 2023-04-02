package br.com.alura.languages.API;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository <Languages, String> {
    
}
