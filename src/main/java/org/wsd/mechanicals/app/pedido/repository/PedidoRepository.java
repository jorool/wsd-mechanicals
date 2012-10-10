package org.wsd.mechanicals.app.pedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, ListQueryDslPredicateExecutor<Pedido> {

	public List<Pedido> findByNumero(Integer numero);

}