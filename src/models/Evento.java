package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento extends Elemento {
	private DateTimeFormatter horario;
	private int categoria;
	//TODO: COLOCAR ARRAYLIST<USUARIO> PARTICIPANTES
	
	
	public Evento(int id, String nome, String endereco, int categoria) {
		super(id, nome,endereco);
		this.horario =  DateTimeFormatter.ofPattern("HH:mm:ss");
		this.categoria = categoria;
	}
	public String getHorario() {
		return horario.format(LocalDateTime.now());
	}
	
	public int getCategoria() {
		return categoria;
	}
}
