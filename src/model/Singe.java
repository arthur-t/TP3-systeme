package model;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Singe implements Callable<Integer> {



    private int collecterBananes(){
        Random r = new Random();
        return r.nextInt(10);
    }

    @Override
    public Integer call() throws Exception {
        return collecterBananes();
    }
}
