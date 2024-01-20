package com.testdome.java.cachecasting;

public class MemoryCache extends Cache {

	public MemoryCache() {
		
		// TODO Auto-generated constructor stub
	}

	private Integer memoryCapacity;

	public Integer getMemoryCapacity() {
		return memoryCapacity;
	}

	public void setMemoryCapacity(Integer memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}

	@Override
	public String toString() {
		return "MemoryCache [memoryCapacity=" + memoryCapacity + ", getId()=" + getId() + "]";
	}
	
	
}
