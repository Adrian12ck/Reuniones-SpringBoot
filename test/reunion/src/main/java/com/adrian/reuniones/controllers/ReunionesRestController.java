package com.adrian.reuniones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.reuniones.models.Reunion;
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
}