package com.druid3000.flashCards.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemDetail {

	private final String title;
	private final String detail;
	private String type;
	private String instance;
	private Integer status;

}