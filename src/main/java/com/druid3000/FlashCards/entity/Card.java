package com.druid3000.FlashCards.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "frontSide")
    private String frontSide;

    @Column(name = "backSide")
    private String backSide;

    @Column(name = "backSideDescription")
    private String backSideDescription;

    @Column(name = "topic")
    private String topic;
}
