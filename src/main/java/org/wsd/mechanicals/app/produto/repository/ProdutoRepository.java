package org.wsd.mechanicals.app.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ListQueryDslPredicateExecutor<Produto> {

}
