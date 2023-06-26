package application;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import java.net.URL;
public class Main extends Application {

	Stage stage=new Stage();
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage)throws Exception {
          
//    	music();
    	PlaySong p = new PlaySong("gamesong",true);
    	p.start();
    	AnchorPane root = new AnchorPane();
        
        Label label = new Label("Click Button To start Game ");
        label.setLayoutX(149);
        label.setLayoutY(39);
        label.setTextFill(javafx.scene.paint.Color.web("#ff0808"));
        label.setFont(new Font("System Bold", 30));

        Button button = new Button("START GAME");
        button.setLayoutX(253);
        button.setLayoutY(285);
        button.setOnAction(e -> {
		PlaySong buttonClicked=new PlaySong("ClickButton",false);
		buttonClicked.start();
        	primaryStage.close();
        	try {
			startGame();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        });

        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("T E T R I S");
        primaryStage.show();
    }

    public void ExitGame() throws IOException {
    	
    	Stage sc = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("exitpage.fxml"));
		Scene scene = new Scene(root);
		sc.setScene(scene);
		sc.show();
		
    }
    public void ExitButton()
    {
    	System.exit(0);
    }
    public void RestartButton() throws Exception
    {
    	Teteis t = new Teteis();
    	
    	t.start(new Stage());
        System.out.println("Game started!");
    }
    private void startGame() throws Exception {
    	Teteis t = new Teteis();
    	t.start(stage);
        System.out.println("Game started!");
    }
   
    
}
