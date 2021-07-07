/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorLexicos;

/**
 *
 * @author EGNOEL
 */
public class LexemasTokens {
    
      private  String lexema;
  private String token;
    private int linha;

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
   
    
    public LexemasTokens( int linha,String lexema , String token){
        this.lexema= lexema;
        this.token = token;
        this.linha=linha;
    }
public LexemasTokens(int linha,String lexema){
    this.linha=linha;
    this.lexema=lexema;
}
    /**
     * @return the 
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}
