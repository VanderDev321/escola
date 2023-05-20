package br.com.alura.escola.shared.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {
	
	LocalDateTime momento();
	TipoEvento tipo();
	Map<String, Object> informacoes();

}
