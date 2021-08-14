package com.herokuapp.apimotooto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
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

    @URL (message = "URL not valid")
    private String imageURL;

    private BigDecimal price;

}
