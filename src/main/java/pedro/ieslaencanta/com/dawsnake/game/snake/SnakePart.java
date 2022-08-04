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
public class SnakePart extends Entity {

    public SnakePart() {
        super();
    }

    public SnakePart(Coordenada posicion, Color color, Size tamaño) {
        super(color, posicion, tamaño);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(this.posicion.getX() * Snake.part_size.getHeight(), this.posicion.getY() * Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());

    }

    public void drawHead(GraphicsContext gc,int direccion,int tamano) {
        Image imagen;
        String path = "images.png";
        ClassLoader classLoader = getClass().getClassLoader();
        imagen = new Image(classLoader.getResource(path).toString());

        gc.drawImage(imagen, direccion, 0, tamano, 16, this.posicion.getX() * Snake.part_size.getWidth(), this.posicion.getY() * Snake.part_size.getHeight(), Snake.part_size.getWidth(), Snake.part_size.getHeight());//gc.setFill(this.color);        gc.fillRect(this.posicion.getX() * Snake.part_size.getHeight(), this.posicion.getY() * Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());        //gc.fillRect(6 * Snake.part_size.getHeight(),6* Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());

    }

}
