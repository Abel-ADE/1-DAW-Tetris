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

import java.awt.Color;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public class BarPiece extends Piece {

    private int position;

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game
     */
    public BarPiece(Game game) {
        this.game = game;
        squares = new Square[4];
        //Imprimo en pantalla a ficha
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * i, Color.YELLOW, game);

        }
        position = 0;
    }

    @Override
    public boolean rotate() {
        boolean validPosition = true;

        if (position == 0) {

            validPosition = game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                    & game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                    & game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2, squares[3].getY() - Game.SQUARE_SIDE * 2);

            if (validPosition) {
                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);
                squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);

                position = 1;
                return validPosition;
            }

        } else if (position == 1) {

            validPosition = game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                    & game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                    & game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE * 2, squares[3].getY() + Game.SQUARE_SIDE * 2);
            
            if (validPosition) {
                
                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE * 2);
                squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE * 2);
                
                position = 0;
                return validPosition;
            }
        }

        return validPosition;
    }

}
