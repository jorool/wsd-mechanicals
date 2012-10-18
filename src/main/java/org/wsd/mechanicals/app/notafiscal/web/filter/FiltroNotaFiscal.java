package org.wsd.mechanicals.app.notafiscal.web.filter;

import java.io.Serializable;

import org.joda.time.DateMidnight;

import com.mysema.query.types.Predicate;

public class FiltroNotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numero;

	private DateMidnight dataInicial;

	private DateMidnight dataFinal;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public DateMidnight getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(DateMidnight dataInicial) {
		this.dataInicial = dataInicial;
	}

	public DateMidnight getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(DateMidnight dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Predicate toPredicate() {
		return null;
	}

}