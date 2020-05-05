package com.druid3000.flashCards.controller;

import com.druid3000.flashCards.dto.LearnDto;
import com.druid3000.flashCards.service.LearnService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/learn")
@RequiredArgsConstructor
public class LearnController {

    private final LearnService learnService;

    @GetMapping
    public ResponseEntity<LearnDto> learn(){
        String text = learnService.learn();
        val learnDto = LearnDto.builder()
                .text(text)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(learnDto);
    }
}
