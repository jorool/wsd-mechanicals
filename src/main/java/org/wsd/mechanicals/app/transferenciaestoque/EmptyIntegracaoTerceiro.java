package org.wsd.mechanicals.app.transferenciaestoque;

public class EmptyIntegracaoTerceiro implements IntegracaoTerceiro {

	private EmptyIntegracaoTerceiro() {
	}

	public static EmptyIntegracaoTerceiro newEmptyIntegracaoTerceiro() {
		return new EmptyIntegracaoTerceiro();
	}

	@Override
	public void integrar(TransferenciaEstoque transferenciaEstoque) {
	}

}