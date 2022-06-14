package views;

import java.util.List;
import java.util.Scanner;

import models.Usuario;

public class UsuarioView {
	Scanner sc = new Scanner(System.in);

    public void listar(List<Usuario> lista) {
        for (int i =0; i < lista.size(); i++) {
            Usuario usr = lista.get(i);
            System.out.println(i+"-> ("+usr.getId()+") "+usr.getNome()+" - "+usr.getContato()+ " - " + usr.getEndereco());
        }
    }
    public void displayUsuario(Usuario usr) {
        System.out.println("--------------------------------");
        System.out.println("ID: "+usr.getId());
        System.out.println("Nome: "+ usr.getNome());
        System.out.println("Contato.: "+usr.getContato());
        System.out.println("Endereço: "+usr.getEndereco());
        System.out.println("--------------------------------");
    }

    public Usuario displayFormularioUsuario(){
		String nome, contato, endereco;
		System.out.print("Digite o seu nome: $");
		nome = (sc.next());
		System.out.print("Digite um contato: $");
		contato = (sc.next());
		System.out.print("Digite o seu endereço: $");
		endereco = (sc.next());
		Usuario usr = new Usuario(0,nome,contato,endereco);
		return usr;
    }

}
