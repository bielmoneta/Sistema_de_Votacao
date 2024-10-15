package entidades;

public class Candidato {
	
	private String nome;
	private int votos;
	private int numero;
	
	public Candidato() {
	}

	public Candidato(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
 	}
  
	public String getNome() {
		return nome;
	}

	public int getVotos() {
		return votos;
	}

	public int getNumero() {
		return numero;
	}
	
	public int addVotos() {
		return votos++;
	}
	
	public String toString() { 
		return "\nNome: "+ nome + "\nNúmero: "+ numero + "\nVotos: "+ votos;
	}
	
	public static Candidato localizarCandidato(Candidato[] vetor, int numero) {
        for (Candidato candidato : vetor) {
            if (candidato.getNumero() == numero) {
                return candidato;
            }
        } 
        return null; 
   }
} 
