package views;

import java.util.List;
import java.util.Scanner;

import models.Evento;

public class EventoView {
	Scanner sc = new Scanner(System.in);

    public void listar(List<Evento> lista) {
        for (int i =0; i < lista.size(); i++) {
            Evento usr = lista.get(i);
            System.out.println(i+"-> ("+usr.getId()+") "+usr.getNome()+" - " + usr.getEndereco());
        }
    }
    public void displayEvento(Evento evt) {
        System.out.println("--------------------------------");
        System.out.println("ID: "+evt.getId());
        System.out.println("Nome: "+ evt.getNome());
        System.out.println("Endereço: "+evt.getEndereco());
        System.out.println("Categoria.: "+evt.getCategoria());
        System.out.println("--------------------------------");
    }

    public Evento displayFormularioEvento(){
		String nome, contato, endereco;
		int categoria = -1;
		System.out.print("Digite o nome do seu evento: $");
		nome = (sc.next());
		System.out.print("Digite o seu endereço: $");
		endereco = (sc.next());
		do {
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
		} while ( categoria < 1 && categoria > 4);

		categoria = sc.nextInt();
		Evento usr = new Evento(0,nome,endereco,categoria);
		return usr;
    }

}
