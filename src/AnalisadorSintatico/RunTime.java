/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorSintatico;
import AnalisadorLexicos.AnalisadorSimbolos;
import AnalisadorLexicos.LexemasTokens;
import AnalisadorLexicos.Token;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AIRES DO ROSARIO
 */
public class RunTime {
    static  private String lerficheiro(){
       Scanner ficheiro;
       ArrayList <Character> ch = new ArrayList<>(); 
       String pala ="";
       
        try {
        ficheiro = new Scanner(new File("testito.txt"));
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
    public static void main(String[] args) {
         String cod = lerficheiro();
        AnalisadorSimbolos lexico=new AnalisadorSimbolos(cod);
        ArrayList <LexemasTokens> lexes= lexico.analex();
        Analise a= new Analise();
        ArrayList <Erro> erros=a.error(lexes);
        System.out.println(erros.size());
      
        System.out.println("=================================================================================");
        for(int i=0; i<erros.size();i++){
            System.out.println(erros.get(i).getErro()+" Linha: "+erros.get(i).getLinha());
        }
    }
}
