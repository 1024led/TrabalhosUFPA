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
}