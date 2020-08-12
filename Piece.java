
package Game.piece;

import Game.Alliance;
import Game.board.Board;
import Game.board.Move;

import java.util.List;

public abstract class Piece
{
    protected final int piecePositions;
    protected final Alliance pieceAlliance;

    public Piece(final int piecePositions,final Alliance pieceAlliance)
    {
        this.piecePositions=piecePositions;
        this.pieceAlliance=pieceAlliance;
    }

    public abstract List<Move> validMoves(final Board board);  //gives a arraylist of legal moves for a piece
}
