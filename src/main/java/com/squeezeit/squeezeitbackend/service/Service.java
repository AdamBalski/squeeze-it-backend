package com.squeezeit.squeezeitbackend.service;

import com.squeezeit.squeezeitbackend.dto.MinifiedDto;
import com.squeezeit.squeezeitbackend.dto.OriginalDto;
import com.squeezeit.squeezeitbackend.util.Generator;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@org.springframework.stereotype.Service
public class Service {
    private final Generator generator;

    public Service(Generator generator) {
        this.generator = generator;
    }

    public MinifiedDto getMinified(String original) {
        if(Storage.originalToMinified.containsValue(original)) {
            String minified = Storage.originalToMinified.get(original);
            return new MinifiedDto(minified);
        }

        String minified = generate();

        Storage.originalToMinified.put(original, minified);
        Storage.minifiedToOriginal.put(minified, original);

        return new MinifiedDto(minified);
    }

    public OriginalDto getOriginal(String minified) throws ResponseStatusException {
        if(Storage.minifiedToOriginal.containsKey(minified)) {
            String original = Storage.minifiedToOriginal.get(minified);
            return new OriginalDto(original);
        }
        else throw new ResponseStatusException(NO_CONTENT);
    }

    public String generate() {
        String generated = generator.generate();

        if(Storage.minifiedToOriginal.containsKey(generated)) {
            return generate();
        }
        return generated;
    }
}

class Storage {
    public static final Map<String, String> minifiedToOriginal = new HashMap<>();
    public static final Map<String, String> originalToMinified = new HashMap<>();
}