package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Square;

public class SquareController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private Button generate;

    @FXML
    private TextField txtOrder;

    @FXML
    private Label txtAdvice;

    @FXML
    private ChoiceBox<String> startOption;

    @FXML
    private ChoiceBox<String> wayOption;
    
    private Square s;
    
    public int startValue(String first) {
    	int n = 0;
    	if(first.equals("UP")) {
    		n=1;
    	}else if(first.equals("DOWN")) {
    		n=2;
    	}else if(first.equals("LEFT")) {
    		n=3;
    	}else {
    		n=4;
    	}
    	return n;
    }
    
    public int wayValue(String way) {
    	int n = 0;
    	if(way.equals("NO")) {
    		n=1;
    	}else if(way.equals("NE")) {
    		n=2;
    	}else if(way.equals("SO")) {
    		n=3;
    	}else {
    		n=4;
    	}
    	return n;
    }
    
    public void generateSquare(ActionEvent event) {
    	grid.getChildren().clear();
    	grid.setGridLinesVisible(true);
    	int o = Integer.parseInt(txtOrder.getText());
    	s.setOrder(o);
    	
    	if(s.check()) {
    		txtAdvice.setVisible(false);
    		grid.setGridLinesVisible(true);
    		System.out.println("Generando...");
        	
        	String first = startOption.getValue();
        	String way = wayOption.getValue();
        	int f = startValue(first);
        	int w = wayValue(way);
        	
        	
        	int[][] matrix = s.generate(o);
        	s.fill(f, w, matrix, o);
        	
        	for(int i=0; i < matrix.length; i++) {
        		for(int j=0; j < matrix.length; j++) {
        			if(j==matrix.length-1) {
        				System.out.print(matrix[i][j]+"\t\n");
        			}else {
        				System.out.print(matrix[i][j]+"\t");
        			}
        			Button label = new Button(matrix[i][j]+"");
        			grid.add(label, j, i);
        		}
        	}
    	}else {
    		txtAdvice.setVisible(true);
    	}
    	
    	
    }

    @FXML
    void initialize() {
    	s = new Square();
    	startOption.getItems().add("UP");
    	startOption.getItems().add("DOWN");
    	//startOption.getItems().add("LEFT");
    	//startOption.getItems().add("RIGHT");
    	
    	wayOption.getItems().add("NO");
    	wayOption.getItems().add("NE");
    	wayOption.getItems().add("SO");
    	wayOption.getItems().add("SE");
    }
}
