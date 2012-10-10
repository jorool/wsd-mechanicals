package org.wsd.mechanicals.app.notafiscal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, String>, ListQueryDslPredicateExecutor<NotaFiscal> {

}