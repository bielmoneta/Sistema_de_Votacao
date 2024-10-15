package aplicação2;

import java.util.Scanner;
import entidades.Candidato;

public class Cadastramento extends Candidato{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nome;
		int numero;
		
		//Solicita ao usuário quantos candidatos ele quer cadastrar
		System.out.print("Quantos candidatos você quer cadastrar? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		//Cria um array/vetor para armazenar os candidatos
		Candidato[] vetor = new Candidato[n];
		
		//Loop para registrar os candidatos com nome e número
		for (int i = 0; i < n; i++) {
			System.out.print("Digite o nome do "+ (i + 1) + "º candidato: ");
			nome = sc.nextLine();
			System.out.print("Digite o número do "+ (i + 1) + "º candidato: ");
			numero = sc.nextInt();
			sc.nextLine();
			//Adiciona os candidatos no array
			vetor[i] = new Candidato(nome, numero);
		} 
		
		//Exibe as informações dos candidatos cadastrados
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("---===<<< Candidato >>>===---");
			System.out.println("Nome: " + vetor[i].getNome());
			System.out.println("Número: " + vetor[i].getNumero());
			System.out.println();
		}
		
		//Solicita ao usuário um número para buscar um candidato específico
        System.out.print("Digite o número do candidato para busca: ");
        int numeroBuscado = sc.nextInt();

        //Encontrar o candidato pelo número
        Candidato candidatoEncontrado = localizarCandidato(vetor, numeroBuscado);

        //Verifica se o candidato foi encontrado
        if (candidatoEncontrado != null) {
            System.out.println("Candidato: " + candidatoEncontrado.getNome());
        } else {
            System.out.println("Candidato não encontrado.");
        }
 
        System.out.println();
        
        //Solicita quantos votos serão lidos
        System.out.print("Quantos votos serão lidos? ");
        int quantidadeVotos = sc.nextInt();

        //Leitura dos votos e associa aos candidatos 
        for (int i = 0; i < quantidadeVotos; i++) {
            System.out.print("Digite o número do candidato votado: ");
            int numeroVotado = sc.nextInt();

            //Localiza os candidatos pelo número votado
            Candidato candidato = localizarCandidato(vetor, numeroVotado);
            if (candidato != null) {
                candidato.addVotos(); //adiciona o número de votos ao candidato encontrado
            } else {
                System.out.println("Candidato com número " + numeroVotado + " não encontrado.");
            }
        }

        //Exibe o resultado final dos votos
        System.out.println("\nResultado Final:");
        for (Candidato candidato : vetor) {
            if (candidato.getVotos() > 0) { //Exibe apenas os candidatos que receberam votos
                System.out.print("---===<<< Candidato >>>===---");
                System.out.println(candidato); //Exibe os dados dos candidatos
            }
        }
        
        sc.close();
    }
}
