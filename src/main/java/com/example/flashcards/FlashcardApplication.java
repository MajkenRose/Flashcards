package com.example.flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlashcardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlashcardApplication.class.getResource("flashcards.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Flashcard");
        stage.setScene(scene);
        stage.show();

        FlashcardController controller = (FlashcardController) fxmlLoader.getController();
        stage.setOnCloseRequest(event -> {
            try {
                controller.gemData();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

