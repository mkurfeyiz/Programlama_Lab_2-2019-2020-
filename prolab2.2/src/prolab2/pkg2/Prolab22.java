/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab2.pkg2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import prolab2.pkg2.Oyuncular.*;
import prolab2.pkg2.Pokemonlar.*;
import java.util.Scanner;

/**
 *
 * @author asus1
 */
public class Prolab22 {

    public static void main(String[] args) throws IOException {
        Arayuz arayuz=new Arayuz();
        ArrayList<Kart> deck = new ArrayList<Kart>(10);
        ArrayList<Kart> hand1 = new ArrayList<Kart>(3);
        ArrayList<Kart> hand2 = new ArrayList<Kart>(3);
        ArrayList<Kart> sahadakiPokemonlar = new ArrayList<Kart>(3);
        GameControl gameControl = new GameControl();
        Deck buildDeck = new Deck(deck);
        buildDeck.deckiKaristir(deck);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Oyuncu o1;
        Oyuncu o2;

        int o1Skoru, o2Skoru;
        int raunt = 1, oyuncuKarti = 0, botKarti = 0, bot2Karti = 0, secim;
        boolean kontrol = false;

        System.out.println("1 -> Oyuncu vs Bot");
        System.out.println("2 -> Bot vs Bot");
        System.out.println("Oyun türünü seçiniz");
        secim = scanner.nextInt();

        switch (secim) {
            case 1:
                o1 = new NormalOyuncu();
                o2 = new BilgisayarOyuncu();

                o1Skoru = o1.getSkor();
                o2Skoru = o2.getSkor();

                //Oyuncular başlangıç kartlarını çektiler
                o1.startingHand(hand1, deck);
                o2.startingHand(hand2, deck);

        //Programı test ederken elimdeki kartları öğrenmek için aşağıdaki kodu kullanacağım.
        /*System.out.println("Deckteki kartlar");
                 for (int i = 0; i < deck1.size(); i++) {
                 System.out.println(deck1.get(i).getPokemonAdi());
                 }
                 System.out.println("-----------------------------------");
                 for (int i = 0; i < deck2.size(); i++) {
                 System.out.println(deck2.get(i).getPokemonAdi());
                 }
                 System.out.println("------------------------------------");
                 System.out.println("Eldeki kartlar");
                 for (int i = 0; i < hand1.size(); i++) {
                 System.out.println(hand1.get(i).getPokemonAdi());
                 }
                 System.out.println("-----------------------------------");
                 for (int i = 0; i < 3; i++) {
                 System.out.println(hand2.get(i).getPokemonAdi());
                 }
                 System.out.println("\n");*/
        //switchle çalışırsam case 1 aşağıdaki kod olur.bot vs bot mantığı da aynı olacağı için sıkıntı yok.
        /*for (int i = 0; i < deck1.size(); i++) {
                 System.out.println(deck1.get(i).getPokemonAdi());
                 }
                 System.out.println("-----------------------------------");
                 for (int i = 0; i < deck2.size(); i++) {
                 System.out.println(deck2.get(i).getPokemonAdi());
                 }
                 System.out.println("Elde bulunan kartlar : \n");
                 o1.startingHand(hand1, deck1);
                 o2.startingHand(hand2, deck2);
                 for (int i = 0; i < hand1.size(); i++) {
                 System.out.println(hand1.get(i).getPokemonAdi());
                 }
                 System.out.println("-----------------------------------");
                 for (int i = 0; i < 3; i++) {
                 System.out.println(hand2.get(i).getPokemonAdi());
                 }
                 System.out.println("\nKart secimi\n");
                 int index=1;
                 System.out.println(o1.kartSec(hand1, 1).getPokemonAdi());
                 System.out.println(o2.kartSec(hand2, index).getPokemonAdi());
                 System.out.println("\nElde kalan kartlar \n");
                 for (int i = 0; i < hand1.size(); i++) {
                 System.out.println(hand1.get(i).getPokemonAdi());
                 }
                 for (int i = 0; i < hand2.size(); i++) {
                 System.out.println(hand2.get(i).getPokemonAdi());
                 }
                 System.out.println("\nKartlar çekildikten sonra eldeki kartlar : \n");
                 o1.kartCek(hand1, deck1);
                 o2.kartCek(hand2, deck2);
        
                 for (int i = 0; i < hand1.size(); i++) {
                 System.out.println(hand1.get(i).getPokemonAdi());
                 }
                 System.out.println("------------------------");
                 for (int i = 0; i < hand2.size(); i++) {
                 System.out.println(hand2.get(i).getPokemonAdi());
                 }*/
                //BU KISIMLAR ÇALIŞIYOR.PROJE İÇİN GERİYE KALAN İSTERLER ARAYÜZ VE OYUNUN ÇALIŞMASI.ISTEDIGIM DEGERI ELDE EDEBILIYORUM.
                //8.11.2019 --> Oyunun çalışma mekaniği tamamlandı.Geriye sadece bot vs bot modunu ayarlama ve arayüzü yapmak kaldı.Yapamazsan da canın sağolsun :*
                while (kontrol != true) {
                    System.out.println(raunt + ". Raunt\n");
                    //Oyuncular ellerindeki kartlardan birini oynayacak
                    System.out.println(o1.getOyuncuAdi() + " elindeki kartlardan birini seçiyor..");
                    oyuncuKarti = scanner.nextInt();
                    while (oyuncuKarti > hand1.size()) {
                        System.out.println(o1.getOyuncuAdi() + ",Hatalı Bir kart Seçimi Yaptın.Lütfen Tekrar Dene");
                        oyuncuKarti = scanner.nextInt();
                    }
                    sahadakiPokemonlar.add(0, o1.kartSec(hand1, oyuncuKarti));
                    System.out.println(o1.getOyuncuAdi() + " Seçimini Tamamladı");
                    System.out.println(o2.getOyuncuAdi() + " elindeki kartlardan birini seçiyor..");
                    botKarti = random.nextInt(hand2.size());
                    sahadakiPokemonlar.add(1, o2.kartSec(hand2, botKarti));
                    System.out.println(o2.getOyuncuAdi() + " Seçimini Tamamladı");
                    //Seçilen pokemonların bilgisi gösteriliyor.
                    System.out.println("Savaş Zamanı!");
                    System.out.println(o1.getOyuncuAdi() + ",Seçtiğin Pokemon : " + sahadakiPokemonlar.get(0).getPokemonAdi()
                            + " / Türü : " + sahadakiPokemonlar.get(0).getPokemonTuru() + " / Hasar Puanı : " + sahadakiPokemonlar.get(0).getHasarPuani());
                    System.out.println(o2.getOyuncuAdi() + ",Seçtiğin Pokemon : " + sahadakiPokemonlar.get(1).getPokemonAdi()
                            + " / Türü : " + sahadakiPokemonlar.get(1).getPokemonTuru() + " / Hasar Puanı : " + sahadakiPokemonlar.get(1).getHasarPuani());
                    //Raundu kazanan pokemon belirleniyor.Kazanan oyuncuya puan ekleniyor.
                    if (sahadakiPokemonlar.get(0).getHasarPuani() > sahadakiPokemonlar.get(1).getHasarPuani()) {
                        System.out.println("Bu Raundun Kazananı " + sahadakiPokemonlar.get(0).getPokemonAdi());
                        System.out.println("5 Puanın Sahibi " + o1.getOyuncuAdi() + " Oluyor");
                        o1Skoru += 5;
                    } else if (sahadakiPokemonlar.get(0).getHasarPuani() < sahadakiPokemonlar.get(1).getHasarPuani()) {
                        System.out.println("Bu Raundun Kazananı " + sahadakiPokemonlar.get(1).getPokemonAdi());
                        System.out.println("5 Puanın Sahibi " + o2.getOyuncuAdi() + " Oluyor");
                        o2Skoru += 5;
                    } else {
                        System.out.println(sahadakiPokemonlar.get(0).getPokemonAdi() + " ve" + sahadakiPokemonlar.get(1).getPokemonAdi() + " Berabere Kalıyor!");
                        System.out.println(o1.getOyuncuAdi() + "," + o2.getOyuncuAdi() + " Bu Raunttan Puan Alamadınız");
                    }
                    //Deckte kart varsa iki oyuncu da deckten kart çekiyor.
                    if (deck.size() != 0) {
                        System.out.println("Oyuncular Desteden Birer Kart Çekiyor");
                        o1.kartCek(hand1, deck);
                        o2.kartCek(hand2, deck);
                    } else {
                        System.out.println("Oyuncuların Destelerinde Kart Kalmadı!");
                    }
                    if (hand1.size() != 0 && hand2.size() != 0) {
                        System.out.println("Bir Sonraki Raunda Geçiliyor..\n");
                    }
                    //5. rauntta oyunun galibi kontrol ediliyor. 
                    if (hand1.size() == 0 && hand2.size() == 0) {
                        System.out.println("Son Raunt Tamamlandı\n");
                        o1.setSkor(o1Skoru);
                        o2.setSkor(o2Skoru);
                        System.out.println("Skorlar");
                        System.out.println("-" + o1.getOyuncuAdi() + " = " + o1.getSkor());
                        System.out.println("-" + o2.getOyuncuAdi() + " = " + o2.getSkor());
                        kontrol = gameControl.checkGame(o1Skoru, o2Skoru, o1, o2);
                    }
                    raunt++;
                }
                break;
            case 2:
                o1 = new BilgisayarOyuncu();
                o2 = new BilgisayarOyuncu();

                o1Skoru = o1.getSkor();
                o2Skoru = o2.getSkor();

                //Oyuncular başlangıç kartlarını çektiler
                o1.startingHand(hand1, deck);
                o2.startingHand(hand2, deck);
//                /*
//                 System.out.println(o1.getOyuncuAdi()+" "+o1.getOyuncuId());
//                 o1.setOyuncuAdi("avlanan avciiii");
//                 o1.setOyuncuId(83);
//                 System.out.println(o1.getOyuncuAdi()+" "+o1.getOyuncuId());*/
//                /*Pokemon p1=new Pikachu();
//                 System.out.println(p1.getHasarPuani()+" "+p1.getPokemonAdi());
//                 p1.setPokemonAdi("beter ali");
//                 p1.setHasarPuani(0);
//                 System.out.println(p1.getHasarPuani()+" "+p1.getPokemonAdi());*/
//
//        //Programı test ederken elimdeki kartları öğrenmek için aşağıdaki kodu kullanacağım.
//        /*System.out.println("Deckteki kartlar");
//                 for (int i = 0; i < deck1.size(); i++) {
//                 System.out.println(deck1.get(i).getPokemonAdi());
//                 }
//                 System.out.println("-----------------------------------");
//                 for (int i = 0; i < deck2.size(); i++) {
//                 System.out.println(deck2.get(i).getPokemonAdi());
//                 }
//                 System.out.println("------------------------------------");
//                 System.out.println("Eldeki kartlar");
//                 for (int i = 0; i < hand1.size(); i++) {
//                 System.out.println(hand1.get(i).getPokemonAdi());
//                 }
//                 System.out.println("-----------------------------------");
//                 for (int i = 0; i < 3; i++) {
//                 System.out.println(hand2.get(i).getPokemonAdi());
//                 }
//                 System.out.println("\n");*/
//        //switchle çalışırsam case 1 aşağıdaki kod olur.bot vs bot mantığı da aynı olacağı için sıkıntı yok.
//        /*for (int i = 0; i < deck1.size(); i++) {
//                 System.out.println(deck1.get(i).getPokemonAdi());
//                 }
//                 System.out.println("-----------------------------------");
//                 for (int i = 0; i < deck2.size(); i++) {
//                 System.out.println(deck2.get(i).getPokemonAdi());
//                 }
//                 System.out.println("Elde bulunan kartlar : \n");

//                 for (int i = 0; i < hand1.size(); i++) {
//                 System.out.println(hand1.get(i).getPokemonAdi());
//                 }
//                 System.out.println("-----------------------------------");
//                 for (int i = 0; i < 3; i++) {
//                 System.out.println(hand2.get(i).getPokemonAdi());
//                 }
//                 System.out.println("\nKart secimi\n");
//                 int index=1;
//                 System.out.println(o1.kartSec(hand1, 1).getPokemonAdi());
//                 System.out.println(o2.kartSec(hand2, index).getPokemonAdi());
//                 System.out.println("\nElde kalan kartlar \n");
//                 for (int i = 0; i < hand1.size(); i++) {
//                 System.out.println(hand1.get(i).getPokemonAdi());
//                 }
//                 for (int i = 0; i < hand2.size(); i++) {
//                 System.out.println(hand2.get(i).getPokemonAdi());
//                 }
//                 System.out.println("\nKartlar çekildikten sonra eldeki kartlar : \n");
//                 o1.kartCek(hand1, deck);
//                 o2.kartCek(hand2, deck);
//        
//                 for (int i = 0; i < hand1.size(); i++) {
//                 System.out.println(hand1.get(i).getPokemonAdi());
//                 }
//                 System.out.println("------------------------");
//                 for (int i = 0; i < hand2.size(); i++) {
//                 System.out.println(hand2.get(i).getPokemonAdi());
//                 }*/

                while (kontrol != true) {
                    System.out.println(raunt + ". Raunt\n");
                    //Oyuncular ellerindeki kartlardan birini oynayacak
                    System.out.println(o1.getOyuncuAdi() + " elindeki kartlardan birini seçiyor..");
                    botKarti = random.nextInt(hand1.size());
                    sahadakiPokemonlar.add(0, o1.kartSec(hand1, botKarti));
                    System.out.println(o1.getOyuncuAdi() + " Seçimini Tamamladı");
                    System.out.println(o2.getOyuncuAdi() + " elindeki kartlardan birini seçiyor..");
                    bot2Karti = random.nextInt(hand2.size());
                    sahadakiPokemonlar.add(1, o2.kartSec(hand2, bot2Karti));
                    System.out.println(o2.getOyuncuAdi() + " Seçimini Tamamladı");
                    //Seçilen pokemonların bilgisi gösteriliyor.
                    System.out.println("Savaş Zamanı!");
                    System.out.println(o1.getOyuncuAdi() + ",Seçtiğin Pokemon : " + sahadakiPokemonlar.get(0).getPokemonAdi()
                            + " / Türü : " + sahadakiPokemonlar.get(0).getPokemonTuru() + " / Hasar Puanı : " + sahadakiPokemonlar.get(0).getHasarPuani());
                    System.out.println(o2.getOyuncuAdi() + ",Seçtiğin Pokemon : " + sahadakiPokemonlar.get(1).getPokemonAdi()
                            + " / Türü : " + sahadakiPokemonlar.get(1).getPokemonTuru() + " / Hasar Puanı : " + sahadakiPokemonlar.get(1).getHasarPuani());
                    //Raundu kazanan pokemon belirleniyor.Kazanan oyuncuya puan ekleniyor.
                    if (sahadakiPokemonlar.get(0).getHasarPuani() > sahadakiPokemonlar.get(1).getHasarPuani()) {
                        System.out.println("Bu Raundun Kazananı " + sahadakiPokemonlar.get(0).getPokemonAdi());
                        System.out.println("5 Puanın Sahibi " + o1.getOyuncuAdi() + " Oluyor");
                        o1Skoru += 5;
                    } else if (sahadakiPokemonlar.get(0).getHasarPuani() < sahadakiPokemonlar.get(1).getHasarPuani()) {
                        System.out.println("Bu Raundun Kazananı " + sahadakiPokemonlar.get(1).getPokemonAdi());
                        System.out.println("5 Puanın Sahibi " + o2.getOyuncuAdi() + " Oluyor");
                        o2Skoru += 5;
                    } else {
                        System.out.println(sahadakiPokemonlar.get(0).getPokemonAdi() + " ve" + sahadakiPokemonlar.get(1).getPokemonAdi() + " Berabere Kalıyor!");
                        System.out.println(o1.getOyuncuAdi() + "," + o2.getOyuncuAdi() + " Bu Raunttan Puan Alamadınız :(");
                    }
                    //Deckte kart varsa iki oyuncu da deckten kart çekiyor.
                    if (deck.size() != 0) {
                        System.out.println("Oyuncular Desteden Birer Kart Çekiyor");
                        o1.kartCek(hand1, deck);
                        o2.kartCek(hand2, deck);
                    } else {
                        System.out.println("Oyuncuların Destelerinde Kart Kalmadı!");
                    }
                    if (hand1.size() != 0 && hand2.size() != 0) {
                        System.out.println("Bir Sonraki Raunda Geçiliyor..\n");
                    }
                    //5. rauntta oyunun galibi kontrol ediliyor. 
                    if (hand1.size() == 0 && hand2.size() == 0) {
                        System.out.println("Son Raunt Tamamlandı\n");
                        o1.setSkor(o1Skoru);
                        o2.setSkor(o2Skoru);
                        System.out.println("Skorlar");
                        System.out.println("-" + o1.getOyuncuAdi() + " = " + o1.getSkor());
                        System.out.println("-" + o2.getOyuncuAdi() + " = " + o2.getSkor());
                        kontrol = gameControl.checkGame(o1Skoru, o2Skoru, o1, o2);
                    }
                    raunt++;
                }
                break;
            default:
                System.out.println("Yanlış Seçim Yaptınız!");
                break;
        }

    }

}

