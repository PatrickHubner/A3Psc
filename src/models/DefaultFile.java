package models;

import java.io.File;

public abstract class DefaultFile {
	// CONSTANTES DE NOME E DIRET�RIO DO ARQUIVO
    protected static final String DIR_ARQ = "C:/Users/W10/Downloads/eventos";

    public DefaultFile() {
        File dir = new File(DIR_ARQ);
        /* SE O DIRET�RIO N�O EXISTIR, CRIA ELE */
        if (!dir.exists()) {
            dir.mkdir();
        }

    }
 
}
