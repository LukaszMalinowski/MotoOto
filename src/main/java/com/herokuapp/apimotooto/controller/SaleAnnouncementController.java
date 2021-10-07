package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.service.SaleAnnouncementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/sale-announcements")
@Slf4j
@RequiredArgsConstructor
public class SaleAnnouncementController {

    private final SaleAnnouncementService saleAnnouncementService;

    @GetMapping ()
    public ResponseEntity<List<SaleAnnouncement>> getFilteredSaleAnnouncements(
            @RequestParam (required = false) String brand,
            @RequestParam (required = false) String model,
            @RequestParam (required = false) String generation,
            @RequestParam (required = false) String fuel) {
        return ResponseEntity.ok(saleAnnouncementService.getFilteredSaleAnnouncements(brand, model, generation, fuel));
    }


}
