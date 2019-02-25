package com.weitongming.zk;

import java.util.List;

/**
 * @author tim.wei
 * @description
 * @date Created on 2019/2/19.
 */
public class ReadZKRecursion {



    public static void main(String[] args) {
        MyZkClient zkClient = new MyZkClient("192.168.1.34:9090") ;
        String path = "/biz/t8t-sys-acc/app/config" ;

        recursion(path ,zkClient);
    }




    public static  void recursion(String path ,MyZkClient zkClient){
        List<String> chidren =  zkClient.getChildren(path) ;
        if (chidren == null || chidren.size() == 0){
            String value = zkClient.readData(path);
            System.out.println(path + "=" + value);
        }
        else chidren.forEach(current ->{
            recursion(path + "/" + current,zkClient);
        });
    }

}
