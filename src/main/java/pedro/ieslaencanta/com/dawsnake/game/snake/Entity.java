/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro.ieslaencanta.com.dawsnake.game.snake;

import javafx.scene.paint.Color;
import pedro.ieslaencanta.com.dawsnake.game.Coordenada;
import pedro.ieslaencanta.com.dawsnake.game.IDrawable;
import pedro.ieslaencanta.com.dawsnake.game.Size;

/**
 *
 * @author Mateo
 */
public abstract class Entity implements IDrawable {

    protected Coordenada posicion;
    protected Size size;
    protected Color color;

    public Entity() {
    }

    public Entity(Color c, Size s) {
        this.color = c;
        this.posicion = null;
        this.size = s;
    }
    public Entity(Color c, Coordenada p, Size s) {
        this.color = c;
        this.posicion = p;
        this.size = s;
    }

    /**
     * @return the posicion
     */
    public Coordenada getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the size
     */
    public Size getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
