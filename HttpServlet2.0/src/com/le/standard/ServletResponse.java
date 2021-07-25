package com.le.standard;

import java.io.IOException;
import java.io.PrintWriter;

public interface ServletResponse {
    PrintWriter getWriter() throws IOException;

    void serContentType(String type);
}
