package com.druid3000.flashCards.service;

import com.druid3000.flashCards.entity.Card;
import com.druid3000.flashCards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card add(Card card) {
        return cardRepository.save(card);
    }

    public Card findById(Integer id) {
        return cardRepository.findById(id).orElse(new Card());
    }

    public Card getRandomCard() {
        long count = cardRepository.count();
        int randomId = 1 + (int) (Math.random() * count);
        return findById(randomId);
    }
}