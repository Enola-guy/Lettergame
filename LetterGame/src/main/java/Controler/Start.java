package Controler;

import Modele.Player;
import Modele.Board;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
    public Player Pone;
    public Player Ptoo;
    public Board leboard;
    
    public Start(){
        leboard = new Board();                
        System.out.println("Demarrage du jeux");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter name Player 1 : ");
        this.Pone = new Player(sc.nextLine());
        
        System.out.println("Enter name Player 2 : ");
        this.Ptoo = new Player(sc.nextLine());
        
        leboard.addrandomletter();
        System.out.println("J1 tire la lettre:");
        leboard.printboard();
        System.out.println("J2 tire la lettre:");           
        leboard.addrandomletter();
        leboard.printboard(1);
        
        System.out.println("Le jeu commence");
        
        if(leboard.boardchar.get(0)>(leboard.boardchar.get(1))){
            Pone.currentplayer = false;
            Ptoo.currentplayer =  true;
                } else {
                        Pone.currentplayer = false;
                        Ptoo.currentplayer =  true;
                        }    
    
    }
    
    
    public void cycle(){
        //ultra ez start, test fction
        Pone = new Player("jo");
        Ptoo = new Player("bob");
        Pone.currentplayer = true;
        Ptoo.currentplayer =  false;
        
        Scanner sc = new Scanner(System.in);
        Player curplay;
        
         if (Pone.currentplayer ==  true){
            curplay = Pone;
            }else {curplay = Ptoo;}
        
    while(curplay.win()==false){  
        leboard.printboard();
        System.out.println("joueur1 : "+Pone.words.toString());
        System.out.println("joueur2 : "+Ptoo.words.toString());
        if (Pone.name == curplay.name ){
        System.out.println(Pone.name + " a toi de jouer" );
        }else { System.out.println(Ptoo.name + " a toi de jouer");}
        
        String tryword = sc.nextLine();
        
       // System.out.println(whereisword(tryword));
        //System.out.println(StringInBoard(tryword,leboard));
        
       try {
            if(leboard.dicowordconfirm(tryword)){
               removefromwhereitis(tryword);
               System.out.println(curplay.name + " Gagne un mot, GG!!");
               
                    if(curplay.name == Pone.name){
                        Pone.addword(tryword);
                        curplay = Ptoo;
                                                                                 
                    }else{
                        Ptoo.addword(tryword);
                        curplay = Pone;}
                    
            }else {System.out.println("ce mot n'exist pas tour suivant");}
            } catch (FileNotFoundException ex){}
            
        //Switch Player
        if (Pone.name == curplay.name){
            curplay = Ptoo;
        }else{curplay = Pone;}
 
    leboard.addrandomletter();    
    }
    }

    public void removefromwhereitis(String wordtype){
        boolean boucle = true;
    
        for(int i = 0; i <Ptoo.words.size()&& boucle;i++){
            CharSequence csw = Ptoo.words.get(i);       
            if(wordtype.contains(csw)){
                Ptoo.words.remove(i);
                boucle = false;}
        }
    
        for(int i = 0; i <Pone.words.size()&& boucle;i++){
            CharSequence csw = Pone.words.get(i);
            if(wordtype.contains(csw)){
                Pone.words.remove(i);
                boucle = false;}
        }
    
        for(int i = 0; i <leboard.boardchar.size()&& boucle;i++){
            leboard.offcharacter(wordtype); 
        }
    }
    
    public boolean whereisword(String wordtype){
        boolean boucle = true;
        wordtype.toUpperCase();      
        for(int i = 0; i <Ptoo.words.size()&& boucle;i++){
            CharSequence csw = Ptoo.words.get(i);
            if(wordtype.contains(csw)){
                wordtype.replaceAll(Ptoo.words.get(i), "");
                boucle = false ;
            }
        }
        for(int i = 0; i <Pone.words.size()&& boucle;i++){
            CharSequence csw = Pone.words.get(i);
            if(wordtype.contains(csw)){
                wordtype.replaceAll(Pone.words.get(i), "");
                boucle = false;
            }
        }
        
       return StringInBoard(wordtype,leboard);        
        
        
    }    

    public boolean StringInBoard(String s, Board bobo){
        CharSequence cs = s;
        boolean var = false;
        
        for(int j = 0;j<cs.length();j++){
            
            for(int i =0;i<bobo.boardchar.size();i++){
                if(bobo.boardchar.get(i)==cs.charAt(j)){
                var = true;
                System.out.println("ce cara y est");
                }
                
            }            
            if(var = false){
                return false;
            }
        }
   
        return false;
    }

}
    
