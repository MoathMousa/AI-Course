/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_searchs;

import java.util.LinkedList;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author Mohammad
 */
public class BFS {

    static LinkedList<Node> queue = new LinkedList<>();
    static LinkedList<Node> finalqueue = new LinkedList<>();
    public static boolean[][] queens;

    public static boolean[][] solve1(boolean[][] queens1) {
        queens = queens1;
        queue.addLast(new Node(0, 0, 0, queens1, 0,0));
        while (true) {

            if (FXMLGenerateController.getNumOfConflict(queens) == 0) {
			FXMLGenerateController.moves=finalqueue;

                return queens;
            } else {
                solve();
            }
}
}
	public static void solve() {
		//s.nextInt();
                Scanner ss=new Scanner(System.in);
                //ss.nextInt();
		queens=queue.getFirst().state.clone();
		Node n=queue.getFirst();
                finalqueue.addLast(n);

		queue.removeFirst();
		
		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens.length-1; j++) {
				if(queens[i][j]){

					queens[i][j]=false;
					queens[i][j+1]=true;
					queue.addLast(new Node(i,j,+1,queens,0,0));

					queens[i][j]=true;
					queens[i][j+1]=false;
					break;
				}
			}
			
			
			
			for (int j =1; j < queens.length; j++) {
				if(queens[i][j]){
					queens[i][j-1]=true;
					queens[i][j]=false;
					queue.addLast(new Node(i,j,-1,queens,0,0));
					queens[i][j-1]=false;
					queens[i][j]=true;
					break;
					
				}
			}
			
			
			
		}
		
	}

    
    
}
