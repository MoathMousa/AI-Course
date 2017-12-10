/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_searchs;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammad
 */
public class FXMLGenerateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public  ScrollPane mainPane;
    @FXML
    public  ListView moveListdfs,moveLista,moveListida,moveListids,moveListbfs;
    private static boolean [][]queens;
    private static boolean [][]queensinit;
    
    boolean isFirstTime=true;
    public static LinkedList<Node> moves;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if(isFirstTime){
            initializeQueen();
            isFirstTime=false;
       }
       else{
          // fillList();
           
           
       }
        GridPane gridpane = new GridPane();

        for (int i = 0; i < StaticsVariable.BOARD_SIZE; i++) {
            for (int j = 0; j < StaticsVariable.BOARD_SIZE; j++) {
                StackPane cellPane = new StackPane();
                Color cellBackgroundColor;
                if ((i + j) % 2 == 0) {
                    cellBackgroundColor = Color.BLACK;
                } else {
                    cellBackgroundColor = Color.GOLD;
                }
                cellPane.getChildren().add(new Rectangle(StaticsVariable.CELL_SIZE, StaticsVariable.CELL_SIZE, cellBackgroundColor));

                if(queensinit[i][j]){
				cellPane.getChildren().add(new Circle(StaticsVariable.CIRCLE_RADIUS, StaticsVariable.QUEEN_COLOR));
			}
                gridpane.add(cellPane, j, i);
            }

        }

        mainPane.setContent(gridpane);

    }    
    
    
    private static void initializeQueen() {
		queensinit=new boolean[StaticsVariable.BOARD_SIZE][StaticsVariable.BOARD_SIZE];
		for (int i = 0; i < queensinit.length; i++) {
			queensinit[i][(int)(Math.random()*queensinit.length)]=true;
		}
		//queue.addLast(new Node(0,0,0,queens));
		
		
	}

    
    
    
    public static int getNumOfConflict(boolean [][]queens) {
		int numOfConflict=0;

		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens.length; j++) {
				if(queens[i][j])
				numOfConflict+=getNumOfConflict(i,j,queens);

			}
			
		}
		return numOfConflict;
	}
    
    
    
    private static int getNumOfConflict(int i,int j,boolean [][]queens) {
		// check vertical
		int numOfConflict=0;
		for (int j1 = 0; j1 < queens.length; j1++) {
			if (queens[j1][j]&&j1!=i){
				numOfConflict++;
				
			}			
		}
		// check qutri
				// >^
		for (int x1 = i+1,y1=j-1; x1 < queens.length&&y1 >= 0; x1++,y1--) {
			if(queens[x1][y1])
				numOfConflict++;
		}
			// >!^
		for (int x1 = i+1,y1=j+1; x1 < queens.length&&y1 < queens.length; x1++,y1++) {
			if(queens[x1][y1])
				numOfConflict++;
		}
		// <^
				for (int x1 = i-1,y1=j-1; x1>=0&&y1>=0; x1--,y1--) {
					if(queens[x1][j])
						numOfConflict++;
				}
				// <!^
				for (int x1 = i-1,y1=j+1; x1>=0&&y1<queens.length; x1--,y1++) {
					if(queens[x1][y1])
						numOfConflict++;
				}
				return numOfConflict;
	}
    

      
    @FXML
    public void BFSSOlve() {
        long startTime = System.nanoTime();    

        queens=BFS.solve1(queensinit);
        JOptionPane.showMessageDialog(null, "SLOVE DONE");
        moveListbfs.getItems().add("Time = " +(System.nanoTime()-startTime)/1000000 + " milliseconds");

        fillList(moveListbfs);
    }    
    

    
      
    @FXML
    public void DFSSOlve() {
         long startTime = System.nanoTime();   
       queens= DFS.solve1(queensinit);
               JOptionPane.showMessageDialog(null, "SLOVE DONE");
                       moveListdfs.getItems().add("Time = " +(System.nanoTime()-startTime)/1000000 + " milliseconds");

        fillList(moveListdfs);

    }    
    
     @FXML
    public void AStarSOlve() {
         long startTime = System.nanoTime();   
       queens= AStar.solve1(queensinit);
               JOptionPane.showMessageDialog(null, "SLOVE DONE");
                       moveLista.getItems().add("Time = " +(System.nanoTime()-startTime)/1000000 + " milliseconds");

        fillList(moveLista);

    } 
    
    
      @FXML
    public void IDSSOlve() {
         long startTime = System.nanoTime();   
       queens= IDS.solve1(queensinit);
               JOptionPane.showMessageDialog(null, "SLOVE DONE");
                       moveListids.getItems().add("Time = " +(System.nanoTime()-startTime)/1000000 + " milliseconds");

        fillList(moveListids);

    }
    
     
      @FXML
    public void IDAStarSOlve() {
         long startTime = System.nanoTime();   
       queens= IDAStar.solve1(queensinit);
       JOptionPane.showMessageDialog(null, "SLOVE DONE");
               moveListida.getItems().add("Time = " +(System.nanoTime()-startTime)/1000000 + " milliseconds");

        fillList(moveListida);    }
    
    
    
     @FXML
    public void Play() {
        queensinit=queens;
         initialize(null,null);  
    } 

    private void fillList(ListView<String>  moveList) {
            moveList.getItems().add("Number of moves = "+moves.size());

        while(!moves.isEmpty()) {
            moveList.getItems().add(moves.getFirst().xWhosMove+"   "+moves.getFirst().leftOrRight);
            moves.removeFirst();
        }


    }
    
}
