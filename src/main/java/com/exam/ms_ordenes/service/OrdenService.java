package com.exam.ms_ordenes.service;

import com.exam.ms_ordenes.client.ProductoClient;
import com.exam.ms_ordenes.entity.Orden;
import com.exam.ms_ordenes.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;
    private final ProductoClient productoClient;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository, ProductoClient productoClient) {
        this.ordenRepository = ordenRepository;
        this.productoClient = productoClient;
    }

    public Orden crearOrden(Orden orden) {
        productoClient.validarProductos(orden.getProductosIds());
        return ordenRepository.save(orden);
    }
    public List<Orden> listarOrdenes() { return ordenRepository.findAll(); }
}
