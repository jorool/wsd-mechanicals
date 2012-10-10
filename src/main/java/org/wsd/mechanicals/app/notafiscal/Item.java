package org.wsd.mechanicals.app.notafiscal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.wsd.mechanicals.app.produto.Produto;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	@ManyToOne
	@JoinColumn(name = "nota_fiscal_fk")
	private NotaFiscal notaFiscal;

	private Produto produto;

	private Integer quantidade;

	Item() {
	}

	public static Item newItem() {
		return new Item();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
}