import org.apache.xmlrpc.XmlRpcClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class KlientRPC {

    public static void main(String[] args){
        try{
            XmlRpcClient srv = new XmlRpcClient("http://localhost:10005");

            Vector<Integer> params = new Vector<Integer>();
            params.addElement(new Integer(13));
            params.addElement(new Integer(21));

//            Object result = srv.execute("mojserwer.echo",params);
//
//            System.out.println("Wynik: "+((Integer) result).intValue());

            AC cb = new AC();

            Vector<Integer> params2 = new Vector<Integer>();
            params2.add(new Integer(1000));
            srv.executeAsync("mojserver.asy",params2,cb);
            System.out.println("Wywołano asynchronicznie");
        }
        catch(Exception exception){
            System.err.println("Klient XML-RPC: " + exception);
        }
    }
}
