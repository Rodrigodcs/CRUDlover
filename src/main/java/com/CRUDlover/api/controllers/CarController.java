package com.CRUDlover.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDlover.api.DTOs.CarDTO;
import com.CRUDlover.api.models.Car;
import com.CRUDlover.api.repositories.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/car")
public class CarController {
    
    @Autowired
    private CarRepository repository;

    @PostMapping
    public void create(@RequestBody @Valid CarDTO req){
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> listAll(){
        return repository.findAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,@RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car ->{
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setData(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());
            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
