/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorLexicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EGNOEL
 */
public class compilar {

    /**
     * @param args the command line arguments
     */
     static  public String lerficheiro(){
       Scanner ficheiro;
       ArrayList <Character> ch = new ArrayList<>(); 
       String pala ="";
       
        try {
        ficheiro = new Scanner(new File("texto.txt"));
       while(ficheiro.hasNextLine()){ 
           pala+=ficheiro.nextLine()+"\n";
       }   
        ficheiro.close();
        }
        
        catch(FileNotFoundException e){
            
            System.out.println("erro");
    
      }
 return pala;   
}
   /*
    public static void main(String[] args) {
        // TODO code application logic here
        String cod = lerficheiro();
        
        AnalisadorSimbolos an=new AnalisadorSimbolos(cod);
       ArrayList<LexemasTokens> arr=an.analex();   
         System.out.println("Lexema                   Token                   Linha");
    for(LexemasTokens x : arr){
           
       System.out.println( x.getLexema() + "                   " + x.getToken() +"                   " + x.getLinha() );
       }  
    
    
    } 
   */
}
