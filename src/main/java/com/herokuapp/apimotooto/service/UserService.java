package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.exception.UserNotExistsException;
import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.repository.SaleAnnouncementRepository;
import com.herokuapp.apimotooto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SaleAnnouncementRepository saleAnnouncementRepository;

    public List<SaleAnnouncement> getUsersAllSaleAnnouncements(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new UserNotExistsException(userId);
        }

        return saleAnnouncementRepository.findSaleAnnouncementByOwner_Id(userId);
    }

}
