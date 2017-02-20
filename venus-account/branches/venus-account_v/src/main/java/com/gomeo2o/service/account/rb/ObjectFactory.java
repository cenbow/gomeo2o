
package com.gomeo2o.service.account.rb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gomeo2o.service.account.rb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcceptBalanceTask_QNAME = new QName("http://webservice.rb.gome.founder.com/", "acceptBalanceTask");
    private final static QName _AcceptBalanceTaskResponse_QNAME = new QName("http://webservice.rb.gome.founder.com/", "acceptBalanceTaskResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gomeo2o.service.account.rb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcceptBalanceTaskResponse }
     * 
     */
    public AcceptBalanceTaskResponse createAcceptBalanceTaskResponse() {
        return new AcceptBalanceTaskResponse();
    }

    /**
     * Create an instance of {@link RefundBalanceTask }
     * 
     */
    public RefundBalanceTask createRefundBalanceTask() {
        return new RefundBalanceTask();
    }

    /**
     * Create an instance of {@link RefundTaskReply }
     * 
     */
    public RefundTaskReply createRefundTaskReply() {
        return new RefundTaskReply();
    }

    /**
     * Create an instance of {@link AcceptBalanceTask_Type }
     * 
     */
    public AcceptBalanceTask_Type createAcceptBalanceTask_Type() {
        return new AcceptBalanceTask_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptBalanceTask_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.rb.gome.founder.com/", name = "acceptBalanceTask")
    public JAXBElement<AcceptBalanceTask_Type> createAcceptBalanceTask(AcceptBalanceTask_Type value) {
        return new JAXBElement<AcceptBalanceTask_Type>(_AcceptBalanceTask_QNAME, AcceptBalanceTask_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptBalanceTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.rb.gome.founder.com/", name = "acceptBalanceTaskResponse")
    public JAXBElement<AcceptBalanceTaskResponse> createAcceptBalanceTaskResponse(AcceptBalanceTaskResponse value) {
        return new JAXBElement<AcceptBalanceTaskResponse>(_AcceptBalanceTaskResponse_QNAME, AcceptBalanceTaskResponse.class, null, value);
    }

}
