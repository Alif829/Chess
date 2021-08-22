package Game.board;

import Game.Alliance;
import Game.piece.Piece;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

public class Board
{
    private List<Tile> gameBoard;
    private Board(Builder builder)
    {
        this.gameBoard=createGameBoard(builder);
    }
    public Tile getTile(final int tileCoordinate)
    {
        return null;
    }

    private static List<Tile> createGameBoard(final Builder builder)
    {
        final Tile[] tiles=new Tile[BoardUtils.NumTiles];
        for (int i=0;i<BoardUtils.NumTiles;i++)
        {
            tiles[i]=Tile.createTile(i,builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }

    public static class Builder
    {
        Map<Integer, Piece> boardConfig;
        Alliance nextMoveMaker;

        public Builder(){

        }

        public Builder setPiece(final Piece piece)
        {
            this.boardConfig.put(piece.getPiecePositions(),piece);
        }

        public Builder setMoveMaker(final Alliance nextMoveMaker)
        {
            this.nextMoveMaker=nextMoveMaker;
            return this;
        }

        public Board build()
        {
            return new Board(this);
        }
    }
}
