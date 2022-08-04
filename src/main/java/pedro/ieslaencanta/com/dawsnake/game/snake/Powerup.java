/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro.ieslaencanta.com.dawsnake.game.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import pedro.ieslaencanta.com.dawsnake.game.Coordenada;
import pedro.ieslaencanta.com.dawsnake.game.Size;

/**
 *
 * @author Mateo
 */
public class Powerup extends Entity{
    private Image imagen;
    private String path = "images.png";
    private ClassLoader classLoader = getClass().getClassLoader();

    public Powerup() {
        super();
    }

    public Powerup(Coordenada p, Size t, Color c) {
        super(c, p, t);
        this.imagen = new Image(classLoader.getResource(this.path).toString());
    }

  

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(imagen, 85, 16, 16, 16, this.posicion.getX() * Snake.part_size.getWidth(), this.posicion.getY() * Snake.part_size.getHeight(), Snake.part_size.getWidth(), Snake.part_size.getHeight());//gc.setFill(this.color);        gc.fillRect(this.posicion.getX() * Snake.part_size.getHeight(), this.posicion.getY() * Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());        //gc.fillRect(6 * Snake.part_size.getHeight(),6* Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());
    }

    @Override
    public String toString() {
        return this.posicion.toString();
    }
    

}
