package org.wsd.mechanicals.app.notafiscal;

import java.io.Serializable;

import org.wsd.mechanicals.app.produto.Produto;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

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

}