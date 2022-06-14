package controllers;

import databases.UsuarioDB;
import interfaces.UsuarioInterface;
import models.Usuario;
import views.UsuarioView;

public class UsuarioController implements UsuarioInterface{
    UsuarioDB db;
    UsuarioView view;

    public UsuarioController() {
        this.db = UsuarioDB.getInstance(); //N�O CRIA UM NOVO, PEGA O J� CRIADO NA CLASSE
        this.view = new UsuarioView();
    }

    public void novoUsuario() {
        Usuario usr = view.displayFormularioUsuario();
        db.incluir(usr);
        view.displayUsuario(usr);
    }

    public void listarUsuarios() {
         view.listar(db.getTodosUsuarios());
    }
}
