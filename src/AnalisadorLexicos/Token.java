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
public class Token {
    
    // Tipos de Dados
    static String TOKEN_BYTE="byte";
    static String TOKEN_SHORT="short";  
    static String TOKEN_CHAR="char";
    static String TOKEN_INT="int";
    static String TOKEN_LONG="long";
    static String TOKEN_FLOAT="float";
    static String TOKEN_DOUBLE="double";
    static String TOKEN_BOOLEAN="boolean"; 
    static String TOKEN_INTEIRO="VALOR_INTEIRO";
    static String TOKEN_FLOATI="VALOR_REAL";
    //Modificadores de acesso
    static String TOKEN_PUBLIC="public";
    static String TOKEN_PROTECTED="protected";
    static String TOKEN_PRIVATE="private";
    static String TOKEN_STATIC="static";
    static String TOKEN_ABSTRACT="abstract";
    static String TOKEN_FINAL="final";
    static String TOKEN_NATIVE="native";
    static String TOKEN_SYNCHRONIZED="synchronized";
    static String TOKEN_TRANSIENT="transient";
    static String TOKEN_VOLATILE="volatile";
    static String TOKEN_STRICTFP="strictfp";
    
    //Unidades de compilação
     static String TOKEN_PACKAGE="package";
     static String TOKEN_IMPORT="import";
     static String TOKEN_CLASS="class";
     static String TOKEN_EXTENDS="extends"; 
    
     //    
    static String TOKEN_ASSERT="assert";    
    static String TOKEN_BREAK="break";     
    static String TOKEN_CASE="case";          
    static String TOKEN_CATCH="catch";  
    static String TOKEN_CONST="const";   
    static String TOKEN_CONTINUE="continue"; 
    static String TOKEN_DEFAULT="default";   
    static String TOKEN_DO="do";   
    static String TOKEN_ELSE="else";     
    static String TOKEN_FINALLY="finally";     
    static String TOKEN_FOR="for";     
    static String TOKEN_GOTO="goto";   
    static String TOKEN_IF="if";    
    static String TOKEN_IMPLEMENTS="implements";    
    static String TOKEN_INSTANCEOF="instanceof";   
    static String TOKEN_INTERFACE="interface";   
    static String TOKEN_NEW="new";    
    static String TOKEN_RETURN="return";  
    static String TOKEN_SUPER="super";   
    static String TOKEN_SWITCH="switch";    
    static String TOKEN_THIS="this";   
    static String TOKEN_THROW="throw";     
    static String TOKEN_THROWS="throws";    
    static String TOKEN_TRY="try";    
    static String TOKEN_VOID="void";  
    static String TOKEN_WHILE="while";  
    
