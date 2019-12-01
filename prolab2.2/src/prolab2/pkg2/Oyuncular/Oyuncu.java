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
public abstract class Oyuncu {
    int oyuncuId;
    String oyuncuAdi;
    int Skor;
    Random _random=new Random();
    ArrayList<Pokemon> pokemonlar=new ArrayList<Pokemon>(10);
    ArrayList<Pokemon> playerDeck=new ArrayList<Pokemon>(5);
    ArrayList<Pokemon> botDeck=new ArrayList<Pokemon>(5);
    
    public Oyuncu()
    {
        
    }
    public Oyuncu(String oyuncuAdi,int oyuncuId,int Skor)
    {
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuId=oyuncuId;
        this.Skor=Skor;
    }
    
    public void kartlariDagit(ArrayList<Kart> oyuncu1,ArrayList<Kart> tumDeck){
        int player_index;
        for (int i = 0; i < 5; i++) {
            player_index=_random.nextInt(tumDeck.size());
            oyuncu1.add(tumDeck.get(player_index));
            tumDeck.remove(player_index);
        }
    }
    
    public abstract Kart kartSec(ArrayList<Kart> hand,int index);
    
    public void kartCek(ArrayList<Kart> hand,ArrayList<Kart> deck){
        int index=deck.size();
        hand.add(deck.get(index-1));
        deck.remove(index-1);
    }
    
    public void startingHand(ArrayList<Kart> hand,ArrayList<Kart> deck)
    {
        for (int i = 0; i < 3; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
    }
    
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
