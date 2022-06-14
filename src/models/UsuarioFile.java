package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import databases.UsuarioDB;

public class UsuarioFile extends DefaultFile {
    protected static final String NOME_ARQ = "Usuarios.csv";
	
	public UsuarioFile() {
        super();
    }

	public String converteUsuarioPraCsv(Usuario usr) {
		return "USU�RIO" + usr.getId() + "\n" + "Nome: "+ usr.getNome() + ";" + "Contato: " + usr.getContato() + ";" + "Endere�o: "+ usr.getEndereco() + ";";
		
	}

    public Usuario converteCSVPraUsuario(String linha){
    	String[] campos = linha.split(";");
        /* CRIA O FUNCIONARIO COM BASE NA LINHA LIDA PELO ARQUIVO */
        Usuario f = new Usuario(
                Integer.parseInt(campos[0]),
               campos[1],
                campos[2],
                campos[3]);
        return f;
    };

    public void salvarUsuarios(List<Usuario> lista) {
    	File arquivo = new File(DIR_ARQ + "/" + NOME_ARQ);
        /* TENTA GRAVAR NOVO ARQUIVO, SE DER RUIM LAN�A UM ERRO DE IO*/
        try {
            System.out.println(lista);
            //boolean newFile = arquivo.createNewFile();
            FileOutputStream fos = new FileOutputStream(arquivo);

            for(int i = 0; i < lista.size(); ++i) {
                //CONVERTE PRA CSV E TRANSFORMA O CONTE�DO PRA BYTES
                fos.write(this.converteUsuarioPraCsv(lista.get(i)).getBytes());
                fos.write("\n========\n".getBytes());
            }
            /* DESCARREGA NO ARQUIVO E FECHA O ARQUIVO */
            fos.flush();
            fos.close();
        } catch (IOException var6) {
            //LOGA O ERRO DE ACESSO A DISCO
            var6.printStackTrace();
        }
		
	}

	public ArrayList carregarUsuarios(UsuarioDB db) {
		/*TENTA ACHAR O ARQUIVO NO PATHNAME ENVIADO*/
        File arquivo = new File(DIR_ARQ+"/"+NOME_ARQ);
        ArrayList retorno = new ArrayList<>();
        if (arquivo.exists()) {
        	 try {
                 /*TENTA LER O ARQUIVO ENCONTRADO*/
                 Scanner fileScanner = new Scanner(arquivo);
                 /*
                 *ENQUANTO O ARQUIVO TIVER MAIS UMA LINHA DE CONTE�DO,
                 *ELE FAZ A CONVERS�O DISSO PRA LISTA FUNCIONARIO
                 */
                 while(fileScanner.hasNextLine()) {
                     String linha = fileScanner.nextLine();
                     /*CHAMA A CONVERS�O, ADICIONANDO O FUNCIONARIO CRIADO DIRETO NO ARQUIVO*/
                     Usuario u = converteCSVPraUsuario(linha);
                     retorno.add(u);
                     db.setIdAtual(u.getId());
                 }

                 fileScanner.close(); //FECHA O SCANNER
                 } catch (FileNotFoundException var8) {
                     // PRINTA O ERRO DE ARQUIVO N�O ENCONTRADO
                     var8.printStackTrace();
                 }
        	}
            return retorno;	
	}

}
