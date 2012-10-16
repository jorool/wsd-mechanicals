package org.wsd.mechanicals.app.seguranca;

import org.springframework.security.core.GrantedAuthority;


public enum Permissao implements GrantedAuthority {

	ROLE_USER,

	ROLE_ADMIN,
	
	ROLE_EDITAR_PEDIDO;

	@Override
	public String getAuthority() {
		return name();
	}

}