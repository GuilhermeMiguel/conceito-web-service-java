package br.com.empresa.calculadora.ws.services;

public class CalculadoraServerProxy implements br.com.empresa.calculadora.ws.services.CalculadoraServer {
  private String _endpoint = null;
  private br.com.empresa.calculadora.ws.services.CalculadoraServer calculadoraServer = null;
  
  public CalculadoraServerProxy() {
    _initCalculadoraServerProxy();
  }
  
  public CalculadoraServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculadoraServerProxy();
  }
  
  private void _initCalculadoraServerProxy() {
    try {
      calculadoraServer = (new br.com.empresa.calculadora.ws.services.CalculadoraServerServiceLocator()).getCalculadoraServerPort();
      if (calculadoraServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculadoraServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculadoraServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculadoraServer != null)
      ((javax.xml.rpc.Stub)calculadoraServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.empresa.calculadora.ws.services.CalculadoraServer getCalculadoraServer() {
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer;
  }
  
  public double divisao(double arg0, double arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.divisao(arg0, arg1);
  }
  
  public double soma(double arg0, double arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.soma(arg0, arg1);
  }
  
  public double multiplicacao(double arg0, double arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.multiplicacao(arg0, arg1);
  }
  
  public double subtracao(double arg0, double arg1) throws java.rmi.RemoteException{
    if (calculadoraServer == null)
      _initCalculadoraServerProxy();
    return calculadoraServer.subtracao(arg0, arg1);
  }
  
  
}