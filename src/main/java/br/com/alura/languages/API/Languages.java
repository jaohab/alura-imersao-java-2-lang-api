package br.com.alura.languages.API;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "principaisLinguagens")
public record Languages(String name, String image, String ranking) {

    @Id
    static String id;
    
}
