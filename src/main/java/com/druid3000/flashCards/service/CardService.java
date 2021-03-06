package com.druid3000.flashCards.service;

import com.druid3000.flashCards.entity.Card;
import com.druid3000.flashCards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card add(Card card) {
        return cardRepository.save(card);
    }

    @Transactional
    public List<Card> addAll(List<Card> cards) {
        return cardRepository.saveAll(cards);
    }

    public Card findById(Integer id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card does not exist"));
    }

    public Card getRandomCard() {
        long count = cardRepository.count();
        int randomId = 1 + (int) (Math.random() * count);
        return findById(randomId);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}