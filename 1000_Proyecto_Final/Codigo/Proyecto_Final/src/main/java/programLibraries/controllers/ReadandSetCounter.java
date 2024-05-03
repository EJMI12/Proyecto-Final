package programLibraries.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programLibraries.Configuration;
import programLibraries.FileManagerResponse;
import programLibraries.WebResponse;
import programLibraries.YouTubeCSV;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadandSetCounter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Path path = Paths.get(Configuration.DATA_MODEL_FILE_NAME);

        FileManagerResponse readResponse = YouTubeCSV.read(path);
        WebResponse webResponse = new WebResponse();

        if (readResponse.isStatus()) {
            webResponse.setStatus(true);
            webResponse.setContent(readResponse.getContent());
            response.setContentType("application/json");
            response.getWriter().append(webResponse.toJSON());
        } else {
            webResponse.setStatus(false);
            webResponse.setContent("Error reading file: " + readResponse.getError());
  
            response.setContentType("application/json");
            response.getWriter().append(webResponse.toJSON());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}