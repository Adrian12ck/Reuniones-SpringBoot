package com.adrian.reuniones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.reuniones.data.ReunionRepository;
import com.adrian.reuniones.models.Reunion;

@Service
public class ReunionService {
       
    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository){
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones(){
        return reunionRepository.findAll();
    }

    public Optional<Reunion> getById(Long id) {
        // Busca la reunión por ID en la base de datos
        return reunionRepository.findById(id);
    }

    public void createReunion(Reunion reunion) {
    // Encode password before saving the user
    //userInfo.setPassword(encoder.encode(userInfo.getPassword()));
    //repository.save(userInfo);
    //return "User Added Successfully";

    reunionRepository.save(reunion);
    


    }

    public boolean deleteReunion(Long id) {
        
        if (reunionRepository.existsById(id)) {
            reunionRepository.deleteById(id); // Elimina la reunión de la base de datos
            return true; // Devuelve true si se eliminó con éxito
        } else {
            return false; // Devuelve false si no se encontró la reunión
        }
    }

    public Optional<Reunion> updateReunion(Long id, Reunion reunion) {
        if (reunionRepository.existsById(id)) {
            reunion.setId(id); // Asegura que el ID de la reunión se mantiene
            return Optional.of(reunionRepository.save(reunion)); // Guarda la reunión actualizada
        } else {
            return Optional.empty(); // Retorna un Optional vacío si la reunión no existe
        }
    }
}
