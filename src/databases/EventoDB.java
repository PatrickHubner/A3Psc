package databases;
import java.util.ArrayList;
import java.util.List;

import models.Evento;
import models.EventoFile;
import models.Usuario;

public class EventoDB {
    private ArrayList<Evento> eventos;
    private ArrayList<String> participantes;
    private ArrayList<Integer> horario;
    EventoFile evtFile;
    private int idAtual = 0;
    private static EventoDB instancia; // USANDO DESIGN PATTERN SINGLETON

    /* CRIA NOVA INSTANCIA SE ELA FOR NULA */
    public static EventoDB getInstance() {
        if(instancia == null) {
            /* CRIA O ARQUIVO DO BANCO DE DADOS A PARTIR DA INSTANCIA JÁ EXISTENTE*/
            instancia = new EventoDB();
            instancia.evtFile = new EventoFile();
            ArrayList ret = instancia.evtFile.carregarEventos(instancia);
            instancia.eventos.addAll(ret);
        }
        // SE JÁ EXISTIR SÓ RETORNA
        return instancia;
    }

    public EventoDB() {
    	eventos = new ArrayList<>();
    	participantes = new ArrayList<String>();
    }
    /*CORRIGE O ID NO FUNCIONARIO FILE*/
    public void setIdAtual(int id) {
        this.idAtual = id;
    }
    public void incluir(Evento evento) {
        /* CONFIGURA ID UNICO */
        if (evento.getId() == 0) {
            this.idAtual++;
            evento.setId(this.idAtual);
        }
        /* CHECA SE O FUNCIONARIO JÁ EXISTE */
        if (this.eventos.contains(evento)) {
            System.out.println("evento já existe");
        } else {
            /* ADICIONA USUARIO */
            this.eventos.add(evento);
            salvarEventosNoBD();

        }
    }
    public ArrayList<Evento> getTodosEventos() {
        return this.eventos;
    }

    public void salvarEventosNoBD () {
        instancia.evtFile.salvarEventos(this.eventos);
    }
    
	public void addParticipante(String participante,Evento evento) {
		evento.addParticipante(participante);
		this.participantes.add(participante);
		salvarEventosNoBD();
	}
	
	public void removeParticipante(String participante, Evento evento) {
		evento.removeParticipante(participante);
		this.participantes.remove(participante);
		salvarEventosNoBD();
	}

}
