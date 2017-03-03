/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Modele;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dark pantoufle
 */
public class Player {
    
    public String name;
    public boolean currentplayer;
    public List<String> words;
    
        public Player(String a){
            this.name = a;
            this.words = new ArrayList<>();
        }
        
        public void addword(String a){
            words.add(a);
        }
    
        public int wordsnumber(){
          return words.size();
        }
           
        public boolean win(){
            if(words.size()==9){
                return false;
            } return false;
        }
        
        public void delword(String a){
            this.words.remove(a);
        }
}
