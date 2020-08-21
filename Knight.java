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

public class Knight extends Piece
{
    private final static int[] moveCoordinates={-17,-15,-10,-6,6,10,15,17};

    public Knight(final int piecePositions,final Alliance pieceAlliance)
    {
        super(piecePositions, pieceAlliance);
    }

    @Override
    public Collection<Move> validMoves(Board board)
    {
        final List<Move> legalMoves=new ArrayList<>();

        for (final int currentCandidateOffset:moveCoordinates)
        {
            final int destinationCoordinates=this.piecePositions+currentCandidateOffset;
            if (BoardUtils.isValidTileCoordinate(destinationCoordinates))
            {
                if(isFirstColoumnExclusion(this.piecePositions,currentCandidateOffset)||
                        isSecondColoumnExclusion(this.piecePositions,currentCandidateOffset)||
                        isSeventhColoumnExclusion(this.piecePositions,currentCandidateOffset)||
                        isEighthColoumnExclusion(this.piecePositions,currentCandidateOffset))
                {
                    continue;
                }
                final Tile candidateDestinationTile=board.getTile(destinationCoordinates);
                if(!candidateDestinationTile.isOccupied())
                {
                    legalMoves.add(new Move());
                }
                else
                {
                    final Piece pieceAtDestination=candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance!=pieceAlliance)
                    {
                        legalMoves.add(new Move());
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }

    private static boolean isFirstColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.FirstColoumn[currentPosition] && ((candidateOfset==-17) ||(candidateOfset==-10)||(candidateOfset==6)||(candidateOfset==15));
    }

    private static boolean isSecondColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.SecondColoumn[currentPosition] && ((candidateOfset==-10)||(candidateOfset==6));
    }

    private static boolean isSeventhColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.SeventhColoumn[currentPosition] && ((candidateOfset==-6)||(candidateOfset==10));
    }

    private static boolean isEighthColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.EighthColoumn[currentPosition] && ((candidateOfset==17) ||(candidateOfset==10)||(candidateOfset==-6)||(candidateOfset==-15));
    }

}
