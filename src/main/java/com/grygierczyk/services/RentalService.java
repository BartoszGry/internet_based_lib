package com.grygierczyk.services;

import com.grygierczyk.DTO.RentalResponseDTO;
import com.grygierczyk.clients.BibliotekaNarodowaClient;
import com.grygierczyk.models.BibsItem;
import com.grygierczyk.models.User;
import com.grygierczyk.models.RentalRecord;
import com.grygierczyk.system_repo.BibsItemRepository;
import com.grygierczyk.system_repo.RentalRecordRepository;
import com.grygierczyk.system_repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRecordRepository rentalRecordRepository;
    private final UserRepository userRepository;
    private final BibsItemRepository bibsItemRepository;

    private final BibliotekaNarodowaClient bibliotekaNarodowaClient;

    public RentalService(RentalRecordRepository rentalRecordRepository, UserRepository userRepository, BibsItemRepository bibsItemRepository, BibliotekaNarodowaClient bibliotekaNarodowaClient) {
        this.rentalRecordRepository = rentalRecordRepository;
        this.userRepository = userRepository;
        this.bibsItemRepository = bibsItemRepository;
        this.bibliotekaNarodowaClient = bibliotekaNarodowaClient;
    }

    public RentalResponseDTO rentItem(int userId, Long bibsItemId) {

        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusMonths(3);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        List<BibsItem> bibsItemsList = bibsItemRepository.findById(bibsItemId);
        BibsItem bibsItem;

        if (bibsItemsList.isEmpty()) {
            bibsItem = bibliotekaNarodowaClient.fetchByParamsToList(bibsItemId, null, null, null, null, null).get(0);
            bibsItemRepository.save(bibliotekaNarodowaClient.fetchByParamsToList(bibsItemId, null, null, null, null, null).get(0));
        } else {
            bibsItem = bibsItemsList.get(0);
        }

        RentalRecord rentalRecord = new RentalRecord(currentDate, expirationDate, user, bibsItem);
        RentalRecord newRecord = rentalRecordRepository.save(rentalRecord);

        return  mapToRentalResponseDTO(newRecord);
    }


    public List<RentalResponseDTO> getAllRentalsForUser(int userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Get all rental records for the user
        List<RentalRecord> rentalRecords = rentalRecordRepository.findByUser(user);

        return rentalRecords.stream()
                .map(this::mapToRentalResponseDTO)
                .collect(Collectors.toList());
    }

    private RentalResponseDTO mapToRentalResponseDTO(RentalRecord rentalRecord) {
        return new RentalResponseDTO(
                rentalRecord.getUser().getEmail(),
                rentalRecord.getBibsItem().getAuthor(),
                rentalRecord.getBibsItem().getTitle(),
                rentalRecord.getBibsItem().getId(),
                rentalRecord.getRentalDate(),
                rentalRecord.getRentalExpire()
        );
    }

}
