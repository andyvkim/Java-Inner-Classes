package Kim.Andy.InnerClassesLab;

import java.io.Closeable;

/**
 * Created by andykim on 2/2/17.
 */
public interface Connection extends Closeable{

    String getipAddress();

    String getPort();

    String getProtocol();

    String connect();

    void close();


}
