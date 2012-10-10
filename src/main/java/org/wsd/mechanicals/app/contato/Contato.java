package org.wsd.mechanicals.app.contato;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import com.google.common.base.Strings;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;
	
	private String nome;

	private Contato() {
	}

	@PersistenceConstructor
	private Contato(String nome) {
		this.nome = nome;
	}

	public static Contato newContato() {
		return new Contato();
	}

	public static Contato newContato(String nome) {
		checkArgument(!Strings.isNullOrEmpty(nome));
		return new Contato(nome);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}