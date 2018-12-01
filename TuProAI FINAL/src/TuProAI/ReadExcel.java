/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuProAI;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Nuzulul Aulia P P
 */
public class ReadExcel {
    public ArrayList<DataTrain> readTrain(String file) throws ClassNotFoundException
    {
	try
	{
            String excelFilePath = file;
            FileInputStream fileInput;
            fileInput = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInput);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            ArrayList<DataTrain> data = new ArrayList();
            Row nextRow = iterator.next();
            while (iterator.hasNext()) 
            {
                nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                DataTrain dataTrain=new DataTrain();
                int i=0;
                Cell cell = cellIterator.next();
                while (cellIterator.hasNext()) 
                {
                    cell = cellIterator.next();
                    dataTrain.setData(i,cell.getNumericCellValue());
                    i++;
                }  
                data.add(dataTrain);
            }
            workbook.close();
            fileInput.close();
            return data;
        }
        catch (Exception e) 
        {
            e.printStackTrace(); return null;
        }
    }
    
    public ArrayList<DataTest> readTest(String file) throws ClassNotFoundException
    {
	try
	{
            String excelFilePath = file;
            FileInputStream fileInput;
            fileInput = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInput);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            ArrayList<DataTest> data = new ArrayList();
            Row nextRow = iterator.next();
            while (iterator.hasNext()) 
            {
                nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                DataTest dataTest = new DataTest();
                int i=0;
                Cell cell = cellIterator.next();
                while (cellIterator.hasNext()) 
                {
                    cell = cellIterator.next();
                    dataTest.setData(i,cell.getNumericCellValue());
                    i++;
                }  
                data.add(dataTest);
            }
            workbook.close();
            fileInput.close();
            return data;
        }
        catch (Exception e) 
        {
            e.printStackTrace(); return null;
        }
    }
    
    public ArrayList<DataTrain> readDataAkurasi() throws ClassNotFoundException
    {
	try
	{
            String excelFilePath = "Data Akurasi.xlsx";
            FileInputStream fileInput;
            fileInput = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInput);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            ArrayList<DataTrain> data = new ArrayList();
            Row nextRow = iterator.next();
            while (iterator.hasNext()) 
            {
                nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                DataTrain dataTrain=new DataTrain();
                int i=0;
                Cell cell = cellIterator.next();
                while (cellIterator.hasNext()) 
                {
                    cell = cellIterator.next();
                    dataTrain.setData(i,cell.getNumericCellValue());
                    i++;
                }  
                data.add(dataTrain);
            }
            workbook.close();
            fileInput.close();
            return data;
        }
        catch (Exception e) 
        {
            e.printStackTrace(); return null;
        }
    }
}
