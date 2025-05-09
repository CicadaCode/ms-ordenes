package com.exam.ms_ordenes.service;

import com.exam.ms_ordenes.client.ProductoClient;
import com.exam.ms_ordenes.entity.Orden;
import com.exam.ms_ordenes.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;
    @Autowired private ProductoClient productoClient;
    public Orden crearOrden(Orden orden) {
        productoClient.validarProductos(orden.getProductosIds());
        return ordenRepository.save(orden);
    }
    public List<Orden> listarOrdenes() { return ordenRepository.findAll(); }
}
