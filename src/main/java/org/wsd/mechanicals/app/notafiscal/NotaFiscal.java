package org.wsd.mechanicals.app.notafiscal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.wsd.mechanicals.app.pedido.Faturamento;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.pedido.PedidoObserver;
import org.wsd.mechanicals.app.pessoa.Pessoa;
import org.wsd.mechanicals.app.service.WebServiceReceita;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

@Entity
public class NotaFiscal implements Serializable, PedidoObserver {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	Integer version;
	
	@NotNull
	private Integer numero;

	@OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
	private List<NotaFiscalItem> itens = Lists.newLinkedList();

	@ManyToOne()
	private Pessoa cliente;
	
	NotaFiscal() {
	}

	private NotaFiscal(Integer numero) {
		this.numero = numero;
	}

	public static NotaFiscal newNotaFiscal(Integer numero) {
		checkNotNull(numero);
		checkArgument(numero > 0);
		return new NotaFiscal(numero);
	}

	public static NotaFiscal newNotaFiscal(Pedido pedido) {
		return new NotaFiscal(pedido.getNumero());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NotaFiscal) {
			NotaFiscal other = (NotaFiscal) obj;
			return Objects.equal(this.numero, other.numero);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.numero);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("numero", numero).toString();
	}

	public NotaFiscal addItem(NotaFiscalItem item) {
		checkNotNull(item, "Item não pode ser nulo.");
		if (!itens.contains(item)) {
			itens.add(item);
		}
		return this;
	}

	public NotaFiscal removeItem(NotaFiscalItem item) {
		checkNotNull(item, "Item não pode ser nulo.");
		if (itens.contains(item)) {
			itens.remove(item);
		}
		return this;
	}

	public void enviar(WebServiceReceita webServiceReceita) {
		// codigo encapsulado
		// Tell, don't ask

		// Mande, não pergunte
	}

	@Override
	public void faturado(Faturamento faturamento) {
		System.out.println("Nota Fiscal Faturada");
	}

	public Long getId() {
		return id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<NotaFiscalItem> getItens() {
		return ImmutableList.copyOf(itens);
	}

}