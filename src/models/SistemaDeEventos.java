package models;
import java.util.Scanner;

import controllers.SistemaController;
import views.MenuView;

public class SistemaDeEventos {
	
	public void run() {
        Scanner sc = new Scanner (System.in);
        int opcaoEscolhida = -1;
        SistemaController sdb= new SistemaController(); 
        MenuView mv = new MenuView(opcaoEscolhida);
        mv.displayMenu(sc, sdb);
	}

}
