package com.testdome.java.algorithms;

public class SortedSearch {

    public static int countNumbers(int[] sortedArray, int lessThan) {
    	int index = -1;
    	int counter = 0;
    	int elementFound = 0;
    	boolean flag = false;
    	while(index == -1) {
    		if(!flag) {
    			flag = !flag;
    			elementFound = lessThan + (counter);
    			index = findIndex(sortedArray, elementFound, 0, sortedArray.length - 1);
    			counter++;
    		}else {
    			elementFound = lessThan - (counter);
    			index = findIndex(sortedArray, elementFound, 0, sortedArray.length - 1);
    		}    		
    	}
    	
        return elementFound < lessThan ? index + 1 : index;
    }
    
    private static int findIndex(int[] sortedArray, int element, int fromIndex, int toIndex) {
    	
    	if(fromIndex > toIndex) {
    		return -1;
    	}
    	
    	int halfIndex = fromIndex + ((toIndex - fromIndex) / 2) ;
    	if(sortedArray[halfIndex] == element) {
    		return halfIndex;
    	}else if (sortedArray[halfIndex] < element) {
    		return findIndex(sortedArray, element, halfIndex+1, toIndex);
    	}else {
    		return findIndex(sortedArray, element, fromIndex, halfIndex-1);
    	}
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 5));
    }

}
