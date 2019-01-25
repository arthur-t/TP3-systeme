package model;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ramasseur {

    private Integer numberOfBananasCollected;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ArrayBlockingQueue<Integer> bananes = new ArrayBlockingQueue<>(100);

    public void collecter(){
        for(int i=0;i<10;i++){
            Singe s = new Singe();
            FutureTask<Integer> futureTask = new FutureTask<>(s);
            executorService.execute(futureTask);

        }
    }
}
