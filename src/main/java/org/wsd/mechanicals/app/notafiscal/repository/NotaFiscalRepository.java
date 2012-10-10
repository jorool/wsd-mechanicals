package org.wsd.mechanicals.app.notafiscal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface NotaFiscalRepository extends MongoRepository<NotaFiscal, String>, ListQueryDslPredicateExecutor<NotaFiscal> {

}