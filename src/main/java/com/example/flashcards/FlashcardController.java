package com.example.flashcards;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class FlashcardController {

    private int countCorrect = 0;
    private int countAlmost = 0;
    private int countPartially =0;
    private int countNot = 0;
    private int MAX = 10;

    private final ObservableList<Flashcard> flashcards = FXCollections.observableArrayList();

    public void gemData() throws IOException {
        SerializableHelper.skrivObjekter (flashcards);
    }

    @FXML
    private Label almostAnswer;

    @FXML
    private TextArea answer;

    @FXML
    private Label cardsNotShown;

    @FXML
    private Label correctAnswer;

    @FXML
    private ImageView image;

    @FXML
    private Label notAnswer;

    @FXML
    private Label numberOfCards;

    @FXML
    private Label partiallyAnswer;

    @FXML
    private Label shownCards;

    @FXML
    void addAlmost(ActionEvent event) {
        countAlmost++;
        almostAnswer.setText(String.valueOf(countAlmost));
    }

    @FXML
    void addCorrect(ActionEvent event) {
        if(countCorrect < MAX) {
        correctAnswer.setText(String.valueOf(++countCorrect));
        }
        if (countCorrect == MAX) {
            showEndScreen();
        }
    }

    @FXML
    void addNot(ActionEvent event) {
        countNot++;
        notAnswer.setText(String.valueOf(countNot));
    }

    @FXML
    void addPartially(ActionEvent event) {
        countPartially++;
        partiallyAnswer.setText(String.valueOf(countPartially));
    }

    private void showEndScreen() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End Screen");
        alert.setHeaderText(null);
        alert.setContentText("You have gotten all the cards correct");
        alert.showAndWait();
    }

    public void initialize() {
        numberOfCards.setText("10");
    }
}