package databases;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;
import models.UsuarioFile;

public class UsuarioDB {
    private List<Usuario> usuarios;
    UsuarioFile usrFile;
    private int idAtual = 0;
    private static UsuarioDB instancia; // USANDO DESIGN PATTERN SINGLETON

    /* CRIA NOVA INSTANCIA SE ELA FOR NULA */
    public static UsuarioDB getInstance() {
        if(instancia == null) {
            /* CRIA O ARQUIVO DO BANCO DE DADOS A PARTIR DA INSTANCIA JÁ EXISTENTE*/
            instancia = new UsuarioDB();
            instancia.usrFile = new UsuarioFile();
            ArrayList ret = instancia.usrFile.carregarUsuarios(instancia);
            instancia.usuarios.addAll(ret);
        }
        // SE JÁ EXISTIR SÓ RETORNA
        return instancia;
    }

    private UsuarioDB() {
    	usuarios = new ArrayList<>();
    }
    /*CORRIGE O ID NO FUNCIONARIO FILE*/
    public void setIdAtual(int id) {
        this.idAtual = id;
    }
    public void incluir(Usuario usuario) {
        /* CONFIGURA ID UNICO */
        if (usuario.getId() == 0) {
            this.idAtual++;
            usuario.setId(this.idAtual);
        }
        /* CHECA SE O FUNCIONARIO JÁ EXISTE */
        if (this. usuarios.contains( usuario)) {
            System.out.println("usuario já existe");
        } else {
            /* ADICIONA USUARIO */
            this.usuarios.add( usuario);
            salvarUsuariosNoBD();

        }
    }
    public List<Usuario> getTodosUsuarios() {
        return this. usuarios;
    }

    public void salvarUsuariosNoBD () {
        instancia.usrFile.salvarUsuarios(this.usuarios);
    }

}
