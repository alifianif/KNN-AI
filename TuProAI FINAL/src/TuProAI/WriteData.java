/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuProAI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Nuzulul Aulia P P
 */
public class WriteData {
    private static Workbook workbook = new XSSFWorkbook();
    private static Sheet sheet = workbook.createSheet("Data Test");
    
    public void CreateExcelTrainTrain(int size, String file) throws IOException
    {
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        for (int i = 0; i <= size; i++){
        data.put(Integer.toString(i+1), new Object [] {"ID", "Y"});}
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) 
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) 
            {
            Cell cell = row.createCell(cellnum++);
		if(obj instanceof String)
                    cell.setCellValue((String)obj);
            }
        }
        try 
        {
            FileOutputStream out = new FileOutputStream(new File(file));
            workbook.write(out);
            out.close();
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
        }
    }
    
    public void CreateExcelTrainTest() throws IOException
    {
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        for (int i = 0; i <= 10000; i++){
        data.put(Integer.toString(i+1), new Object [] {"ID", "Y"});}
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) 
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) 
            {
            Cell cell = row.createCell(cellnum++);
		if(obj instanceof String)
                    cell.setCellValue((String)obj);
            }
        }
        try 
        {
            FileOutputStream out = new FileOutputStream(new File("Nilai Y Data Test.xlsx"));
            workbook.write(out);
            out.close();
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
        }
    }
    
    public void WriteDataTrainTrain(int baris, int id, double hasilfix) throws java.io.IOException
    {
        try 
        {
            FileInputStream file = new FileInputStream(new File("Data Akurasi.xlsx"));

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell = null;
            cell = sheet.getRow(baris).getCell(0);
            cell.setCellValue(id);
            cell = sheet.getRow(baris).getCell(1);
            cell.setCellValue(hasilfix);
			
            file.close();
			
            FileOutputStream outFile =new FileOutputStream(new File("Data Akurasi.xlsx"));
            workbook.write(outFile);
            outFile.close();
			
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    public void WriteDataTrainTest(int baris, int id, double hasilfix) throws java.io.IOException
    {
        try 
        {
            FileInputStream file = new FileInputStream(new File("Nilai Y Data Test.xlsx"));

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell = null;
            cell = sheet.getRow(baris).getCell(0);
            cell.setCellValue(90000+id);
            cell = sheet.getRow(baris).getCell(1);
            cell.setCellValue(hasilfix);
			
            file.close();
			
            FileOutputStream outFile =new FileOutputStream(new File("Nilai Y Data Test.xlsx"));
            workbook.write(outFile);
            outFile.close();
			
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
}

