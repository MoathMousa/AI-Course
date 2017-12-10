package ai_searchs;

import java.util.Arrays;

public class Node implements Comparable<Node>{
	public  int xWhosMove;
	public  int yWhosMove;
	boolean [][] state;
	int coastToHere;
	int depth;
	public int leftOrRight;
	public Node(int xWhosMove,int yWhosMove, int leftOrRight,boolean [][]state1,int costToHere,int hx) {
		super();
		this.xWhosMove = xWhosMove;
		this.yWhosMove = yWhosMove;
		this.leftOrRight = leftOrRight;
		this.depth=costToHere;
		coastToHere=hx;
		this.state=new boolean[state1.length][state1.length];
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				state[i][j]=state1[i][j];

			}
		}
	}
	
	@Override
	public String toString() {
		return "Node [xWhosMove=" + xWhosMove + ", yWhosMove=" + yWhosMove + ", state=" + Arrays.toString(state)
				+ ", coastToHere=" + coastToHere + ", totalcost=" + depth + ", leftOrRight=" + leftOrRight + "]";
	}

	@Override
	public int compareTo(Node o) {
		if(depth+coastToHere<o.depth+coastToHere){
			return -1;
		}
		else if(depth+coastToHere>o.depth+coastToHere){
			return +1;
		}
			
		
		return 0;
	}
	

}