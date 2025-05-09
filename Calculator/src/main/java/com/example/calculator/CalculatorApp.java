package com.example.calculator;// ---------------------
// Project 2: Calculator (All-in-One File)
// ---------------------

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    private TextField display;
    private String current = "";
    private String operator = "";
    private double num1 = 0;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = createCalculatorUI();
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    private BorderPane createCalculatorUI() {
        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 20px;");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        int row = 0;
        int col = 0;

        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(60, 60);
            btn.setStyle("-fx-font-size: 18px;");
            btn.setOnAction(e -> handleButton(text));
            grid.add(btn, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        VBox topBox = new VBox(10, display);
        topBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(grid);
        return root;
    }

    private void handleButton(String value) {
        switch (value) {
            case "C":
                current = "";
                operator = "";
                num1 = 0;
                display.clear();
                break;
            case "=":
                calculate();
                break;
            case "+": case "-": case "*": case "/":
                if (!current.isEmpty()) {
                    num1 = Double.parseDouble(current);
                    operator = value;
                    current = "";
                    display.clear();
                }
                break;
            default:
                current += value;
                display.setText(current);
        }
    }

    private void calculate() {
        if (operator.isEmpty() || current.isEmpty()) return;
        double num2 = Double.parseDouble(current);
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : 0;
            default -> 0;
        };
        display.setText(String.valueOf(result));
        current = String.valueOf(result);
        operator = "";
    }

    public static void main(String[] args) {
        launch(args);
    }
}
