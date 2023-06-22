package application;

import java.net.URL;

import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView; 

public class PlaySong extends Thread {
	public void run() {
		this.playAudio();
	}
	String audioName;
    boolean audioType;
    private Media audio2;
    
    private void playAudio(){
        try{
        	final URL resource = getClass().getResource(audioName+".mp3");
        	final Media media = new Media(resource.toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            if(this.audioType) mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
            mediaPlayer.play();

            while (!Thread.currentThread().isInterrupted() && audioType) {}
            if(!audioType) Thread.sleep(2000); // Sleep for 1000ms(1 Sec) and then it will stop the audio which has type false
            mediaPlayer.stop();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	PlaySong(String audioName, boolean audioType){
        this.audioName=audioName;
        this.audioType=audioType;
    }
}
