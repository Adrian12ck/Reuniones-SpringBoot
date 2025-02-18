package com.adrian.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.adrian.reuniones.models.Persona;

@RepositoryRestResource(path="personas")
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}