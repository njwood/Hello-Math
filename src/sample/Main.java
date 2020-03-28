package sample;

import javafx.application.Application;import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    TextField txtnum1, txtnum2;
    Button btnadd, btndiv, btnmul, btnsub, btnclear;
    Label lblanswer;

    @Override
    public void start(Stage primaryStage) throws Exception{

        txtnum1 = new TextField();
        txtnum2 = new TextField();
        btnadd = new Button("+");
        btnsub = new Button("-");
        btnmul = new Button("*");
        btndiv = new Button("/");
        btnclear = new Button("Clear");
        lblanswer = new Label("?");

        lblanswer.setAlignment(Pos.CENTER);
        lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);

        root.setVgap(10);
        root.setHgap(10);

        root.add(btnadd,0,0);
        root.add(btnsub,1,0);
        root.add(btnmul,0,1);
        root.add(btndiv,1,1);
        root.add(txtnum1,0,2);
        root.add(txtnum2,1,2);

        root.add(lblanswer, 0, 3, 2, 1);
        root.add(btnclear, 0, 4, 2 ,1);

        setWidths();
        attachCode();

        Scene scene = new Scene(root, 300,250);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setWidths(){
        // Set Standard Widths
        txtnum1.setPrefWidth(70);
        txtnum2.setPrefWidth(70);
        btnadd.setPrefWidth(70);
        btnsub.setPrefWidth(70);
        btnmul.setPrefWidth(70);
        btndiv.setPrefWidth(70);
        lblanswer.setPrefWidth(150);
        btnclear.setPrefWidth(150);
    }

    public void attachCode(){
        btnadd.setOnAction(e -> btncode(e));
        btnsub.setOnAction(e -> btncode(e));
        btnmul.setOnAction(e -> btncode(e));
        btndiv.setOnAction(e -> btncode(e));
        btnclear.setOnAction(e -> btncode(e));
    }

    public void btncode(ActionEvent e){
        int num1, num2, answer;
        char symbol;

        // Parameter e stores what value was clicked on the calculator

        if(e.getSource() == btnclear){
            txtnum1.setText("");
            txtnum2.setText("");
            lblanswer.setText("?");
            txtnum1.requestFocus();
            return;
        }

        num1 = Integer.parseInt(txtnum1.getText());
        num2 = Integer.parseInt(txtnum2.getText());

        if(e.getSource() == btnsub){
            symbol = '-';
            answer = num1 - num2;
        }
        else if(e.getSource() == btnadd){
            symbol = '+';
            answer = num1 + num2;
        }
        else if(e.getSource() == btndiv){
            symbol = '/';
            answer = num1/num2;
        }
        else{
            symbol = '*';
            answer = num1*num2;
        }

        lblanswer.setText("" + num1 + symbol + num1 + "=" + answer);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
