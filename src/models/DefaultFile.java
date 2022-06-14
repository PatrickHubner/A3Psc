package models;

import java.io.File;

public abstract class DefaultFile {
	// CONSTANTES DE NOME E DIRETÓRIO DO ARQUIVO
    protected static final String DIR_ARQ = "C:/Users/W10/Downloads/eventos";

    public DefaultFile() {
        File dir = new File(DIR_ARQ);
        /* SE O DIRETÓRIO NÃO EXISTIR, CRIA ELE */
        if (!dir.exists()) {
            dir.mkdir();
        }

    }
 
}
