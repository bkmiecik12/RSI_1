import org.apache.xmlrpc.WebServer;

public class SerwerRPC {

    public static void main(String[] args) {
        try{
            System.out.println("Startuje serwer XML-RPC...");
            int port = 10005;
            WebServer server = new WebServer(port);

            server.addHandler("mojserver", new SerwerRPC());
            server.start();
            System.out.println("Serwer wystartował pomyślnie.");
            System.out.println("Nasłuchuje na porcie " + port);
            System.out.println("Aby zatrzymać serwer naciśnij Ctrl+c");
        }
        catch (Exception exception){
            System.err.println("Serwer XML-RPC: " + exception);
        }
    }

    public Integer echo(int x, int y){
        return new Integer(x+y);
    }

    public Integer asy(int x){
        System.out.println("Wywołano asy - odliczam...");
        try{
            Thread.sleep(x);
        } catch(InterruptedException ex){
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("asy - koniec odliczania");
        return 123;
    }
}

