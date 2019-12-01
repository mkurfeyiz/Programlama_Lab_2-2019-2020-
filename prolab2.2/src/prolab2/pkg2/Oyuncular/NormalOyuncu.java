/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2.Oyuncular;

import java.util.ArrayList;
import prolab2.pkg2.Kart;
import prolab2.pkg2.Pokemonlar.*;

/**
 *
 * @author asus1
 */
public class NormalOyuncu extends Oyuncu{
    ArrayList<Pokemon> hand=new ArrayList<Pokemon>(3);
    public NormalOyuncu()
    {
        this.oyuncuId=_random.nextInt(1000);
        this.oyuncuAdi="PokemonMaster_69";
        this.Skor=0;
    }
    public NormalOyuncu(String oyuncuAdi,int oyuncuId,int Skor)
    {
        super(oyuncuAdi,oyuncuId,Skor);
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuId=oyuncuId;
        this.Skor=Skor;
    }
    
    @Override
    public Kart kartSec(ArrayList<Kart> hand,int index)
    {
        Kart kart=hand.get(index-1);
        hand.remove(index-1);
        return kart;
    }
   
}
