/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuProAI;

import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * Alifiani Fauzia              (1301140417)
   Nuzulul Aulia Perdana Putra  (1301144037)
   Muhammad Thomy Farhan        (1301140397)
   Setyono Dwi Utomo            (1103134393)

 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner input =new Scanner(System.in);
        int pil = 0;
        ReadExcel read = new ReadExcel();
        WriteData write = new WriteData();
        
        System.out.println("Menu : ");
        System.out.println("1. Run Train-Tes");
        System.out.println("2. Run Train-Train");
        System.out.println("3. Akurasi");
        System.out.print("Input Menu : ");
        pil = input.nextInt();
        switch (pil)
        {
            case 1 :
                double kelas = 0;
                double hasil[] = new double[999999];
                double hasilfix = 0;
                ArrayList<DataTest> arrayDataTest = new ArrayList();
                ArrayList<DataTrain> arrayDataTrain = new ArrayList();
                DataTest dataTest = new DataTest();
                DataTrain dataTrain = new DataTrain();
                arrayDataTest = read.readTest("Test.xlsx"); 
                arrayDataTrain = read.readTrain("Train.xlsx");
                write.CreateExcelTrainTest();
        
                for(int i = 0; i < 10000 ; i++)
                {
                    dataTest = arrayDataTest.get(i);
                    for(int j = 0; j < 90000 ; j++)
                    {    
                        double jmlh = 0;
                        dataTrain = arrayDataTrain.get(j);
                        for(int k = 0; k < 10; k++)
                        {
                            jmlh = jmlh + pow((dataTest.getData(k) - dataTrain.getData(k)), 2);
                        }
                        hasil[j] = jmlh;
                    }
                    hasilfix = sqrt(hasil[0]);
                    for(int l = 0; l < 90000; l++)
                    {
                        if (sqrt(hasil[l]) <= hasilfix)
                        {
                            hasilfix = sqrt(hasil[l]);
                            kelas = arrayDataTrain.get(l).getData(10);
                            write.WriteDataTrainTest((i+1), (i+1), kelas);
                        }
                    }
                System.out.print("KNN data ke-" + (i+1));
                System.out.println(" : " + hasilfix + " , kelas : " + kelas);
                }
                break;
                
            case 2 :
                System.out.println("1. K = 1");
                System.out.println("2. K = 5");
                System.out.println("3. K = 7");
                System.out.println("4. K = 11");
                int pil1 = 0;
                pil1 = input.nextInt();
                switch(pil1)
                {
                    case 1 :
                        double kelas1 = 0;
                        double hasil1[] = new double[999999];
                        double hasilfix1 = 0;
                        ArrayList<DataTrain> arrayDataTrain1 = new ArrayList();
                        ArrayList<DataTrain> arrayDataTrain2 = new ArrayList();
                        DataTrain dataTrain1 = new DataTrain();
                        DataTrain dataTrain2 = new DataTrain();
                        arrayDataTrain1 = read.readTrain("Train.xlsx"); 
                        arrayDataTrain2 = read.readTrain("Train.xlsx");

                        write.CreateExcelTrainTrain(arrayDataTrain1.size(),"DataAkurasiK1.xslx");

                        for(int i = 0; i < 22500 ; i++)
                        {
                            dataTrain1 = arrayDataTrain1.get(i);
                            for(int j = 0; j < 22500 ; j++)
                            {    
                                double jmlh1 = 0;
                                dataTrain2 = arrayDataTrain2.get(j);
                                for(int k = 0; k < 10; k++)
                                {
                                    jmlh1 = jmlh1 + pow((dataTrain1.getData(k) - dataTrain2.getData(k)), 2);
                                }
                                hasil1[j] = jmlh1;
                            }
                            hasilfix1 = sqrt(hasil1[0]);
                            for(int l = 0; l < 90000; l++)
                            {
                                if (sqrt(hasil1[l]) <= hasilfix1)
                                {
                                    hasilfix1 = sqrt(hasil1[l]);
                                    kelas1 = arrayDataTrain2.get(l).getData(10);
                                    write.WriteDataTrainTrain((i+1), (i+1), kelas1);
                                }
                            }
                        System.out.print("KNN data ke-" + (i+1));
                        System.out.println(" : " + hasilfix1 + " , kelas : " + kelas1);
                        }
                        break;
                    
                    case 2 :
                        double kelas5 = 0;
                        double hasil5[] = new double[999999];
                        double hasilfix5 = 0;
                        ArrayList<DataTrain> arrayDataTrain51 = new ArrayList();
                        ArrayList<DataTrain> arrayDataTrain52 = new ArrayList();
//                        ArrayList<DataTrain> arraySimpanKNN = new ArrayList();
                        DataKNN arrayDataKNN[];
                        DataTrain dataTrain51 = new DataTrain();
                        DataTrain dataTrain52 = new DataTrain();
                        arrayDataTrain51 = read.readTrain("Train.xlsx"); 
                        arrayDataTrain52 = read.readTrain("Train.xlsx");

                        write.CreateExcelTrainTrain(arrayDataTrain52.size(),"DataAkurasiK5.xslx");

                        for(int i = 22500; i < 45000 ; i++)
                        {
                            dataTrain51 = arrayDataTrain51.get(i);
                            for(int j = 22500; j < 45000 ; j++)
                            {    
                                double jmlh1 = 0;
                                dataTrain52 = arrayDataTrain52.get(j);
                                for(int k = 0; k < 10; k++)
                                {
                                    jmlh1 = jmlh1 + pow((dataTrain51.getData(k) - dataTrain52.getData(k)), 2);
                                }
                                hasil5[j] = jmlh1;
                                hasilfix5 = sqrt(hasil5[0]);
                                DataKNN dataKNN = new DataKNN(hasilfix5, j);
                                arrayDataKNN.add(dataKNN);
                            }
                            for(int l = 0; l < 22500; l++)
                            {
                                if (arrayDataKNN.get(l).getJarak() <= arrayDataKNN.get(i+1).getJarak())
                                {
                                    hasilfix1 = sqrt(hasil1[l]);
                                    kelas5 = arrayDataTrain2.get(l).getData(10);
                                    write.WriteDataTrainTrain((i+1), (i+1), kelas1);
                                }
                            }
                        System.out.print("KNN data ke-" + (i+1));
                        System.out.println(" : " + hasilfix1 + " , kelas : " + kelas1);
                        }
                        break;
                }
                break;
            
            case 3 :
                System.out.println("1. K = 1");
                System.out.println("2. K = 5");
                System.out.println("3. K = 7");
                System.out.println("4. K = 11");
                int pilih = 0;
                pilih = input.nextInt();
                switch(pilih)
                {
                    case 1 :
                        int sama = 0;
                        double result = 0;
                        ArrayList<DataTrain> arrayDataTrain3 = new ArrayList();
                        ArrayList<DataTrain> arrayDataAkurasi = new ArrayList();
                        DataTrain dataTrain3 = new DataTrain();
                        DataTrain dataAkurasi = new DataTrain();
                        arrayDataTrain3 = read.readTrain(); 
                        arrayDataAkurasi = read.readDataAkurasi();
                        for (int i = 0; i < 90000; i++)
                        {
                            if (arrayDataTrain3.get(i).getData(10) == arrayDataAkurasi.get(i).getData(0))
                            {
                                sama++;
                            }
                            System.out.print("data ke- : " + (i + 1) + " " + arrayDataTrain3.get(i).getData(10) + ", ");
                            System.out.println(arrayDataAkurasi.get(i).getData(0));
                        }
                        result = sama * 100 / 90000;
                        System.out.println("Akurasi data KNN : " + result + "%");
                }
                
                break;
            
        }
    }
}    
