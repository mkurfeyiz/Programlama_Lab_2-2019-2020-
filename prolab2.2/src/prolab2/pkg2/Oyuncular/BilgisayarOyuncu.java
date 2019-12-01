/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2.Oyuncular;

import java.util.ArrayList;
import java.util.Random;
import prolab2.pkg2.Kart;
import prolab2.pkg2.Pokemonlar.*;

/**
 *
 * @author asus1
 */
public class BilgisayarOyuncu extends Oyuncu{
    ArrayList<Pokemon> hand=new ArrayList<Pokemon>(3);
    public BilgisayarOyuncu()
    {
        this.oyuncuId=_random.nextInt(1000);
        this.oyuncuAdi="Kurfo Bot";
        this.Skor=0;
    }
    public BilgisayarOyuncu(String oyuncuAdi,int oyuncuId,int Skor)
    {
        super(oyuncuAdi,oyuncuId,Skor);
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuId=oyuncuId;
        this.Skor=Skor;
    }
   
   
    @Override
    public Kart kartSec(ArrayList<Kart> hand,int index)
    {
        index=_random.nextInt(hand.size());
        Kart kart=hand.get(index);
        hand.remove(index);
        return kart;
    }
    
}
