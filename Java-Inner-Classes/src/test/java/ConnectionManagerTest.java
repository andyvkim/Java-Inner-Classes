import Kim.Andy.InnerClassesLab.ConnectionManager;
import Kim.Andy.InnerClassesLab.Connection;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ConnectionManagerTest {



    ArrayList<Connection> connectionArrayListforTesting = new ArrayList<Connection>();

    String ipAddress = "99.9.99.99.9";
    String port = "8000";
    String protocol = "HTTP";
    ConnectionManager connectionManager;

    @Before
    public void setUp(){
        connectionManager = new ConnectionManager();

    }


    @Test
    public void getConnectionFromStringStringTest(){
        connectionManager.getConnectionFromStringString(ipAddress, port);
        connectionManager.getConnectionFromStringString(ipAddress, port);
        connectionManager.getConnectionFromStringString(ipAddress, port);

        int expected = 3;
        int actual = connectionManager.connections.size();
        Assert.assertEquals("I expect this to pass because my array size should increase to 1",actual, expected);

    }
    @Test
    public void getConnectionFromStringStringStringTest(){
        connectionManager.getConnectionFromThreeStrings(ipAddress,port,protocol);
        int expected = 1;
        int actual = connectionManager.connections.size();
        Assert.assertEquals("I expect this to pass because my array size should increased to 1",actual, expected);
    }
    @Test
    public void tooManyConnectionsTest(){
        connectionManager.getConnectionFromThreeStrings(ipAddress, port, protocol);
        connectionManager.getConnectionFromStringString(ipAddress, port);
        connectionManager.getConnectionFromStringString(ipAddress, port);
        connectionManager.getConnectionFromStringString(ipAddress, port);
        int expected = 3;
        int actual = connectionManager.connections.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getIpTest(){
        Connection TestConnection = connectionManager.getConnectionFromStringString(ipAddress,port);
        Assert.assertEquals("I expect this to pass because getipAddress gets the ipAddress",ipAddress, TestConnection.getipAddress());

    }
    @Test
    public void getPortTest(){
        Connection TestConnection = connectionManager.getConnectionFromStringString(ipAddress, port);
        Assert.assertEquals("I expect this to pass because getPort gets the port information",port, TestConnection .getPort());
    }
    @Test
    public void getProtocolTest(){
        Connection TestConnection = connectionManager.getConnectionFromThreeStrings(ipAddress, port, protocol);
        Assert.assertEquals("I expect this to pass because I'm getting the protocol with the getProtocol method",protocol, TestConnection.getProtocol());
    }

    @Test
    public void connectTest(){
        Connection TestConnection = connectionManager.getConnectionFromStringString(ipAddress,port);
        String expected = "Connected to 99.9.99.99.9 via HTTP";
        String actual = TestConnection.connect();
        Assert.assertEquals("I expect this to pass because the statement should come out correctly",expected,actual);
    }






}
