package com.druid3000.flashCards.controller;

import com.druid3000.flashCards.dto.CardDto;
import com.druid3000.flashCards.entity.Card;
import com.druid3000.flashCards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/learn")
@RequiredArgsConstructor
public class LearnController {

    private final CardService cardService;

    @GetMapping("frontSide")
    public ResponseEntity<CardDto> learnFrontSide(HttpSession httpSession){
        Card card = (Card) httpSession.getAttribute("card");

        CardDto cardDto;

        if(card == null){
            card = cardService.getRandomCard();
            httpSession.setAttribute("card", card);
            cardDto = CardDto.builder()
                    .id(card.getId())
                    .frontSide("hidden")
                    .backSide(card.getBackSide())
                    .backSideDescription(card.getBackSideDescription())
                    .topic(card.getTopic())
                    .build();
        } else {
            cardDto = CardDto.builder()
                    .id(card.getId())
                    .frontSide(card.getFrontSide())
                    .backSide(card.getBackSide())
                    .backSideDescription(card.getBackSideDescription())
                    .topic(card.getTopic())
                    .build();
            httpSession.removeAttribute("card");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cardDto);
    }

}
