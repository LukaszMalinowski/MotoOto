package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.dto.SaleAnnouncementDto;
import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.model.User;
import com.herokuapp.apimotooto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping ("/{userId}/sale-announcements")
    public ResponseEntity<List<SaleAnnouncement>> getUsersAllSaleAnnouncements(@PathVariable Long userId) {
        List<SaleAnnouncement> saleAnnouncements = userService.getUsersAllSaleAnnouncements(userId);
        return ResponseEntity.ok(saleAnnouncements);
    }

    @PostMapping ("/{userId}/sale-announcements")
    public ResponseEntity<List<SaleAnnouncement>> addSaleAnnouncement(@PathVariable Long userId,
                                                                      Authentication authentication,
                                                                      @RequestBody @Valid SaleAnnouncementDto saleAnnouncementDto) {
        User user = (User)authentication.getPrincipal();
        userService.addSaleAnnouncement(userId, user, saleAnnouncementDto);
        return ResponseEntity.noContent().build();
    }

}
