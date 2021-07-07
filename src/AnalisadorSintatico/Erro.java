/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorSintatico;

/**
 *
 * @author AIRES DO ROSARIO
 */
public class Erro {
    String erro;
    int linha;

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public Erro(String erro, int linha) {
        this.erro = erro;
        this.linha = linha;
    }
    
    public Erro() {
    }
}
