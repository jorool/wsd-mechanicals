package org.wsd.mechanicals.config.root;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.wsd.mechanicals.app.contato.Contato;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.seguranca.Usuario;

@EnableJpaRepositories(basePackageClasses = {Usuario.class, Produto.class, Pedido.class, NotaFiscal.class, Contato.class})
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@ImportResource("classpath*:META-INF/spring/applicationContext-data.xml")
public class RepositoryConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory);
	}

}