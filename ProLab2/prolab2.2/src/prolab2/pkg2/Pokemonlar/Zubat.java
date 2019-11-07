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
public class Zubat extends Pokemon{
    Zubat()
    {
        this.pokemonAdi="Zubat";
        this.pokemonTuru="Hava";
        this.hasarPuani=50;
    }
    Zubat(String pokemonAdi,String pokemonTuru)
    {
        super(pokemonAdi,pokemonTuru);
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
        this.hasarPuani=50;
    }
    @Override
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
}
