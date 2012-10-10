package org.wsd.mechanicals.app.produto.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.produto.repository.ProdutoRepository;

@Configurable
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Long id = Long.valueOf(value);
		return produtoRepository.findOne(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Produto produto = (Produto) value;
		return produto.getId().toString();
	}

}
