package com.CRUDlover.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUDlover.api.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
