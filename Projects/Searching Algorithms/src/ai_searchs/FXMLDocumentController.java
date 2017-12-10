/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_searchs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Mohammad
 */
public class FXMLDocumentController implements Initializable {

    public static Stage generatestage;

    @FXML
    private TextField tfNumOfQueen;
    @FXML
    private Label errorLable;

    @FXML
    private void generateSetOnAction() {
        String number = tfNumOfQueen.getText().toString();
        try {
            int intNumOfQueen = Integer.parseInt(number);
            if (intNumOfQueen > 3) {
                // code
               StaticsVariable.BOARD_SIZE=intNumOfQueen;
                Stage stage1 = new Stage();

                Parent root = FXMLLoader.load(getClass().getResource("FXMLGenerate.fxml"));

                Scene scene = new Scene(root);
                stage1.setScene(scene);
                stage1.show();

                generatestage.close();

            }
            errorLable.setText("not Exist solution for n < 4");

        } catch (Exception e) {
            errorLable.setText(e.getMessage());
        }

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    
	
}
