/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_searchs;

import static ai_searchs.BFS.finalqueue;
import static ai_searchs.BFS.queens;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Mohammad
 */
public class AStar {

    static PriorityQueue<Node> heap = new PriorityQueue<>();
    static LinkedList<Node> finalqueue = new LinkedList<>();

    public static boolean[][] queens;
    
    

    public static boolean[][] solve1(boolean[][] queen1) {
        queens = queen1;
        heap.add(new Node(0, 0, 0, queens, 0, FXMLGenerateController.getNumOfConflict(queens)));

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
        //	Scanner s=new Scanner(System.in);
        //	s.nextInt();
        Node n = heap.peek();
        heap.remove();
        queens = n.state;
        finalqueue.addLast(n);

        //	System.out.println("x = "+n.xWhosMove+" y = "+n.yWhosMove+" deg = "+n.leftOrRight);
        //System.out.println("Nnnnnn"+n.coastToHere+"    "+n.totalcost);
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length - 1; j++) {
                if (queens[i][j]) {

                    queens[i][j] = false;
                    queens[i][j + 1] = true;
                    System.err.println(n.depth + 1 + "    " + FXMLGenerateController.getNumOfConflict(queens));
                    heap.add(new Node(i, j, +1, queens, n.depth + 1, FXMLGenerateController.getNumOfConflict(queens)));

                    queens[i][j] = true;
                    queens[i][j + 1] = false;
                    break;
                }
            }

            for (int j = 1; j < queens.length; j++) {
                if (queens[i][j]) {
                    queens[i][j - 1] = true;
                    queens[i][j] = false;
                    heap.add(new Node(i, j, -1, queens, n.depth + 1, FXMLGenerateController.getNumOfConflict(queens)));
                    queens[i][j - 1] = false;
                    queens[i][j] = true;
                    break;

                }
            }

        }

    }

}
