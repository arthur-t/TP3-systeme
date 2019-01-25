package model;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

public class Singe implements Callable<Integer> {

    private ArrayBlockingQueue<Integer> bananes;

    public Singe(ArrayBlockingQueue<Integer> bananes) {
        this.bananes = bananes;
    }

    private int collecterBananes(){
        Random r = new Random();
        return r.nextInt(10);
    }

    @Override
    public Integer call() {
        int bananesCollectees = collecterBananes();
        this.bananes.add(bananesCollectees);
        return bananesCollectees;
    }
}
