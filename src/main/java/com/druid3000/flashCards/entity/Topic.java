package com.druid3000.flashCards.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
public class Topic {

    private String name;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    private List<Card> cards;
}
