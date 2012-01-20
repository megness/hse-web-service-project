package soa.logging.client;

/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 06.01.12
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import soa.logging.ws.Logging;

public class LoggingClient
{
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/ws/logging?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws.logging.soa/", "LoggingImplService");
        Service service = Service.create(url, qname);
        Logging log = service.getPort(Logging.class);

        log.Log("SN1","T2", 1, "M1");
        log.Log("SN2","T2", 2, "M2");
        log.Log("SN3","T3", 3, "M3");
        log.Log("SN1","T4", 4, "M4");
        log.Log("SN5","T5", 5, "M5");
        log.Log("SN6","T6", 6, "M6");
        log.Log("SN1","T2", 7, "M7");
        log.Log("SN8","T8", 8, "M8");
        log.Log("SN9","T9", 9, "M9");
        log.Log("SN1","T10", 10, "M10");

        String[] res = log.getMessagesSN("SN1", 1, 7);
        for(String s : res)
            System.out.println(s);

        System.out.println();

        res = log.getMessagesSNT("SN1", "T2", 1, 7);
        for(String s : res)
            System.out.println(s);

        
    }

}

