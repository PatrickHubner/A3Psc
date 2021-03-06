package models;

public class Usuario extends Elemento {
	private String contato;
	
	
	public Usuario(int id, String nome, String contato, String endereco) {
		super(id, nome,endereco);
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
		return "Id: " + getId() + " - " + "Nome: " + getNome() + " - " + "Contato: " + getContato() +  " - " + "Endereco: " + getEndereco();
	}	
	
}
