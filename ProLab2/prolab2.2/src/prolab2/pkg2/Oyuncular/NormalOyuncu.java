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
public class NormalOyuncu extends Oyuncu{
    ArrayList<String> oyuncuKartlari=new ArrayList<String>(5);
    NormalOyuncu()
    {
        this.oyuncuId=idSayaci;
        this.idSayaci++;
        this.oyuncuAdi="BeastMaster_69";
        this.Skor=0;
    }
    NormalOyuncu(String oyuncuAdi,int oyuncuId,int Skor)
    {
        super(oyuncuAdi,oyuncuId,Skor);
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuId=oyuncuId;
        this.Skor=Skor;
    }
    @Override
    public String kartSec()
    {
        String kart=kartListesi.get(0).toString();
        return kart;
    }
    
}
