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
public class Meowth extends Pokemon{
    Meowth()
    {
        this.pokemonAdi="Meowth";
        this.pokemonTuru="Normal";
        this.hasarPuani=40;
    }
    Meowth(String pokemonAdi,String pokemonTuru)
    {
        super(pokemonAdi,pokemonTuru);
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
        this.hasarPuani=40;
    }
    @Override
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
}
