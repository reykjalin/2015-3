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
 * Created by kristofer on 8/30/15.
 */
public class ClientRequest {
    public String getFileContent(String fileName) throws RequestException {
        // Got this method from:
        // http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
        // Reads file and parses content into string
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new RequestException("Couldn't read file");
        }
        return new String(encoded, Charset.defaultCharset());
    }

    public String getRequest(String url) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        String content = target.request(MediaType.TEXT_PLAIN_TYPE).get().readEntity(String.class);

        return content;
    }
}
