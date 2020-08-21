package Game.board;

public class BoardUtils
{
    public static final boolean[] FirstColoumn=null;
    public static final boolean[] SecondColoumn=null;
    public static final boolean[] SeventhColoumn=null;
    public static final boolean[] EighthColoumn=null;

    private BoardUtils()
    {
        throw new RuntimeException("Cant be instantiated");
    }

    public static boolean isValidTileCoordinate(int coordinate)
    {
        return coordinate>=0 && coordinate<64 ;
    }
}
