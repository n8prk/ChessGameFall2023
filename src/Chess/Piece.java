package Chess;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public abstract class Piece
{
    public ImageIcon chessPiece; // image of piece displayed on the
    public boolean isWhite; // attribute of piece color
    public String pieceType;

    public abstract boolean canMove(int startX, int startY, int endX, int endY, Piece[][] array);
    public void drawPiece(int x, int y, Graphics g)
    {
        g.drawImage(chessPiece.getImage(), x, y, null);
    }
}
