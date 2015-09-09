package is.ru.honn.teiknir.json;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contains method to read text from a file
 *
 * Created by kristofer on 8/29/15.
 *
 * @author Kristofer R.
 * @version 1
 */
public class FileLoader {
    /**
     * Reads content of a file and stores text in a string
     * @param fileName Name of file to read
     * @return Text from the file "fileName"
     * @throws FileLoadException
     */
    public String loadFileName(String fileName) throws FileLoadException {
        // Got this method from:
        // http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
        // Reads file and parses content into string
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new FileLoadException("Couldn't read file: " + e.getMessage());
        }
        return new String(encoded, Charset.defaultCharset());
    }
}
