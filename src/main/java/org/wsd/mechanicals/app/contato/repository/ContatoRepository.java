package org.wsd.mechanicals.app.contato.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.wsd.mechanicals.app.contato.Contato;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface ContatoRepository extends MongoRepository<Contato, String>, ListQueryDslPredicateExecutor<Contato> {

}
