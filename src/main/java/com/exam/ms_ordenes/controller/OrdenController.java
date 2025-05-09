package com.exam.ms_ordenes.controller;

import com.exam.ms_ordenes.dto.OrdenDto;
import com.exam.ms_ordenes.entity.Orden;
import com.exam.ms_ordenes.service.OrdenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
@AllArgsConstructor
public class OrdenController {

    private OrdenService service;

    // Endpoint para crear una nueva orden
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Orden> create(@RequestBody @Valid OrdenDto dto) {
        // Usando el Builder de la entidad Orden
        Orden orden = new Orden.Builder()
                .usuarioId(dto.getUsuarioId())
                .productosIds(dto.getProductosIds())
                .build();
        // Guardar la orden usando el servicio
        Orden ordenCreada = service.crearOrden(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCreada);
    }

    // Endpoint para listar las órdenes (solo admin o superadmin)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public List<Orden> list() {
        return service.listarOrdenes();
    }
}