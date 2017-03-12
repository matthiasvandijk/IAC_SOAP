/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iac_soap.statsq;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 *
 * @author Matthias
 */

@WebService(wsdlLocation = "WEB-INF/wsdl/NormVerdService.wsdl", portName = "WS-Port", targetNamespace = "http://api.hu.fnt.nl/normverd")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public interface NormVerdServiceI {
    @WebMethod(operationName="calculateNormVerd")
    public NormVerdResponse calculateNormVerd( 
            @WebParam(name = "data") List<Double> data) throws MyFault;
}
