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
    private int countShown = 0;
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
        countShown++;
        shownCards.setText(String.valueOf(countShown));
    }

    @FXML
    void addCorrect(ActionEvent event) {
        if(countCorrect < MAX) {
        correctAnswer.setText(String.valueOf(++countCorrect));
            countShown++;
            shownCards.setText(String.valueOf(countShown));
        }
        if (countCorrect == MAX) {
            showEndScreen();
        }
    }

    @FXML
    void addNot(ActionEvent event) {
        countNot++;
        notAnswer.setText(String.valueOf(countNot));
        countShown++;
        shownCards.setText(String.valueOf(countShown));
    }

    @FXML
    void addPartially(ActionEvent event) {
        countPartially++;
        partiallyAnswer.setText(String.valueOf(countPartially));
        countShown++;
        shownCards.setText(String.valueOf(countShown));
    }

    @FXML
    void restart(ActionEvent event) {
        countCorrect = 0;
        countAlmost = 0;
        countPartially = 0;
        countNot = 0;
        countShown = 0;
        correctAnswer.setText(String.valueOf(countCorrect));
        almostAnswer.setText(String.valueOf(countAlmost));
        partiallyAnswer.setText(String.valueOf(countPartially));
        notAnswer.setText(String.valueOf(countNot));
        shownCards.setText(String.valueOf(countShown));
    }


    @FXML
    void endExercise(ActionEvent event) {

    }

    @FXML
    void pause(ActionEvent event) {

    }

    @FXML
    void showAnswer(ActionEvent event) {

    }

    private void showEndScreen() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End Screen");
        alert.setHeaderText(null);
        alert.setContentText("You have gotten all the cards correct");
        alert.showAndWait();
    }

    public void initialize() {
        numberOfCards.setText(String.valueOf(MAX));
        cardsNotShown.setText(String.valueOf(MAX));
        shownCards.setText("0");
        answer.setEditable(false);
    }
}