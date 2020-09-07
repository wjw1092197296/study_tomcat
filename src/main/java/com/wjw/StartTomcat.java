package com.wjw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *启动tomcat
 */
public class StartTomcat
{

    /**
     * 用于存url对应的sevlet名称
     */
    static Map<String, String> cacheMap = new ConcurrentHashMap<>();

    public static void main( String[] args )throws Exception
    {
        /**
         * 默认存一个HelloServlet
         */
        cacheMap.put("/hello","com.wjw.HelloServlet");
        new StartTomcat().start();
    }

    /**
     * 启动接收信息
     */
    public void start() {
        int port = 8080;
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is Start...################");

            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                DiyRequest diyRequest = new DiyRequest(inputStream);
                DiyResponse diyResponse = new DiyResponse(outputStream);
                dispatch(diyRequest, diyResponse);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != serverSocket){
                try{
                    serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            //关闭socket
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 利用反射实例化具体的 Servlet 进行处理,这里默认使用HelloServlet
     * @param myRequest
     * @param myResponse
     */
    private void dispatch(DiyRequest myRequest, DiyResponse myResponse){
        try {
            Class<DiyServlet> myServletClass = (Class<DiyServlet>)Class.forName(cacheMap.get(myRequest.getUrl()));
            DiyServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest,myResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
