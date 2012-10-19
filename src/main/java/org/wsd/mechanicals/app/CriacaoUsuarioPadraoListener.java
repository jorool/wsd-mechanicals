package org.wsd.mechanicals.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wsd.mechanicals.app.seguranca.PerfilUsuario;
import org.wsd.mechanicals.app.seguranca.Permissao;
import org.wsd.mechanicals.app.seguranca.Usuario;
import org.wsd.mechanicals.app.seguranca.repository.PerfilUsuarioRepository;
import org.wsd.mechanicals.app.seguranca.repository.UsuarioRepository;

@Component
public class CriacaoUsuarioPadraoListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		PerfilUsuario perfilPadraoSalvo = null;
		if (perfilUsuarioRepository.findAll().isEmpty()) {
			PerfilUsuario perfilPadrao = PerfilUsuario.newPerfilUsuario("Admin");
			perfilPadrao.addPermissao(Permissao.ROLE_ADMIN);
			perfilPadraoSalvo = perfilUsuarioRepository.save(perfilPadrao);
		}
		if (usuarioRepository.findAll().isEmpty()) {
			Usuario usuarioPadrao = Usuario.newUsuario("admin");
			usuarioPadrao.setSenha("admin");
			usuarioPadrao.addPerfil(perfilPadraoSalvo);
			usuarioRepository.save(usuarioPadrao);
		}
	}
}
