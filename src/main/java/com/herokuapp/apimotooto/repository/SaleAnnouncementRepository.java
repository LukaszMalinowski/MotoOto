package com.herokuapp.apimotooto.repository;

import com.herokuapp.apimotooto.model.SaleAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleAnnouncementRepository extends JpaRepository<SaleAnnouncement, Long> {

    List<SaleAnnouncement> findSaleAnnouncementByOwner_Id(Long userId);

    //TODO add filtering by carMillage + check for sql injection
    @Query ("select s from SaleAnnouncement s where (:brand is null or (upper(s.car.brand) like upper(:brand))) and (:model is null or (upper(s.car.model) like upper(:model))) and (:generation is null or (upper(s.car.generation) like upper(:generation))) and (:fuel is null or (upper(s.car.fuelType) like upper(:fuel)))")
    List<SaleAnnouncement> findAllFilteredByCar(String brand, String model, String generation, String fuel);

    boolean existsByCar_BrandAndCar_ModelAndOwner_Id(String brand, String model, Long userId);
}

