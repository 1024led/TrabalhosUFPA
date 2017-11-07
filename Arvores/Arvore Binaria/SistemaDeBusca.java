import java.util.Scanner;
import java.util.ArrayList;

public class SistemaDeBusca{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList pilha = new ArrayList<>();
		No raiz = (new Arvore()).gerarArvore();
		System.out.print("\nInsira o valor a ser buscado: ");
		int valor = scanner.nextInt();
		pilha = buscar(valor, raiz, pilha);
		//System.out.println("Traceview: " + pilha.index(1));
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
}