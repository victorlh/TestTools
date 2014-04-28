package com.snakeTest;

public class Node {
	private int i ;
	private int j ;
	

	public Node(){
		
	}
	
	public Node(int i,int j){
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "i:"+i+",j:"+j;
	}

	@Override
	public int hashCode() {
		final int prime = 1000000000;
		int result = 1;
		result = prime * result * i;
		result += j;
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
		Node other = (Node) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

	
	
	
}
