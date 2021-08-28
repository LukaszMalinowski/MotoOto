package com.herokuapp.apimotooto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.herokuapp.apimotooto.dto.SaleAnnouncementDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleAnnouncement {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne (cascade = CascadeType.MERGE)
    private User owner;

    @OneToOne (cascade = CascadeType.ALL)
    private Car car;

    @URL (message = "URL not valid")
    private String imageURL;

    private BigDecimal price;

    public SaleAnnouncement(SaleAnnouncementDto saleAnnouncementDto, User user) {
        this.car = saleAnnouncementDto.getCar();
        this.imageURL = saleAnnouncementDto.getImageURL();
        this.price = saleAnnouncementDto.getPrice();
        this.owner = user;
    }
}
