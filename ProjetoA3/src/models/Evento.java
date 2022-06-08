package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento extends Elemento {
	private DateTimeFormatter horario;
	private int categoria;
	//TODO: COLOCAR ARRAYLIST<USUARIO> PARTICIPANTES
	
	
	public Evento(String nome, String endereco, int categoria) {
		super(nome,endereco);
		this.horario =  DateTimeFormatter.ofPattern("HH:mm:ss");
		this.categoria = categoria;
	}
	public String getHorario() {
		return horario.format(LocalDateTime.now());
	}
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Nome do Evento: " + getNome() + "\n" + "Horário:" +  getHorario() + "\n" + "Endereco=" + getEndereco() + "\n" + "Categoria=" + categoria + "\n";
	}
	
	
	
	
	
	
}
