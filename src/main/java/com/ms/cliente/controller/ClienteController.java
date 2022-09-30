package com.ms.cliente.controller;

import com.ms.cliente.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getCliente(@PathVariable Long id){
        if(id == 23445322){
            logger.info("Se encontro al cliente con id : ", id);
            return ResponseEntity.status(HttpStatus.OK).body(findClienteById(id));
        }else{
            logger.info("No se encontro al cliente");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Cliente findClienteById(Long id){
        return Cliente.builder()
                .id(id)
                .primerNombre("José")
                .segundoNombre("Martín")
                .primerApellido("Pérez")
                .segundoApellido("Castro")
                .telefono("+579765678909")
                .direccion("Avenida Los Vengadores 124")
                .ciudad("Cartagena")
                .build();
    }
}
