package is.ru.honn;

import is.ru.honn.json.RequestException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Stores functions to read text from files or websites.
 *
 * @author Kristofer R.
 * @version 1
 */
public class ClientRequest {
    /**
     * Found method on: http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
     * Reads text in a file and stores in a string
     * @param fileName Name of file to read
     * @return Text from file
     * @throws RequestException
     */
    public String getFileContent(String fileName) throws RequestException {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new RequestException("Couldn't read file: " + e.getMessage());
        }
        return new String(encoded, Charset.defaultCharset());
    }

    /**
     * Reads text from a website and stores in a string
     * @param url URL of website
     * @return Text from website
     */
    public String getRequest(String url) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        String content = target.request(MediaType.TEXT_PLAIN_TYPE).get().readEntity(String.class);

        return content;
    }
}
