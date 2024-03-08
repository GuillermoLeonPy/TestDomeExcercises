package com.testdome.java.algorithms;

import java.util.LinkedList;

public class TrainComposition3 {

	LinkedList<Integer> train = new LinkedList<>();
	
    public void attachWagonFromLeft(int wagonId) {
        train.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
    	train.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return train.removeFirst();
    }

    public int detachWagonFromRight() {
    	return train.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }

}
