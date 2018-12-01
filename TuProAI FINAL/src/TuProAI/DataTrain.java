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
public class DataTrain {
    private double[] kolom;
    
    public DataTrain()
    {
        kolom = new double[12];
    }

    public DataTrain(double[] kolom)
    {
        kolom = new double[12];
        for(int i=0;i<13;i++)
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

    
}
