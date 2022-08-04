/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawsnake.game.snake;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import pedro.ieslaencanta.com.dawsnake.game.Coordenada;
import pedro.ieslaencanta.com.dawsnake.game.Direction;
import pedro.ieslaencanta.com.dawsnake.game.Game;
import pedro.ieslaencanta.com.dawsnake.game.IDrawable;
import pedro.ieslaencanta.com.dawsnake.game.Size;

/**
 *
 * @author Pedro
 */
public class Snake implements IDrawable {

    public enum State {
        OK,
        COLISION
    }
    private boolean conpowerup;
    private State state;
    private Direction direction;
    private LinkedList<SnakePart> snake;
    //MODIFICAR ESTO A PRIVADO LUEGO ARREGLANDOLO
    public static Size part_size;

    public Snake() {
        this.state = State.OK;
        this.direction = Direction.LEFT;
        this.conpowerup = false;
        this.snake = new LinkedList<>();
        this.snake.push(new SnakePart(new Coordenada(10, 10), Color.BLUE, part_size));
    }

    public void addpart() {
        int col, row;
        SnakePart tempo;
        SnakePart cola = this.snake.peekLast();
        row = cola.getPosicion().getX();
        col = cola.getPosicion().getY();
        if (this.snake.size() == 1) {
            switch (this.getDirection()) {
                case LEFT:
                    row++;
                    break;
                case RIGHT:
                    row--;
                    break;
                case UP:
                    col++;
                    break;
                case DOWN:
                    row--;
                    break;
            }
            System.out.println("Añado en la cabeza");
        } else {
            System.out.println("Añado en otro sitio que no es la cabeza");
        }

        tempo = new SnakePart(new Coordenada(row, col), this.snake.peekLast().getColor(), part_size);
        this.snake.addLast(tempo);
    }

    public State DetectarColisionBordes(Size s) {
        boolean caso1, caso2, caso3, caso4;
        caso1 = this.snake.peek().getPosicion().getX() < 0;
        caso2 = this.snake.peek().getPosicion().getY() < 0;
        caso3 = this.snake.peek().getPosicion().getX() >= s.getWidth() - 4;
        caso4 = this.snake.peek().getPosicion().getY() >= s.getHeight() - 4;
        if (caso1
                || caso2
                || caso3
                || caso4) {
            if (this.isConpowerup() == true) {
                if (caso1) {
                    this.snake.peek().setPosicion(new Coordenada(s.getWidth() - 4, this.snake.peek().getPosicion().getY()));
                } else if (caso2) {
                    this.snake.peek().setPosicion(new Coordenada(this.snake.peek().getPosicion().getX(), s.getHeight() - 4));
                } else if (caso3) {
                    this.snake.peek().setPosicion(new Coordenada(0, this.snake.peek().getPosicion().getY()));
                } else if (caso4) {
                    this.snake.peek().setPosicion(new Coordenada(this.snake.peek().getPosicion().getX(), 0));
                }
            } else {
                System.out.println("Colisión Detectada");
                this.state = State.COLISION;
            }
        }
        return this.state;
    }

    public void Powerup() {
        SnakePart tempo;//=this.snake.peek();
        Iterator<SnakePart> iterador = this.snake.listIterator(1);
        Color color = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        while (iterador.hasNext()) {
            tempo = iterador.next();
            tempo.setColor(color);
        }
    }

    public State DetectarColisionSerpiente(Size s) {
        SnakePart tempo;
        Coordenada comparación = this.snake.peek().getPosicion();
        Iterator<SnakePart> iterador = this.snake.listIterator(1);
        while (iterador.hasNext()) {
            tempo = iterador.next();
            if (tempo.getPosicion().compareTo(comparación) == 0) {
                this.state = State.COLISION;
            }
        }
        return this.state;
    }

    public void EliminarCola() {
        SnakePart temporal = this.snake.peek();
        this.snake.clear();
        this.snake.push(temporal);
    }

    /**
     * vuelve la serpiente
     *
     * @param s
     * @return devuelve el estado de la serpiente correcto,toca borde, se toca a
     * ella misma
     */
    public State move(Size s) {
        SnakePart temporal = this.snake.peek();
        Iterator<SnakePart> iterador = this.snake.iterator();//.listIterator(1);
        Coordenada coordtempo = temporal.getPosicion().clone();
        switch (this.getDirection()) {
            case LEFT:
                this.snake.peek().getPosicion().setX(this.snake.peek().getPosicion().getX() - 1);
                break;
            case RIGHT:
                this.snake.peek().getPosicion().setX(this.snake.peek().getPosicion().getX() + 1);
                break;
            case UP:
                this.snake.peek().getPosicion().setY(this.snake.peek().getPosicion().getY() - 1);
                break;
            case DOWN:
                this.snake.peek().getPosicion().setY(this.snake.peek().getPosicion().getY() + 1);
                break;
        }
        iterador.next();
        while (iterador.hasNext()) {
            temporal = iterador.next();
            Coordenada tempocambio = temporal.getPosicion().clone();
            temporal.setPosicion(coordtempo);
            coordtempo = tempocambio;
        }

        return this.state;
    }

    public void setDirection(Direction d) {
        this.direction = d;

    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    public int coordenadasegundireccion() {
        int vuelta;
        vuelta = switch (this.getDirection()) {
            case LEFT ->
                15;
            case RIGHT ->
                0;
            case UP ->
                43;
            case DOWN ->
                29;
            default ->
                0;
        };
        return vuelta;
    }

    @Override
    public void draw(GraphicsContext gc) {
        SnakePart temporal;
        Iterator<SnakePart> iterador = this.snake.listIterator(1);
        int tamano = 16;
        if (this.getDirection() == Direction.UP || this.getDirection() == Direction.DOWN) {
            tamano = 12;
        }
        this.snake.peek().drawHead(gc, this.coordenadasegundireccion(), tamano);
        while (iterador.hasNext() == true) {
            temporal = iterador.next();
            gc.setFill(temporal.getColor());
            temporal.draw(gc);
        }
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * @return the part_size
     */
    public Size getPart_size() {
        return part_size;
    }

    /**
     * @param part_size the part_size to set
     */
    public void setPart_size(Size part_size) {
        this.part_size = part_size;
    }

    /**
     * @return the conpowerup
     */
    public boolean isConpowerup() {
        return conpowerup;
    }

    /**
     * @param conpowerup the conpowerup to set
     */
    public void setConpowerup(boolean conpowerup) {
        this.conpowerup = conpowerup;
    }

    /**
     * @return the snake
     */
    public LinkedList<SnakePart> getSnake() {
        return snake;
    }

    /**
     * @param snake the snake to set
     */
    public void setSnake(LinkedList<SnakePart> snake) {
        this.snake = snake;
    }

}
