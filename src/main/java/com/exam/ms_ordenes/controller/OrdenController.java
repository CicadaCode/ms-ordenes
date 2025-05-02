package com.exam.ms_ordenes.controller;

import com.exam.ms_ordenes.entity.Orden;
import com.exam.ms_ordenes.service.OrdenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService service;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Orden> create(@RequestBody @Valid OrdenDto dto) {
        Orden orden = new OrdenBuilder()
                .usuarioId(dto.getUsuarioId())
                .productosIds(dto.getProductosIds())
                .build();
        return ResponseEntity.status(CREATED).body(service.crearOrden(orden));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','SUPERADMIN')")
    public List<Orden> list() {
        return service.listarOrdenes();
    }
}
