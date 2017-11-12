package arvoreBinaria;
import java.util.Scanner;

import java.util.ArrayList;

public class SistemaDeBusca{
    public static void buscarValor(No raiz){
        Scanner scanner = new Scanner(System.in);
        ArrayList caminho = new ArrayList<>();
        
        System.out.print("\nInsira o valor a ser buscado: ");
        caminho = buscar(scanner.nextInt(), raiz, caminho);
        imprimirCaminho(caminho);
    }

    public static ArrayList buscar(int valor, No raiz, ArrayList pilha) {
        pilha.add(raiz.valor);
        if (valor == raiz.valor){
            System.out.println("VALOR ENCONTRADO");
            return pilha;
        } else {
            if (valor < raiz.valor && raiz.noEsquerdo != null){
                buscar(valor, raiz.noEsquerdo, pilha);
            } else if (valor > raiz.valor && raiz.noDireito != null){
                buscar(valor, raiz.noDireito, pilha);
            } else {
                System.out.println("VALOR NAO EXISTE NA ARVORE.");
            }
        }
        return pilha;
    }
    
    public static void imprimirCaminho(ArrayList pilha){
        for(int x = 0; x < pilha.size(); x++){
            System.out.printf("%d - ", pilha.get(x));
        }
    }
}