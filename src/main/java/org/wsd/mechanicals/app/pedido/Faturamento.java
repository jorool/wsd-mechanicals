package org.wsd.mechanicals.app.pedido;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.quantidade.Quantidade;

import com.google.common.base.Objects;

@Entity
public class Faturamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;

	private DateTime data = new DateTime(DateTimeUtils.currentTimeMillis());

	private Quantidade quantidade;

	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "pedido_fk")
	private Pedido pedido;

	Faturamento() {
	}

	private Faturamento(Pedido pedido) {
		this.pedido = pedido;
	}

	public static Faturamento newFaturamento(Pedido pedido) {
		checkNotNull(pedido, "Pedido não pode ser nulo.");
		return new Faturamento(pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Faturamento) {
			Faturamento other = (Faturamento) obj;
			return Objects.equal(this.data, other.data) && Objects.equal(this.pedido, other.pedido);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.data, this.pedido);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("data", data).add("pedido", pedido).toString();
	}

	public Long getId() {
		return id;
	}

	public DateTime getData() {
		return data;
	}

	public Quantidade getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Quantidade quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

}