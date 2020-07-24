package com.squeezeit.squeezeitbackend.controller;

import com.squeezeit.squeezeitbackend.dto.MinifiedDto;
import com.squeezeit.squeezeitbackend.dto.OriginalDto;
import com.squeezeit.squeezeitbackend.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Rest API for minifying and getting minified links back
 * @author Adam Balski
 */
@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    /**
     * Minifies link.
     * If the link was requested previously then returns the same link as before.
     * @param original unmodified link
     * @return minified
     */
    @GetMapping(value = "/api/minify/{original}")
    public MinifiedDto getRedirectedLink(@PathVariable String original) {
        return service.getMinified(original);
    }

    /**
     * Returns the original version of the link.
     * @throws ResponseStatusException (appears as 204 NO_CONTENT) if the link has never been generated
     * @param minified modified link
     * @return original version of link
     */
    @GetMapping(value = "/api/redirect/{minified}")
    public OriginalDto getOriginalLink(@PathVariable String minified) {
        return service.getOriginal(minified);
    }
}
