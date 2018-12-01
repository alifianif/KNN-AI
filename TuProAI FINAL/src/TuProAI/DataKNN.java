/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuProAI;

/**
 *
 * @author USER
 */
public class DataKNN {
    double jarak;
    int posisi;

    public DataKNN(double jarak, int posisi){
        this.jarak = jarak;
        this.posisi = posisi;
    }
    
    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }    
}
