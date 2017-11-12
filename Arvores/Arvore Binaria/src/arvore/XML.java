package arvore;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XML{
    public static void gerarXML(No raiz){
        
        try {
            FileOutputStream fos = new FileOutputStream(new File("./arvore.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(raiz);
            encoder.close();
            fos.close();
            System.out.println("XML GERADO COM SUCESSO");
        } catch (IOException ex) {
            System.out.println("ERRO: GERACAO DO XML FALHOU - " + ex);
        }
    }
    
    public static No carregarXML(){
        try {
            FileInputStream fis = new FileInputStream("./arvore.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            No raiz = (No) xmlDecoder.readObject();
            System.out.printf("RAIZ: %d", raiz.valor);
            return raiz;
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO: CARREGAMENTO DO XML FALHOU - " + ex);
        }
    return null;
    }
}