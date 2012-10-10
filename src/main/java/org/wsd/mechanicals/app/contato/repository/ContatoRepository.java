package org.wsd.mechanicals.app.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsd.mechanicals.app.contato.Contato;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface ContatoRepository extends JpaRepository<Contato, String>, ListQueryDslPredicateExecutor<Contato> {

}
