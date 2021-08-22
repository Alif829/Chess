package Game;

public enum Alliance
{
    BLACK
            {
                @Override
                public int getDirection()
                {
                    return -1;
                }

                @Override
                public boolean isBlack() {
                    return true;
                }

                @Override
                public boolean isWhite() {
                    return false;
                }

                @Override
                public boolean isGreen() {
                    return false;
                }

                @Override
                public boolean isRed() {
                    return false;
                }
            },
    WHITE
            {
                @Override
                public int getDirection() {
                    return 1;
                }

                @Override
                public boolean isBlack() {
                    return false;
                }

                @Override
                public boolean isWhite() {
                    return true;
                }

                @Override
                public boolean isGreen() {
                    return false;
                }

                @Override
                public boolean isRed() {
                    return false;
                }
            },
    GREEN
            {
                @Override
                public int getDirection() {
                    return 1;
                }

                @Override
                public boolean isBlack() {
                    return false;
                }

                @Override
                public boolean isWhite() {
                    return false;
                }

                @Override
                public boolean isGreen() {
                    return true;
                }

                @Override
                public boolean isRed() {
                    return false;
                }
            },
    RED
            {
                @Override
                public int getDirection() {
                    return -1;
                }

                @Override
                public boolean isBlack() {
                    return false;
                }

                @Override
                public boolean isWhite() {
                    return false;
                }

                @Override
                public boolean isGreen() {
                    return false;
                }

                @Override
                public boolean isRed() {
                    return true;
                }
            };

    public abstract int getDirection();
    public abstract boolean isBlack();
    public abstract boolean isWhite();
    public abstract boolean isGreen();
    public abstract boolean isRed();
}
