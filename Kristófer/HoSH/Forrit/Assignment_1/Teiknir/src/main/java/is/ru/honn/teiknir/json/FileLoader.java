package is.ru.honn.teiknir.json;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kristofer on 8/29/15.
 */
public class FileLoader {
    public String loadFileName(String fileName) throws FileLoadException {
        // Got this method from:
        // http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
        // Reads file and parses content into string
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new FileLoadException("Couldn't read file");
        }
        return new String(encoded, Charset.defaultCharset());
    }
}
