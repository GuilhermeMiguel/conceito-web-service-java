package br.com.empresa.calculadora.ws.services;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;



@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public class CalculadoraServer {
	
	@WebResult
	public double soma(double num1, double num2) {
		return num1 + num2;
	}
	
	@WebResult
	public double subtracao(double num1, double num2) {
		return num1 - num2;
	}

	@WebResult
	public double multiplicacao(double num1, double num2) {
		return num1 * num2;
	}

	@WebResult
	public double divisao(double num1, double num2) {
		return num1 / num2;
	}
}
