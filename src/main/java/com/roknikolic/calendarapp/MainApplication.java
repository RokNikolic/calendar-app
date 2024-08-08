package com.roknikolic.calendarapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        // Launch UI
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Configure UI with the calendar scene
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-scene.fxml"));
        Scene main_scene = new Scene(fxmlLoader.load());
        stage.setScene(main_scene);
        // Add icon and title
        Image icon = new Image(String.valueOf(MainApplication.class.getResource("calendar_icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Calendar App");
        stage.show();
    }
}