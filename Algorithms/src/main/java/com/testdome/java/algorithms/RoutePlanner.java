package com.testdome.java.algorithms;
import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
    	if(toRow < 0 || toRow > mapMatrix.length || toColumn < 0 || toColumn > mapMatrix[0].length || !mapMatrix[toRow][toColumn] || !mapMatrix[fromRow][fromColumn]) {
    		return false;
    	}
    	
    	List<String> pathTraveled = new ArrayList<>();
        int [] nextCoordinates = getNextCoordinate(mapMatrix, fromColumn, fromRow, pathTraveled);
        
    	while((nextCoordinates[0] != -1 && nextCoordinates[1] != -1) && (!("" + nextCoordinates[1] + "" + nextCoordinates[0]).equals("" + toColumn + "" +  toRow))) {    		
    		nextCoordinates = getNextCoordinate(mapMatrix, nextCoordinates[1], nextCoordinates[0], pathTraveled);
    		//System.out.println(("" + nextCoordinates[1] + "" + nextCoordinates[0]) + " = " + ("" + toColumn + "" +  toRow) + "?");
    	}
    	if((nextCoordinates[0] == -1 && nextCoordinates[1] == -1)) {
    		return false;	
    	}else {
    		System.out.println(pathTraveled);
    		return true;
    	}    	
    }
    
    private static int[] getNextCoordinate(boolean[][] mapMatrix, int x, int y, List<String> pathTraveled) {

    	pathTraveled.add(y + "" + x);
    	if(checkNextCoordinate(mapMatrix, x-1, y, pathTraveled)) {
    		return new int[] {y,x-1};
    	}else if (checkNextCoordinate(mapMatrix, x+1, y, pathTraveled)) {
    		return new int[] {y,x+1};
    	}else if (checkNextCoordinate(mapMatrix, x, y+1, pathTraveled)) {
    		return new int[] {y+1,x};
    	}else if (checkNextCoordinate(mapMatrix, x, y-1, pathTraveled)) {
    		return new int[] {y-1,x};
    	}else {
    		return new int[] {-1,-1};
    	}
    }
    
    private static boolean checkNextCoordinate(boolean[][] mapMatrix, int x, int y, List<String> pathTraveled) {
    	if(x >= 0 && x < mapMatrix[0].length && y >= 0 && y < mapMatrix.length && mapMatrix[y][x] && !pathTraveled.contains(y + "" + x)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
   private static boolean[][] generateData(int num){
	   if(num == 0) {
		   boolean[][] mapMatrix = {
		            {true,  false, false},
		            {true,  true,  false},
		            {false, true,  true}
		        };
		   return mapMatrix;
	   }else if (num == 1) {
		   boolean[][] mapMatrix = {
		            {true,  false, false, false,  false, false},
		            {true,  true,  false, false,  false,  false},
		            {false, true,  true, false, false,  false},
		            {false,  false, true, true,  false, false},
		            {false,  false,  false, true,  true,  false},
		            {false, false,  false, false, true,  true},
		        };
		   return mapMatrix;
	   }else if (num == 2) {
		   boolean[][] mapMatrix = {
		            {true,  false, true, true,  true, false},
		            {true,  false,  true, false,  true,  false},
		            {true, false,  true, false, true,  false},
		            {true,  false, true, false,  true, false},
		            {true,  false,  true, false,  true,  false},
		            {true, true,  true, false, true,  true},
		        };
		   return mapMatrix;
	   }else if (num == 3) {
		   boolean[][] mapMatrix = {
		            {true,  false, false, true,  true, false},
		            {true,  false,  false, false,  true,  false},
		            {true, true,  true, false, true,  false},
		            {false,  false, false, false,  true, false},
		            {false,  false,  false, false,  true,  false},
		            {false, false,  true, false, true,  true},
		        };
		   return mapMatrix;
	   }else {
		   throw new RuntimeException("end test data");
	   }
   }
    
    
    public static void main(String[] args) {
//        boolean[][] mapMatrix = {
//            {true,  false, false},
//            {true,  true,  false},
//            {false, true,  true}
//        };
        boolean continueFlag = true;
        int counter = 0;
        while(continueFlag) {
        	try {
        		boolean[][] mapMatrix = generateData(counter++);
        		printMatrix(mapMatrix);
        		
        		boolean exists = routeExists(0, 0, mapMatrix.length-1, mapMatrix[0].length-1,  mapMatrix);
        		int x = mapMatrix.length - 1;
        		int y = mapMatrix[0].length-1;
        		System.out.println("routeExists(0, 0, "  + y + ", " + x +") = " + exists);
        		
        		exists = routeExists(mapMatrix.length-1, mapMatrix[0].length-1, 0, 0,  mapMatrix);
        		x = mapMatrix.length - 1;
        		y = mapMatrix[0].length-1;
        		System.out.println("routeExists(" + y + ", " + x + ", 0, 0) = " + exists);
        		
        		exists = routeExists(mapMatrix.length-1, mapMatrix[0].length-1, 0, 0,  mapMatrix);
        		x = mapMatrix.length - 1;
        		y = mapMatrix[0].length-1;
        		System.out.println("routeExists(" + y + ", " + x + ", 0, 0) = " + exists);
        		
        	}catch (Exception e) {
				// TODO: handle exception
        		
        		continueFlag = false;
			}
        }
        
        
        
    }
    
    private static void printMatrix(boolean[][] mapMatrix) {
    	StringBuffer sb = new StringBuffer();
    	for(int row = 0; row < mapMatrix.length; row++) {
    		sb.append("\n");
    		for(int column = 0; column < mapMatrix[0].length; column++) {
    			sb.append(mapMatrix[row][column] + "\t");
        	}	
    	}    	
    	System.out.println(sb.toString());
    }
    
}