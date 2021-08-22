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

public class Queen extends Piece
{
    private final static int[] CandidateMoveVectorCoordinate={ -9,-8,-7,-1,1,7,8,9 };

    public Queen(int piecePositions, Alliance pieceAlliance) {
        super(piecePositions, pieceAlliance);
    }

    @Override
    public Collection<Move> validMoves(final Board board)
    {
        final List<Move> legalMoves=new ArrayList<>();

        for (final int candidatecCoordinateOffset:CandidateMoveVectorCoordinate)
        {
            int destinationCoordinate=this.piecePositions;

            while (BoardUtils.isValidTileCoordinate(destinationCoordinate))
            {
                if (isFirstColoumnExclusion(destinationCoordinate,candidatecCoordinateOffset)||
                        isTenthColoumnExclusion(destinationCoordinate,candidatecCoordinateOffset))
                {
                    break;
                }

                destinationCoordinate+=candidatecCoordinateOffset;
                if (BoardUtils.isValidTileCoordinate(destinationCoordinate))
                {
                    final Tile candidateDestinationTile=board.getTile(destinationCoordinate);
                    if(!candidateDestinationTile.isOccupied())
                    {
                        legalMoves.add(new Move.MajorMove(board,this,destinationCoordinate));
                    }
                    else
                    {
                        final Piece pieceAtDestination=candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance=pieceAtDestination.getPieceAlliance();
                        if (this.pieceAlliance!=pieceAlliance)
                        {
                            legalMoves.add(new Move.AttackMove(board,this,destinationCoordinate,pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private static boolean isFirstColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.FirstColoumn[currentPosition] && ((candidateOfset==-1)||(candidateOfset==-9)||(candidateOfset==7));
    }
    private static boolean isTenthColoumnExclusion(final int currentPosition,final int candidateOfset)
    {
        return BoardUtils.EighthColoumn[currentPosition] && ((candidateOfset==-7)||(candidateOfset==1) ||(candidateOfset==9));
    }
}
