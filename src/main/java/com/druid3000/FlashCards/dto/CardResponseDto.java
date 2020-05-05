package com.druid3000.FlashCards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponseDto {
    private Integer id;
    private String frontSide;
    private String backSide;
    private String backSideDescription;
    private String topic;
}
