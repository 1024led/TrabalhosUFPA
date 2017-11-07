package arvoreBinaria;

import java.util.Scanner;
import java.util.Random;

public class ArvoreBinaria{
    public static void inserirNo(No raiz, No novoNo){
        if (novoNo.valor < raiz.valor){
            if (raiz.noEsquerdo == null){
                    //novoNo.noPai = raiz;
                    raiz.noEsquerdo = novoNo;
                    System.out.printf("Valor %d inserido com sucesso\n", novoNo.valor);
            } else {
                inserirNo(raiz.noEsquerdo, novoNo);
            }
        } else if (novoNo.valor > raiz.valor){
            if (raiz.noDireito == null){
                //novoNo.noPai = raiz;
                raiz.noDireito = novoNo;
                System.out.printf("Valor %d inserido com sucesso\n", novoNo.valor);
            } else {
                inserirNo(raiz.noDireito, novoNo);
            }
        }
        if (raiz.valor == novoNo.valor){
            System.out.printf("Valor %d ja existe na arvore\n", novoNo.valor);
        }
    }

    public static No gerarNo(Random random, int tamanho){
        No novoNo = new No(random.nextInt(100));
        return novoNo;
    }

    public static No gerarArvore(){
        Random random = new Random();
        No raiz = new No(random.nextInt(100));
        System.out.print("Insira o tamanho da arvore: ");
        int tamanho = (new Scanner(System.in)).nextInt();
        System.out.println("Raiz: " + raiz.valor);
        for(int x = 0; x < tamanho; x++){
            System.out.printf("%d - ", x);
            inserirNo(raiz, gerarNo(random, tamanho));
        }
        return raiz;
    }
}