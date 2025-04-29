package com.adrian.reuniones.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.reuniones.models.Persona;
import com.adrian.reuniones.models.Reunion;
import com.adrian.reuniones.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {
    private PersonaService personaService;

    public PersonaRestController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @PostMapping
    public String createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable Long id) {
        Optional<Persona> persona = personaService.getById(id);
        
        return persona.map(r -> ResponseEntity.ok(r)) // Si se encontró la reunión, devuelve 200 OK con el recurso
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encontró, devuelve 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        
        boolean deleted = personaService.deletePersona(id);

        if (deleted) {
            return ResponseEntity.noContent().build(); // Código 204: No Content, eliminación exitosa
        } else {
            return ResponseEntity.notFound().build(); // Código 404: No encontrado, si no existe la reunión
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        Optional<Persona> updatedReunion = personaService.updatePersona(id, persona);
        return updatedReunion.map(r -> ResponseEntity.ok(r)) // Si se encontró y actualizó
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra la reunión
    }

    
}
