package com.wjw;

import java.io.InputStream;

/**
 * @description: 自定义一个request
 * @author: wjw
 * @date 2020/9/3 20:52
 */
public class DiyRequest {

    private String head;
    private String url;
    private String method;
    private String request;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * 读取http请求，创建request
     *
     * @param inputStream
     * @throws Exception
     */
    public DiyRequest(InputStream inputStream) {

        try {
            byte[] requestBytes = new byte[1024];
            int length = 0;
            if ((length = inputStream.read(requestBytes)) > 0) {
                request = new String(requestBytes);

                //读出http请求的head、method、url
                head = request.split("\n")[0];
                method = request.split("\\s")[0];
                url = request.split("\\s")[1];
                System.out.println(request);
//                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
