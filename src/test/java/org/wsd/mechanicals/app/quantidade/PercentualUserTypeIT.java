package org.wsd.mechanicals.app.quantidade;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.wsd.mechanicals.app.pessoa.Pessoa;
import org.wsd.mechanicals.app.pessoa.PessoaFisica;
import org.wsd.mechanicals.app.pessoa.Vendedor;
import org.wsd.mechanicals.config.root.WSDConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WSDConfig.class)
@TransactionConfiguration
public class PercentualUserTypeIT {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void save() {
		PessoaFisica pessoaFisica = Pessoa.newPessoaFisica("Fulano");
		Vendedor vendedor = Vendedor.newVendedor(pessoaFisica);
		entityManager.persist(pessoaFisica);
		entityManager.persist(vendedor);
		assertEquals(pessoaFisica.getId(), vendedor.getId());
	}

}
