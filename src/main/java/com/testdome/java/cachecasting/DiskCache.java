package com.testdome.java.cachecasting;

public class DiskCache extends Cache {

	public DiskCache() {
		// TODO Auto-generated constructor stub
	}

	private Integer diskCapacity;

	public Integer getDiskCapacity() {
		return diskCapacity;
	}

	public void setDiskCapacity(Integer diskCapacity) {
		this.diskCapacity = diskCapacity;
	}

	@Override
	public String toString() {
		return "DiskCache [diskCapacity=" + diskCapacity + ", getId()=" + getId() + "]";
	}
	
	
}
