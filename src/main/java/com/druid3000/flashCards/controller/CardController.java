package com.druid3000.flashCards.controller;

import com.druid3000.flashCards.dto.CardDto;
import com.druid3000.flashCards.dto.CardResponseDto;
import com.druid3000.flashCards.entity.Card;
import com.druid3000.flashCards.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("add")
    public ResponseEntity<CardResponseDto> add(@RequestBody CardDto cardDto) {
        val newCard = Card.builder()
                .frontSide(cardDto.getFrontSide())
                .backSide(cardDto.getBackSide())
                .backSideDescription(cardDto.getBackSideDescription())
                .topic(cardDto.getTopic())
                .build();

        Card card = cardService.add(newCard);

        val cardResponseDto = CardResponseDto.builder()
                .id(card.getId())
                .frontSide(card.getFrontSide())
                .backSide(card.getBackSide())
                .backSideDescription(card.getBackSideDescription())
                .topic(card.getTopic())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(cardResponseDto);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<CardResponseDto> findById(@PathVariable Integer id){
        Card card = cardService.findById(id);

        val cardResponseDto = CardResponseDto.builder()
                .id(card.getId())
                .frontSide(card.getFrontSide())
                .backSide(card.getBackSide())
                .backSideDescription(card.getBackSideDescription())
                .topic(card.getTopic())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(cardResponseDto);
    }
}
