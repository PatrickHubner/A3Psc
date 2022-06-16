package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Evento extends Elemento {
	private DateTimeFormatter horario;
	private String categoria;
	private ArrayList<Usuario> participantes;
	//TODO: COLOCAR ARRAYLIST<USUARIO> PARTICIPANTES
	
	
	public Evento(int id, String nome, String endereco, String categoria, ArrayList<Usuario> participantes) {
		super(id, nome,endereco);
		this.horario =  DateTimeFormatter.ofPattern("HH:mm:ss");
		this.categoria = categoria;
		this.participantes = participantes;
	}
	public String getHorario() {
		return this.horario.format(LocalDateTime.now());
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public ArrayList<Usuario> listarParticipantes() {
		return this.participantes;
	}
	
	public void addParticipante(Usuario participante) {
		this.participantes.add(participante);
	}
	
	public void removeParticipante(Usuario participante) {
		this.participantes.remove(participante);
	}
	@Override
	public String toString() {
		return getId() + " - Evento " + getNome() + " - Endereço: " + getEndereco() + " - Categoria: " + getCategoria() + "Horário: " + getHorario() + " - Participantes: " + listarParticipantes() + ";";
	}
	

}
