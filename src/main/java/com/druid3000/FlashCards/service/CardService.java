package com.druid3000.FlashCards.service;

import com.druid3000.FlashCards.entity.Card;
import com.druid3000.FlashCards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card add(Card card){
        return cardRepository.save(card);
    }

    public Card findById(Integer id){
        return cardRepository.findById(id).orElse(new Card());
    }
}