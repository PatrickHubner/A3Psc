package app;

import java.util.Locale;

import models.SistemaDeEventos;

public class main {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		SistemaDeEventos sde = new SistemaDeEventos();
		sde.run();
	}
}
