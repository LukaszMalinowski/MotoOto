package com.herokuapp.apimotooto.repository;

import com.herokuapp.apimotooto.model.SaleAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleAnnouncementRepository extends JpaRepository<SaleAnnouncement, Long> {

    List<SaleAnnouncement> findSaleAnnouncementByOwner_Id(Long userId);

}
