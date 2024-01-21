package com.testdome.java.algorithms;

import java.util.Stack;

public class TrainComposition2 {

	Stack<Integer> stack = new Stack<>();
	
    public void attachWagonFromLeft(int wagonId) {
        stack.add(0, wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
    	stack.add(wagonId);
    }

    public int detachWagonFromLeft() {
    	int i = stack.firstElement();
    	stack.remove(0);
    	return i;
    }

    public int detachWagonFromRight() {
        return stack.pop();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
