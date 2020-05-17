import org.apache.xmlrpc.WebServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration

@EnableAutoConfiguration
public class Server {

    @Bean(name = "/chat")
    RemoteExporter chatService() {
        WebServer server = new WebServer(8884);
        ChatServiceServerImpl test = new ChatServiceServerImpl();
        server.addHandler("XMLRPCServer", test);
        System.out.println("Attempting to start XML-RPC Server...");
        server.start();

        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(test);
        exporter.setServiceInterface( ChatServiceServer.class );
        return exporter;
    }


    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}