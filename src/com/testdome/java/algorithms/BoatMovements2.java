package com.testdome.java.algorithms;

public class BoatMovements2 {

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
        	//vertical movement
        	return canTravelTo(gameMatrix, fromRow < toRow ? ++fromRow : --fromRow, fromColumn, toRow, toColumn);
        }else {
        	//horizontal movement
        	return canTravelTo(gameMatrix, fromRow, fromColumn < toColumn ? ++fromColumn : --fromColumn, toRow, toColumn);
        }   	
    	
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
