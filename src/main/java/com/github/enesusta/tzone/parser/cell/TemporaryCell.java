package com.github.enesusta.tzone.parser.cell;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TemporaryCell {

    public static Cell of() {
        return new Cell() {
            @Override
            public int getColumnIndex() {
                return 0;
            }

            @Override
            public int getRowIndex() {
                return 0;
            }

            @Override
            public Sheet getSheet() {
                return null;
            }

            @Override
            public Row getRow() {
                return null;
            }

            @Override
            public void setCellType(CellType cellType) {

            }

            @Override
            public void setBlank() {

            }

            @Override
            public CellType getCellType() {
                return null;
            }

            @Override
            public CellType getCellTypeEnum() {
                return null;
            }

            @Override
            public CellType getCachedFormulaResultType() {
                return null;
            }

            @Override
            public CellType getCachedFormulaResultTypeEnum() {
                return null;
            }

            @Override
            public void setCellValue(double v) {

            }

            @Override
            public void setCellValue(Date date) {

            }

            @Override
            public void setCellValue(LocalDateTime localDateTime) {

            }

            @Override
            public void setCellValue(Calendar calendar) {

            }

            @Override
            public void setCellValue(RichTextString richTextString) {

            }

            @Override
            public void setCellValue(String s) {

            }

            @Override
            public void setCellFormula(String s) throws FormulaParseException, IllegalStateException {

            }

            @Override
            public void removeFormula() throws IllegalStateException {

            }

            @Override
            public String getCellFormula() {
                return null;
            }

            @Override
            public double getNumericCellValue() {
                return 0;
            }

            @Override
            public Date getDateCellValue() {
                return null;
            }

            @Override
            public LocalDateTime getLocalDateTimeCellValue() {
                return null;
            }

            @Override
            public RichTextString getRichStringCellValue() {
                return null;
            }

            @Override
            public String getStringCellValue() {
                return "Empty string cell value";
            }

            @Override
            public void setCellValue(boolean b) {

            }

            @Override
            public void setCellErrorValue(byte b) {

            }

            @Override
            public boolean getBooleanCellValue() {
                return false;
            }

            @Override
            public byte getErrorCellValue() {
                return 0;
            }

            @Override
            public void setCellStyle(CellStyle cellStyle) {

            }

            @Override
            public CellStyle getCellStyle() {
                return null;
            }

            @Override
            public void setAsActiveCell() {

            }

            @Override
            public CellAddress getAddress() {
                return null;
            }

            @Override
            public void setCellComment(Comment comment) {

            }

            @Override
            public Comment getCellComment() {
                return null;
            }

            @Override
            public void removeCellComment() {

            }

            @Override
            public Hyperlink getHyperlink() {
                return null;
            }

            @Override
            public void setHyperlink(Hyperlink hyperlink) {

            }

            @Override
            public void removeHyperlink() {

            }

            @Override
            public CellRangeAddress getArrayFormulaRange() {
                return null;
            }

            @Override
            public boolean isPartOfArrayFormulaGroup() {
                return false;
            }
        };
    }

}