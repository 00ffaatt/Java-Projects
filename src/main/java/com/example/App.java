package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Button[][] buttons = new Button[3][3];
    private boolean playerXTurn = true;
    private Board aBoard;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("TicTacToe!");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        initializeBoard(grid);

        Text sceneTitle = new Text("David's 2 player tictactoe Game");
        sceneTitle.setFont(new Font(20));
        grid.add(sceneTitle, 0, 0, 3, 1);

        scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void initializeBoard(GridPane gridPane) {
        aBoard = new Board();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int tempRow = row;
                int tempCol = col;

                Button button = new Button();
                button.setFont(new Font(24));
                button.setMinSize(100, 100);

                button.setOnAction(event -> buttonClicked(button, tempRow, tempCol, gridPane));
                buttons[row][col] = button;
                buttons[row][col].setStyle("");
                buttons[row][col].setFocusTraversable(false);
                gridPane.add(button, col, row + 1);
            }
        }
    }

    private void buttonClicked(Button button, int row, int col, GridPane gridPane) {
        if (playerXTurn) {
            aBoard.action(row, col, BoxState.CROSS);
        } else {
            aBoard.action(row, col, BoxState.CIRCLE);
        }
        button.setText(playerXTurn ? "X" : "O");
        button.setDisable(true);
        playerXTurn = !playerXTurn;
        if (aBoard.checkGameFinished()) {
            if (aBoard.getGameState() == GameState.CIRCLE_WIN) {
                showEndDialog("Circles win! Press the button below to start another game", gridPane);
            } else if (aBoard.getGameState() == GameState.CROSS_WIN) {
                showEndDialog("Crosses win! Press the button below to start another game", gridPane);
            } else {
                showEndDialog("It's a draw! Press the button below to start another game", gridPane);
            }
        }
    }

    private void resetBoard() {
        aBoard = new Board();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setDisable(false);
                buttons[row][col].setStyle("");
                buttons[row][col].setFocusTraversable(false);
            }
        }
        playerXTurn = true;
    }

    private void showEndDialog(String message, GridPane gridPane) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType playAgain = new ButtonType("Play Again");
        ButtonType exit = new ButtonType("Exit");

        alert.getButtonTypes().setAll(playAgain, exit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == playAgain) {
            resetBoard();
        } else {
            System.exit(0);
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}