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
 * @author AIRES DO ROSARIO
 */
public class Analise {
   ArrayList <LexemasTokens> regras;
   AnalisadorSimbolos lexico;
   ArrayList <Erro> erros= new ArrayList() ;
   int i=0;
   
       
       public  ArrayList<Erro> error( ArrayList<LexemasTokens> lex){
           regras=lex;
           principio();
           return erros;
       }
    ArrayList <ClassVari> variaveis;
      private void principio(){
       variaveis=new ArrayList();
       pacote();i++;
       listadclImport();
       ListaDeclaracao();
    
    }
      private void listadclImport(){
          
          Import();
          if(i<regras.size()){
              while(regras.get(i).getToken().equals("import")){
                  Import();
              }
         
          }
      }
   
   private boolean modificador(){
        if(regras.get(i).getToken().equals("public")){
            return true ;
        }else if(regras.get(i).getToken().equals("protected")){
             return true ;
        }else if(regras.get(i).getToken().equals("private")){
             return true;
        }else if(regras.get(i).getToken().equals("static")){
             return true;
        }else if(regras.get(i).getToken().equals("abstract")){
             return true;
        }else if(regras.get(i).getToken().equals("final")){
             return true;
        }else if(regras.get(i).getToken().equals("native")){
             return true;
        }else if(regras.get(i).getToken().equals("synchronized")){
             return true;
        }else if(regras.get(i).getToken().equals("transient")){
             return true;
        }else if(regras.get(i).getToken().equals("volative")){
             return true;
        }else if(regras.get(i).getToken().equals("strictfp")){
             return true;
        }
       return false;
       
   }
   
