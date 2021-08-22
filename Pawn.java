package Game.piece;

import Game.Alliance;
import Game.board.Board;
import Game.board.BoardUtils;
import Game.board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece
{
    private final static int[] CandidateMoveVectorCoordinate={ 8,16,7,9 };

    public Pawn(final int piecePositions, final Alliance pieceAlliance) {
        super(piecePositions, pieceAlliance);
    }

    @Override
    public Collection<Move> validMoves(final Board board)
    {
        final List<Move> legalMoves=new ArrayList<>();
        for (final int currentCandidateofset:CandidateMoveVectorCoordinate)
        {
            final int candidateDestinationCoordinate = this.piecePositions+(this.pieceAlliance.getDirection()*currentCandidateofset);
            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate))
            {
                continue;
            }
            if(currentCandidateofset==0 && !board.getTile(candidateDestinationCoordinate).isOccupied())
            {
                //Todo
                legalMoves.add(new Move.MajorMove(board,this,candidateDestinationCoordinate));
            }
            else if(currentCandidateofset=16 && this.isFirstMove)
            if (this.getPieceAlliance().isRed() || this.getPieceAlliance().isGreen())
            {
                candidateDestinationCoordinate=this.piecePositions+(this.getPieceAlliance().getDirection());
            }
            if (this.getPieceAlliance().isBlack() || this.getPieceAlliance().isWhite())
            {
                candidateDestinationCoordinate = this.piecePositions + (this.getPieceAlliance().getDirection() * currentCandidateofset);
            }
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate))
            {
                continue;
            }
            if (currentCandidateofset==10  && !board.getTile(candidateDestinationCoordinate).isOccupied())
            {
                //More work
                legalMoves.add(new Move.MajorMove(board,this,candidateDestinationCoordinate));
            }
            else if (currentCandidateofset==9 &&
                    !((BoardUtils.TenthColoumn[this.piecePositions] && this.pieceAlliance.isWhite() ||
                    (BoardUtils.FirstColoumn[this.piecePositions] && this.pieceAlliance.isBlack()))))
            {
                if (board.getTile(candidateDestinationCoordinate).isOccupied())
                {
                    final Piece pieceOncandiate=board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance!=pieceOncandiate.getPieceAlliance())
                    {
                        //Needs more work
                        legalMoves.add(new Move.MajorMove(board,this,candidateDestinationCoordinate));
                    }
                }
            }
            else if (currentCandidateofset==11 &&
                    !((BoardUtils.FirstColoumn[this.piecePositions] && this.pieceAlliance.isWhite() ||
                    (BoardUtils.TenthColoumn[this.piecePositions] && this.pieceAlliance.isBlack()))))
            {
                if (board.getTile(candidateDestinationCoordinate).isOccupied())
                {
                    final Piece pieceOncandiate=board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance!=pieceOncandiate.getPieceAlliance())
                    {
                        //Needs more work
                        legalMoves.add(new Move.MajorMove(board,this,candidateDestinationCoordinate));
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }
}
