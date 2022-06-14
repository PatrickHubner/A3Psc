package views;

import java.util.Scanner;

import controllers.MenuController;
import controllers.SistemaController;

public class MenuView {
	private int op;
	
	
	
	public MenuView(int op) {
		this.op = op;
	}

	public void displayMenu(Scanner sc, SistemaController sdb) {
	    do {
	    	System.out.println(
	    			" _______________________________\n"
	    			+"|                               |)\n"
	    			+"| === ? SISTEMA DE EVENTOS  === |)\n"
	    			+"|                               |)\n"
	    			+ "|  1 - Cadastrar Usu�rio        |)\n"
	    			+ "|  2 - Listar Usu�rio           |)\n"
	    			+ "|  3 - Cadastrar Evento         |)\n"
	    			+ "|  4 - Consultar Eventos        |)\n"
	    			+ "|  5 - Partipar de um Evento    |)\n"
	    			+ "|  6 - Sair de um Evento        |)\n"
	    			+ "|  7 - Eventos que eu participo |)\n"
	    			+ "|  8 - Eventos q n�o participo  |)\n"
	    			+ "|  9 - Evtos pr�ximos de agora  |)\n"
	    			+ "|  0 - Sair                     |)\n"
	    			+ "|_______________________________|)"
	    			);
	    	System.out.print("\nDigite uma op��o: $");
	    	op = sc.nextInt();
	    	MenuController mc = new MenuController(op);
	    	mc.chooseOption(sdb);
	    } while (op != 0);
	}
}
