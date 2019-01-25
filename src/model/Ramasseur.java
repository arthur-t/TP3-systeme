package model;


import java.util.concurrent.*;

public class Ramasseur {

    private Integer numberOfBananasCollected;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ArrayBlockingQueue<Integer> bananes = new ArrayBlockingQueue<>(100);

    public void collecter() throws InterruptedException {
        for(int i=0;i<10;i++){
            Singe s = new Singe(this.bananes);
            FutureTask<Integer> futureTask = new FutureTask<>(s);
            executorService.execute(futureTask);
        }
        while (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)) {
            //Attente de la fin des taches
        }
        additionnerBananes();

    }

    private void additionnerBananes(){
        for (Integer bananes:this.bananes) {
            numberOfBananasCollected += bananes;
        }
    }
}
