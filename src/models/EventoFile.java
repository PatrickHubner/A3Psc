package models;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import databases.EventoDB;

public class EventoFile extends DefaultFile {
    protected static final String NOME_ARQ = "Eventos.csv";
	private EventoDB db = EventoDB.getInstance();
	
	public EventoFile() {
        super();
    }

	public String converteEventoPraCsv(Evento evt) {
		return evt.getId() + ";" +  evt.getNome() + ";" + evt.getEndereco() + ";" + evt.getCategoria()  + ";"  +  evt.getHorario()  + ";" + evt.listarParticipantes() + ";\n";
		
	}
	
	public void formatarDados(ArrayList<String> participantes, ArrayList<Integer> horario, String[] campos) {
		if (campos[5].length() > 0) {
			String temp = campos[5].replace("[", ",").replace("]", ",");
			String[] lista = temp.split(",");
	    	for (int i = 1; i < lista.length; i ++) {
	    		System.out.println(lista[i]);
	    		participantes.add(lista[i]);
	    	}
		}
    	int hora = Integer.parseInt(campos[4].split("")[1] + campos[4].split("")[2]);
    	int minuto = Integer.parseInt(campos[4].split("")[5] + campos[4].split("")[6]);
    	int segundo = Integer.parseInt(campos[4].split("")[9] + campos[4].split("")[10]);
    	horario.add(hora);
    	horario.add(minuto);
    	horario.add(segundo);
	}

    public Evento converteCSVPraEvento(String linha){
    	String[] campos = linha.split(";");
        /* CRIA O FUNCIONARIO COM BASE NA LINHA LIDA PELO ARQUIVO */
    	ArrayList<String> participantes = new ArrayList<String> ();
    	ArrayList<Integer> horario = new ArrayList<Integer> ();
    	formatarDados(participantes, horario, campos);
    	System.out.println("CSV PRA EVENTO");
        Evento f = new Evento(
                Integer.parseInt(campos[0]),
                campos[1],
                campos[2],
                campos[3],
                horario,
        		participantes);
        return f;
    };

    public void salvarEventos(List<Evento> lista) {
    	File arquivo = new File(DIR_ARQ + "/" + NOME_ARQ);
        /* TENTA GRAVAR NOVO ARQUIVO, SE DER RUIM LANÇA UM ERRO DE IO*/
        try {
            //boolean newFile = arquivo.createNewFile();
            FileOutputStream fos = new FileOutputStream(arquivo);

            for(int i = 0; i < lista.size(); ++i) {
                //CONVERTE PRA CSV E TRANSFORMA O CONTEÚDO PRA BYTES
                fos.write(this.converteEventoPraCsv(lista.get(i)).getBytes());
            }
            /* DESCARREGA NO ARQUIVO E FECHA O ARQUIVO */
            fos.flush();
            fos.close();
        } catch (IOException var6) {
            //LOGA O ERRO DE ACESSO A DISCO
            var6.printStackTrace();
        }
		
	}

	public ArrayList carregarEventos(EventoDB db) {
		/*TENTA ACHAR O ARQUIVO NO PATHNAME ENVIADO*/
        File arquivo = new File(DIR_ARQ+"/"+NOME_ARQ);
        ArrayList retorno = new ArrayList<>();
        if (arquivo.exists()) {
        	 try {
                 /*TENTA LER O ARQUIVO ENCONTRADO*/
                 Scanner fileScanner = new Scanner(arquivo);
                 /*
                 *ENQUANTO O ARQUIVO TIVER MAIS UMA LINHA DE CONTEÚDO,
                 *ELE FAZ A CONVERSÃO DISSO PRA LISTA FUNCIONARIO
                 */
                 while(fileScanner.hasNextLine()) {
                     String linha = fileScanner.nextLine();
                     /*CHAMA A CONVERSÃO, ADICIONANDO O FUNCIONARIO CRIADO DIRETO NO ARQUIVO*/
                     Evento e = converteCSVPraEvento(linha);
                     retorno.add(e);
                     System.out.println(retorno);
                     db.setIdAtual(e.getId());
                 }

                 fileScanner.close(); //FECHA O SCANNER
                 } catch (FileNotFoundException var8) {
                     // PRINTA O ERRO DE ARQUIVO NÃO ENCONTRADO
                     var8.printStackTrace();
                 }
        	}
            return retorno;	
	}

}
