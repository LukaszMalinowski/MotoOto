package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.exception.BrandNotAvailableException;
import com.herokuapp.apimotooto.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<String> getAllAvailableBrands() {
        return carRepository.findDistinctBrand();
    }

    public List<String> getAllAvailableModelsForBrand(String brand) {
        if (!carRepository.existsByBrandIgnoreCase(brand)) {
            throw new BrandNotAvailableException(brand);
        }

        return carRepository.findDistinctModelsByBrand(brand);
    }

}
