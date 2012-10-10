package org.wsd.mechanicals.app.pedido.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.pedido.QPedido;
import org.wsd.mechanicals.config.root.WSDConfig;

@ActiveProfiles("teste")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WSDConfig.class)
@TransactionConfiguration
public class PedidoRepositoryIT {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Transactional
	@Test
	public void save() {
		Pedido pedido = Pedido.newPedido(123);
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		assertNotNull(pedidoSalvo.getId());
		assertNotNull(pedidoRepository.findOne(pedidoSalvo.getId()));
		assertEquals(pedidoSalvo, pedidoRepository.findByNumero(123).get(0));
		assertEquals(pedidoSalvo, pedidoRepository.findOne(QPedido.pedido.numero.eq(123)));
	}

}
