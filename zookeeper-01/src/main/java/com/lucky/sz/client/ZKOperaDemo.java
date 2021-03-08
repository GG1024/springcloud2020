package com.lucky.sz.client;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * @FileName: ZKOperaDemo.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-08
 **/
public class ZKOperaDemo implements Serializable {

    private static String connectString = "192.168.92.129:2181";
    private static int sessionTimeout = 50 * 1000;

    /**
     * 连接zookeeper服务器
     */
    public ZooKeeper connectionZookeeper() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
        return zooKeeper;
    }

    /**
     * 创建节点
     */
    public String createZKNode(ZooKeeper zooKeeper, String path, String data) throws KeeperException, InterruptedException {
        byte[] bytesData = data.getBytes();
        //访问控制列表
        List<ACL> openAcl = ZooDefs.Ids.OPEN_ACL_UNSAFE;

        CreateMode mode = CreateMode.PERSISTENT;

        String result = zooKeeper.create(path, bytesData, openAcl, mode);
        System.out.println("创建节点成功" + result);
        return result;

    }


    /**
     * 获取节点上的数据
     */
    public String getZkNodeData(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, false, new Stat());
        return new String(data);
    }

    /**
     * 设置节点上数据
     */
    public Stat setZkNodeData(ZooKeeper zooKeeper, String path, String data) throws KeeperException, InterruptedException {
        return zooKeeper.setData(path, data.getBytes(), -1);
    }

    /**
     * 判断节点是否存在
     */
    public Stat isExitZKPath(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        Stat exists = zooKeeper.exists(path, false);
        return exists;
    }


    @Test
    public void testConnection() throws IOException, InterruptedException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        System.out.println("====================");
        System.out.println(zooKeeper);
        System.out.println("====================");
        Thread.sleep(Long.MAX_VALUE);
    }


    //测试创建节点
    @Test
    public void testCreateZKNode() throws KeeperException, InterruptedException, IOException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        String result = zkOperaDemo.createZKNode(zooKeeper, "/address", "ShenZhen");
        System.out.println(result);
    }


    //测试获取节点数据
    @Test
    public void testGetZKNodeData() throws KeeperException, InterruptedException, IOException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        String result = zkOperaDemo.getZkNodeData(zooKeeper, "/address");
        System.out.println(result);
    }


    //测试设置节点数据
    @Test
    public void testSetZKNodeData() throws KeeperException, InterruptedException, IOException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        Stat stat = zkOperaDemo.setZkNodeData(zooKeeper, "/address", "Shen Zhen update");
        System.out.println(stat);
        //结果是二进制数据
        if (null != null) {
            System.out.println(stat.getCversion());
        }

    }

    //测试节点是否存在
    @Test
    public void testIsExitZKPath() throws KeeperException, InterruptedException, IOException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        Stat stat = zkOperaDemo.isExitZKPath(zooKeeper, "/addressaa");
        //结果是二进制数据  如果节点不存在，则返回null
        System.out.println(stat);
        if (null != null) {
            System.out.println(stat.getCversion());
        }

    }


    public void getZKNodeData2(final ZooKeeper zooKeeper, final String path) throws InterruptedException, KeeperException {
        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    String data2 = ZKOperaDemo.process(zooKeeper, path);
                    System.out.println("第一次调用============= " + data2 + " =================");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        System.out.println("该节点" + path + "上的数据为: " + new String(data));
        Thread.sleep(Long.MAX_VALUE);

    }

    public static String process(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    String data = ZKOperaDemo.process(zooKeeper, path);
                    System.out.println("============= " + data + " =================");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, new Stat());
        return new String(data);
    }


    @Test
    public void testGetZKNodeData2() throws KeeperException, InterruptedException, IOException {
        ZKOperaDemo zkOperaDemo = new ZKOperaDemo();
        ZooKeeper zooKeeper = zkOperaDemo.connectionZookeeper();
        zkOperaDemo.getZKNodeData2(zooKeeper, "/address");
    }
}
