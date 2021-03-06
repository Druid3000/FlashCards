package com.druid3000.flashCards.entity;

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

    @Column(name = "example")
    private String example;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
