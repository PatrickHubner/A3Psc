package controllers;

import databases.EventoDB;
import models.Evento;
import views.EventoView;

public class EventoController {
	    EventoDB db;
	    EventoView view;

	    public EventoController() {
	        this.db = EventoDB.getInstance(); //NÃO CRIA UM NOVO, PEGA O JÁ CRIADO NA CLASSE
	        this.view = new EventoView();
	    }

	    public void novoEvento() {
	       Evento usr = view.displayFormularioEvento();
	        db.incluir(usr);
	        view.displayEvento(usr);
	    }

	    public void listarEventos() {
	         view.listar(db.getTodosEventos());
	    }
	}

