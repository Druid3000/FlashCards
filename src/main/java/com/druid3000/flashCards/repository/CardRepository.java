package com.druid3000.flashCards.repository;

import com.druid3000.flashCards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
