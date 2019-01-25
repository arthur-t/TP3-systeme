package util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class WebVerif implements Runnable{

    private URL website;
    private List<Integer> results;
    private Semaphore sem;

    public WebVerif(String website, ArrayList<Integer> results, Semaphore sem) throws MalformedURLException {
        this.sem = sem;
        this.website = new URL(website);
        this.results=results;
        configProxy();

    }

    private synchronized int getStatus() {

        try {
            HttpURLConnection connection = (HttpURLConnection) website.openConnection();
            connection.connect();

            int responseCode = connection.getResponseCode();

            connection.disconnect();
            return responseCode;
        } catch (IOException e) {
            System.err.println("Erreur lors de la connection à l'host");
            return -1;
        }

    }

    private void configProxy(){
        System.setProperty("http.proxyPort", "8080");
    }

    @Override
    public void run() {
        int result =getStatus();
        try {
            sem.acquire();
            results.add(result);

        } catch (InterruptedException e) {
            System.err.println("Erreur d'excution du thread.");
        }
        finally {
            sem.release();
        }

    }
}
