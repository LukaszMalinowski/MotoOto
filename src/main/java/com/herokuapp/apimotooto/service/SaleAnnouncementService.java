package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.repository.SaleAnnouncementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaleAnnouncementService {

    private final SaleAnnouncementRepository saleAnnouncementRepository;

    public List<SaleAnnouncement> getFilteredSaleAnnouncements(String brand, String model, String generation,
                                                               String fuel) {
        return saleAnnouncementRepository.findAllFilteredByCar(brand, model, generation, fuel);
    }
}
