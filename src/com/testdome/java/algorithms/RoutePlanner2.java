package com.testdome.java.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RoutePlanner2 {

	public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
			boolean[][] mapMatrix) {
		boolean[][] mapVisited = new boolean[mapMatrix.length][mapMatrix[0].length];

		return routeSearch(fromRow, fromColumn, toRow, toColumn,mapMatrix, mapVisited);

	}

	public static boolean routeSearch(int fromRow, int fromColumn, int toRow, int toColumn,
			boolean[][] mapMatrix, boolean[][] mapVisited) {


		if(fromRow < 0 || fromColumn < 0 || fromRow >= mapMatrix.length || fromColumn >= mapMatrix[0].length)
			return false;


		if(mapVisited[fromRow][fromColumn] || !mapMatrix[fromRow][fromColumn]
				|| !mapMatrix[toRow][toColumn])
			return false;

		if(fromRow == toRow && fromColumn == toColumn)
			return true;

		mapVisited[fromRow][fromColumn] = true;

		return routeSearch(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)
				|| routeSearch(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, mapVisited)
				|| routeSearch(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, mapVisited)            
				||routeSearch(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, mapVisited);
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
		//boolean[][] mapMatrix = {
		//{true,  false, false},
		//{true,  true,  false},
		//{false, true,  true}
		//};
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
