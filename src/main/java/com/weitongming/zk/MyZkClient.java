package com.weitongming.zk;

import org.I0Itec.zkclient.ZkClient;

public class MyZkClient extends ZkClient
{

    public MyZkClient(String zkHost)
    {
        super(zkHost, 30000, 30000, new StringZkSerializer());
    }
}
