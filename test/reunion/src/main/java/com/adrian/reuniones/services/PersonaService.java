package com.adrian.reuniones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.reuniones.data.PersonaRepository;
import com.adrian.reuniones.models.Persona;
import com.adrian.reuniones.models.Reunion;
import com.adrian.reuniones.models.User;

@Service
public class PersonaService {
    
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }

    public Optional<Persona> getById(Long id) {
        // Busca la reunión por ID en la base de datos
        return personaRepository.findById(id);
    }

     public String createPersona(Persona persona) {
        // Encode password before saving the user
        personaRepository.save(persona);
        return "Persona Added Successfully";
    }

    public boolean deletePersona(Long id) {
        
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id); // Elimina la reunión de la base de datos
            return true; // Devuelve true si se eliminó con éxito
        } else {
            return false; // Devuelve false si no se encontró la reunión
        }
    }

    public Optional<Persona> updatePersona(Long id, Persona persona) {
        
        if (personaRepository.existsById(id)) {
            persona.setId(id); // Asegura que el ID de la reunión se mantiene
            return Optional.of(personaRepository.save(persona)); // Guarda la reunión actualizada
        } else {
            return Optional.empty(); // Retorna un Optional vacío si la reunión no existe
        }
    }

}
