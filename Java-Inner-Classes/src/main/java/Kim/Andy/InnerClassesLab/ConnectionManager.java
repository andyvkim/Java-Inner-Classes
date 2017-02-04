package Kim.Andy.InnerClassesLab;



import java.util.ArrayList;

/**
 * Created by andykim on 2/2/17.
 */
public class ConnectionManager {

    final int maxNumberOfConnections = 3;

    public ArrayList<Connection> connections = new ArrayList<Connection>();


    public Connection getConnectionFromStringString(String ipAddress, String port) {

            if (connections.size() < maxNumberOfConnections){
                Connection newManagedConnection = new ManagedConnection(ipAddress,"HTTP", port);
                connections.add(newManagedConnection);
                return newManagedConnection;

        }
            else System.out.println("Connections full. Error");
            return null;

    }

    public Connection getConnectionFromThreeStrings(String ipAddress, String port, String protocol) {
        if (connections.size() <  maxNumberOfConnections){
            ManagedConnection newManagedConnection = new ManagedConnection(ipAddress, protocol, port);
            connections.add(newManagedConnection);
            return newManagedConnection;
        }
        else System.out.println("Connections full. Error");
         return null;
    }


    private class ManagedConnection implements Connection {

        String ipAddress;

        String protocol;

        String port;

        String status;

        public ManagedConnection(String ipAddress, String protocol, String port) {
            this.ipAddress = ipAddress;
            this.protocol = protocol;
            this.port = port;
            this.status = "open";
        }
        public ManagedConnection(){
            this.ipAddress = "nope";
            this.protocol =  "nope";
            this.port = "nope";
            this.status = "closed";

        }

        public void close() {
            if(this.status == "closed"){
                this.status = "closed";
            }


        }

        public String connect() {

               return "Connected to " + this.getipAddress() + " via " + this.getProtocol();

        }


        public String getipAddress() {
            return this.ipAddress;
        }

        public String getPort() {
            return this.port;
        }

        public String getProtocol() {
            return this.protocol;
        }


    }

}

