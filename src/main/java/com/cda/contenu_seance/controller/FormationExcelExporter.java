package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Formation;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.io.IOException;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;


public class FormationExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Formation> formationList;

    private List<Centre> centreList;

    public FormationExcelExporter(List<Formation> formationList,List<Centre> centreList) {
        this.formationList = formationList;
        this.centreList = centreList;
       workbook = new XSSFWorkbook();
    }
    private void writeHeaderLine() {
        sheet = workbook.createSheet("formation");

        sheet.autoSizeColumn(0);
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Formation ID", style);
        createCell(row, 1, "Type Formation", style);
    }
    private void writeHeaderLineCentre() {
        sheet = workbook.createSheet("Centre");
        sheet.autoSizeColumn(1);
        Row row = sheet.createRow(1);
        CellStyle styled = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        styled.setFont(font);
        createCell(row, 0, "Centre ID", styled);
        createCell(row, 1, "Nom Centre", styled);
        createCell(row, 2, "Adresse centre", styled);
        createCell(row, 3, "CP Centre", styled);
        createCell(row, 4, "Ville", styled);

    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);


        for (Formation formation : formationList) {
            Row row = sheet.createRow(rowCount++);
            Cell cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(formation.getId());
            Cell celltype = row.createCell(1);
            celltype.setCellValue(formation.getTypeFormation());
        }
    }
    private void writeDataLinesCentre() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Centre centre : centreList) {
            Row row = sheet.createRow(rowCount++);
            Cell cell = row.createCell(0);
            cell.setCellValue(centre.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(centre.getNomCentre());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(centre.getAdresseCentre());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(centre.getCodesPostal());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(centre.getVille());
        }
    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
      //  writeDataLinesCentre();
        writeHeaderLineCentre();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
