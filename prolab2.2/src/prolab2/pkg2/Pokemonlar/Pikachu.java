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
public class Pikachu extends Pokemon{
    public Pikachu()
    {
        this.pokemonAdi="Pikachu";
        this.pokemonTuru="Elektrik";
        this.hasarPuani=40;
    }
    public Pikachu(String pokemonAdi,String pokemonTuru)
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
