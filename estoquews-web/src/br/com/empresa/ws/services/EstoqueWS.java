package br.com.empresa.ws.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.empresa.estoque.ws.modelo.item.Filtro;
import br.com.empresa.estoque.ws.modelo.item.Filtros;
import br.com.empresa.estoque.ws.modelo.item.Item;
import br.com.empresa.estoque.ws.modelo.item.ItemDao;
import br.com.empresa.estoque.ws.modelo.item.ItemValidador;
import br.com.empresa.estoque.ws.modelo.item.ListaItens;
import br.com.empresa.estoque.ws.modelo.usuario.AutorizacaoException;
import br.com.empresa.estoque.ws.modelo.usuario.TokenDao;
import br.com.empresa.estoque.ws.modelo.usuario.TokenUsuario;



@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public class EstoqueWS { //RPC

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "item")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}

	@WebMethod(action="CadastrarItem",operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizacaoException {

		System.out.println("Cadastrando " + item + ", " + token);

		boolean valido = new TokenDao().ehValido(token);

		if (!valido) {
			throw new AutorizacaoException("Token invalido");
		}

		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		
		return item;
	}
}