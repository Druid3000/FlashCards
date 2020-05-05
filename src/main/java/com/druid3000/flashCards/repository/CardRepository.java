package com.druid3000.flashCards.repository;

import com.druid3000.flashCards.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
