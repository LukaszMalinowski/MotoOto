package com.herokuapp.apimotooto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull (message = "Brand is mandatory")
    private String brand;

    @NotNull (message = "Model is mandatory")
    private String model;

    private String generation;

    @Enumerated (value = EnumType.STRING)
    private FuelType fuelType;

    private int productionYear;

    private BigDecimal carMileage;

}
