/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package teistris.model;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public abstract class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    protected Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    protected Square squares[];

    /**
     * Método que devolve o array de cadrados.
     *
     * @return o array de cadrados.
     */
    public Square[] getSquares() {
        return squares;
    }

    /**
     * @return o obxecto xogo
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game o obxecto xogo
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
        for (Square square : squares) {
            if (!game.isValidPosition(square.getX() + Game.SQUARE_SIDE, square.getY())) {
                return false;
            }
        }

        for (Square square : squares) {
            square.setX(square.getX() + Game.SQUARE_SIDE);
        }
        return true;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {

        for (Square square : squares) {
            if (!game.isValidPosition(square.getX() - Game.SQUARE_SIDE, square.getY())) {
                return false;
            }
        }

        for (Square square : squares) {
            square.setX(square.getX() - Game.SQUARE_SIDE);
        }
        return true;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {

        for (Square square : squares) {
            if (!game.isValidPosition(square.getX(), square.getY() + Game.SQUARE_SIDE)) {
                return false;
            }
        }

        for (Square square : squares) {
            square.setY(square.getY() + Game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        //método que non fai nada, xa que cada obxecto peza debe implementar o método
        return true;
    }
}
