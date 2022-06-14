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
	
 }
