package views;

import java.util.Scanner;

import controllers.MenuController;
import databases.SistemaDB;

public class MenuView {
	private int op;
	
	
	
	public MenuView(int op) {
		this.op = op;
	}

	public void displayMenu(Scanner sc, SistemaDB sdb) {
	    do {
	    	System.out.println(
	    			" _______________________________\n"
	    			+"|                               |)\n"
	    			+"| === ? SISTEMA DE EVENTOS  === |)\n"
	    			+"|                               |)\n"
	    			+ "|  1 - Cadastrar Usuário        |)\n"
	    			+ "|  2 - Listar Usuário           |)\n"
	    			+ "|  3 - Cadastrar Evento         |)\n"
	    			+ "|  4 - Consultar Eventos        |)\n"
	    			+ "|  5 - Partipar de um Evento    |)\n"
	    			+ "|  6 - Sair de um Evento        |)\n"
	    			+ "|  7 - Eventos que eu participo |)\n"
	    			+ "|  8 - Eventos q não participo  |)\n"
	    			+ "|  9 - Evtos próximos de agora  |)\n"
	    			+ "|  0 - Sair                     |)\n"
	    			+ "|_______________________________|)"
	    			);
	    	System.out.print("\nDigite uma opção: $");
	    	op = sc.nextInt();
	    	MenuController mc = new MenuController(op);
	    	mc.chooseOption(sdb);
	    } while (op != 0);
	}
}
