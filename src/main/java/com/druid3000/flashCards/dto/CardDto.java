package com.druid3000.flashCards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
    private Integer id;
    private String frontSide;
    private String backSide;
    private String backSideDescription;
    private String example;
}
