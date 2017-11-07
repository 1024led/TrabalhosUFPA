package arvoreBinaria;

public class No{
    int valor;
    No noEsquerdo = null;
    No noDireito = null;
    //No noPai = null;

    public No(int valor){
        this.valor = valor;
    }
    
    public No(){
        super();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }
    
}