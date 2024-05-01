package com.example.seatplanner;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.Objects;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField nameBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!HelloApplication.isSplashLoaded) {
            loadSplashScreen();
        }

    }

    public void switchScenes(ActionEvent event) throws IOException {


        String name = nameBox.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.FXML"));
        root = loader.load();

        MenuController menucontroller = loader.getController();
        menucontroller.displayName(name);

        //making new stake? could cause problems?
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }








    private void loadSplashScreen(){
        try {
            HelloApplication.isSplashLoaded = true;
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SplashFXML.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1),pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1),pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e)-> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e)->{
                try {
                    AnchorPane parentContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}