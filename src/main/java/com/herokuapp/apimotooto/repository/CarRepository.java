package com.herokuapp.apimotooto.repository;

import com.herokuapp.apimotooto.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query ("select distinct c.brand from Car c")
    List<String> findDistinctBrand();

    @Query ("select distinct c.model from Car c where upper(c.brand) = upper(:brand)")
    List<String> findDistinctModelsByBrand(String brand);

    boolean existsByBrandIgnoreCase(String brand);
}
