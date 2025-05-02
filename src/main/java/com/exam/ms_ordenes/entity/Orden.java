package com.exam.ms_ordenes.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Orden {
    @Id
    @GeneratedValue
    private Long id;
    private Long usuarioId;
    @ElementCollection
    private List<Long> productosIds;
    private LocalDateTime fecha;

    protected Orden() { }

    private Orden(Builder b) {
        this.usuarioId = b.usuarioId;
        this.productosIds = b.productosIds;
        this.fecha = b.fecha != null ? b.fecha : LocalDateTime.now();
    }

    public static class Builder {
        private Long usuarioId;
        private List<Long> productosIds;
        private LocalDateTime fecha;

        public Builder usuarioId(Long usuarioId) {
            this.usuarioId = usuarioId;
            return this;
        }

        public Builder productosIds(List<Long> productosIds) {
            this.productosIds = productosIds;
            return this;
        }

        public Builder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public Orden build() {
            if (usuarioId == null || productosIds == null) {
                throw new IllegalStateException("usuarioId y productosIds son obligatorios");
            }
            return new Orden(this);
        }
    }
}