package databases;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.EventoInterface;
import interfaces.UsuarioInterface;
import models.Evento;
import models.Usuario;

public class SistemaDB implements UsuarioInterface, EventoInterface{
	ArrayList<Evento> eventos;
	ArrayList<Usuario> usuarios;
	Scanner sc;
	
	public SistemaDB() {
		this.eventos = new ArrayList<> ();
		this.usuarios = new ArrayList<> ();
		this.sc = new Scanner (System.in);
	}
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	public void addEvento(Evento evento) {
		this.eventos.add(evento);
	}
	private ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	@Override
	public void cadastrarUsuario() {
		String nome, contato, endereco;
		System.out.print("Digite o seu nome: $");
		nome = (sc.next());
		System.out.print("Digite um contato: $");
		contato = (sc.nextLine());
		System.out.print("Digite o seu endereço: $");
		endereco = (sc.nextLine());
		this.addUsuario(new Usuario(nome,contato,endereco));
		nome = "";
		contato = "";
		endereco = "";
		
	}
	@Override
	public void listarUsuarios() {
		System.out.println(getUsuarios());
		
	}
	@Override
	public void cadastrarEvento() {
		String nome, local;
		int categoria;
		System.out.print("Digite o nome do evento: $");
		nome = (sc.nextLine());
		System.out.print("Digite o seu endereço: $");
		local = (sc.nextLine());
		System.out.println(
				" _______________________________\n"
    			+"|                               |)\n"
    			+"| === ? ESCOLHA A CATEGORIA === |)\n"
    			+"|                               |)\n"
    			+"|  1 - Bailão retrô anos 80/90  |)\n"
    			+"|  2 - Festa Junina             |)\n"
    			+"|  3 - Encontro ens. médio      |)\n"
    			+"|  4 - 'Botequinho cos guri'    |)\n"
    			+ "|_______________________________|)"
				);
		categoria = sc.nextInt();
		this.addEvento(new Evento(nome,local,categoria));
		
	}
	@Override
	public void listarEventos() {
		System.out.println(getEventos());
		
	}


	
}
