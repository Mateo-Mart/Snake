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
import pedro.ieslaencanta.com.dawsnake.game.Game;
import pedro.ieslaencanta.com.dawsnake.game.Size;

/**
 *
 * @author Mateo
 */
public final class Food extends Entity {

    private Image imagencomida;
    private String pathcomida = "images.png";
    private ClassLoader classLoader = getClass().getClassLoader();
    private int tipo;

    public Food() {
        super();
    }

    public Food(Coordenada p, Size t, Color c) {
        super(c, p, t);
        this.tipo = (int) (Math.random() * 4);
        this.imagencomida = new Image(classLoader.getResource(this.pathcomida).toString());
    }

    public int coordenadaseguntipo() {
        int vuelta;
        vuelta = switch (this.tipo) {
            case 0 -> 0;
            case 1 -> 18;
            case 2 -> 34;
            case 3 -> 51;
            default -> 0;
        };
        return vuelta;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(imagencomida, this.coordenadaseguntipo(), 16, 16, 16, this.posicion.getX() * Snake.part_size.getWidth(), this.posicion.getY() * Snake.part_size.getHeight(), Snake.part_size.getWidth(), Snake.part_size.getHeight());//gc.setFill(this.color);        gc.fillRect(this.posicion.getX() * Snake.part_size.getHeight(), this.posicion.getY() * Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());        //gc.fillRect(6 * Snake.part_size.getHeight(),6* Snake.part_size.getWidth(), Snake.part_size.getHeight(), Snake.part_size.getWidth());
    }

}
