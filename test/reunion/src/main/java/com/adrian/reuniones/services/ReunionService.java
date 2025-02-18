package com.adrian.reuniones.services;

import java.util.List;

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

    public Reunion getById(long id) {
        return reunionRepository.findById(id).get();
    }
}
