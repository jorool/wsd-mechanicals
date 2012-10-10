package org.wsd.mechanicals.app.notafiscal;

public class CodigoReceitaEstadoNotaFiscalVisitor implements EstadoNotaFiscalVisitor<Integer> {

	@Override
	public Integer visit(EstadoNotaFiscalFaturada estadoNotaFiscalFaturada) {
		return 1;
	}

	@Override
	public Integer visit(EstadoNotaFiscalCancelada estadoNotaFiscalCancelada) {
		return 3;
	}

}
