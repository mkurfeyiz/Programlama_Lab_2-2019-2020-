/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2.Oyuncular;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public abstract class Oyuncu {
    int oyuncuId;
    String oyuncuAdi;
    int Skor;
    static int idSayaci=1;
    ArrayList<String> kartListesi=new ArrayList<String>(10);
    boolean kartKullanildiMi;
    Oyuncu()
    {
        
    }
    Oyuncu(String oyuncuAdi,int oyuncuId,int Skor)
    {
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuId=oyuncuId;
        this.Skor=Skor;
    }
    
    public abstract String kartSec();
    
    public int skorGoster()
    {
        return this.Skor;
    }
    
    public String getOyuncuAdi()
    {
        return this.oyuncuAdi;
    }
    public void setOyuncuAdi(String oyuncuAdi)
    {
        this.oyuncuAdi=oyuncuAdi;
    }
    
    public int getOyuncuId()
    {
        return this.oyuncuId;
    }
    public void setOyuncuId(int oyuncuId)
    {
        this.oyuncuId=oyuncuId;
    }
    
    public int getSkor()
    {
        return this.Skor;
    }
    public void setSkor(int Skor)
    {
        this.Skor=Skor;
    }
}
