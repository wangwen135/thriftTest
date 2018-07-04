package service.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;

public class HelloServiceClient {
    /**
     * 调用 Hello 服务
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置调用的服务地址为本地，端口为 7911
            TTransport transport = new TSocket("localhost", 7911);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);

            Hello.Client client = new Hello.Client(protocol);

            // 调用服务方法
            
            client.helloVoid();
            System.out.println("无返回的方法");

            int rint = client.helloInt(123123);
            System.out.println("返回值：" + rint);

            String rString = client.helloString("asdfsdf");
            System.out.println("返回的字符串是：" + rString);

            // 直接返回null值是有问题的
            // client.helloNull();

            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}