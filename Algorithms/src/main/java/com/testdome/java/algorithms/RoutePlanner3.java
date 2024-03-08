package com.testdome.java.algorithms;

public class RoutePlanner3 {

	public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
			boolean[][] mapMatrix) {	
		
		boolean[][] coveredRoute = new boolean[mapMatrix.length][mapMatrix[0].length];
		
		
		return searchPath(fromRow, fromColumn, toRow, toColumn, mapMatrix, coveredRoute);
	}
	
	public static boolean searchPath(int fromRow, int fromColumn, int toRow, int toColumn,
			boolean[][] mapMatrix, boolean[][] coveredPath) {
		
		if(fromRow < 0 || fromRow >= mapMatrix.length 
				|| fromColumn < 0 || fromColumn >= mapMatrix[0].length 
				|| !mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]
				|| coveredPath[fromRow][fromColumn]) {
			return false;
		}
		
		coveredPath[fromRow][fromColumn] = true;
		
		if(fromRow == toRow && fromColumn == toColumn) {
			return true;
		}
		
		return 
				searchPath(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, coveredPath) ||
				searchPath(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, coveredPath) ||
				searchPath(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, coveredPath) ||
				searchPath(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, coveredPath);
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
//	        boolean[][] mapMatrix = {
//	            {true,  false, false},
//	            {true,  true,  false},
//	            {false, true,  true}
//	        };
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
