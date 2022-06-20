package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import databases.EventoDB;
import databases.UsuarioDB;
import models.Evento;

import java.time.LocalDateTime;

public class EventoView {
	Scanner sc = new Scanner(System.in);
	EventoDB evb = EventoDB.getInstance();

    public void listar(List<Evento> lista) {
        for (int i =0; i < lista.size(); i++) {
            Evento evt = lista.get(i);
            System.out.println(evt.getId()+" - "+ "Nome: " + evt.getNome() +" - " + "Endereço: " + evt.getEndereco() + " - " + " Horário: " + evt.getHorario().get(0) + ":" + evt.getHorario().get(1) + ":" + evt.getHorario().get(2) + " - " + " Participantes:" + evt.listarParticipantes());
        }
    }
    public void displayEvento(Evento evt) {
        System.out.println("--------------------------------");
        System.out.println("ID: "+evt.getId());
        System.out.println("Nome: "+ evt.getNome());
        System.out.println("Endereço: "+evt.getEndereco());
        System.out.println("Categoria.: "+evt.getCategoria());
        System.out.println("Horario: "+evt.getHorario().get(0)+":"+evt.getHorario().get(1)+":"+evt.getHorario().get(2));
        System.out.println("--------------------------------");
    }

    public Evento displayFormularioEvento(){
		String nome, contato, endereco, newCategoria;
		int categoria = -1;
		ArrayList<String> participantes = new ArrayList<String>();
		ArrayList<Integer> horario = new ArrayList<Integer> ();
		System.out.print("Digite o nome do seu evento: $");
		nome = (sc.nextLine());
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
		switch (categoria) {
			case 1:
				newCategoria =  "Bailão retrô anos 80/90";
				break;
			case 2:
				newCategoria = "Festa Junina";
				break;
			case 3:
				newCategoria = "Encontro do ensino médio";
				break;
			case 4:
				newCategoria = "Botequinho cos guri";
				break;
			default:
				newCategoria = "LOQUEOU, TÁ MALUCO MEU?!?";
				break;
		}
		System.out.print("Digite a hora do evento (HH): ");
		horario.add(sc.nextInt());
		System.out.print("Digite o minuto do evento (MM): ");
		horario.add(sc.nextInt());
		System.out.print("Digite o segundo do evento (SS): ");
		horario.add(sc.nextInt());
		System.out.println("Digite o seu endereço: $");
		endereco = (sc.next());
		
		Evento evt = new Evento(0,nome,endereco,newCategoria, horario, participantes);
		return evt;
    }
    
    public void addParticipante() {
		UsuarioDB udb = UsuarioDB.getInstance();
		System.out.println("ESCOLHA QUAL DOS SEUS USUÁRIOS VOCÊ QUER QUE PARTICIPE: \n");
		for (int i = 0; i < udb.getTodosUsuarios().size(); i ++) {
			System.out.print(udb.getTodosUsuarios().get(i)+ "\n");
		}
		System.out.print("Digite o id do usuário escolhido: ");
		int id = sc.nextInt();
		System.out.println("ESCOLHA QUAL DOS SEUS EVENTOS VOCÊ QUER PARTICIPAR: \n");
		for (int i = 0; i < evb.getTodosEventos().size(); i ++) {
			System.out.println(evb.getTodosEventos().get(i));
		}
		System.out.println("\n");
		System.out.print("Digite o id do evento escolhido: ");
		int idEvt = sc.nextInt();
		try {
			evb.addParticipante(udb.getTodosUsuarios().get(id -1).getNome(),evb.getTodosEventos().get(idEvt -1));
			System.out.println("USUARIO ADICIONADO AEEE\n\n");
		} catch (Error error) {
			System.out.println(error);
		}

    }
    
    public void removeParticipante() {
		UsuarioDB udb = UsuarioDB.getInstance();
		System.out.println("ESCOLHA QUAL DOS SEUS USUÁRIOS VOCÊ QUER QUE PARTICIPE: \n");
		for (int i = 0; i < udb.getTodosUsuarios().size(); i ++) {
			System.out.print(udb.getTodosUsuarios().get(i)+ "\n");
		}
		System.out.print("Digite o id do usuário escolhido: ");
		int id = sc.nextInt();
		System.out.println("ESCOLHA QUAL DOS SEUS EVENTOS VOCÊ QUER PARTICIPAR: \n");
		for (int i = 0; i < evb.getTodosEventos().size(); i ++) {
			System.out.println(evb.getTodosEventos().get(i));
		}
		System.out.println("\n");
		System.out.print("Digite o id do evento escolhido: ");
		int idEvt = sc.nextInt();
		try {
			evb.removeParticipante(udb.getTodosUsuarios().get(id -1).getNome(),evb.getTodosEventos().get(idEvt -1));
			System.out.println("USUARIO REMOVIDO AEEE\n\n");
		} catch (Error error) {
			System.out.println(error);
		}

    }
    
	public void eventosComUser() {
		UsuarioDB udb = UsuarioDB.getInstance();
		System.out.println("ESCOLHA QUAL DOS SEUS USUÁRIOS VOCÊ QUER QUE PARTICIPE: \n");
		for (int i = 0; i < udb.getTodosUsuarios().size(); i ++) {
			System.out.print(udb.getTodosUsuarios().get(i)+ "\n");
		}
		System.out.print("Digite o id do usuário escolhido: ");
		int id = sc.nextInt();
		for (int i = 0; i < evb.getTodosEventos().size(); i ++) {
			if (evb.getTodosEventos().get(i).listarParticipantes().contains(udb.getTodosUsuarios().get(id -1).getNome())) {
				System.out.println(evb.getTodosEventos().get(i));
			}
		}
	}
	
	public void eventosSemUser() {
		UsuarioDB udb = UsuarioDB.getInstance();
		System.out.println("ESCOLHA QUAL DOS SEUS USUÁRIOS VOCÊ QUER QUE PARTICIPE: \n");
		for (int i = 0; i < udb.getTodosUsuarios().size(); i ++) {
			System.out.print(udb.getTodosUsuarios().get(i)+ "\n");
		}
		System.out.print("Digite o id do usuário escolhido: ");
		int id = sc.nextInt();
		for (int i = 0; i < evb.getTodosEventos().size(); i ++) {
			if (!evb.getTodosEventos().get(i).listarParticipantes().contains(udb.getTodosUsuarios().get(id -1).getNome())) {
				System.out.println(evb.getTodosEventos().get(i));
			}
		}
	}
	
	public void eventosPertoDeAgora() {
		int horaEmMin = LocalDateTime.now().getHour() * 60;
		int minuto = LocalDateTime.now().getMinute();
		
		for (int i = 0 ; i < evb.getTodosEventos().size(); i ++) {
			int evHoraEmMin = evb.getTodosEventos().get(i).getHorario().get(0) * 60;
			int evMin = evb.getTodosEventos().get(i).getHorario().get(1);
			boolean horaIgual = (evHoraEmMin + evMin) == (horaEmMin + minuto);
			boolean horaMaior = ((evHoraEmMin + evMin) - (horaEmMin + minuto) <= 30 && (evHoraEmMin + evMin) - (horaEmMin + minuto) >= 0);
			boolean horaMenor = ((evHoraEmMin + evMin) - (horaEmMin + minuto) >= -30 && (evHoraEmMin + evMin) - (horaEmMin + minuto) <= 0);
			if (horaIgual || horaMaior || horaMenor ) {
				System.out.println(evb.getTodosEventos().get(i));
			}
		}
	}

}
