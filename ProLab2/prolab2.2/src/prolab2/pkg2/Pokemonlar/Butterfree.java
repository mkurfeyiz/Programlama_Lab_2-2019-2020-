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
public class Butterfree extends Pokemon{
    Butterfree()
    {
        this.pokemonAdi="Butterfree";
        this.pokemonTuru="Hava";
        this.hasarPuani=10;
    }
    Butterfree(String pokemonAdi,String pokemonTuru)
    {
        super(pokemonAdi,pokemonTuru);
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
        this.hasarPuani=10;
    }
    @Override
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
}