    public static String TOKEN_PALAVRA_RESERVADA="["+TOKEN_BYTE+"]["+TOKEN_WHILE+"]["+TOKEN_VOID+"]["+TOKEN_TRY+"["
    +TOKEN_THROWS+"]["+TOKEN_THROW+"]["+TOKEN_THIS+"]["+TOKEN_SWITCH+"]["+TOKEN_SUPER+"]["+TOKEN_RETURN+"]["+TOKEN_NEW+"]["
    + TOKEN_INTERFACE+"]["+TOKEN_INSTANCEOF+"]["+TOKEN_IMPLEMENTS+"]["+TOKEN_IF+"]["+TOKEN_GOTO+"]["+TOKEN_FOR+"]["
    +TOKEN_FINALLY+"]["+TOKEN_ELSE+"]["+TOKEN_DO+"]["+TOKEN_DEFAULT+"]["+TOKEN_CONTINUE+"]["+TOKEN_CONST+"]["
    +TOKEN_CATCH+"]["+TOKEN_CASE+"]["+TOKEN_BREAK+"]["+TOKEN_ASSERT+"]["+TOKEN_PACKAGE+"]["+TOKEN_IMPORT+"]["
    +TOKEN_CLASS+"]["+TOKEN_EXTENDS+"]["+TOKEN_PUBLIC+"]["+TOKEN_PROTECTED+"]["+TOKEN_PRIVATE+"]["+TOKEN_STATIC+"]["
    +TOKEN_ABSTRACT+"]["+TOKEN_FINAL+"]["+TOKEN_NATIVE+"]["+TOKEN_SYNCHRONIZED+"]["+TOKEN_TRANSIENT+"]["+TOKEN_VOLATILE+"]["
    +TOKEN_STRICTFP+"]["+TOKEN_BYTE+"]["+TOKEN_SHORT+"]["+TOKEN_CHAR+"]["+TOKEN_INT+"]["+TOKEN_LONG+"]["+TOKEN_FLOAT+"]["
    +TOKEN_DOUBLE+"]["+TOKEN_BOOLEAN+"]";
    //
    
    
public static String TOKEN_ID = "IDENTIFICADOR";
public static String TOKEN_ABRE_PARENTESES_CURVO = "ABRE PARENTESES CURVO";
public static String TOKEN_FECHA_PARENTESES_CURVO = "FECHA PARENTESES CURVO";
public static String TOKEN_ABRE_PARENTESES_RETO = "ABRE PARENTESES RECTO";
public static String TOKEN_FECHA_PARENTESES_RETO = "FECHA PARENTESES RECTO";
public static String TOKEN_ABRECHAVETA = "ABRE CHAVETA";
public static String TOKEN_FECHA_CHAVETA = "FECHA CHAVETA";
public static String TOKEN_DOIS_PONTOS = "DOIS PONTOS";
public static String TOKEN_PONTO_VIRGULA = "PONTO E VIRGULA";
public static String TOKEN_VIRGULA = "VIRGULA";
public static String TOKEN_PONTO = "PONTO";
public static String TOKEN_MAIOR_IGUAL = "MAIOR IGUAL";
public static String TOKEN_MAIOR = "MAIOR";
public static String TOKEN_MAIOR_MAIOR = "MAIOR MAIOR";
public static String TOKEN_MENOR_IGUAL = "MENOR IGUAL";
public static String TOKEN_MENOR = "MENOR";
public static String TOKEN_MENOR_MENOR = "MENOR MENOR";
public static String TOKEN_IGUAL_IGUAL = "IGUAL IGUAL";
public static String TOKEN_IGUAL = "IGUAL";
public static String TOKEN_COMENTARIO_LINEAR = "COMENTÁRIO LINEAR";
public static String TOKEN_COMENTARIO_MULT="COMENTARIO MULTI LINHA";
public static String TOKEN_DIVIDIR_ATRIBUIR = "DIVEDE E ATRIBUI";
public static String TOKEN_MULTIPLICAR_ATRIBUIR = "MULTIPLICA E ATRIBUI";
public static String TOKEN_SOMAR_ATRIBUIR = "SOMA E ATRIBUI";
public static String TOKEN_SUBTRAIR_ATRIBUIR = "SUBTRAI E ATRIBUI";
public static String TOKEN_MOD_A = "RESTO DA DIVISÃO E ATRIBUI";
public static String TOKEN_SOMA = "SOMA";
public static String TOKEN_DUPLA_SOMA="Dupla Soma";
public static String TOKEN_SUBTRAI = "SUBTRAI";
public static String TOKEN_DUPLA_SUBTRACAO="Dupla Subtração";
public static String TOKEN_MULT = "MULTIPLICAÇÃO";
public static String TOKEN_DIV = "DIVISÃO";
public static String TOKEN_MOD = "RESTO DA DIVISÃO";
public  static String TOKEN_INCREMENTO = "INCREMENTO";
public static String TOKEN_DECREMENTO = "DECREMETNO";
public static String TOKEN_NOT = "NEGAÇÃO";
public static String TOKEN_DIFERENTE = "DIFERENTE";
public static String TOKEN_AND = "and bit a bit";
public static String TOKEN_AND_AND = "and";
public static String TOKEN_OR = "or bit a bit";
public static String TOKEN_OR_OR = "or";
public static String TOKEN_XOR = "xor";
public static String TOKEN_INTERROGACAO = "OPERADOR TERNARIO";
public static String TOKEN_RESERVADA="Palavra reservada";
public static String TOKEN_ASPAS_DUPLAS="Aspas Duplas";
public static String TOKEN_ASPAS_SIMPLES="Aspas Simples";
public static String TOKEN_NOTI="Negacao";

}
