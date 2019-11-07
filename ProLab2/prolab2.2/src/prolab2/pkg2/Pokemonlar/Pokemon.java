/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2.Pokemonlar;

/**
 *
 * @author user
 */

public class Pokemon {
    String pokemonAdi;
    String pokemonTuru;
    int pokemonId;
    int hasarPuani;
    
    Pokemon()
    {
        
    }
    Pokemon(String pokemonAdi,String pokemonTuru)
    {
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
    }
    
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
    
    public String getPokemonAdi()
    {
        return this.pokemonAdi;
    }
    public void setPokemonAdi(String pokemonAdi)
    {
        this.pokemonAdi=pokemonAdi;
    }
    
    public int getPokemonId()
    {
        return this.pokemonId;
    }
    public void setPokemonId(int pokemonId)
    {
        this.pokemonId=pokemonId;
    }
    
    public String getPokemonTuru()
    {
        return this.pokemonTuru;
    }
    public void setPokemonTuru(String pokemonTuru)
    {
        this.pokemonTuru=pokemonTuru;
    }
    
    public int getHasarPuani()
    {
        return this.hasarPuani;
    }
    public void setHasarPuani(int hasarPuani)
    {
        this.hasarPuani=hasarPuani;
    }
}
