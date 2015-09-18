package com.technia.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;

@WebService(serviceName="PersonService", targetNamespace="http://www.technia.com/personservice")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
public class PersonServiceEndpoint {

	@WebMethod(operationName="GetPersons",action="GetPersonsAction")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
	@WebResult(name="String")
	public String getPersons() {
		System.out.println("NAKKI!");
		return "person";
	}
}
