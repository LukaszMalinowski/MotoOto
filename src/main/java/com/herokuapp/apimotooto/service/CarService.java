package com.herokuapp.apimotooto.service;

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

}
