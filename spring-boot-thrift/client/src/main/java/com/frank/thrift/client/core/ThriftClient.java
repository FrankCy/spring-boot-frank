package com.frank.thrift.client.core;

import com.frank.thrift.api.shriftcode.StudentService;
import lombok.Setter;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 *
 * @author cy
 * @version ThriftClient.java, v 0.1 2020年12月04日 10:50 上午 cy Exp $
 */
public class ThriftClient {

    @Setter
    private String host;

    @Setter
    private Integer port;

    private TTransport tTransport;

    private TProtocol tProtocol;

    private StudentService.Client client;

    private void init() {
        tTransport = new TFramedTransport(new TSocket(host, port), 600);
        //协议对象 这里使用协议对象需要和服务器的一致
        tProtocol = new TCompactProtocol(tTransport);
        client = new StudentService.Client(tProtocol);
    }

    public StudentService.Client getService() {
        return client;
    }

    public void open() throws TTransportException {
        if (null != tTransport && !tTransport.isOpen()) {
            tTransport.open();
        }
    }

    public void close() {
        if (null != tTransport && tTransport.isOpen()) {
            tTransport.close();
        }
    }
}
