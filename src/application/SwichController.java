package application;

import javafx.stage.Stage;

public class SwichController {
	
	public void StartGame() throws Exception {
		Teteis a = new Teteis();
		Stage stage = new Stage();
		a.start(stage);
		
		
	}
}