class Arayuz {

    Arayuz() throws IOException {
        ArrayList<Kart> deck=new ArrayList<Kart>(10);
        Deck deste=new Deck(deck);
        JFrame window = new JFrame("Pokemon Card Game"); 
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane=new JPanel();
//        JLabel lblPokemon=new JLabel(new ImageIcon("pokemonlar//pokemon.png"));
//        lblPokemon.setSize(1000, 600);
//        lblPokemon.setLocation(0,100);
//        contentPane.add(lblPokemon);
//        
        JLabel[] lblKart=new JLabel[]{
            new JLabel(new ImageIcon(deck.get(0).getKartImg())),
            new JLabel(new ImageIcon(deck.get(1).getKartImg())),
            new JLabel(new ImageIcon(deck.get(2).getKartImg())),
            new JLabel(new ImageIcon(deck.get(3).getKartImg())),
            new JLabel(new ImageIcon(deck.get(4).getKartImg())),
            new JLabel(new ImageIcon(deck.get(5).getKartImg())),
            new JLabel(new ImageIcon(deck.get(6).getKartImg())),
            new JLabel(new ImageIcon(deck.get(7).getKartImg())),
            new JLabel(new ImageIcon(deck.get(8).getKartImg())),
            new JLabel(new ImageIcon(deck.get(9).getKartImg()))
        };
        for (int i = 0; i < lblKart.length; i++) {
            lblKart[i].setSize(100,100);
            lblKart[i].setLocation((i*10)+110, 130);
            contentPane.add(lblKart[i]);
        }
        
        
        window.add(contentPane);
        
        window.setVisible(true);
    }
}

class GameControl {

    public boolean checkGame(int skor1, int skor2, Oyuncu o1, Oyuncu o2) {
        if (skor1 > skor2) {
            System.out.println("\nOyunun Galibi " + o1.getOyuncuAdi() + " Oluyor!");
            System.out.println("Tebrikler!");
            return true;
        } else if (skor1 < skor2) {
            System.out.println("Oyunun Galibi " + o2.getOyuncuAdi() + " Oluyor!");
            System.out.println("Tebrikler!");
            return true;
        } else {
            System.out.println("Oyun Berabere Bitti." + o1.getOyuncuAdi() + "," + o2.getOyuncuAdi() + " Güzel Oyundu,Elinize Sağlık!!");
            return true;
        }
    }
}
