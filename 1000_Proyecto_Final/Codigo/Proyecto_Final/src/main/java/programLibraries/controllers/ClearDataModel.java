package programLibraries.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programLibraries.Configuration;
import programLibraries.FileManagerResponse;
import programLibraries.WebResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClearDataModel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Path path = Paths.get(Configuration.DATA_MODEL_FILE_NAME);

        FileManagerResponse clearResponse = clearDataModel(path);
        WebResponse webResponse = new WebResponse();

        if (clearResponse.isStatus()) {
            webResponse.setStatus(true);
            webResponse.setContent("Data model has been cleared successfully.");
            response.setContentType("application/json");
            response.getWriter().append(webResponse.toJSON());
        } else {
            webResponse.setStatus(false);
            webResponse.setContent("Error clearing data model: " + clearResponse.getError());
            response.setContentType("application/json");
            response.getWriter().append(webResponse.toJSON());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private FileManagerResponse clearDataModel(Path path) {
        FileManagerResponse clearResponse = new FileManagerResponse();
        clearResponse.setStatus(false);

        try {
            // Aquí puedes agregar lógica para eliminar o limpiar el modelo de datos según tus requisitos.
            // Por ejemplo, si el modelo de datos está representado por un archivo, podrías eliminar el archivo.
            Files.deleteIfExists(path);

            clearResponse.setContent("Data model has been cleared successfully.");
            clearResponse.setStatus(true);
        } catch (IOException ex) {
            clearResponse.setError(ex.toString());
        }

        return clearResponse;
    }
}