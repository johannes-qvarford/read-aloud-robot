package net.qvarford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        String s1 = "temp/The House in Fata Morgana (PS5) Walkthrough part 13 Endings 1-3 (4K 60 FPS).mp4";
        Media media = new Media(new File(s1).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setMute(true);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnError(() -> {
            // TODO: Need pulseaudio to work in WSL or run on Windows
            System.out.println("Error!!! " + mediaPlayer.getError());
        });

        MediaView mediaView = new MediaView(mediaPlayer);

        Scene scene = new Scene(new StackPane(mediaView), media.getWidth(), media.getHeight());

        mediaPlayer.setOnReady(() -> {
            stage.setHeight(media.getHeight());
            stage.setWidth(media.getWidth());
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        launch();
    }

}