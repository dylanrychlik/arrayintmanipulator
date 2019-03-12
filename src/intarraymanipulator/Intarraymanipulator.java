/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intarraymanipulator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author dylan
 */
public class Intarraymanipulator extends Application {
    //Dylan Rychlik
    //3/12/2019
//This program take an array of ints and manipulates them via an fxml controller. 

    @Override
    public void start(final Stage stage) throws IOException {
//call fxml file
       
            Parent root = FXMLLoader.load(getClass().getResource("/intarraymanipulator/int_manipulator.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/intarraymanipulator/int_manipulator.css");

            stage.setScene(scene);
            stage.setTitle("Array Manipulator");
            stage.close();
            stage.show();

       
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
