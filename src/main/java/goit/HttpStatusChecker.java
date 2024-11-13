package goit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    private final static String BASE_URL = "https://http.cat";

    String getStatusImage(int code) throws Exception {
        String newUrl = BASE_URL + "/" + code + ".jpg";
        URL url = new URL(newUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        con.disconnect();

        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new Exception("image not found");
        }
        return newUrl;
    }
}
