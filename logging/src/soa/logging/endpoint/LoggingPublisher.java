package soa.logging.endpoint;

/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 06.01.12
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
import soa.logging.ws.LoggingImpl;
import javax.xml.ws.Endpoint;

//Endpoint publisher
public class LoggingPublisher {
    public static void main(String[] args) {
             Endpoint.publish("http://localhost:8080/ws/logging", new LoggingImpl());
        }
}