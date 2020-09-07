package com.wjw;

import java.io.IOException;

/**
 * @description: DiyServlet的实现HelloServlet
 * @author: wjw
 * @date： 2020/9/7 17:31
 */
public class HelloServlet extends DiyServlet{
    @Override
    public void doGet(DiyRequest diyRequest, DiyResponse diyResponse) throws Exception {
        try {

            diyResponse.returnPage("service......doGet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(DiyRequest diyRequest, DiyResponse diyResponse) throws Exception {
        try {
            diyResponse.returnPage("service......doPost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
