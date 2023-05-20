package br.com.alura.escola.shared.evento;

public abstract class Ouvinte {
	
	public void processa(Evento evento) {
		if(deveProcessar(evento)) {
			reageAo(evento);
		}
	}

	protected abstract void reageAo(Evento evento);

	protected abstract boolean deveProcessar(Evento evento);

}
