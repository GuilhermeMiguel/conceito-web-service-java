package br.com.empresa.app;

import java.net.URL;

import br.com.empresa.calculadora.ws.services.CalculadoraServer;
import br.com.empresa.calculadora.ws.services.CalculadoraServerServiceSoapBindingStub;

public class ConsumirdorCalculadora {

	public static void main(String[] args) {
		try {
			CalculadoraServer calc = new CalculadoraServerServiceSoapBindingStub(new URL("http://localhost:8090/calculadoraws-web/CalculadoraServer"), null);
			double divisao = calc.divisao(10.0, 5.0);
			System.out.println("Divisão:" + divisao);
		} catch (Exception ex) {
			System.out.println("Erro:" + ex.getMessage());
		}
	}

}
