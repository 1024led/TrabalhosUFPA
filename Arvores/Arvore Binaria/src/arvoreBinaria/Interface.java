package arvoreBinaria;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x, y, aux;
        String aleatorio;
        No novoNo;
        
        System.out.print("Informe o valor da raiz: ");
        No arvore = ArvoreBinaria.gerarArvore(scanner.nextInt());
        
        while(true){
            System.out.print("\nSelecione uma opcao:\n"
                + "1 - Inserir elementos na arvore\n"
                + "2 - Remover elementos da arvore\n"
                + "3 - Salvar XML\n"
                + "4 - Carregar XML\n"
                + "Opcao: ");
            
            switch(scanner.nextInt()){
                case 1:
                    System.out.print("Quantos elementos deseja inserir? | ");
                    x = scanner.nextInt();
                    System.out.print("Elementos aleatorios? S/N | ");
                    aleatorio = scanner.next().toUpperCase();
                    
                    switch(aleatorio){
                        case "S":
                            System.out.print("Valor maximo: ");
                            aux = scanner.nextInt();
                            for(y = 0; y < x; y++){
                                novoNo = ArvoreBinaria.gerarNoAleatorio(aux);
                                ArvoreBinaria.inserirNo(arvore, novoNo);
                            }
                            break;
                        case "N":
                            for(y = 0; y < x; y++){
                                System.out.print("Informe o valor do novo No: ");
                                aux = scanner.nextInt();
                                novoNo = ArvoreBinaria.gerarNo(aux);
                                ArvoreBinaria.inserirNo(arvore, novoNo);
                            }
                            break;
                        default:
                            System.out.println("ERRO: ENTRADA INVALIDA");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor que deseja remover: ");
                    aux = scanner.nextInt();
                    ArvoreBinaria.removerNo(arvore, aux);
                    break;
                case 3:
                    XML.gerarXML(arvore);
                    break;
                case 4:
                    arvore = XML.carregarXML();
                    break;
                default:
                    System.out.println("ERRO: ENTRADA INVALIDA");
                    break;
            }
        }
    }
}
