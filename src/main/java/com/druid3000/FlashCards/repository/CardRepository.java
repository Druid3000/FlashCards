package com.druid3000.FlashCards.repository;

import com.druid3000.FlashCards.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
