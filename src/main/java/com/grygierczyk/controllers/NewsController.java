package com.grygierczyk.controllers;


import com.grygierczyk.models.NewsTile;
import com.grygierczyk.services.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsController {

  private NewsService newsService;
  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<NewsTile>> getAllNewsTiles() {
    List<NewsTile> newsTiles = newsService.getNewsTiles();
    return new ResponseEntity<>(newsTiles, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NewsTile> getNewsTileById(@PathVariable int id) {
    Optional<NewsTile> newsTile = newsService.findNewsTileById(id);
    return newsTile.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

@PostMapping("/add")
public ResponseEntity<String> addNewsTile(
        @RequestParam String header,
        @RequestParam String text,
        @RequestParam("imageBytes") MultipartFile imageFile) {
  byte[] imageBytes = null;
  try {
    if (imageFile != null && !imageFile.isEmpty()) {
      imageBytes = imageFile.getBytes();
    }
  } catch (IOException e) {
    e.printStackTrace();
    return new ResponseEntity<>("Failed to process image file", HttpStatus.INTERNAL_SERVER_ERROR);
  }

  NewsTile newsTile = new NewsTile(header, text, imageBytes);

  newsService.addNewsTile(newsTile);
  return new ResponseEntity<>("NewsTile added successfully", HttpStatus.CREATED);
}

  @PutMapping("/edit/{id}")
  public ResponseEntity<String> editNewsTileById(
          @PathVariable int id,
          @RequestParam(required = false) String newHeader,
          @RequestParam(required = false) String newText,
          @RequestParam(required = false) byte[] newImage) {

    boolean result = newsService.editNewsTileById(id, newHeader, newText, newImage);

    if (result) {
      return new ResponseEntity<>("NewsTile edited successfully", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("NewsTile not found", HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteNewsTileById(@PathVariable int id) {
    boolean result = newsService.deleteNewsTile(id);

    if (result) {
      return new ResponseEntity<>("NewsTile deleted successfully", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("NewsTile not found", HttpStatus.NOT_FOUND);
    }
  }
}


