/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_searchs;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Mohammad
 */
public class IDS {
    
        public static boolean[][] queens;

    
    	static Node startState;

        static LinkedList<Node> finalqueue = new LinkedList<>();

    	static Stack<Node> stack=new Stack<>();

    
public static boolean [][] solve1(boolean [][]queen1){
	queens=queen1;
	startState=new Node(0,0,0,queen1,0,0);
	stack.push(startState);
	while(true){

		if(FXMLGenerateController.getNumOfConflict(queens) ==0){
			FXMLGenerateController.moves=finalqueue;
			return queens ;
		}else if(stack.isEmpty()){
			StaticsVariable.depth++;
			stack.push(startState);}
		else
			solve();
	}
}
	public static  void solve() {
		Scanner s=new Scanner(System.in);
		//s.nextInt();
		Node n=stack.pop();
        finalqueue.addLast(n);

		queens=n.state.clone();

    if(n.depth+1>StaticsVariable.depth)
	return;
		
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens.length-1; j++) {
				if(queens[i][j]){

					queens[i][j]=false;
					queens[i][j+1]=true;
					stack.push(new Node(i,j,+1,queens,n.depth+1,0));

					queens[i][j]=true;
					queens[i][j+1]=false;
					break;
				}
			}
			
			
			
			for (int j =1; j < queens.length; j++) {
				if(queens[i][j]){
					queens[i][j-1]=true;
					queens[i][j]=false;
					stack.push(new Node(i,j,-1,queens,n.depth,0));
					queens[i][j-1]=false;
					queens[i][j]=true;
					break;
					
				}
			}
			
			
			
		}
		
	}
    
    
}
