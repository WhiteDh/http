package goit;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = checker.getStatusImage(code);
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == 200) {
            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                 FileOutputStream out = new FileOutputStream(code + ".jpg")) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("image saved as " + code + ".jpg");
            } catch (IOException e) {
                throw new IOException("failed to download image: " + e.getMessage());
            }
        } else {
            throw new Exception("image not found for http status code: " + code);
        }

        connection.disconnect();
    }
}