   private void declaracaoClass(){
       
       if(modificador()) i++;
      
      if(i<regras.size()){
      if(regras.get(i).getToken().equals("class")){
          i++;
          if(i<regras.size()){
              if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                  i++;
                  corpoclass();
              }else{
                  Erro e=new Erro();
                 e.erro="Esperava-se encontrar um identificador";
                 e.linha=regras.get(i).getLinha();
                 erros.add(e);
              }
          } else{
                 Erro e=new Erro();
                 e.erro="Esperava-se encontrar um identificador";
                 e.linha=regras.get(i).getLinha();
                 erros.add(e);
          }
                  
      }else{
          Erro e=new Erro();
                 e.erro="Esperava-se encontrar a palavra reservada class";
                 e.linha=regras.get(i).getLinha();
                 erros.add(e);
      }
      
      }
    }
   private void corpoclass(){
       if(i<regras.size()){
       if( regras.get(i).getToken().equals("ABRE CHAVETA")){
           i++;
           if(i<regras.size()){
           
           listadeclCorpoClass();

           if( i< regras.size()){
               if(regras.get(i).getToken().equals("FECHA CHAVETA")){
                   
               }
          
           else{
               
                Erro e=new Erro();
                e.erro="Esperava-se encontrar um Fecha Chaveta ww";
                e.linha=regras.get(i-2).getLinha();
                erros.add(e);
           } }
       }else{
                Erro e=new Erro();
                e.erro="Esperava-se encontrar um Fecha Chaveta ff ";
                e.linha=regras.get(i-1).getLinha();
                erros.add(e);
           }
       }
       else
       {
            Erro e=new Erro();
            e.erro="Esperava-se encontrar um Abre Chaveta ";
            e.linha=regras.get(i).getLinha();
            erros.add(e);
       }
       }else{
           Erro e=new Erro();
            e.erro="Esperava-se encontrar um Abre Chaveta ";
            e.linha=regras.get(i).getLinha();
            erros.add(e);
       }
       
   }
  

    private void listadeclCorpoClass(){
        
       declaracaoCorpoClass();
       i++; 
           while(i<regras.size() && ((modificador() 
                   || regras.get(i).equals("IDENTIFICADOR") 
                   || regras.get(i).getToken().equals("class") 
                   || tipo() || regras.get(i).getToken().equals("void")))){
               declaracaoCorpoClass();i++;
           }

       
       
   }
   
   private void pacote(){
    if(regras.get(i).getToken().equals("package")){
            i++;
            if(i<regras.size()){
               
                if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                    i++;
                    if(i<regras.size()){
                        while(!regras.get(i).getToken().equals("PONTO E VIRGULA")){
                            if(i<regras.size()){
                            if(regras.get(i).getToken().equals("PONTO")){
                            i++;
                                if(i<regras.size()){
                                  
                                        if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                                            
                                        }else{
                                           Erro e=new Erro();
                                            e.erro="Esperava-se encontrar um identificador depois do .";
                                            e.linha=regras.get(i).getLinha();
                                            erros.add(e);
                                        }
                                }
                            }else if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
                            break;
                            }else{
                            Erro e=new Erro();
                            e.erro="Esperava-se ponto e virgula";
                            e.linha=regras.get(i).getLinha();
                            erros.add(e);
                            }
                        i++;
                        }
                    }
                    }else{
                        Erro e= new Erro();
                        e.erro="Esperava-se encontrar ponto ou ponto e virgula antes de ";
                        e.linha=regras.get(i).getLinha();
                        erros.add(e); 
                    }
                }else{
                    Erro e= new Erro();
                    e.erro="Esperava-se um Identificador antes de "+ regras.get(i).getToken();
                    e.linha=regras.get(i-1).getLinha();
                    erros.add(e);
                   
                }
            }else{
                Erro e= new Erro();
                e.erro="Esperava-se um Identificador";
                e.linha=regras.get(i).getLinha();
                erros.add(e);
            }
            
        }
}
   private boolean valor(){
       if(regras.get(i).getToken().equals("true")){
           return  true;
       } else if(regras.get(i).getToken().equals("null")){
           return true;
       } else if(regras.get(i).getToken().equals("VALOR_INTEIRO")){
           return true ;
       } else if(regras.get(i).getToken().equals("false")){
           return true;
       } else if(regras.get(i).getToken().equals("char")){
           return true;
       }else if(regras.get(i).getToken().equals("VALOR_REAL")){
           return true;
       }else if(regras.get(i).getToken().equals("String")){
           return true;
       } return false;
   }
    private void nome(){
        if(regras.get(i).getToken().equals("IDENTIFICADOR")){
        i++;
        if(i<regras.size()){
           if(regras.get(i).getToken().equals("PONTO")){
               i++; 
               nome();
            }
        }
        }else if(regras.get(i).getToken().equals("MULTIPLICAÇÃO")){
                
             }else{
                Erro e= new Erro();
                e.setErro("Esperava-se um Identificador");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        
    }
    private void auxImp(){
        int c=0; 
        if(i<regras.size()){
        if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
            i++;
            c=-1;
        }else if(regras.get(i).getToken().equals("MULTIPLICAÇÃO") && i<regras.size()){
                i++;
                if( regras.get(i).getToken().equals("PONTO E VIRGULA") && i<regras.size()){
                    i++;
                    c=-1;
                }
            }
        
        if(c==0){
                            Erro e=new Erro();
                            e.erro="Esperava-se ponto e virgula";
                            e.linha=regras.get(i-1).getLinha();
                            erros.add(e);
        }
      }else{
                            Erro e=new Erro();
                            e.erro="Esperava-se ponto e virgula";
                            e.linha=regras.get(i).getLinha();
                            erros.add(e);
        }
    }
    private void Import(){
        if(regras.get(i).getToken().equals("import")){
            i++;
                if(i<regras.size()){
                nome();
                auxImp();
                        
            }else{
                Erro e= new Erro();
                e.setErro("Esperava-se um a palavra reservada import");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }    
        }
    }
    
 
   private void ListaDeclaracao(){
       if(i<regras.size()){
           while(i<regras.size() && (regras.get(i).getToken().equals("public") || regras.get(i).getToken().equals("private")
                || regras.get(i).getToken().equals("protected") || regras.get(i).getToken().equals("static")
                || regras.get(i).getToken().equals("abstract") || regras.get(i).getToken().equals("final") 
                || regras.get(i).getToken().equals("native") || regras.get(i).getToken().equals("synchronized") 
                || regras.get(i).getToken().equals("transient") || regras.get(i).getToken().equals("volatile")
                ||regras.get(i).getToken().equals("class") || regras.get(i).getToken().equals("PONTO E VIRGULA"))){
                
               if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
                i++;
                } else if(regras.get(i).getToken().equals("public") || regras.get(i).getToken().equals("private")
                || regras.get(i).getToken().equals("protected") || regras.get(i).getToken().equals("static")
                || regras.get(i).getToken().equals("abstract") || regras.get(i).getToken().equals("final") 
                || regras.get(i).getToken().equals("native") || regras.get(i).getToken().equals("synchronized") 
                || regras.get(i).getToken().equals("transient") || regras.get(i).getToken().equals("volatile")
                ||regras.get(i).getToken().equals("class")){
       
                declaracaoClass();
             }
         }
       }
   }
    
   private boolean tipoPrimitivo(){
       if(regras.get(i).getToken().equals("byte")){
           return  true;
       } else if(regras.get(i).getToken().equals("short")){
           return true;
       } else if(regras.get(i).getToken().equals("int")){
           return true ;
       } else if(regras.get(i).getToken().equals("long")){
           return true;
       } else if(regras.get(i).getToken().equals("char")){
           return true;
       }else if(regras.get(i).getToken().equals("float")){
           return true;
       }else if(regras.get(i).getToken().equals("double")){
           return true;
       }else if(regras.get(i).getToken().equals("boolean")){
           return true;
       }else if(regras.get(i).getToken().equals("String")){
           return true;
       } return false;
   }
   private void vectorTipo(){
       if(regras.get(i).getToken().equals("IDENTIFICADOR")){
            nome();
            while(regras.get(i).getToken().equals("ABRE PARENTESES RECTO") && i<regras.size() ){
                i++;
                if(i>=regras.size()){
                    Erro e=new Erro();
                    e.setErro("Esperava FECHA PARENTESES RECTO");
                    e.setLinha(regras.get(i).getLinha());
                    erros.add(e); 
                
                }
                 i++;
        }
           
     }
       
   }
   private boolean tipo(){
       
       if(tipoPrimitivo()){
           return true;
       }/*else if(regras.get(i).getToken().equals("IDENTIFICADOR")){
       vectorTipo();
       i--;
       return true;
       }*/
       return false;
   }
   private void dcl_campo(){
       if(modificador())i++;
       if(tipo()){ 
           i++;                
       dcl_campo1();
   }
       /*System.out.println("\tdepois "+regras.get(i).getToken()+" "+regras.get(i).getLexema());
       System.out.println("\tdepois "+regras.get(i).getLinha());
       System.out.println("================");*/
       if(!regras.get(i).getToken().equals("PONTO E VIRGULA")){
            Erro e=new Erro();
                       e.setErro("Esperava ponto e virgula");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
                       i--;
       }
   }
   private void dcl_campo1(){
       dcl_varia();
       i++;
      if(i<regras.size() && regras.get(i).getToken().equals("VIRGULA")){
           while(i<regras.size() && regras.get(i).getToken().equals("VÍRGULA")){
               dcl_varia();
               i++;
            }
      }else i--;
   }
   private void listaDclVariavel(){
       dcl_varia();
       i++;
       if(i<regras.size()){
           if(regras.get(i).getToken().equals("VIRGULA")){
               
           while(regras.get(i).getToken().equals("VIRGULA")){
               dcl_varia();
           }
          }else i--;
       }
   }
   private void dcl_varia(){
       id_dclv();
       i++;
       if(regras.get(i).getToken().equals("IGUAL")){
           inicializacaovariavel();
       }else i--;
   }
   private void inicializacaovariavel(){
       if(i<regras.size()){
       if(regras.get(i).getToken().equals("ABRE CHAVETA")){
           
           inicializacaoArray();
       
       }else{
           i--;
           expressao();i--;
       }
           
       }
   }
   private void inicializadoresVariaveis(){
       inicializacaovariavel(); i++;
       while(i<regras.size() && regras.get(i).getToken().equals("VIRGULA")){     
            inicializacaovariavel();
                i++;
       }
   }
   private void inicializacaoArray(){
       int c=0; i++;
       if(i<regras.size()){
           if(regras.get(i).getToken().equals("FECHA CHAVETA")){
              return;
           }else{
               i++;
               if(i<regras.size()){
               inicializadoresVariaveis();
               c=1;
               i++;
               
           }
         }
       
       if(c==1){
           if(i>= regras.size() || !regras.get(i).getToken().equals("FECHA CHAVETA")){
                       Erro e=new Erro();
                       e.setErro("Esperava Fecha chaveta }");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
           }
       }
       }
   }
   private void id_dclv(){
       
       if(i<regras.size()){
       if(regras.get(i).getToken().equals("IDENTIFICADOR")){
           i++;
           if(i<regras.size()){
               if(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
                   i++;
                   if(regras.get(i).getToken().equals("FECHA PARENTESES RECTO")){
                       i++;
                   }else{
                       i--;
                       Erro e=new Erro();
                       e.setErro("Esperava Fecha parentes recto");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
                   }
               }else i--;
           }else{
               return;
           }
       }else{
            Erro e=new Erro();
            e.setErro("Esperava Identificador aqui");
            e.setLinha(regras.get(i).getLinha());
            erros.add(e);
       }
   }
   }
   private void Metodos(){
       dcl_Metodo();
       corpoM();
       
   }
   private void dcl_Metodo(){
       if(modificador()) i++;
      int c=0;
       if(i<regras.size() && regras.get(i).getToken().equals("void")){
           i++; c=1;
       }else{
           tipo();
           i++;c=1;
       }
       if(c==0){
            Erro e=new Erro();
                       e.setErro("Esperava tipo de metodo");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
       }
       def_metodo();
   }
   private void corpoM(){
       if(i<regras.size()){
           if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
               i++;
           }else{
               bloco();
           }
       }
   }
   private void def_metodo(){
       if(i<regras.size()){
       if(regras.get(i).getToken().equals("IDENTIFICADOR")){
           i++;
           if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
               i++;
               listaPformais();
          
           if(regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
               i++;
               
           }else{
               Erro e= new Erro();
               e.setErro("Esperava encontrar ) ");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
           } 
          }else{
               Erro e= new Erro();
               e.setErro("Esperava encontrar (");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
           }
       }else{
            Erro e= new Erro();
               e.setErro("Esperava encontrar um identificador ");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
       }
       }else{
            Erro e= new Erro();
               e.setErro("Esperava encontrar um identificador ");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
       }
   }
   private void paraFormais(){
       if(tipo()){
           i++;
           id_dclv();
       }
   }
   private void listaPformais(){
       paraFormais();
       while(regras.get(i).getToken().equals("VIRGULA") ){
           if(i<regras.size()){
           paraFormais();
           i++;
           }else{
               Erro e= new Erro();
               e.setErro("Eesperava encontrar algum parametro");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
               break;
           }
       }
   }
   private void expressao(){
       atribExpressao();
   }
   private void atribExpressao(){
       int control=0;
        if(regras.get(i).getToken().equals("IDENTIFICADOR")){
            
            nome();      
        }else i++; 
       if(i<regras.size()){
          
           if(regras.get(i).getToken().equals("new") 
             || regras.get(i).getToken().equals("SOMA") 
             || regras.get(i).getToken().equals("SUBTRAÇÃO")
             || regras.get(i).getToken().equals("ABRE PARENTESES CURVO")
             || regras.get(i).getToken().equals("NEGAÇÃO")
             || regras.get(i).getToken().equals("Negacao")
             || regras.get(i).getToken().equals("MENOR")
             || regras.get(i).getToken().equals("MAIOR")
             || regras.get(i).getToken().equals("or")
             || regras.get(i).getToken().equals("and")
             || regras.get(i).getToken().equals("or bit a bit")      
             || regras.get(i).getToken().equals("xor")
             || regras.get(i).getToken().equals("and bit a bit")
             || regras.get(i).getToken().equals("IGUAL")
             || regras.get(i).getToken().equals("IGUAL IGUAL")
             || regras.get(i).getToken().equals("MENOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR MAIOR")
             || regras.get(i).getToken().equals("MENOR MENOR")
             || regras.get(i).getToken().equals("DIVEDE")
             || regras.get(i).getToken().equals("RESTO DA DIVISAO")
             || regras.get(i).getToken().equals("MULTIPLA")
             || regras.get(i).getToken().equals("instantof")
             || valor()){
               if(regras.get(i).getToken().equals("new")){
                   if(i+1<regras.size())
                   if(!regras.get(i+1).getToken().equals("IDENTIFICADOR")){
                        Erro e= new Erro();
                        e.setErro("Esperava-se um tipo de dado");
                        e.setLinha(regras.get(i).getLinha());
                        erros.add(e);
                   while(i<regras.size() && !regras.get(i).getToken().equals("PONTO E VIRGULA") 
                           && !regras.get(i).getToken().equals("FECHA CHAVETA")){
                       i++;   
                   }
               control=-1;
              }
              
             if(control==0)
             opTernaria();  
              
           }else if( atribOperador() || regras.get(i).getToken().equals("ABRE PARENTESES RECTO")|| regras.get(i).getToken().equals("SOMA") 
             || regras.get(i).getToken().equals("SUBTRAÇÃO")
             || regras.get(i).getToken().equals("ABRE PARENTESES CURVO")
             || regras.get(i).getToken().equals("NEGAÇÃO")
             || regras.get(i).getToken().equals("Negacao")
             || regras.get(i).getToken().equals("MENOR")
             || regras.get(i).getToken().equals("MAIOR")
             || regras.get(i).getToken().equals("or")
             || regras.get(i).getToken().equals("and")
             || regras.get(i).getToken().equals("or bit a bit")      
             || regras.get(i).getToken().equals("xor")
             || regras.get(i).getToken().equals("and bit a bit")
             || regras.get(i).getToken().equals("IGUAL")
             || regras.get(i).getToken().equals("IGUAL IGUAL")
             || regras.get(i).getToken().equals("MENOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR MAIOR")
             || regras.get(i).getToken().equals("MENOR MENOR")
             || regras.get(i).getToken().equals("DIVEDE")
             || regras.get(i).getToken().equals("RESTO DA DIVISAO")
             || regras.get(i).getToken().equals("MULTIPLA")
             || regras.get(i).getToken().equals("instantof")
             || valor()){  
               i++;
              atribuicao();
           } else{
               i++; 
           }
       }
    } 
 }   
   private void acederVector(){
       if(i<regras.size()){
           if(regras.get(i).getToken().equals("IDENTIFICADOR")){
               nome();
                if(i<regras.size()){
                    if(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
                       i++;
                       expressao();
                       if(i<regras.size()){
                           if(regras.get(i).getToken().equals("FECHA PARENTESES RECTO")){
                               
                           }else{
                            Erro e= new Erro();
                            e.setErro("Esperava encotrar fecha parenteses rectos ]");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                            }
                       }
                   }
                }
            }else{
               principalSemVectNovo();
               i++;
               if(i<regras.size()){
                    if(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
                       i++;
                       expressao();
                       if(i<regras.size()){
                           if(regras.get(i).getToken().equals("FECHA PARENTESES RECTO")){
                               
                           }else{
                            Erro e= new Erro();
                            e.setErro("Esperava encotrar fecha parenteses rectos ]");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                            }
                       }
                   }
                }
            }
        }
   }
   private void lhs(){
       if(i<regras.size()){
           if(i+1<regras.size() && regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
               acederVector();
           }else if(regras.get(i).getToken().equals("IDENTIFICADOR")){
               nome();
               i--;
           }
       }
   }
   private  void atribuicao(){
       
       if(i<regras.size()){
            if(atribOperador()|| regras.get(i).getToken().equals("SOMA") 
             || regras.get(i).getToken().equals("SUBTRAÇÃO")
             || regras.get(i).getToken().equals("ABRE PARENTESES CURVO")
             || regras.get(i).getToken().equals("NEGAÇÃO")
             || regras.get(i).getToken().equals("Negacao")
             || regras.get(i).getToken().equals("MENOR")
             || regras.get(i).getToken().equals("MAIOR")
             || regras.get(i).getToken().equals("or")
             || regras.get(i).getToken().equals("and")
             || regras.get(i).getToken().equals("or bit a bit")      
             || regras.get(i).getToken().equals("xor")
             || regras.get(i).getToken().equals("and bit a bit")
             || regras.get(i).getToken().equals("IGUAL")
             || regras.get(i).getToken().equals("IGUAL IGUAL")
             || regras.get(i).getToken().equals("MENOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR IGUAL")
             || regras.get(i).getToken().equals("MAIOR MAIOR")
             || regras.get(i).getToken().equals("MENOR MENOR")
             || regras.get(i).getToken().equals("DIVEDE")
             || regras.get(i).getToken().equals("RESTO DA DIVISAO")
             || regras.get(i).getToken().equals("MULTIPLA")
             || regras.get(i).getToken().equals("instantof")
             || valor())
           
                atribExpressao();       
       }
    }
    private void opTernaria(){
        expressaoOu();
            if(i<regras.size()){
                if(regras.get(i).getToken().equals("OPERADOR TERNARIO")){
                    expressao();
                        i++;
                        if(i<regras.size()){
                            if(!regras.get(i).getToken().equals("DOIS PONTOS")){
                                Erro e= new Erro();
                                e.setErro("Esperava encotrar :");
                                e.setLinha(regras.get(i).getLinha());
                                erros.add(e);
                            }i++;
                            if(i<regras.size()){
                                opTernaria();
                            }
                        }else{
                                 Erro e= new Erro();
                                e.setErro("Esperava encotrar :");
                                e.setLinha(regras.get(i).getLinha());
                                erros.add(e);
                        }
                    }
                }
            }
            private boolean atribOperador(){
                
                if(regras.get(i).getToken().equals("IGUAL")){
                    return true;
                }else if(regras.get(i).getToken().equals("SOMA E ATRIBUI")){
                    return true;
                }else if(regras.get(i).getToken().equals("MULTIPLICA E ATRIBUI")){
                    return true;
                }else if(regras.get(i).getToken().equals("DIVEDE E ATRIBUI")){
                    return true;
                }else if(regras.get(i).getToken().equals("SUBTRAI E ATRIBUI")){
                    return true;
                }else if(regras.get(i).getToken().equals("RESTO DA DIVISÃO E ATRIBUI")){
                    return true;
                }else if(regras.get(i).getToken().equals("xor")){
                    return true;
                }
                
                return false;
            }
           private void expressaoOu(){
               expressaoE(); i++;
                   while(regras.get(i).getToken().equals("or")){
                       expressaoE();
                   }
               
           }
            private void expressaoE(){
        expressaoOR();i++;
        while(regras.get(i).getToken().equals("AND")){
            expressaoOR();
        }
    }
           
    private void expressaoOR(){
        expressaoXOR();i++;
        
        while(regras.get(i).getToken().equals("or bit a bit")){
            expressaoXOR();
        }
    }  
    private void expressaoXOR(){
        expressaoAND();i++;
        while(regras.get(i).getToken().equals("xor")){
            expressaoAND();
        }
    }
    private void expressaoAND(){
        expressaoIgual();
        while(regras.get(i).getToken().equals("and bit a bit")){
            expressaoIgual();
        }
    }   
      private void expressaoIgual(){
        expressaoComparacao();
        while(regras.get(i).getToken().equals("IGUAL IGUAL")){
            expressaoComparacao();
        }
    }      
        private void expressaoComparacao(){
        expressaoDeslocamento(); i++;
        while(regras.get(i).getToken().equals("MAIOR")|| regras.get(i).getToken().equals("MAIOR IGUAL")
              || regras.get(i).getToken().equals("MENOR")|| regras.get(i).getToken().equals("MENOR IGUAL")){
            expressaoDeslocamento();
            
        }
    }
            private void expressaoDeslocamento(){
        expressaoAdicaoSubtracao();
        while(regras.get(i).getToken().equals("MAIOR MAIOR") || regras.get(i).getToken().equals("MENOR MENOR")){
            expressaoAdicaoSubtracao();
        }
    } 
            private void expressaoAdicaoSubtracao(){
                
                multiplicaoDivisaoMod();
                 while(regras.get(i).getToken().equals("SOMA")|| regras.get(i).getToken().equals("SUBTRAI")){
            multiplicaoDivisaoMod();
        }
            }
           private void  multiplicaoDivisaoMod(){
                expressaoUnaria();
                       while(regras.get(i).getToken().equals("MULTIPLICA")|| regras.get(i).getToken().equals("DIVISÃO")
                             || regras.get(i).getToken().equals("RESTO DA DIVISÃO")){
             expressaoUnaria();
        }
       }    
           private void expressaoUnaria(){
               
                i++;
                if(i<regras.size()){
                   
               if(regras.get(i).getToken().equals("SUBTRAI")){
                 preDecremento();  
               } else if(regras.get(i).getToken().equals("SOMA")){
                   preIncremento();
               }else {
                  
                   expressaoUnariaSemMaisMenos();
               }
               while(regras.get(i).getToken().equals("SUBTRAI") || regras.get(i).getToken().equals("SOMA")){
                   i++;
                   if(i<regras.size()){
                   if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
             i++;
             if(i<regras.size()){
                 if(regras.get(i).getToken().equals("SUBTRAI")){
                 preDecremento();  
               } else if(regras.get(i).getToken().equals("SOMA")){
                   preIncremento();
               }
             }
               }else {
                  i--;
                  
                   expressaoUnariaSemMaisMenos();
               }
                   }
               }
                 
                }
            }            
            private void preIncremento(){
                i++;
                if(i<regras.size()){
                    if(regras.get(i).getToken().equals("Dupla Soma")){
                        i++;
                        if(i<regras.size()){
                            expressaoUnaria();
                        }
                    }
                }
            }
               private void preDecremento(){
                i++;
                if(i<regras.size()){
                    if(regras.get(i).getToken().equals("Dupla Sutração")){
                        i++;
                        if(i<regras.size()){
                            expressaoUnaria();
                        }
                    }
                }
            }
               private void expressaoUnariaSemMaisMenos(){
                
                   if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                       casting();
                      
                   }else if(regras.get(i).getToken().equals("NEGAÇÃO")){
                       i++;
                       if(i<regras.size())
                       { 
                           expressaoUnaria();
                       }
                   }else if(regras.get(i).getToken().equals("Negacao")){
                       i++;
                       if(i<regras.size())
                       {
                           expressaoUnaria();
                       }
                   }else{
                      expressaoPosterior();
                   }
                 
               }
               private void casting(){
                   
               }
               private void principal(){
                   if(regras.get(i).getToken().equals("new")){
                       i++;
                       if(i<regras.size()){
                           if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                               nome();
                               if(i<regras.size() && regras.get(i).getToken().equals("ABRE PARENTESES")){
                                   i--;
                                   principalSemVectNovo();
                               }else{
                                   criacaoVector();
                               }
                           }else{
                               criacaoVector();
                           }
                       }
                   }else{
                       principalSemVectNovo();
                   }
               }
               private void expressaoPosterior(){
                              
                  if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                      nome();
                  }else if(regras.get(i).getToken().equals("new")|| regras.get(i).getToken().equals("this")
                          || posIncremento() || posDecremento()){
                      principal();
                  }
               }
               private boolean posIncremento(){
                   return false;
               }
               private boolean posDecremento(){
                   return false;
               }

    private void declaracaoCorpoClass() {
            while(i<regras.size() && modificador()){
                i++;
                if(i>=regras.size()) break;
            }
            declaracaoCorpoClass1();
        
    }
   
    private void declaracaoCorpoClass1() {
        
        if(i<regras.size()){
        if(regras.get(i).getToken().equals("class")){
           declaracaoClass();
           
       }else if(regras.get(i).getToken().equals("void") || tipo()){
           
           declaracaoMemClass();
           }else if (regras.get(i).getToken().equals("ABRE CHAVETA")){
           inicicalizacaoStatic();
           
           
           if(!regras.get(i).getToken().equals("FECHA CHAVETA")){
               Erro e= new Erro();
               e.setErro("Esperava fecha chaveta }");
               e.setLinha(regras.get(i).getLinha());
           }
         } 
        } 
    }

   private void declaracaoMemClass(){
       i++;
       if(i<regras.size()){
           if(!regras.get(i).getToken().equals("IDENTIFICADOR")){
               Erro e= new Erro();
               e.setErro("Eesperava encontrar um identificador ^jh");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
           }else{
               i++;
           }
           if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
               i--;i--;
               Metodos();
           }else{
               i--;
               dcl_campo();
           }
       }else{
               Erro e= new Erro();
               e.setErro("Esperava encontrar um identificador ççç");
               e.setLinha(regras.get(i).getLinha());
               erros.add(e);
       }
       
            
        
    
       
    
}

    private void inicicalizacaoStatic() {
        bloco();
    }
    private void bloco(){
        int c=0;
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("ABRE CHAVETA")){
                i++;
                if(i<regras.size()){
                if(!regras.get(i).getToken().equals("FECHA CHAVETA")){
                    
                    listaDclBloco();
                    
                    c=1;
                    
                    
                }
                }else{
                     Erro e=new Erro();
                       e.setErro("Esperava Fecha chaveta");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
                }
            }else{
                         Erro e=new Erro();
                       e.setErro("Esperava abre chaveta");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
            }
        }
        if(c==1 ){
            if(i<regras.size()){
                if(regras.get(i).getToken().equals("FECHA CHAVETA")){
                    
                }else{
                    
                        Erro e=new Erro();
                       e.setErro("Esperava Fecha chaveta acola");
                       e.setLinha(regras.get(i).getLinha());
                       erros.add(e);
                }
            }
        }
    }
    private void listaDclBloco(){
         declaracaoBloco();
        i++; 
        if(i<regras.size()){
            while(( regras.get(i).getToken().equals("while") || regras.get(i).getToken().equals("do")
                    || regras.get(i).getToken().equals("IDENTIFICADOR")|| regras.get(i).getToken().equals("this")
                    || regras.get(i).getToken().equals("switch") || regras.get(i).getToken().equals("for")
                    || regras.get(i).getToken().equals("break") || regras.get(i).getToken().equals("continue")
                    || regras.get(i).getToken().equals("return") || regras.get(i).getToken().equals("syncronized")
                    || regras.get(i).getToken().equals("try") || regras.get(i).getToken().equals("throw")
                    || regras.get(i).getToken().equals("PONTO E VIRGULA")|| regras.get(i).getToken().equals("ABRE CHAVETA")
                    || regras.get(i).getToken().equals("DOIS PONTOS")|| regras.get(i).getToken().equals("if")
                    || regras.get(i).getToken().equals("do")
                    || regras.get(i).getToken().equals("ABRE PARENTESES RECTO")|| regras.get(i).getToken().equals("SOMA")
                    || regras.get(i).getToken().equals("SUBTRAI")|| regras.get(i).getToken().equals("new")|| tipo()) /*&& 
                    !regras.get(i).getToken().equals("FECHA CHAVETA")*/){
                /*if(tipo()){
                    if(regras.get(i).getToken().equals("IDENTIFICADOR"))i=i-2;
                } */
                declaracaoBloco();//i++;
                if(i>=regras.size()) break;
            }
        }
 }
   private void declaracaoVariaLocal0(){
        declaracaoVariavelLocal();
        i++;
        if(i<regras.size() ){
            if(!regras.get(i).getToken().equals("PONTO E VIRGULA")){
                i--;
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
            
            
        }else{
            Erro e= new Erro();
            e.setErro("Esperava-se ponto e virgula");
            e.setLinha(regras.get(i).getLinha());
            erros.add(e);
        }
    }
    private void declaracaoBloco(){
         if(tipo()){
         int control=1;
         if(regras.get(i-1).getToken().equals("IDENTIFICADOR") && regras.get(i).getToken().equals("IDENTIFICADOR")){
             i-=1;
            
             
         }else if(!tipo()){
             i--;
             declaracao();
             control=0;
         }
        
           if(control==1)
         declaracaoVariaLocal0();
         if(!regras.get(i).getToken().equals("PONTO E VIRGULA") && !regras.get(i).getToken().equals("ABRE CHAVETA"))i++;
        
         
     }else if(regras.get(i).getToken().equals("while") || regras.get(i).getToken().equals("do") 
                    || regras.get(i).getToken().equals("switch") || tipo() || regras.get(i).getToken().equals("for")
                    || regras.get(i).getToken().equals("break") || regras.get(i).getToken().equals("continue")
                    || regras.get(i).getToken().equals("return") || regras.get(i).getToken().equals("syncronized")
                    || regras.get(i).getToken().equals("try") || regras.get(i).getToken().equals("throw")
                    || regras.get(i).getToken().equals("PONTO E VIRGULA")|| regras.get(i).getToken().equals("ABRE CHAVETA")
                    || regras.get(i).getToken().equals("DOIS PONTOS")|| regras.get(i).getToken().equals("if")
                    || regras.get(i).getToken().equals("do")){
         
         declaracao();
         
     }else if(regras.get(i).getToken().equals("class")){
         declaracaoClass();
     }else if(regras.get(i).getToken().equals("IDENTIFICADOR")){
             i++;
             if(i<regras.size()){
                 if(atribOperador()){
                     i++;
                     if(i<regras.size()){
                         
                         expressao();
                            
                             if(i<regras.size()){
                             if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
                                 i++;
                             }else{
                                Erro e= new Erro();
                                e.setErro("Esperava-se ponto e virgula");
                                e.setLinha(regras.get(i).getLinha());
                                erros.add(e); 
                             }
                             }else{
                                Erro e= new Erro();
                                e.setErro("Esperava-se ponto e virgula");
                                e.setLinha(regras.get(i).getLinha());
                                erros.add(e); 
                             }
                        
                     }else{
                                Erro e= new Erro();
                                e.setErro("Esperava-se algum valor");
                                e.setLinha(regras.get(i).getLinha());
                                erros.add(e);
                     }
                 }else{
                        Erro e= new Erro();
                        e.setErro("Esperava-se alguma atribuição");
                        e.setLinha(regras.get(i).getLinha());
                        erros.add(e);
                 }
             }else{
                 Erro e= new Erro();
                 e.setErro("Esperava-se alguma atribuição");
                 e.setLinha(regras.get(i).getLinha());
                 erros.add(e);
             }
     }
    }
    private  void declaracao(){
        
        if(regras.get(i).getToken().equals("do")){
            declaracaoDo();
            i++;
        }else if(regras.get(i).getToken().equals("while")){
        declaracaoWhile();
        i++;
        }else if(regras.get(i).getToken().equals("for")){
        declaracaoFor();
        i++;
        }else if(regras.get(i).getToken().equals("if")){
        declaracaoIf();
        i++;
        }else if(regras.get(i).getToken().equals("switch")){
        declaracaoSwitch();
        i++;
        } else if(regras.get(i).getToken().equals("while")){
        declaracaoWhile();
        i++;
        }else if(regras.get(i).getToken().equals("DOIS PONTOS")){
        declaracaoRotulo();
        i++;
        }else if(regras.get(i).getToken().equals("ABRE CHAVETA")){
        bloco();
        i++;
        }else if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
        i++;
        }else if(regras.get(i).getToken().equals("trhow")){
        declaracaoTrhow();
        i++;
        }else if(regras.get(i).getToken().equals("break")){
        declaracaoBreak();
        i++;
        }else if(regras.get(i).getToken().equals("continue")){
        declaracaoContinue();
        i++;
        } else if(regras.get(i).getToken().equals("return")){
        declaracaoReturn();
        i++;
        }else if(regras.get(i).getToken().equals("IDENTIFICADOR") || regras.get(i).getToken().equals("ABRE PARENTESES RECTO") 
                || regras.get(i).getToken().equals("IGUAL")|| valor()|| regras.get(i).getToken().equals("SOMA")
                || regras.get(i).getToken().equals("SUBTRAI")|| regras.get(i).getToken().equals("new")
                || regras.get(i).getToken().equals("this")|| regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
            declaracaoExpressao();
            i++;
        }
    }
    private void declaracaoDo() {
        i++;
        if(i<regras.size()){
            if(tipo()){
                Erro e= new Erro();
                e.setErro("Nao pode declarar variaveis");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
                while(!regras.get(i).getToken().equals("while")){
                    i++;
                    if(i>=regras.size()){
                        break;
                    }
                    if(regras.get(i).getToken().equals("FECHA CHAVETA")){
                        i=i-2;
                        break;
                    }
                }
            }else{
                
                declaracao();
            }
            if(i<regras.size()){
                if(!regras.get(i).getToken().equals("while")){
                    Erro e= new Erro();
                            e.setErro("Esperava encontrar while");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                }i++;
                if(i< regras.size()){
                    if(!regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                            Erro e= new Erro();
                            e.setErro("Esperava-se abre parenteses");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    }
                    if(i<regras.size() && regras.get(i+1).getToken().equals("FECHA PARENTESES CURVO")){
                            Erro e= new Erro();
                            e.setErro("Esperava-se condição de paragem no 'while'");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    }else i++;
                    if(i<regras.size()){
                        expressao();
                    if(!regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){   
                        Erro e= new Erro();
                            e.setErro("Esperava-se fecha parenteses");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    } i++;
                    if(i<regras.size() && regras.get(i).getToken().equals("PONTO E VIRGULA")){
                        
                    }else{
                        Erro e= new Erro();
                            e.setErro("Esperava-se ponto e virgula");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    }
                    }
                }
            }
        }
    }

    private void declaracaoWhile() {
        i++;
           if(i<regras.size()){
                if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                   
                   if(i<regras.size() && regras.get(i+1).getToken().equals("FECHA PARENTESES CURVO")){
                            Erro e= new Erro();
                            e.setErro("Esperava-se condição de paragem no 'while'");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    }else i++;
                   
                    expressao(); 
                   if(i<regras.size()){
                       if(regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                           i++; 
                           
                           declaracao();
                           
                       }else{
                            Erro e= new Erro();
                            e.setErro("Esperava-se fecha parenteses");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                       }
                   }else{
                  Erro e= new Erro();
                  e.setErro("Esperava-se fecha parenteses");
                  e.setLinha(regras.get(i).getLinha());
                  erros.add(e);
                   }
               }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
               }
           }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
           }
       
    }

    private void declaracaoTrhow() {
        expressao();
       if(i<regras.size()){
           if(!regras.get(i).getToken().equals("PONTO E VIRGULA")){
               Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
           }
       }else{
        Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
    }
    }

    private void declaracaoBreak() {
        i++;
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("IDENTIFICADOR"))
                i++;
            if(i<regras.size() && regras.get(i).getToken().equals("PONTO E VIRGULA")){
                
            }else{
                i--;
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }else{
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
    }

    private void declaracaoContinue() {
         i++;
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("IDENTIFICADOR"))
                i++;
            if(i<regras.size() && regras.get(i).getToken().equals("PONTO E VIRGULA")){
                
            }else{
                i--;
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }else{
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
    }

   

    private void declaracaoReturn() {
        i++;
        if(i<regras.size()){
            if(!regras.get(i).getToken().equals("PONTO E VIRGULA"))
                expressao();
            if(i<regras.size() && regras.get(i).getToken().equals("PONTO E VIRGULA")){
                
            }else{
                i--;
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }else{
                Erro e= new Erro();
                e.setErro("Esperava-se ponto e virgula");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
    }

    private void declaracaoExpressao() {
        
        if(regras.get(i).getToken().equals("Dupla Soma")){
            preIncremento();
        }else if(regras.get(i).getToken().equals("Dupla Subtração")){
            preDecremento();
        }else if(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
            atribuicao();
        }else if(regras.get(i).getToken().equals("new")){
            instanciaClass();
        }else if(regras.get(i).getToken().equals("IDENTIFICADOR")){
            
            nome();
            
            if(i<regras.size()){
                
                if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                    i--;
                    invocarMetodo();
                }else if(atribOperador()){
                    
                    atribuicao();
                }
            }
        }
       
    }

    private void declaracaoFor() {
       i++;
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
            i++;
            }else{
            Erro e= new Erro();
            e.setErro("Esperava-se abre parenteses");
            e.setLinha(regras.get(i).getLinha());
            erros.add(e);i++;
            }
            
            if(i<regras.size() && tipo() && !tipoPrimitivo()){
                nome(); 
                
                if(i<regras.size() && regras.get(i).getToken().equals("DOIS PONTOS")){
                    i++;
                    if(i<regras.size())
                    nome();
                    
                }
            }
            else{ 
                if(i<regras.size()){
                inicialFor();
                
                i++;
                if(i<regras.size()){
                    if(regras.get(i).getToken().equals("PONTO E VIRGULA")){
                        i++;
                        expressao();
                        
                        if(i<regras.size() && regras.get(i).getToken().equals("PONTO E VIRGULA")){
                            i++;
                            if(i<regras.size())
                            actualizaFor();
                            //i--; 
                        }else{
                            Erro e= new Erro();
                            e.setErro("Esperava-se ponto e virgula ; ");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                        }
                    }else{
                        Erro e= new Erro();
                            e.setErro("Esperava-se ponto e virgula ; ");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                    }
                }
            }else{
                Erro e= new Erro();
                            e.setErro("Esperava-se argumentos");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
            }
            }    
            i--;
            if(!regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                Erro e= new Erro();
                            e.setErro("Esperava-se fecha parenteses )");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
            }
            
            declaracao();
        }else{
            Erro e= new Erro();
            e.setErro("Esperava-se abre parenteses");
            e.setLinha(regras.get(i).getLinha());
            erros.add(e);
        }
    }

    private void declaracaoIf() {
        
           i++;
           if(i<regras.size()){
               if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                   
                   if(i<regras.size() && regras.get(i+1).getToken().equals("FECHA PARENTESES CURVO")){
                            Erro e= new Erro();
                            e.setErro("Esperava-se alguma expressao no if");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                           
                    } i++; 
                   expressao();
                   //--i;
                   if(i<regras.size()){
                       if(regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                           i++; 
                           declaracao();
                           
                           
                           if(i< regras.size() && regras.get(i).getToken().equals("else")){
                               i++;
                               declaracao();
                           }
                       }else{
                            Erro e= new Erro();
                            e.setErro("Esperava-se fecha parenteses");
                            e.setLinha(regras.get(i).getLinha());
                            erros.add(e);
                       }
                   }else{
                  Erro e= new Erro();
                  e.setErro("Esperava-se fecha parenteses");
                  e.setLinha(regras.get(i).getLinha());
                  erros.add(e);
                   }
               }
           }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
           }
      
       
    }

   

    private void declaracaoSwitch() {

        i++;
       if(i<regras.size()){
           if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
               i++;
               if(i<regras.size() && !regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                    expressao();
               }else{
                    Erro e= new Erro();
                    e.setErro("Esperava-se alguma expressao");
                    e.setLinha(regras.get(i).getLinha());
                    erros.add(e);
               }
                      
               if(i<regras.size() && regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                   i++;
                   blocoSwitch();
               }else{
                    Erro e= new Erro();
                    e.setErro("Esperava-se fecha parenteses");
                    e.setLinha(regras.get(i).getLinha());
                    erros.add(e);
               }
           }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
           }
       }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
       }
    }

    private void declaracaoRotulo() {
       i++;
       if(i<regras.size()) 
       declaracao();
           
    }


    private void declaracaoVariavelLocal() {
        if(tipo()){
            i++;
            if(regras.get(i).getToken().equals("IDENTIFICADOR")){
              
                listaDclVariavel();  
             
        }else{
               
                Erro e= new Erro();
                e.setErro("Esperava-se algum tipo de dado");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e); i++;
        }
    }
   }
    private void instanciaClass() {
        tipoClass();
        if(!regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                 Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
                //i++;
        }else i++;
        if(i<regras.size()){
            if(!regras.get(i).getToken().equals("PONTO E VIRGULA") && !regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                listaArgumentos();
                if(!regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                     Erro e= new Erro();
                e.setErro("Esperava-se fecha parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
                }
            }else if(!regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                 Erro e= new Erro();
                e.setErro("Esperava-se fecha parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }else{
             Erro e= new Erro();
                e.setErro("Esperava-se fecha parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
    }
    private void tipoClass(){
        i++;
        if(i<regras.size())
            nome();
        else{
            
        }       Erro e= new Erro();
                e.setErro("Esperava-se um Identificador");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
    }

    private void listaArgumentos() {
        expressao();
       while(i<regras.size() && regras.get(i).getToken().equals("VIRGULA")){
           expressao();
       }
    }

    private void blocoSwitch() {
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("ABRE CHAVETA")){
                i++;
                if(i<regras.size()){
                   while(regras.get(i).getToken().equals("case") || regras.get(i).getToken().equals("default")){
                       rotuloSwitch();
                       
                   }
                if(!regras.get(i).getToken().equals("FECHA CHAVETA")){
                    Erro e= new Erro();
                e.setErro("Esperava-se fecha chaveta");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
                }
                }  
            }
        }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre chaveta");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
    }

    private void rotuloSwitch() {
        if(regras.get(i).getToken().equals("case")){
            i++;
            expressao();
            if(i<regras.size()){
                if(regras.get(i).getToken().equals("DOIS PONTOS")){
                    i++;
                }else{
                Erro e= new Erro();
                e.setErro("Esperava-se dois pontos");
                e.setLinha(regras.get(i-2).getLinha());
                erros.add(e);
                }
                if(i<regras.size() && (regras.get(i).getToken().equals("while") || regras.get(i).getToken().equals("do") 
                    || regras.get(i).getToken().equals("switch") || tipo() || regras.get(i).getToken().equals("for")
                    || regras.get(i).getToken().equals("break") || regras.get(i).getToken().equals("continue")
                    || regras.get(i).getToken().equals("return") || regras.get(i).getToken().equals("syncronized")
                    || regras.get(i).getToken().equals("try") || regras.get(i).getToken().equals("throw")
                    || regras.get(i).getToken().equals("PONTO E VIRGULA")|| regras.get(i).getToken().equals("ABRE CHAVETA")
                    || regras.get(i).getToken().equals("DOIS PONTOS")|| regras.get(i).getToken().equals("if")
                    || regras.get(i).getToken().equals("do"))){
                    declaracao();
                }
                
            }
        }else if(regras.get(i).getToken().equals("default")){
            i++;
            if(i<regras.size()){
                if(regras.get(i).getToken().equals("DOIS PONTOS")){
                    i++;
                }else{
                Erro e= new Erro();
                e.setErro("Esperava-se dois pontos");
                e.setLinha(regras.get(i-2).getLinha());
                erros.add(e);
                }
                if(i<regras.size() && (regras.get(i).getToken().equals("while") || regras.get(i).getToken().equals("do") 
                    || regras.get(i).getToken().equals("switch") || tipo() || regras.get(i).getToken().equals("for")
                    || regras.get(i).getToken().equals("break") || regras.get(i).getToken().equals("continue")
                    || regras.get(i).getToken().equals("return") || regras.get(i).getToken().equals("syncronized")
                    || regras.get(i).getToken().equals("try") || regras.get(i).getToken().equals("throw")
                    || regras.get(i).getToken().equals("PONTO E VIRGULA")|| regras.get(i).getToken().equals("ABRE CHAVETA")
                    || regras.get(i).getToken().equals("DOIS PONTOS")|| regras.get(i).getToken().equals("if")
                    || regras.get(i).getToken().equals("do"))){
                    declaracao();
                }
            }
        }
    }

    private void inicialFor() {
        
        if(tipoPrimitivo()){
            declaracaoVariavelLocal();
        }else{
            declaracaoExpressao();
        }
    }

    private void actualizaFor() {
        
        listaDeclaracaoExpressao();
    }

    private void listaDeclaracaoExpressao() {
        declaracaoExpressao();
        
        while(regras.get(i).getToken().equals("Dupla Subtração") ||regras.get(i).getToken().equals("Dupla Soma") 
              ||regras.get(i).getToken().equals("new") || regras.get(i).getToken().equals("ABRE PARENTESES RECTO")
              ||regras.get(i).getToken().equals("IDENTIFICADOR")){
            
            declaracaoExpressao();
            i++;
        }
    }

    private void principalSemVectNovo() {
       if(valor()){
           
       }else if(regras.get(i).getToken().equals("this")){
           i++;
           if(i<regras.size()){
               if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                   expressao();
                   i++;
                   if(i<regras.size() && regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                       
                   }else{
                        Erro e= new Erro();
                        e.setErro("Esperava-se fecha parenteses");
                        e.setLinha(regras.get(i).getLinha());
                        erros.add(e); 
                   }
               }else{
                   Erro e= new Erro();
                   e.setErro("Esperava-se abre parenteses");
                   e.setLinha(regras.get(i).getLinha());
                   erros.add(e);
               }
           }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
           }
       }else if(regras.get(i).getToken().equals("new")){
          instanciaClass();
       }
    }

    private void criacaoVector() {
        if(regras.get(i).getToken().equals("new")){
            i++;
            if(i<regras.size()){
                if(tipo()){
                    i++;
                    listaExprParentesesRecto();
                    i++;
                    if(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
                        parentesesRecto();
                    }
                }
                
            }
        }
    }

    private void listaExprParentesesRecto() {
       expressaoParentesesRecto();
       while(regras.get(i).getToken().equals("ABRE PARENTESES RECTO")){
           expressaoParentesesRecto();
       }
    }

    private void expressaoParentesesRecto() {
        i++;
        if(i<regras.size()){
            expressao();
            if(i<regras.size() && regras.get(i).getToken().equals("FECHA PARENTESES RECTO")){
                
            }else{
                Erro e= new Erro();
                e.setErro("Esperava-se fecha parenteses recto");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }
    }
   
    private void parentesesRecto() {
        i++;
        if(i<regras.size() && regras.get(i).getToken().equals("FECHA PARENTESES REECTO")){
            
        }else{
                Erro e= new Erro();
                e.setErro("Esperava-se fecha parenteses recto");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
        }
        if(regras.get(i).getToken().equals("ABRE PARENTESES REECTO")){
            parentesesRecto();
        }
    }

    private void invocarMetodo() {
       
        if(i<regras.size()){
            if(regras.get(i).getToken().equals("IDENTIFICADOR")){
                nome();
            }else if(regras.get(i).getToken().equals("this") ||regras.get(i).getToken().equals("new")){
                principal();
            }
            i++;
            if(i<regras.size()){
                if(regras.get(i).getToken().equals("ABRE PARENTESES CURVO")){
                    listaArgumentos();
                    if(i<regras.size()){
                    if(!regras.get(i).getToken().equals("FECHA PARENTESES CURVO")){
                        Erro e= new Erro();
                        e.setErro("Esperava-se fecha parenteses");
                        e.setLinha(regras.get(i).getLinha());
                        erros.add(e);
                        }
                    }else{
                        Erro e= new Erro();
                        e.setErro("Esperava-se fecha parenteses");
                        e.setLinha(regras.get(i).getLinha());
                        erros.add(e);
                    }
                }else{
                    Erro e= new Erro();
                    e.setErro("Esperava-se abre parenteses");
                    e.setLinha(regras.get(i).getLinha());
                    erros.add(e);
                }
            }else{
                Erro e= new Erro();
                e.setErro("Esperava-se abre parenteses");
                e.setLinha(regras.get(i).getLinha());
                erros.add(e);
            }
        }
    }
    
}