package com.druid3000.flashCards.service;

import com.druid3000.flashCards.entity.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LearnService {

    private final CardService cardService;
    private Card card;

    public String learn() {
        if (card == null) {
            card = cardService.getRandomCard();
            return card.getBackSide();

        } else {
            String frontSide = card.getFrontSide();
            card = null;
            return frontSide;
        }
    }
}
