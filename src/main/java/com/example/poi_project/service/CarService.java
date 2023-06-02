package com.example.poi_project.service;

import com.example.poi_project.dto.CarExcelDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public List<CarExcelDto> getCarInfo() {
        List<CarExcelDto> result = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            result.add(CarExcelDto.builder()
                    .company("company" + i)
                    .name("name" + i)
                    .price(i)
                    .rating(0.9)
                    .build());
        }
        result.forEach(r-> System.out.println(r.getPrice()));
        return result;
    }
}
