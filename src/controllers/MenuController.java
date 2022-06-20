package controllers;

public class MenuController {
	private int op;
	
	
	public MenuController(int op) {
		this.op = op;
	}


	public void chooseOption(SistemaController sdb) {
	    	switch(op) {
	    	case 1: 
	    		sdb.cadastrarUsuario();
	    		break;
	    	case 2: 
	    		sdb.listarUsuarios();
	    		break;
	    	case 3:
	    		sdb.cadastrarEvento();
	    		break;
	    	case 4:
	    		sdb.listarEventos();
	    		break;
	    	case 5:
	    		sdb.addParticipante();
	    		break;
	    	case 6: 
	    		sdb.removeParticipante();
	    		break;
	    	case 7: 
	    		sdb.eventosComUser();
	    		break;
	    	case 8: 
	    		sdb.eventosSemUser();
	    		break;
	    	case 9: 
	    		sdb.eventosPertoDeAgora();
	    		break;
	    	case 0: 
	    		System.out.println("Fim do programa!\n");
	    		break;
	    	default:
	    		System.out.println("Opção inválida!\n");
	    		break;
	    	}
	}
}
