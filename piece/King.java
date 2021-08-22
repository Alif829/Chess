package Game.piece;

import Game.Alliance;
import Game.board.Board;
import Game.board.BoardUtils;
import Game.board.Move;
import Game.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static Game.board.Move.*;

public class King extends Piece
{
    private final static int[] CandidateMoveVectorCoordinate={ -11,-10,-9,-1,1,9,10,11 };

    public King(int piecePositions, Alliance pieceAlliance) {
        super(piecePositions, pieceAlliance);
    }

    @Override
    public Collection<Move> validMoves(Board board)
    {
        final List<Move> legalMoves=new ArrayList<>();

        for (final int currentCandidateofset:CandidateMoveVectorCoordinate)
        {
            final int candidateDestinationcoordinate=this.piecePositions+currentCandidateofset;
            if (isFirstColoumnExclusion(this.piecePositions,currentCandidateofset)
                || isTenthColoumnExclusion(this.piecePositions,currentCandidateofset))
            {
                continue;
            }

            if (BoardUtils.isValidTileCoordinate(candidateDestinationcoordinate))
            {
                final Tile candidateDestinationTile=board.getTile(candidateDestinationcoordinate);
                if(!candidateDestinationTile.isOccupied())
                {
                    legalMoves.add(new MajorMove(board,this,candidateDestinationcoordinate));
                }
                else
                {
                    final Piece pieceAtDestination=candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance!=pieceAlliance)
                    {
                        legalMoves.add(new AttackMove(board,this,candidateDestinationcoordinate,pieceAtDestination));
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }

    private static boolean isFirstColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.FirstColoumn[currentPosition] && ((candidateOfset==-11) ||(candidateOfset==-1)||(candidateOfset==9));
    }

    private static boolean isTenthColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.TenthColoumn[currentPosition] && ((candidateOfset==11) ||(candidateOfset==1)||(candidateOfset==-9));
    }
}
