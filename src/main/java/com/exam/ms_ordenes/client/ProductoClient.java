package com.exam.ms_ordenes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="ms-productos", path="/productos")
public interface ProductoClient {
    @PostMapping("/validate")
    void validarProductos(@RequestBody List<Long> ids);
}