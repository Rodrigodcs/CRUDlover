package com.CRUDlover.api.models;

import java.util.Date;

import com.CRUDlover.api.DTOs.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO data) {
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.valor = data.valor();
        this.anoModelo = data.anoModelo();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String modelo;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(length = 50, nullable = false)
    private Date dataFabricacao;

    @Column(nullable = false)
    private Integer valor;

    @Column(nullable = false)
    private Integer anoModelo;
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public void setData(Date data){
        this.dataFabricacao = data;
    }
    public void setValor(Integer valor){
        this.valor = valor;
    }
    public void setAnoModelo(Integer anoModelo){
        this.anoModelo = anoModelo;
    }
}
