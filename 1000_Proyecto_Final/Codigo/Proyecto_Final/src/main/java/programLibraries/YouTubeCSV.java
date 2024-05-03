package programLibraries;

import java.nio.file.Path;
import java.nio.file.Paths;

public class YouTubeCSV {

    public boolean save(VideoRegister registry) {
        Path path = Paths.get(Configuration.DATA_MODEL_FILE_NAME);
        FileManagerResponse writeResponse = FileManager.write(registry, path);
        return writeResponse.isStatus();
    }
    

    public static FileManagerResponse read(Path path) {
        FileManagerResponse readResponse = FileManager.read(path);
        if (!readResponse.isStatus()) {
            return readResponse;
        }

        String content = readResponse.getContent();
        StringBuilder videos = new StringBuilder();

        String[] lines = content.split("\n");
        for (String line : lines) {
            String[] values = line.split(",");
            if (values.length == 7) {
                if (videos.length() > 0) {
                    videos.append("\n");
                }
                videos.append(String.format("%s,%s,%s,%s,%s,%s,%s", values[0], values[1], values[2], values[3], values[4], values[5], values[6]));
            }
        }

        readResponse.setContent(videos.toString());
        return readResponse;
    }
    
    
}