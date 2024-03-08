package com.testdome.java.cachecasting;

public class OptimizedDiskCache extends DiskCache {

	public OptimizedDiskCache() {
		// TODO Auto-generated constructor stub
	}

	private String accessType;

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	@Override
	public String toString() {
		return "OptimizedDiskCache [accessType=" + accessType + ", getDiskCapacity()=" + getDiskCapacity()
				+ ", getId()=" + getId() + "]";
	}
	
	
}
