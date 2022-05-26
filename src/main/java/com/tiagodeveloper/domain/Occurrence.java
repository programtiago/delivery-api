package com.tiagodeveloper.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.OffsetDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Delivery delivery;
    private String descricao;
    private OffsetDateTime registryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OffsetDateTime getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(OffsetDateTime registryDate) {
        this.registryDate = registryDate;
    }
}
