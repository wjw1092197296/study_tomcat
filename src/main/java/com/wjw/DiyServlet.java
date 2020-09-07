package com.wjw;

import java.io.IOException;

/**
 * @description: 自定义servlet、应用启动时创建、初始化，关闭销毁
 * @author: wjw
 * @date： 2020/9/6 19:15
 */
public abstract class DiyServlet {


    public abstract void doGet(DiyRequest diyRequest,DiyResponse diyResponse)throws  Exception;
    public abstract void  doPost(DiyRequest diyRequest,DiyResponse diyResponse)throws  Exception;

    /**
     * 处理请求
     * @param diyRequest
     * @param diyResponse
     * @throws Exception
     */
    public void service(DiyRequest diyRequest,DiyResponse diyResponse)throws  Exception{
        String method = diyRequest.getMethod();
        if(method.equalsIgnoreCase("GET")){
            doGet(diyRequest,diyResponse);
        }else if (method.equalsIgnoreCase("POST")){
            doPost(diyRequest,diyResponse);
        }
    }

}
