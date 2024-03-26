package com.grygierczyk.controllers;

import com.grygierczyk.DTO.RentalDTO;
import com.grygierczyk.DTO.RentalResponseDTO;
import com.grygierczyk.services.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
@CrossOrigin(origins = "http://localhost:5173")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/create")
    public RentalResponseDTO createRentalRecord(@RequestBody RentalDTO body) {
        return rentalService.rentItem(body.getClientId(), body.getBibsItemId());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RentalResponseDTO>> getAllRentalsForUser(@PathVariable int userId) {
        List<RentalResponseDTO> rentals = rentalService.getAllRentalsForUser(userId);
        return ResponseEntity.ok(rentals);
    }
}
