/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import prolab2.pkg2.Pokemonlar.*;

/**
 *
 * @author asus1
 */
public class Kart {
    private int hasarPuani;
    private String pokemonAdi;
    private String pokemonTuru;
    private BufferedImage kartImg;
    Kart(Pokemon pokemon,BufferedImage kartImg){
        this.hasarPuani=pokemon.getHasarPuani();
        this.pokemonAdi=pokemon.getPokemonAdi();
        this.pokemonTuru=pokemon.getPokemonTuru();
        this.kartImg=kartImg;
    }
    
    public int getHasarPuani()
    {
        return hasarPuani;
    }
    
    public String getPokemonTuru()
    {
        return pokemonTuru;
    }
    
    public String getPokemonAdi()
    {
        return pokemonAdi;
    }
    
    @Override
    public String toString()
    {
        return pokemonAdi;
    }
    
    public BufferedImage getKartImg()
    {
        return kartImg;
    }
}
