
package Game.board;

import Game.piece.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile
{
    protected final int tileCoordinate;

    private static final Map<Integer,EmptyTile> emptyTiles=createPossibleEmptyTiles(); //initiates a key for all tiles

    private static Map<Integer, EmptyTile> createPossibleEmptyTiles()
    {
        final Map<Integer,EmptyTile> emptyTileMap=new HashMap<>();
        for (int i=0;i<64;i++)
        {
            emptyTileMap.put(i,new EmptyTile(i)); //initializing all empty tiles
        }

        return ImmutableMap.copyOf(emptyTileMap); //making an immutable tile
    }

    public static Tile createTile(final int tileCoordinate,final Piece piece)
    {
        return piece!=null ? new OccupiedTile(tileCoordinate,piece):emptyTiles.get(tileCoordinate);//if piece is not null returns an occupied tile otherwise empty tile
    }

    private Tile(final int tileCoordinate)
    {
        this.tileCoordinate=tileCoordinate; //tile constructor immuatable from outside
    }

    public abstract boolean isOccupied();//defined later
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile
    {
        private EmptyTile(final int coordinate)
        {
            super(coordinate);
        }

        public boolean isOccupied()
        {
            return false;
        }
        public Piece getPiece()
        {
                return null;
        }
    }

    public static final class OccupiedTile extends Tile
    {
        private final Piece pieceOnTile;
        private OccupiedTile(int tileCoordinate,final Piece pieceOnTile)
        {
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }
        public boolean isOccupied()
        {
            return true;
        }
        public Piece getPiece()
        {
                return this.pieceOnTile;
        }
    }
}
