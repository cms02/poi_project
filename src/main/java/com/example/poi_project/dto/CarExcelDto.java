package com.example.poi_project.dto;

import com.example.poi_project.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CarExcelDto {
    @ExcelColumn(headerName = "회사ㅋ")
    private final String company; // 회사
    @ExcelColumn(headerName = "차종ㅋ")
    private final String name; // 차종
    @ExcelColumn(headerName = "가격ㅋ")
    private final int price; // 가격
    @ExcelColumn(headerName = "평점ㅋ")
    private final double rating; // 평점
}
