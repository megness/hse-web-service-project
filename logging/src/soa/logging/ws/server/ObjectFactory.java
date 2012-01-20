
package soa.logging.ws.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soa.logging.ws.server package. 
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

    private final static QName _GetMessagesSNResponse_QNAME = new QName("http://ws.logging.soa/", "getMessagesSNResponse");
    private final static QName _GetMessagesSNT_QNAME = new QName("http://ws.logging.soa/", "getMessagesSNT");
    private final static QName _LogResponse_QNAME = new QName("http://ws.logging.soa/", "LogResponse");
    private final static QName _Log_QNAME = new QName("http://ws.logging.soa/", "Log");
    private final static QName _GetMessagesSN_QNAME = new QName("http://ws.logging.soa/", "getMessagesSN");
    private final static QName _GetMessagesSNTResponse_QNAME = new QName("http://ws.logging.soa/", "getMessagesSNTResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soa.logging.ws.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMessagesSNResponse }
     * 
     */
    public GetMessagesSNResponse createGetMessagesSNResponse() {
        return new GetMessagesSNResponse();
    }

    /**
     * Create an instance of {@link LogResponse }
     * 
     */
    public LogResponse createLogResponse() {
        return new LogResponse();
    }

    /**
     * Create an instance of {@link Log }
     * 
     */
    public Log createLog() {
        return new Log();
    }

    /**
     * Create an instance of {@link GetMessagesSN }
     * 
     */
    public GetMessagesSN createGetMessagesSN() {
        return new GetMessagesSN();
    }

    /**
     * Create an instance of {@link GetMessagesSNT }
     * 
     */
    public GetMessagesSNT createGetMessagesSNT() {
        return new GetMessagesSNT();
    }

    /**
     * Create an instance of {@link GetMessagesSNTResponse }
     * 
     */
    public GetMessagesSNTResponse createGetMessagesSNTResponse() {
        return new GetMessagesSNTResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesSNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "getMessagesSNResponse")
    public JAXBElement<GetMessagesSNResponse> createGetMessagesSNResponse(GetMessagesSNResponse value) {
        return new JAXBElement<GetMessagesSNResponse>(_GetMessagesSNResponse_QNAME, GetMessagesSNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesSNT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "getMessagesSNT")
    public JAXBElement<GetMessagesSNT> createGetMessagesSNT(GetMessagesSNT value) {
        return new JAXBElement<GetMessagesSNT>(_GetMessagesSNT_QNAME, GetMessagesSNT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "LogResponse")
    public JAXBElement<LogResponse> createLogResponse(LogResponse value) {
        return new JAXBElement<LogResponse>(_LogResponse_QNAME, LogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Log }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "Log")
    public JAXBElement<Log> createLog(Log value) {
        return new JAXBElement<Log>(_Log_QNAME, Log.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesSN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "getMessagesSN")
    public JAXBElement<GetMessagesSN> createGetMessagesSN(GetMessagesSN value) {
        return new JAXBElement<GetMessagesSN>(_GetMessagesSN_QNAME, GetMessagesSN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesSNTResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.logging.soa/", name = "getMessagesSNTResponse")
    public JAXBElement<GetMessagesSNTResponse> createGetMessagesSNTResponse(GetMessagesSNTResponse value) {
        return new JAXBElement<GetMessagesSNTResponse>(_GetMessagesSNTResponse_QNAME, GetMessagesSNTResponse.class, null, value);
    }

}
