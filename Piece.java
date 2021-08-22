
package Game.piece;

import Game.Alliance;
import Game.board.Board;
import Game.board.Move;

import java.util.Collection;
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

    public int getPiecePositions()
    {
        return this.piecePositions;
    }

    public Alliance getPieceAlliance()
    {
        return this.pieceAlliance;
    }

    public abstract Collection<Move> validMoves(final Board board);  //gives a arraylist of legal moves for a piece
}
