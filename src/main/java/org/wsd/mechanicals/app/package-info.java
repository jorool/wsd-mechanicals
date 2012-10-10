@TypeDefs({
		@TypeDef(name = "dateTime", typeClass = DateTimeUserType.class, defaultForType = DateTime.class),
		@TypeDef(name = "estadoPedido", typeClass = EstadoPedidoUserType.class, defaultForType = EstadoPedido.class),
		@TypeDef(name = "percentual", typeClass = PercentualUserType.class, defaultForType = Percentual.class),
		@TypeDef(name = "quantidade", typeClass = QuantidadeUserType.class, defaultForType = Quantidade.class)
})
package org.wsd.mechanicals.app;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;
import org.wsd.mechanicals.app.pedido.EstadoPedido;
import org.wsd.mechanicals.app.pedido.EstadoPedidoUserType;
import org.wsd.mechanicals.app.quantidade.Percentual;
import org.wsd.mechanicals.app.quantidade.PercentualUserType;
import org.wsd.mechanicals.app.quantidade.Quantidade;
import org.wsd.mechanicals.app.quantidade.QuantidadeUserType;
import org.wsd.mechanicals.app.usertype.DateTimeUserType;


