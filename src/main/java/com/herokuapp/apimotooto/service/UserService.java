package com.herokuapp.apimotooto.service;

import com.herokuapp.apimotooto.dto.SaleAnnouncementDto;
import com.herokuapp.apimotooto.exception.UserNotExistsException;
import com.herokuapp.apimotooto.exception.UserNotPermittedException;
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

    public List<SaleAnnouncement> getUsersAllSaleAnnouncements(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotExistsException(userId);
        }

        return saleAnnouncementRepository.findSaleAnnouncementByOwner_Id(userId);
    }

    @Transactional
    public void addSaleAnnouncement(Long userId, User user, SaleAnnouncementDto saleAnnouncementDto) {
        if (!userId.equals(user.getId())) {
            throw new UserNotPermittedException("You can only add announcements to your account!");
        }

        SaleAnnouncement saleAnnouncement = new SaleAnnouncement(saleAnnouncementDto, user);
        saleAnnouncementRepository.save(saleAnnouncement);
    }
}
