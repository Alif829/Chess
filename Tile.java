public abstract class Tile
{
    int tileCoordinate;

    public Tile(int tileCoordinate)
    {
        this.tileCoordinate=tileCoordinate;
    }

    public abstract boolean isOccupied();
    public abstract Piece getPiece[];

    public static final class EmptyTile extends Tile
    {
        public EmptyTile(int coordinate)
        {
            super(coordinate);
        }

        public boolean isOccupied()
        {
            return false;
        }
        public Piece getPiece[]
        {
                return null;
        }
    }

    public static final class OccupiedTile extends Tile
    {
        Piece pieceOnTile;
        public OccupiedTile(int tileCoordinate,Piece pieceOnTile)
        {
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }
        public boolean isOccupied()
        {
            return true;
        }
        public Piece getPiece[]
        {
                return this.pieceOnTile;
        }
    }
}
