package models;

public class Usuario extends Elemento {
	private String contato;
	
	
	public Usuario(String nome, String contato, String endereco) {
		super(nome,endereco);
		this.contato = contato;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\n" + "Contato: " + contato + "\n" + "Endereco: " + getEndereco() + "";
	}
	
	

	
}
