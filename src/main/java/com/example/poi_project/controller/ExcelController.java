package com.example.poi_project.controller;

import com.example.poi_project.dto.CarExcelDto;
import com.example.poi_project.service.CarService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExcelController {

    private final CarService carService;
    @GetMapping("/api/v1/excel/car")
    public void downloadCarInfo(HttpServletResponse response) throws IOException {
        // 엑셀 파일 하나를 만듭니다
        Workbook workbook = new SXSSFWorkbook();
        // 엑셀 파일 내부에 Sheet 를 하나 생성합니다 (엑셀 파일 하나에는 여러 Sheet가 있을 수 있습니다)
        Sheet sheet = workbook.createSheet();

        // 엑셀 렌더링에 필요한 DTO를 가져옵니다
        List<CarExcelDto> carExcelDtos = carService.getCarInfo();

        // 헤더를 생성합니다
        int rowIndex = 0;
        Row headerRow = sheet.createRow(rowIndex++);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("회사");

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("차종");

        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("가격");

        Cell headerCell4 = headerRow.createCell(2);
        headerCell3.setCellValue("평점");

        // 바디에 데이터를 넣어줍니다
        for (CarExcelDto dto : carExcelDtos) {
            Row bodyRow = sheet.createRow(rowIndex++);

            Cell bodyCell1 = bodyRow.createCell(0);
            bodyCell1.setCellValue(dto.getCompany());

            Cell bodyCell2 = bodyRow.createCell(1);
            bodyCell2.setCellValue(dto.getName());

            Cell bodyCell3 = bodyRow.createCell(2);
            bodyCell3.setCellValue(dto.getPrice());

            Cell bodyCell4 = bodyRow.createCell(3);
            bodyCell4.setCellValue(dto.getRating());
        }
        response.setContentType("application/vnd.ms-excel");
        workbook.write(response.getOutputStream());
    }
}
