package com.wjw;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @description: 自定义一个response
 * @author: wjw
 * @date： 2020/9/6 19:07
 */
public class DiyResponse {

    private OutputStream outputStream;

    public DiyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void returnPage(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");

        outputStream.write(httpResponse.toString().getBytes());
    }

}
