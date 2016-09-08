package com.kr.dto;

import java.io.Serializable;

/**
 * A review.
 */
public class TestQueryResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long timeDiff;
	int noOfTestQueries;
	
	public TestQueryResult() {
		super();
	}

	public long getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(long timeDiff) {
		this.timeDiff = timeDiff;
	}

	public int getNoOfTestQueries() {
		return noOfTestQueries;
	}

	public void setNoOfTestQueries(int noOfTestQueries) {
		this.noOfTestQueries = noOfTestQueries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfTestQueries;
		result = prime * result + (int) (timeDiff ^ (timeDiff >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestQueryResult other = (TestQueryResult) obj;
		if (noOfTestQueries != other.noOfTestQueries)
			return false;
		if (timeDiff != other.timeDiff)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestQueryResult [timeDiff=" + timeDiff + ", noOfTestQueries=" + noOfTestQueries + "]";
	}
	
	
	

	
}
