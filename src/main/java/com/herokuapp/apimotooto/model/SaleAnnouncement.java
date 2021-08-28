package com.herokuapp.apimotooto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleAnnouncement {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(ignoreUnknown = true, value = {"saleAnnouncements"})
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
    private User owner;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    @URL (message = "URL not valid")
    private String imageURL;

    private BigDecimal price;

}
