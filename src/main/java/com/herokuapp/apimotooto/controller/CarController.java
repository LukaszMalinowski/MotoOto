package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping ("/brands")
    public ResponseEntity<List<String>> getAllAvailableBrands() {
        return ResponseEntity.ok(carService.getAllAvailableBrands());
    }

    @GetMapping ("/{brand}/models")
    public ResponseEntity<List<String>> getAllAvailableModelsForBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.getAllAvailableModelsForBrand(brand));
    }

}
