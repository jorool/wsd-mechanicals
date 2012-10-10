package org.wsd.mechanicals.app.seguranca.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wsd.mechanicals.app.seguranca.QUsuario;
import org.wsd.mechanicals.app.seguranca.Usuario;
import org.wsd.mechanicals.app.seguranca.repository.UsuarioRepository;

@Service
public class WSDUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findOne(QUsuario.usuario.login.eq(username));
		if (usuario != null) {
			usuario.getAuthorities();
		}
		return usuario;
	}

}