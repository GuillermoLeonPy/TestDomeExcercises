package com.testdome.java.algorithms;

import java.util.ArrayList;
import java.util.List;

public class TrainComposition {

	List<Integer> train = new ArrayList<>();
	
    public void attachWagonFromLeft(int wagonId) {
        train.add(0, wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
    	train.add(wagonId);
    }

    public int detachWagonFromLeft() {
        return train.remove(0);
    }

    public int detachWagonFromRight() {
        return train.remove(train.size() - 1);
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }

}
