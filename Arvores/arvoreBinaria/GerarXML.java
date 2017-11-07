package arvoreBinaria;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class GerarXML{
    public static void main(String[] args){
        No raiz = ArvoreBinaria.gerarArvore();
        
        try {
            FileOutputStream fos = new FileOutputStream(new File("./arvore.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(raiz);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
        }
    }
}