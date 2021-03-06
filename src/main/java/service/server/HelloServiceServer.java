package service.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import service.demo.Hello;
import service.demo.HelloServiceImpl;

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(10086);
            // 设置协议工厂为 TBinaryProtocol.Factory
            Factory proFactory = new TBinaryProtocol.Factory(true, true);
            // 关联处理器与 Hello 服务的实现
            Hello.Processor<Hello.Iface> processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());

            // TThreadPoolServer.Args targs = new
            // TThreadPoolServer.Args(serverTransport);
            // targs.processor(processor);
            // targs.protocolFactory(factory)
            // TServer server = new TThreadPoolServer(targs);

            Args arg = new Args(serverTransport);
            arg.processor(processor);
            arg.protocolFactory(proFactory);
            TServer server = new TThreadPoolServer(arg);

            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
