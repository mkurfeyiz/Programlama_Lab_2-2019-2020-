/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import prolab2.pkg2.Pokemonlar.*;

/**
 *
 * @author asus1
 */
public class Deck {
    private ArrayList<Kart> deck=new ArrayList<Kart>(10);
    private int currentCard; //sonraki kartin indexi
    
    public Deck(ArrayList<Kart> deck)throws IOException
    {
        deck.add(new Kart(new Pikachu(),ImageIO.read(new File("pokemonlar//pikachu.jpg"))));
        deck.add(new Kart(new Bulbasaur(),ImageIO.read(new File("pokemonlar//bulbasaur.jpg"))));
        deck.add(new Kart(new Charmander(),ImageIO.read(new File("pokemonlar//charmander.png"))));
        deck.add(new Kart(new Squirtle(),ImageIO.read(new File("pokemonlar//squirtle.jpg"))));
        deck.add(new Kart(new Zubat(),ImageIO.read(new File("pokemonlar//zubat.jpg"))));
        deck.add(new Kart(new Psyduck(),ImageIO.read(new File("pokemonlar//psyduck.jpg"))));
        deck.add(new Kart(new Snorlax(),ImageIO.read(new File("pokemonlar//snorlax.jpg"))));
        deck.add(new Kart(new Butterfree(),ImageIO.read(new File("pokemonlar//butterfree.jpg"))));
        deck.add(new Kart(new Jigglypuff(),ImageIO.read(new File("pokemonlar//jigglypuff.jpg"))));
        deck.add(new Kart(new Meowth(),ImageIO.read(new File("pokemonlar//meowth.png"))));
//        for (int i = 0; i < deck.size(); i++) {
//            this.deck.add(deck.get(i));
//        }
    }
    
    public void deckiGoster(ArrayList<Kart> deck)
    {
        for (Kart kart : deck) {//javada foreach
            System.out.println(kart.getPokemonAdi()+" "+kart.getHasarPuani());
        }
    }
    
    //Decki karistirmak icin
    public void deckiKaristir(ArrayList<Kart> deck)
    {
        int digerKart;
        Kart temp;
        currentCard=0;
        SecureRandom random=new SecureRandom();
        for (int ilkKart = 0; ilkKart < deck.size(); ilkKart++) {
            digerKart=random.nextInt(10);
            
            temp=deck.get(ilkKart);
            deck.set(ilkKart, deck.get(digerKart));
            deck.set(digerKart,temp);
        }
    }
    

   
}//class sonu
