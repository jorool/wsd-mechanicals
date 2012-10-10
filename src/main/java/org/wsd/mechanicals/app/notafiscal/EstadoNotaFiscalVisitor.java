package org.wsd.mechanicals.app.notafiscal;

interface EstadoNotaFiscalVisitor<T> {

	public T visit(EstadoNotaFiscalFaturada estadoNotaFiscalFaturada);

	public T visit(EstadoNotaFiscalCancelada estadoNotaFiscalCancelada);

}