package com.testdome.java.cachecasting;

public class MainApplication {

	public MainApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSubClassCastDirectAncestorClass();
		testClassToDirectSubClassCast();
		testClassToDirectSubClassCast2();
		testSubClassCastDirectAncestorClass2();
		testClassToDirectSubClassCast3();
		testClassToDirectSubClassCast4();
		
		
	}
	
	private static void testSubClassCastDirectAncestorClass() {
		try {
			OptimizedDiskCache odc = new OptimizedDiskCache();
			Cache cache = (Cache) odc;
			
			System.out.println("Sub class successfully casted to direct ancestor class !");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Sub class could not be casted to direct ancestor class !");
		}
	}
	 
	private static void testClassToDirectSubClassCast() {
		try {
			MemoryCache mc = new MemoryCache();
			Cache cache = (Cache) mc;
			DiskCache dc = (DiskCache) cache;
			System.out.println("Class successfully casted to direct sub class !");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Class could not be casted to direct sub class !");
		}
	}
	
	private static void testClassToDirectSubClassCast2() {
		try {
			DiskCache dc = new DiskCache();
			OptimizedDiskCache odc = (OptimizedDiskCache)dc;
			System.out.println("Class successfully casted to direct sub class !");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Class could not be casted to direct sub class !");
		}
	}
	
	private static void testSubClassCastDirectAncestorClass2() {
		try {
			OptimizedDiskCache odc = new OptimizedDiskCache();
			DiskCache dc = (DiskCache)odc;
			
			System.out.println("Sub class successfully casted to direct ancestor class !");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Sub class could not be casted to direct ancestor class !");
		}
	}
	
	private static void testClassToDirectSubClassCast3() {
		try {
			Cache cache = new Cache();
			MemoryCache mc = (MemoryCache)cache;
			System.out.println("Class successfully casted to direct sub class !");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Class could not be casted to direct sub class !");
		}
	}
	
	private static void testClassToDirectSubClassCast4() {
		try {
			OptimizedDiskCache odc = new OptimizedDiskCache();
			odc.setId("123");
			odc.setAccessType("optical");
			odc.setDiskCapacity(3000);
			System.out.println("original class object: \n" + odc);
			Cache cache = (Cache)odc;
			DiskCache dc = (DiskCache)cache;
			System.out.println("final class object, a direct sub class of the original object class: \n" + dc);
			DiskCache dc2 = new DiskCache();
			dc2.setId("-123");
			dc2.setDiskCapacity(-3000);
			System.out.println("look how final object looks like when initialized with its own constructor..\n" + dc2);
			
			System.out.println("Class successfully casted to direct sub class ! because the original class object is a sub class of the final class object \nin runtime: this is a use case based on the class to direct ancestor class");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Class could not be casted to direct sub class !");
		}
	}

}
