package models;
import java.util.Scanner;
import databases.SistemaDB;
import views.MenuView;

public class SistemaDeEventos {
	
	public void run() {
        Scanner sc = new Scanner (System.in);
        int opcaoEscolhida = -1;
        SistemaDB sdb= new SistemaDB(); 
        MenuView mv = new MenuView(opcaoEscolhida);
        mv.displayMenu(sc, sdb);
	}

}
