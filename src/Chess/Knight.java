package Chess;

import javax.swing.*;

public class Knight extends Piece
{
    public Knight (boolean b)
    {
        pieceType = "Knight";
        isWhite = b;
        if (isWhite)
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wknight.gif");
            chessPiece = new ImageIcon("src/pieces/wknight.gif");
        }
        else
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/bknight.gif");
            chessPiece = new ImageIcon("src/pieces/bknight.gif");
        }
    }
    // The most simple canMove method because knight can "jump" over pieces making any move to an empty square or a capture on enemy pieces a valid move
    public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
    {
        boolean movement = ((endX == startX+2) && (endY == startY+1)) || ((endX == startX+1) && (endY == startY+2))
                || ((endX == startX + 2) && (endY == startY - 1)) || ((endX == startX + 1) && (endY == startY - 2))
                || ((endX == startX - 2) && (endY == startY + 1)) || ((endX == startX - 1) && (endY == startY + 2))
                || ((endX == startX - 2) && (endY == startY - 1)) || ((endX == startX - 1) && (endY == startY - 2)
        );
        if(isWhite && (Chess.moveNum % 2 == 0))
        {
            if(movement)
            {
                return true;
            }
            System.out.println("Invalid Knight Move");
            return false;
        }
        else // Both if statements are really long to consider up to eight different squares that a knight could go to
        {
            if(movement)
            {
                return true;
            }
            System.out.println("Invalid Knight Move");
            return false;
        }
    }
}
