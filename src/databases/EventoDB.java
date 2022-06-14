package databases;
import java.util.ArrayList;
import java.util.List;

import models.Evento;
import models.EventoFile;

public class EventoDB {
    private List<Evento> eventos;
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

    private EventoDB() {
    	eventos = new ArrayList<>();
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
    public List<Evento> getTodosEventos() {
        return this.eventos;
    }

    public void salvarEventosNoBD () {
        instancia.evtFile.salvarEventos(this.eventos);
    }


}
