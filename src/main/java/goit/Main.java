package goit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        HttpImageStatusCli cli = new HttpImageStatusCli();
        try {
            System.out.println("HttpStatusChecker\n********************");
            System.out.println("url for code 200: " + checker.getStatusImage(200));
            System.out.println("\n\nurl for code 200: " + checker.getStatusImage(10000));
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        System.out.println("**************************\n\n");

        try{
            System.out.println("HttpStatusImageDownloader\n*********************");
            downloader.downloadStatusImage(300);
            downloader.downloadStatusImage(2000);
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        System.out.println("**************************\n\n");


        System.out.println("HttpImageStatusCli*********************");
        //to check valid value
        cli.askStatus();
        //for invalid
        cli.askStatus();
    }
}