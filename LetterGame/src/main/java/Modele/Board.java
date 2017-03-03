/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Scanner;
/**
 *
 * @author dark pantoufle
 */
public class Board {
    public List<Character> boardchar;
    private Random alea;
    
    public Board(){
        boardchar = new ArrayList<>();
    }
    
    public boolean dicowordconfirm(String a) throws FileNotFoundException{
        File file = new File( "src/main/resources/dico.txt");
	Scanner scf = new Scanner(new FileReader(file)); 
                        
            while (scf.hasNextLine()) {
                String theword = scf.nextLine();
                if (theword.equals(a)){
                return true;
                }
            }
        return false;
    }
    
    public int numberchar(){
         return this.boardchar.size();
    }
    
    public void offcharacter(String sword){
        sword = sword.toUpperCase();
        Collection<Character> toto = new ArrayList<>();
        for (int i=0;i<sword.length();i++){
        toto.add(sword.charAt(i));
                }        
        boardchar.removeAll(toto);
    }
    
    public void addrandomletter(){
        this.boardchar.add(randomletter());
    }
    
    public Character randomletter(){
        alea = new Random();
        return (char)(65 + alea.nextInt(24));
    }
    
    public void printboard(){
        System.out.println(this.boardchar.toString());
    }
    
    public void printboard(int x){
        System.out.println(this.boardchar.get(x).toString());
    }
}
