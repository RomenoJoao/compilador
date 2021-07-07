/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorLexicos;

import java.util.ArrayList;

/**
 *
 * @author EGNOEL
 */

public class AnalisadorSimbolos {
   ArrayList <LexemasTokens> tokenLexema = new ArrayList<>();
 private   String lexema ="" , codigofonte ="" ;
  private  int i = 0 , estado=0 ,linha;

    public AnalisadorSimbolos(String codigoFonte) {
        this.codigofonte=codigoFonte+"";
    //    System.out.println(this.codigofonte);
    }
  public void voltar_carater(){
     lexema = "";
     estado = 0;
     i--;
                
    }
  public char ler_caracter(int i){
    char k=  this.codigofonte.charAt(i);
      return k;
  }
  
  public ArrayList <LexemasTokens> analex(){
      
    for(i=0,linha=1; i < codigofonte.length();i++){
       char ch = ler_caracter(i);
       
       switch(estado){
           case 0:
               if(ch=='/'){
                  
                   lexema+=ch;
                   estado=7;
               }else if(ch=='='){
               lexema+=ch;
                   estado=1;
                   
           }else if(ch=='+'){
               lexema+=ch;
               estado=2;
           } else if(ch=='-'){
               lexema+=ch;
               estado=3;
                
           }else if((ch >= '0') && (ch <= '9')){
                    lexema += ch;
                    
                  estado = 4;
                  
                } else if (((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z')) ){
                
                lexema += ch;
                i++;
                   ch= ler_caracter(i);
                while(((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z')) || ((ch >= '0') && (ch <= '9')) || (ch == '_') ){
                  // System.out.println(ch);
               
                   lexema += ch;
                    i++;
                   ch= ler_caracter(i);     
                  }
                if(Token.TOKEN_PALAVRA_RESERVADA.contains("["+lexema+"]")){
                    if(lexema.equals("short")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_SHORT));
                    }else if(lexema.equals("char")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CHAR));
                    }else if(lexema.equals("int")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_INT));
                    }else if(lexema.equals("long")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_LONG));
                    }else if(lexema.equals("float")){
                        tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_FLOAT));
                    }else if(lexema.equals("double")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_DOUBLE));
                    }else if(lexema.equals("boolean")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_BOOLEAN));
                    }else if(lexema.equals("public")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_PUBLIC));
                    }else if(lexema.equals("protected")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_PROTECTED));
                    }else if(lexema.equals("private")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_PRIVATE));
                    }else if(lexema.equals("static")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_STATIC));
                    }else if(lexema.equals("abstract")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_ABSTRACT));
                    }else if(lexema.equals("final")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_FINAL));
                    }else if(lexema.equals("native")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_NATIVE));
                    }else if(lexema.equals("synchronized")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_SYNCHRONIZED));
                    }else if(lexema.equals("transient")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_TRANSIENT));
                    }else if(lexema.equals("volatile")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_VOLATILE));
                    }else if(lexema.equals("strictfp")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_STRICTFP));
                    }else if(lexema.equals("package")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_PACKAGE));
                    }else if(lexema.equals("import")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_IMPORT));
                    }else if(lexema.equals("class")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CLASS));
                    }else if(lexema.equals("extends")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_EXTENDS));
                    }else if(lexema.equals("assert")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_ASSERT));
                    }else if(lexema.equals("break")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_BREAK));
                    }else if(lexema.equals("case")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CASE));
                    }else if(lexema.equals("catch")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CATCH));
                    }else if(lexema.equals("const")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CONST));
                    }else if(lexema.equals("continue")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_CONTINUE));
                    }else if(lexema.equals("default")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_DEFAULT));
                    }else if(lexema.equals("do")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_DO));
                    }else if(lexema.equals("else")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_ELSE));
                    }else if(lexema.equals("finally")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_FINALLY));
                    }else if(lexema.equals("for")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_FOR));
                    }else if(lexema.equals("goto")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_GOTO));
                    }else if(lexema.equals("if")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_IF));
                    }else if(lexema.equals("implements")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_IMPLEMENTS));
                    }else if(lexema.equals("instanceof")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_INSTANCEOF));
                    }else if(lexema.equals("interface")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_INTERFACE));
                    }else if(lexema.equals("new")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_NEW));
                    }else if(lexema.equals("return")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_RETURN));
                    }else if(lexema.equals("super")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_SUPER));
                    }else if(lexema.equals("switch")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_SWITCH));
                    }else if(lexema.equals("this")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_THIS));
                    }else if(lexema.equals("throw")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_THROW));
                    }else if(lexema.equals("throws")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_THROWS));
                    }else if(lexema.equals("try")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_TRY));
                    }else if(lexema.equals("void")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_VOID));
                    }else if(lexema.equals("while")){
                        tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_WHILE));
                    }
                  
                     voltar_carater();
                }
                else{
                    tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_ID));
                     voltar_carater();
                }
                } else if (ch == '>'){
                lexema += ch;
                estado=5;
                
                }
                else if(ch == '|'){
                    lexema +=ch;
                    estado = 6;
                 }
                else if (ch == '<'){
                lexema += ch;
                estado=8;
                
                }else if(ch=='.'){
                    lexema+=ch;
                    estado=12;
                    
                }else if(';'==ch){
                    lexema+=ch;
                    estado=13;
                    
                }else if(ch==','){
                    lexema+=ch;
                    estado=14;
                    
                }else if(ch==':'){
                    lexema+=ch;
                    estado=15;
                   
                }else if(ch=='%'){
                    lexema+=ch;
                   estado=9;
                }else if(ch=='('){
                    lexema+=ch;
                    estado=16;
                   
                }else if(ch==')'){
                    lexema+=ch;
                    estado=21;
                    
                }else if(ch=='['){
                    lexema+=ch;
                    estado=17;
                    
                }else if(ch==']'){
                    lexema+=ch;
                    estado=18;
                   
                }else if(ch=='{'){
                    lexema+=ch;
                    estado=19;
                    
                }else if(ch=='}'){
                    lexema+=ch;
                    estado=20;
                   
                }else if(ch=='*'){
                    lexema+=ch;
                    estado=11;
                }else if(ch=='\"'){
                    lexema+=ch;
                    estado=22;
                }else if(ch=='&'){
                    lexema+=ch;
                    estado=23;
                }else if(ch=='\''){
                    lexema+=ch;
                    estado=24;
                }else if(ch=='^'){
                    lexema+=ch;
                    estado=25;
                }else if(ch=='~'){
                    lexema+=ch;
                    estado=26;
                }else if(ch=='!'){
                    lexema+=ch;
                    estado=27;
                }
                else if(ch=='\n'){
                    linha++;
                }
               break;
           case 1:
               if(ch=='='){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_IGUAL_IGUAL));    
                   voltar_carater();i++;
               }else{
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_IGUAL));    
                   voltar_carater();
               }
               break;
           case 2:
               if(ch=='+'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_DUPLA_SOMA));    
                   voltar_carater();i++;
               }
             else  if(ch=='='){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_SOMAR_ATRIBUIR));    
                   voltar_carater();i++;
               }
             else{
                 tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_SOMA));    
                   voltar_carater();
             }
               break;
           case 3:
               if(ch=='-'){
                   lexema+=ch;
                   
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_DUPLA_SUBTRACAO));    
                   voltar_carater();i++;
               }else if(ch=='='){
                    lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_SUBTRAIR_ATRIBUIR));    
                   voltar_carater();i++;
               }else{
                  tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_SUBTRAI));    
                   voltar_carater();
               }
               break;
           case 4:
               while(((ch >= '0') && (ch <= '9'))){

                   lexema += ch;
                    i++;
                   ch= ler_caracter(i);
                
                  }
                if(ch == '.'){
                 lexema += ch;
                     i++;
                     ch= ler_caracter(i);
                   if((ch >= '0') && (ch <= '9')){
                   
                  lexema += ch;
                   while(((ch >= '0') && (ch <= '9'))){
                  // System.out.println(ch);
                  i++;
                   ch= ler_caracter(i);
                   lexema += ch;
                     
                  }
                
               tokenLexema.add(new LexemasTokens(linha, lexema , Token.TOKEN_FLOATI ));
                voltar_carater(); 
         
                  }
                } else{
               tokenLexema.add(new LexemasTokens(linha,lexema , Token.TOKEN_INTEIRO ));
                voltar_carater();
                }
               break;
           case 5:
               if(ch=='>'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MAIOR_MAIOR));
                   voltar_carater();i++;
               }else if(ch=='='){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MAIOR_IGUAL));
                   voltar_carater();i++;
               }else{
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MAIOR));
                   voltar_carater();
               }
               break;
           case 6:
               if(ch=='|'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_OR_OR));
                   voltar_carater();i++;
               }else{
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_OR));
                   voltar_carater();
               }
               break;
           case 7:
               if(ch=='='){
                   lexema+=ch;
                  tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_DIVIDIR_ATRIBUIR));
                  voltar_carater();i++;
               }
               else if(ch=='/'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_COMENTARIO_LINEAR));
                   voltar_carater();i++;
               }
               else if(ch=='*'){
                   lexema+=ch;
                   estado=10;
               }
               else{
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_DIV));    
               voltar_carater();
               }
               break;
           case 8:
               if(ch=='<'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MENOR_MENOR));
                   voltar_carater();i++;
               }else if(ch=='='){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MENOR_IGUAL));
                   voltar_carater();i++;
               }else{
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MENOR));
                   voltar_carater();
               }
               break;
           case 9:
               if(ch=='='){
                   lexema+=ch;
                    tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MOD_A));
                    voltar_carater();
               }else{
                    tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MOD));
                    voltar_carater();
               }
               break;
           case 10:
               while(i++<this.codigofonte.length()){
                   ch=ler_caracter(i++);
                   lexema+=ch;
                   if(ch=='*'){
                       if(i++<this.codigofonte.length()){
                            ch=ler_caracter(i++);
                            if(ch=='/'){
                                lexema+=ch;
                                break;
                            }
                       }
                   }
               }
               tokenLexema.add(new LexemasTokens(linha,lexema, Token.TOKEN_COMENTARIO_MULT));
               voltar_carater();
               break;
           case 11:
               if(ch=='='){
                   lexema+=ch;
                    tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MULTIPLICAR_ATRIBUIR));
                    voltar_carater();i++;
               }else{
                   
                    tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_MULT));
                    voltar_carater();
               }
               break;
           case 12:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_PONTO));
                    voltar_carater();
               break;
               
           case 13:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_PONTO_VIRGULA));
                    voltar_carater();
               break;
           case 14:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_VIRGULA));
                    voltar_carater();
               break;
           case 15:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_DOIS_PONTOS));
                    voltar_carater();
               break;
           case 16:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_ABRE_PARENTESES_CURVO));
                    voltar_carater();
               break;
               
           case 17:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_ABRE_PARENTESES_RETO));
                    voltar_carater();
               break;
           case 18:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_FECHA_PARENTESES_RETO));
                    voltar_carater();
               break;
           case 19:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_ABRECHAVETA));
                    voltar_carater();
               break;
           case 20:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_FECHA_CHAVETA));
                    voltar_carater();
               break;
           case 21:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_FECHA_PARENTESES_CURVO));
                    voltar_carater();
               break;
           case 22:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_ASPAS_DUPLAS));
                    voltar_carater();
               break;
           case 23:
                if(ch=='&'){
                   lexema+=ch;
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_AND_AND));
                   voltar_carater();i++;
               }else{
                   tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_AND));
                   voltar_carater();
               }
               break;
            case 24:
               tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_ASPAS_SIMPLES));
                    voltar_carater();
               break;
            case 25:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_XOR));
                voltar_carater();
                break;
            case 26:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_NOT));
                voltar_carater();
                break;
            case 27:
                tokenLexema.add(new LexemasTokens(linha,lexema,Token.TOKEN_NOTI));
                voltar_carater();
                break;    
    }
     
}
 return tokenLexema; }
}
