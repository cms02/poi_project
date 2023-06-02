package com.example.poi_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CarExcelDto {
    private final String company; // 회사
    private final String name; // 차종
    private final int price; // 가격
    private final double rating; // 평점
}
