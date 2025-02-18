package com.adrian.reuniones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.reuniones.data.PersonaRepository;
import com.adrian.reuniones.models.Persona;

@Service
public class PersonaService {
    
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }

   public Persona getById(long id) {
        return personaRepository.findById(id).get();
    }

}
