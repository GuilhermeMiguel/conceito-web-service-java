/**
 * CalculadoraServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.empresa.calculadora.ws.services;

public interface CalculadoraServer extends java.rmi.Remote {
    public double divisao(double arg0, double arg1) throws java.rmi.RemoteException;
    public double soma(double arg0, double arg1) throws java.rmi.RemoteException;
    public double multiplicacao(double arg0, double arg1) throws java.rmi.RemoteException;
    public double subtracao(double arg0, double arg1) throws java.rmi.RemoteException;
}
