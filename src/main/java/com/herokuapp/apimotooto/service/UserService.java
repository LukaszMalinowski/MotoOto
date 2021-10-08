package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.dto.SaleAnnouncementDto;
import com.herokuapp.apimotooto.exception.AnnouncementAlreadyExistsException;
import com.herokuapp.apimotooto.exception.AnnouncementLimitException;
import com.herokuapp.apimotooto.exception.UserNotExistsException;
import com.herokuapp.apimotooto.exception.UserNotPermittedException;
import com.herokuapp.apimotooto.model.Car;
import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.repository.SaleAnnouncementRepository;
import com.herokuapp.apimotooto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SaleAnnouncementRepository saleAnnouncementRepository;

    private static final int ANNOUNCEMENT_LIMIT = 3;

    public List<SaleAnnouncement> getUsersAllSaleAnnouncements(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotExistsException(userId);
        }

        log.info("Getting all sale announcements for user with id " + userId);
        return saleAnnouncementRepository.findSaleAnnouncementByOwner_Id(userId);
    }

    @Transactional
    public void addSaleAnnouncement(Long userId, User user, SaleAnnouncementDto saleAnnouncementDto) {
        if (!userId.equals(user.getId())) {
            throw new UserNotPermittedException("You can only add announcements to your account!");
        }

        if(saleAnnouncementRepository.countSaleAnnouncementsByOwner_Id(userId) >= ANNOUNCEMENT_LIMIT) {
            throw new AnnouncementLimitException();
        }

        SaleAnnouncement saleAnnouncement = new SaleAnnouncement(saleAnnouncementDto, user);

        Car newCar = saleAnnouncementDto.getCar();
        if (saleAnnouncementRepository
                .existsByCar_BrandAndCar_ModelAndOwner_Id(newCar.getBrand(), newCar.getModel(), userId)) {
            throw new AnnouncementAlreadyExistsException();
        }

        saleAnnouncementRepository.save(saleAnnouncement);

        log.info("Sale announcement added: " + saleAnnouncement);
    }
}
