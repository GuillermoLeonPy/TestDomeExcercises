package com.testdome.java.algorithms;

public class BoatMovements {

    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        
        if(fromRow < 0 || fromRow >= gameMatrix.length 
        		|| fromColumn < 0 || fromColumn >= gameMatrix[0].length
        		|| !gameMatrix[fromRow][fromColumn]
        		|| !gameMatrix[toRow][toColumn]
        		|| (fromRow != toRow && fromColumn != toColumn)) {
        	return false;
        }
        
        if(fromRow == toRow && fromColumn == toColumn) {
        	return true;
        }
        
        if(fromRow != toRow) {
        	//vertical movement: fromColumn == toColumn
        	int elements = Math.abs(fromRow - toRow) + 1;
        	int[] rowsToCheck = new int [elements];
        	boolean ascending = fromRow <= toRow ? true : false;
        	
        	for(int i = 0; i < elements; i++) {
        		rowsToCheck[i] =  ascending ? fromRow++ : fromRow--;        		
        	}
        	return checkPath(gameMatrix, rowsToCheck, new int [] {fromColumn});
        }else {
        	//horizontal movement: fromRow == toRow
        	int elements = Math.abs(fromColumn - toColumn) + 1;
        	int[] columnsToCheck = new int [elements];
        	boolean ascending = fromColumn <= toColumn ? true : false;        	
        	for(int i = 0; i < elements; i++) {
        		columnsToCheck[i] =  ascending ? fromColumn++ : fromColumn--;        		
        	}
        	return checkPath(gameMatrix, new int [] {fromRow}, columnsToCheck);
        }        
    }
    
    private static boolean checkPath(boolean[][] gameMatrix, int[] rowsToCheck, int[] columnsToCheck) {
    	for(int rowsIndex = 0; rowsIndex < rowsToCheck.length; rowsIndex++) {
    		for(int columnsIndex = 0; columnsIndex < columnsToCheck.length; columnsIndex++) {
    			if(!gameMatrix[rowsToCheck[rowsIndex]][columnsToCheck[columnsIndex]]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                { false, false, true, true, false },
                { false, false, true, false, false },
                { false, false, true, true, false },
                { false, true, false, true, false },
                { false, false, true, false, false }
        };

        System.out.println(canTravelTo(gameMatrix, 2, 2, 0, 2));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 2, 1));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 2, 3));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 4, 2));
    }

}
