package Game.board;

public class BoardUtils
{
    public static final boolean[] FirstColoumn=initColoumn(0);
    public static final boolean[] SecondColoumn=initColoumn(1);
    public static final boolean[] SeventhColoumn=initColoumn(6);
    public static final boolean[] EighthColoumn=initColoumn(7);

    public static final boolean[] SecondRow=null;
    public static final boolean[] NinethRow=null;

    public static final int NumTiles=64;
    public static final int NumTilesPerRow=8;

    private static boolean[] initColoumn(int coloumnNumber)
    {
        final boolean[] coloumn=new boolean[NumTiles];
        do
            {
            coloumn[coloumnNumber]=true;
            coloumnNumber+=NumTilesPerRow;
        }while (coloumnNumber<NumTiles);

        return coloumn;
    }

    private BoardUtils()
    {
        throw new RuntimeException("Cant be instantiated");
    }

    public static boolean isValidTileCoordinate(final int coordinate)
    {
        return coordinate>=0 && coordinate<NumTiles ;
    }
}
