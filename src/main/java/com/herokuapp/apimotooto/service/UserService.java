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
public class UserService {

    private final SaleAnnouncementRepository saleAnnouncementRepository;

    public List<SaleAnnouncement> getUsersAllSaleAnnouncements(Long userId) {
        return saleAnnouncementRepository.findSaleAnnouncementByOwner_Id(userId);
    }

}
