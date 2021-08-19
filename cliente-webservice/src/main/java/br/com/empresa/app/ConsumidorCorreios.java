package br.com.empresa.app;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWSSoap;
import org.tempuri.CalcPrecoPrazoWSSoapStub;

public class ConsumidorCorreios {

	public static void main(String[] args) {
		
/*
  		Link dos metodos
  		http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx
  		
  		Link para importar nos projetos clientes
  		http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?wsdl
*/
		
		var resultado = calcPrazo("40010", "08141620", "08110750");
		
		if(resultado != null) {
			List<CServico> listaResultados = new ArrayList<>(Arrays.asList(resultado.getServicos()));
			
			System.out.println("=============================================\n"
					+ "REALIZANDO CÁLCULO\n"
					+ "=============================================");
			
			
			listaResultados.forEach(x -> {
				if(x.getPrazoEntrega() != null && !x.getPrazoEntrega().isEmpty()) {				
					System.out.println("Prazo de Entrega: " + x.getPrazoEntrega());
					System.out.println("Entrega Domiciliar: " + (x.getEntregaDomiciliar().equalsIgnoreCase("S") ? "Sim" : "Não"));
					System.out.println("Entrega no Sábado: " + (x.getEntregaSabado().equalsIgnoreCase("S") ? "Sim" : "Não"));
					System.out.println("Observação: " + x.getObsFim());
				}else {
					System.out.println("Ocorreu um erro: " + x.getMsgErro());
				}
			});
		}
		
	}
	
	private static CResultado calcPrazo(String codigoServico, String cepOrigem, String cepDestino) {

		try {
			CalcPrecoPrazoWSSoap calcPreco = new CalcPrecoPrazoWSSoapStub(
					new URL("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx"), null);
//					null, null);
			return calcPreco.calcPrazo(codigoServico, cepOrigem, cepDestino);
		} catch (Exception ex) {
			return null;
		}
	}
	
}
