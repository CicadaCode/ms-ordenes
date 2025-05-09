package com.exam.ms_ordenes.dto;

import java.util.List;

public class OrdenDto {
    private Long usuarioId;
    private List<Long> productosIds;

    // Constructor sin parámetros
    public OrdenDto() {}

    // Constructor con parámetros
    public OrdenDto(Long usuarioId, List<Long> productosIds) {
        this.usuarioId = usuarioId;
        this.productosIds = productosIds;
    }

    // Getters y setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }
}
