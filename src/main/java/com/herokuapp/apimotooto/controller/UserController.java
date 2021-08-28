package com.herokuapp.apimotooto.controller;

import com.herokuapp.apimotooto.model.SaleAnnouncement;
import com.herokuapp.apimotooto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
