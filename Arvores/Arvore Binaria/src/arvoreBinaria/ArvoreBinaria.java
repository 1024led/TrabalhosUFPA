package arvoreBinaria;

import java.util.Random;

public class ArvoreBinaria{
    public static void inserirNo(No raiz, No novoNo){
        if (novoNo.valor < raiz.valor){
            if (raiz.noEsquerdo == null){
                novoNo.noPai = raiz;
                raiz.noEsquerdo = novoNo;
                System.out.printf("Valor %d inserido com sucesso\n", novoNo.valor);
            } else {
                inserirNo(raiz.noEsquerdo, novoNo);
            }
        } else if (novoNo.valor > raiz.valor){
            if (raiz.noDireito == null){
                novoNo.noPai = raiz;
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
    
    public static void removerNo(No no, int valor){
        if (no.valor == valor){
            if (no.noEsquerdo != null && no.noDireito != null){
                No novoNo = null;
                
                //Encontrar nó filho para substituir
                if (no.noEsquerdo != null){
                    novoNo = localizaPredecessor(no.noEsquerdo);
                } else if (no.noDireito != null){
                    novoNo = localizaSucessor(no.noDireito);
                }
                
                //Desvincular o nó novo de seus pais antigos
                if (novoNo.valor < novoNo.noPai.valor){
                    novoNo.noPai.noEsquerdo = null;
                } else {
                    novoNo.noPai.noDireito = null;
                }
                
                //Vincular os filhos do nó antigo ao nó novo
                if (no.noDireito != null){
                    novoNo.noDireito = no.noDireito;
                    no.noDireito.noPai = novoNo;
                }
                if (no.noEsquerdo != null){
                    novoNo.noEsquerdo = no.noEsquerdo;
                    no.noEsquerdo.noPai = novoNo;
                }
                
                //Vincular o pai do nó antigo ao novo nó
                if (no.noPai != null){ //Raiz não possui nó pai
                    if (no.valor < no.noPai.valor){
                        no.noPai.noEsquerdo = novoNo;
                    } else {
                        no.noPai.noDireito = novoNo;
                    }                    
                }
                
            } else {
                if (no.valor < no.noPai.valor){
                    no.noPai.noEsquerdo = null;
                } else {
                    no.noPai.noDireito = null;
                }
                no.noPai = null;
            }
            System.out.println("NO REMOVIDO COM SUCESSO");
        } else {
            if (valor < no.valor && no.noEsquerdo != null){
                removerNo(no.noEsquerdo, valor);
            } else if (valor > no.valor && no.noDireito != null){
                removerNo(no.noDireito, valor);
            } else {
                System.out.println("ERRO: VALOR NÃO ENCONTRADO NA RAIZ");
            }
        }
    }
    
    public static No localizaPredecessor(No no){
        if (no.noDireito != null){
            localizaSucessor(no.noDireito);
        }
        return no;
    }
    
    public static No localizaSucessor(No no){
        if (no.noEsquerdo != null){
            localizaPredecessor(no.noEsquerdo);
        }
        return no;
    }

    public static No gerarNoAleatorio(int tamanho){
        Random random = new Random();
        No novoNo = new No(random.nextInt(tamanho));
        return novoNo;
    }
    
    public static No gerarNo(int valor){
        No novoNo = new No(valor);
        return novoNo;
    }

    public static No gerarArvore(int valor){
        No raiz = new No(valor);
        return raiz;
    }
}