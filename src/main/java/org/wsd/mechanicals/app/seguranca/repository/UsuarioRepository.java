package org.wsd.mechanicals.app.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wsd.mechanicals.app.repository.ListQueryDslPredicateExecutor;
import org.wsd.mechanicals.app.seguranca.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, ListQueryDslPredicateExecutor<Usuario> {

}