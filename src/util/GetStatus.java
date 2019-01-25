package util;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class GetStatus {

    private String[] hostList = { "http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://wordpress.org/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://en.wikipedia.org/wiki/Main_Page"};

    private ExecutorService executor;



    public GetStatus() {
        int nbthreads = 2;
        executor = Executors.newFixedThreadPool(nbthreads);

    }


    public void executeService(){
        Semaphore sem = new Semaphore(1);
        ArrayList<Integer> results = new ArrayList<>();
        try {
        for (String host:hostList) {
                WebVerif thread = new WebVerif(host,results, sem);
                executor.submit(thread);
            }
            executor.shutdown();
            while (!executor.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                //Attente de la fin des threads
            }
            for (Integer result:results) {
                System.out.println(result);
            }

        }
        catch (MalformedURLException | InterruptedException e) {
            System.err.println("Error lors de la créations des threads.");
        }


    }
}
