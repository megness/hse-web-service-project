package soa.logging.ws;

/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 06.01.12
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;

//Service Endpoint Interface
@WebService
public interface Logging {
    @WebMethod public void Log(String ServiceName, String Tag, int Severity, String Message);
    @WebMethod public String[] getMessagesSN(String ServiceName, int minSeverity, int maxSeverity);
    @WebMethod public String[] getMessagesSNT(String ServiceName, String Tag, int minSeverity, int maxSeverity);
}
