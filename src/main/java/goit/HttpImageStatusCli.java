package goit;

import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
    void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter http status tocheck and download the image:");

        try {
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("the code is " + code);
            try {
                downloader.downloadStatusImage(code);

            } catch (Exception e) {
                System.out.println("There is not image for HTTP status " + code);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");

        }

    }
}
