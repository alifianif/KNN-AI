/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuProAI;

/**
 *
 * @author Nuzulul Aulia P P
 */
public class DataTest {
    private double[] kolom;
    
    public DataTest()
    {
        kolom = new double[11];
    }

    public DataTest(double[] kolom)
    {
        kolom = new double[12];
        for(int i=0;i<12;i++)
        {
            this.kolom[i]=kolom[i];
        }
    }
     
    void setData(int i, double Data) 
    {
        this.kolom[i] = Data;
    }
    
    public double getData(int i) 
    {
        return kolom[i];
    }
    
    public double[] getData()
    {
        return kolom;
    }

}
