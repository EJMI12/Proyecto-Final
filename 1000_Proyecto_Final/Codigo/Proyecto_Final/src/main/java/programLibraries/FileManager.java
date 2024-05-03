package programLibraries;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
;



public class FileManager {

  
	public static FileManagerResponse read(Path path) {
	    FileManagerResponse readResponse = new FileManagerResponse();
	    readResponse.setStatus(false);

	    try (BufferedReader reader = Files.newBufferedReader(path)) {
	        StringBuilder content = new StringBuilder();
	        String line;
	        while ((line = reader.readLine())!= null) {
	            content.append(line).append("\n");
	        }
	        readResponse.setContent(content.toString());
	        readResponse.setStatus(true);
	    } catch (Exception ex) {
	        Configuration.logger.severe("Error reading from file: " + ex.getMessage());
	        readResponse.setContent("Error. No se puedo leer el archivo");
	        readResponse.setStatus(false);
	        readResponse.setError(ex.toString());
	    }
	    return readResponse;
	}
    

    public static FileManagerResponse write(VideoRegister video, Path path) {
        FileManagerResponse writeResponse = new FileManagerResponse();
        writeResponse.setStatus(false);

        try {
            String content = video.toCSV() + "\n";
            Files.writeString(path, content, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            writeResponse.setContent("El video se Registro Correctamente");
            writeResponse.setStatus(true);
        } catch (Exception ex) {
            Configuration.logger.severe("Error writing to file: " + ex.getMessage());
            writeResponse.setContent("Error. No se puedo Registrar el video");
            writeResponse.setStatus(false);
            writeResponse.setError(ex.toString());
        }
        return writeResponse;
    }
    
    
} 
