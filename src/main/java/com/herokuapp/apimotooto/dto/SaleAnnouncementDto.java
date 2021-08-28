package com.herokuapp.apimotooto.dto;

import com.herokuapp.apimotooto.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleAnnouncementDto {

    @NotNull
    private Car car;

    @URL (message = "URL not valid")
    private String imageURL;

    private BigDecimal price;

}
