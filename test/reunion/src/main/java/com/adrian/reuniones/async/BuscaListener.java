package com.adrian.reuniones.async;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.adrian.reuniones.models.Persona;
import com.adrian.reuniones.models.Reunion;
import com.adrian.reuniones.services.PersonaService;
import com.adrian.reuniones.services.ReunionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class BuscaListener {
    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }




    public void recibirMensaje(String mensaje) {


        try {

        InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
        Optional<Persona> persona = personaService.getById(info.getIdAsistente());
        Optional<Reunion>  reunion = reunionService.getById(info.getIdReunion());
        System.out.println("Mensaje enviado!");

        LOG.info("{} {} tiene una reunion a las {}",
        persona.get().getNombre(),
        persona.get().getApellido(),
        reunion.get().getFecha());

        } catch (JsonProcessingException e) {
            LOG.warn("Mensaje incorrecto", e);
        }  catch (Exception e) {
            LOG.error("Error procesando el mensaje: {}", mensaje, e);
        }
    }
}
