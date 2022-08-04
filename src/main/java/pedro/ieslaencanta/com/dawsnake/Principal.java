/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawsnake;

import pedro.ieslaencanta.com.dawsnake.game.Game;
import pedro.ieslaencanta.com.dawsnake.game.Size;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Pedro
 */
public class Principal extends Application {

    private Game game;
    Scene scene;
    private Canvas canvas;
    private Canvas bg_canvas;
    private int width = 480;
    private int height = 480;
    private Image icono;
    private String pathicono = "serpiente.png";

    @Override
    public void start(Stage stage) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        this.icono = new Image(classLoader.getResource(this.pathicono).toString());
        this.canvas = new Canvas(this.width, this.height);
        this.bg_canvas= new Canvas(this.width,this.height);
        StackPane panel = new StackPane(this.bg_canvas,this.canvas);
        this.scene = new Scene(panel, this.width, this.height);

        stage.setTitle("DAW Snake - Mateo");
        stage.setResizable(false);
        stage.getIcons().add(icono);

        /*<a href="https://www.flaticon.es/iconos-gratis/serpiente" title="serpiente iconos">Serpiente iconos creados por Freepik - Flaticon</a>*/
        stage.setScene(scene);
        //para que cierre al pulsar el icono
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        this.initGame();
        this.registerKeys();
        stage.show();
    }

    private void registerKeys() {
        scene.setOnKeyReleased(e -> {
            this.game.OnKeyRelease(
                    e.getCode());
        });
        scene.setOnKeyPressed(e -> {
            this.game.OnKeyPress(e.getCode());

        });

    }

    private void initGame() {
        try {
          
            //se crea el texto
            String path=getClass().getResource("/WONDER.TTF").toURI().toString();
          
            Font f= Font.loadFont(path, 10);
           
            this.game= new Game(this.canvas.getGraphicsContext2D(),
                    this.bg_canvas.getGraphicsContext2D(), 
                    new Size(this.width,this.height),new Size(this.width/20,this.height/20));
            this.game.setDebug(true);
            game.start();
           
        } catch (URISyntaxException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
