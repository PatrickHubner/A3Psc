package models;

import java.util.ArrayList;

public class Evento extends Elemento {
	private ArrayList<Integer> horario;
	private String categoria;
	private ArrayList<String> participantes;
	
	public Evento(int id, String nome, String endereco, String categoria, ArrayList<Integer> horario, ArrayList<String> participantes) {
		super(id, nome,endereco);
		this.horario =  horario;
		this.categoria = categoria;
		this.participantes = participantes;
	}
	public ArrayList<Integer> getHorario() {
		return this.horario;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public ArrayList<String> listarParticipantes() {
		return this.participantes;
	}
	
	public void addParticipante(String participante) {
		this.participantes.add(participante);
	}
	
	public void removeParticipante(String participante) {
		this.participantes.remove(participante);
	}
	@Override
	public String toString() {
		return getId() + " - Evento " + getNome() + " - Endereço: " + getEndereco() + " - Categoria: " + getCategoria() + " Horário: " + getHorario().get(0) +":"+getHorario().get(1)+":"+getHorario().get(2) + " - Participantes: " + listarParticipantes();
	}
	

}
