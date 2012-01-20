package soa.logging.client;/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 09.01.12
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */

import soa.logging.ws.server.*;

import java.util.List;

public class LoggingWSClient {
  public static void main(String[] argv) {
      LoggingImplService service = new LoggingImplService();
      Logging port = service.getPort(Logging.class);

      port.log("SN1", "T2", 1, "M1");
      port.log("SN2", "T2", 2, "M2");
      port.log("SN3", "T3", 3, "M3");
      port.log("SN1", "T4", 4, "M4");
      port.log("SN5", "T5", 5, "M5");
      port.log("SN6", "T6", 6, "M6");
      port.log("SN1", "T2", 7, "M7");
      port.log("SN8", "T8", 8, "M8");
      port.log("SN9", "T9", 9, "M9");
      port.log("SN1", "T10", 10, "M10");

      List<String> res = port.getMessagesSN("SN1", 1, 7);
      for(String s : res)
          System.out.println(s);

      System.out.println();

      res = port.getMessagesSNT("SN1", "T2", 1, 7);
      for(String s : res)
          System.out.println(s);
  }
}