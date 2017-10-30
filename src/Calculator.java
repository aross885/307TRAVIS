import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Calculator extends Application {
   
   TextField txtnum1, txtnum2;
   Button btnadd, btnsub, btndiv, btnmul, btnclear;
   Label lblanswer;
   
   public interface ButtonInterface {
	   void operate();
   }
   
   public class AddButton implements ButtonInterface {
	  public AddButton() {
		  btnadd = new Button("+");
		  btnadd.setOnAction(e -> btncode(e));
		  
	  }
	   public void operate() {
		   
		    
		
	   }
   	}
   
   public class SubButton implements ButtonInterface {
	   public SubButton() {
			  btnsub = new Button("-");
			  btnsub.setOnAction(e -> btncode(e));
			  
		  }
		@Override
		public void operate() {
			btnsub.setOnAction(e -> btncode(e));
			
		}
		   
   }

   public class DivButton implements ButtonInterface {
	   public DivButton() {
			  btndiv = new Button("/");
			  btndiv.setOnAction(e -> btncode(e));
			  
		  }
		@Override
		public void operate() {
			btndiv.setOnAction(e -> btncode(e));
			
		}
	   
   }
   
   public class MulButton implements ButtonInterface {
	   public MulButton() {
			  btnmul = new Button("x");
			  btnmul.setOnAction(e -> btncode(e));
			  
		  }
		@Override
		public void operate() {
			btnmul.setOnAction(e -> btncode(e));
			
		}
	   
   }
   
   public class ButtonFactory {
	   
	   public Button getButton(String buttonType) {
		   if ( buttonType == null) {
			   return null;
		   }
		   else if (buttonType.equalsIgnoreCase("ADD") ) {
			   return new Button("+");
		   }
		   else if (buttonType.equalsIgnoreCase("SUBTRACT") ) {
			   return new Button("-");
		   }
		   else if (buttonType.equalsIgnoreCase("MULTIPLY") ) {
			   return new Button("x");
		   }
		   else if (buttonType.equalsIgnoreCase("DIVIDE") ) {
			   return new Button("/");
		   }
		   return null;
		   
	   }
   }
   
     
    @Override
    public void start(Stage primaryStage) {
        //make the controls
        txtnum1=new TextField();
        txtnum2=new TextField();
        btnadd = new Button("+");
        //Button btnadd = ButtonFactory.getButton("ADD");
        btnsub=new Button("-");
        //Button btnsub = ButtonFactory.getButton("SUBTRACT");
        btnmul=new Button("x");
        //Button btnmul = ButtonFactory.getButton("MULTIPLY");
        btndiv=new Button("/");
        //Button btndiv = ButtonFactory.getButton("DIVIDE");
        btnclear=new Button("Clear");
        lblanswer=new Label("?");
        //center text in label
        lblanswer.setAlignment(Pos.CENTER);
        //apply ccs-like style to label (yes, you can)
        lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
       
        //make container for app
        GridPane root = new GridPane();
        //put container in middle of scene
        root.setAlignment(Pos.CENTER);
        //setspacing between controls in grid
        root.setHgap(10);
        root.setVgap(10);
        //add to grid, cell by cell
        root.add(btnadd,0,0);
        root.add(btnsub,1,0);
        root.add(btnmul,0,1);
        root.add(btndiv,1,1);
        root.add(txtnum1, 0,2);
        root.add(txtnum2,1,2);
        //last 2 rows span across 2 columns
        //col, rol, colspan, rowspan
        root.add(lblanswer,0,3,2,1);
        root.add(btnclear,0,4,2,1);
        //set widths of all controls in separate method
        setWidths();
        //attach buttons to code in separate method
        attachCode();
        //usual stuff
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Calculator NGA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setWidths(){
        //set widths of all controls
        txtnum1.setPrefWidth(80);
        txtnum2.setPrefWidth(80);
        btnadd.setPrefWidth(80);
        btnsub.setPrefWidth(80);
        btnmul.setPrefWidth(80);
        btndiv.setPrefWidth(80);
        btnclear.setPrefWidth(150);
        lblanswer.setPrefWidth(150);
    }
   
    public void attachCode()
    {
        //have each button run BTNCODE when clicked
        btnadd.setOnAction(e -> btncode(e));
        btnsub.setOnAction(e -> btncode(e));
        btnmul.setOnAction(e -> btncode(e));
        btndiv.setOnAction(e -> btncode(e));
        btnclear.setOnAction(e -> btncode(e));
    }
   
    public void btncode(ActionEvent e)
    {
       int num1, num2, answer;
        char symbol;
        //e tells us which button was clicked
        if(e.getSource()==btnclear)
        {
            txtnum1.setText("");
            txtnum2.setText("");
            lblanswer.setText("?");
            txtnum1.requestFocus();
            return;
        }
        //read numbers in from textfields
        num1=Integer.parseInt(txtnum1.getText());
        num2=Integer.parseInt(txtnum2.getText());
        if(e.getSource()==btnadd)
        {
            symbol='+';
            answer=num1+num2;
        }
        else if(e.getSource()==btnsub)
        {
            symbol='-';
            answer=num1-num2;
        }
        else if(e.getSource()==btnmul)
        {
            symbol='x';
            answer=num1*num2;
        }
        else
        {
            symbol='/';
            answer=num1/num2;
        }
        //display answer
        lblanswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }
   
    public static void main(String[] args) {
        launch(args);
    }
   
}
