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
public class SquarePiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     * @param game 
     */
    public SquarePiece(Game game) {
        this.game = game;
        squares = new Square[4];
        getSquares()[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        getSquares()[1] = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        getSquares()[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                Color.BLUE, game);
        getSquares()[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

}
