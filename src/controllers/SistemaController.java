package controllers;

public class SistemaController {
	UsuarioController usr = new UsuarioController();
	EventoController evt = new EventoController();

	public void cadastrarUsuario() {
		usr.novoUsuario();
	}
	
	public void listarUsuarios() {
		usr.listarUsuarios();
	}
	
	public void cadastrarEvento() {
		evt.novoEvento();
	}
	
	public void listarEventos() {
		evt.listarEventos();
	}	
	
	public void addParticipante() {
		evt.addParticipante();
	}
	
	public void removeParticipante() {
		evt.removeParticipante();
	}
	   
	public void eventosComUser() {
		evt.eventosComUser();
	}
	
	public void eventosSemUser() {
		evt.eventosSemUser();
	}
	
	 public void eventosPertoDeAgora() {
		   evt.eventosPertoDeAgora();
	   }
	
 }
