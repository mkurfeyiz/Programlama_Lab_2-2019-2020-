/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2.Pokemonlar;

/**
 *
 * @author asus1
 */
public class Jigglypuff extends Pokemon{
    public Jigglypuff()
    {
        this.pokemonAdi="Jigglypuff";
        this.pokemonTuru="Ses";
        this.hasarPuani=70;
    }
    public Jigglypuff(String pokemonAdi,String pokemonTuru)
    {
        super(pokemonAdi,pokemonTuru);
        this.pokemonAdi=pokemonAdi;
        this.pokemonTuru=pokemonTuru;
        this.hasarPuani=70;
    }
    @Override
    public int hasarPuaniniGoster()
    {
        return this.hasarPuani;
    }
}
