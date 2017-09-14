package com.mark.filter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseWarpper extends HttpServletResponseWrapper {



    public ResponseWarpper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return super.getWriter();
    }


    @Override
    public ServletResponse getResponse() {
        return super.getResponse();
    }
}
