package PlaySongDemo;

import java.io.File;
import java.net.URI;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayList {

  private Queue<String> q = new LinkedBlockingQueue<>();
 // private MediaPlayer mediaPlayer;
 
  public PlayList() {
    q = new LinkedBlockingQueue<String>();
  }

  public Queue<String> getQueue() {
    return q;
  }

  public void queueUpNextSong(String songToAdd) {
    if (q.isEmpty()) {
      q.add(songToAdd);
      playSongIfThereIsOneToPlay();
    } else {
      q.add(songToAdd);
    }
  }

  public void playSongIfThereIsOneToPlay() {
    if (q.isEmpty())
      return;
    else {
      // play the next song
      String nextSong = q.peek();
      
      File file = new File("songfiles/" + nextSong);
      URI uri = file.toURI();
      System.out.println(uri);
      // Play one mp3 
      Media media = new Media(uri.toString());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.play();
      mediaPlayer.setOnEndOfMedia(new Waiter());
      mediaPlayer.play();
    }
  }

  private class Waiter implements Runnable {

    @Override
    public void run() {
      q.remove();
      try {
        Thread.sleep(2000); // 2 seconds
   } catch (InterruptedException e) {
     e.printStackTrace();
   }

      playSongIfThereIsOneToPlay();
    }
  }

 }