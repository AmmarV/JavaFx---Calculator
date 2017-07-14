package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.activation.CommandObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private boolean COMMA_FLAG = true;
    private boolean [] buttonPressed = new boolean[10];
    private int operation = -1;
    double data = 0;
    double result = 0;
    double secNum = 0;
    Main main;

    @FXML
    private TextArea display;
    @FXML
    private Button ac,seven,four,one,zero,sign,eight,five,two,percent,nine,six,three,comma,divide,times,minus,plus,equals;


    public void setMain(Main main) {
        this.main = main;
        display.setEditable(false);
        display.setText("0");
        Arrays.fill(buttonPressed, false);


    }

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(display.getText().equals("0") || display.getText() == "0"){
            display.setText("");
        }
        if(result != 0){
            display.setText("");
            result = 0;
        }
        String displayedText = display.getText();
        for(int i = 0; i< displayedText.length(); i++){
            if(displayedText.charAt(i) == '.'){
                COMMA_FLAG = false;
            }
        }
        Button pressedButton = (Button) event.getSource();
        switch(pressedButton.getId()) {
            case "zero":
                display.appendText("0");
                buttonPressed[0] = true;
                break;
            case "one":
                display.appendText("1");
                buttonPressed[1] = true;
                break;
            case "two":
                display.appendText("2");
                buttonPressed[2] = true;
                break;
            case "three":
                display.appendText("3");
                buttonPressed[3] = true;
                break;
            case "four":
                display.appendText("4");
                buttonPressed[4] = true;
                break;
            case "five":
                display.appendText("5");
                buttonPressed[5] = true;
                break;
            case "six":
                display.appendText("6");
                buttonPressed[6] = true;
                break;
            case "seven":
                display.appendText("7");
                buttonPressed[7] = true;
                break;
            case "eight":
                display.appendText("8");
                buttonPressed[8] = true;
                break;
            case "nine":
                display.appendText("9");
                buttonPressed[9] = true;
                break;
            case "comma":
                if(COMMA_FLAG) {
                    display.appendText(".");
                    COMMA_FLAG = false;
                }
                break;
            case "ac":
                display.setText("");
                COMMA_FLAG = true;
        }

    }

    @FXML
    private void changeSign(){
        double num = Double.parseDouble(display.getText());
        try{
            if (num != 0) {
                num = num * (-1);
                display.setText(num + "");
                System.out.println(num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void operation(ActionEvent event){
        Button btn = (Button) event.getSource();
        switch (btn.getId()){
            case "plus":
                if(!display.getText().isEmpty()) {
                    data = Double.parseDouble(display.getText());
                }
                operation = 1;
                display.setText("");
                COMMA_FLAG = true;
                break;
            case "minus":
                if(!display.getText().isEmpty()) {
                    data = Double.parseDouble(display.getText());
                }
                operation = 2;
                display.setText("");
                COMMA_FLAG = true;
                break;
            case "times":
                if(!display.getText().isEmpty()) {
                    data = Double.parseDouble(display.getText());
                }
                operation = 3;
                display.setText("");
                COMMA_FLAG = true;
                break;
            case "divide":
                data = Double.parseDouble(display.getText());
                operation = 4;
                display.setText("");
                COMMA_FLAG = true;
                break;
            case "percent":
                if(!display.getText().isEmpty()) {
                    data = Double.parseDouble(display.getText());
                }
                String percentText = display.getText() + "%";
                operation = 5;
                display.setText(percentText);
                COMMA_FLAG = true;
        }
    }

    @FXML
    public void result(){
        switch(operation){
            case 1:
                secNum = Double.parseDouble(display.getText());
                result = data + secNum;
                display.setText(String.valueOf(result));
                break;
            case 2:
                secNum = Double.parseDouble(display.getText());
                result = data - secNum;
                display.setText(String.valueOf(result));
                break;
            case 3:
                secNum = Double.parseDouble(display.getText());
                result = secNum * data;
                display.setText(String.valueOf(result));
                break;
            case 4:
                try {
                    secNum = Double.parseDouble(display.getText());
                    result = data / secNum;
                }catch(Exception e){
                    display.setText("Error");
                }
                display.setText(String.valueOf(result));
                break;
            case 5:
                result = data / 100;
                display.setText(String.valueOf(result));
                break;
        }
    }



}
