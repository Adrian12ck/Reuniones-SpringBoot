package com.adrian.reuniones.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.reuniones.models.Reunion;
import com.adrian.reuniones.models.User;
import com.adrian.reuniones.services.ReunionService;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionesRestController {

    private ReunionService reunionService;

    public ReunionesRestController(ReunionService reunionService){
        this.reunionService = reunionService;
    }

    @GetMapping
    public List<Reunion> getAllReuniones(){
        return reunionService.getAllReuniones();
    }

     @PostMapping
    public void createReunion(@RequestBody Reunion reunion) {

         reunionService.createReunion(reunion);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Reunion> getReunion(@PathVariable Long id) {
        Optional<Reunion> reunion = reunionService.getById(id);
        
        return reunion.map(r -> ResponseEntity.ok(r)) // Si se encontró la reunión, devuelve 200 OK con el recurso
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encontró, devuelve 404 Not Found
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReunion(@PathVariable Long id) {

        boolean deleted = reunionService.deleteReunion(id);

        if (deleted) {
            return ResponseEntity.noContent().build(); // Código 204: No Content, eliminación exitosa
        } else {
            return ResponseEntity.notFound().build(); // Código 404: No encontrado, si no existe la reunión
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reunion> updateReunion(@PathVariable Long id, @RequestBody Reunion reunion) {
        Optional<Reunion> updatedReunion = reunionService.updateReunion(id, reunion);
        return updatedReunion.map(r -> ResponseEntity.ok(r)) // Si se encontró y actualizó
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no se encuentra la reunión
    }

}