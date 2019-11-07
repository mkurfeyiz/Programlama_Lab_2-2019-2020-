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
public class BilgisayarOyuncu extends Oyuncu{
    ArrayList<String> botKartlari=new ArrayList<String>(5);//Oyunculardaki tum kartlar 2 farkli listeye atilip
    //bu listeler uzerinden asagidaki islemler icra edilecek
    BilgisayarOyuncu()
    {
        this.oyuncuId=idSayaci;
        this.idSayaci++;
        this.oyuncuAdi="Kurfo Bot";
        this.Skor=0;
    }
    BilgisayarOyuncu(String oyuncuAdi,int oyuncuId,int Skor)
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
