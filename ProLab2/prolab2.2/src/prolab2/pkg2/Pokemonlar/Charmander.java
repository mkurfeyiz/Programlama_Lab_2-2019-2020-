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
public class Charmander extends Pokemon{
    Charmander()
    {
        this.pokemonAdi="Charmander";
        this.pokemonTuru="Ateş";
        this.hasarPuani=60;
    }
    Charmander(String pokemonAdi,String pokemonTuru)
    {
        super(pokemonAdi,pokemonTuru);
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
        this.hasarPuani=60;
    }
    @Override
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
    
}
