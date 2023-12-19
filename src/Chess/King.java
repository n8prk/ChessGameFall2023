package Chess;

import javax.swing.*;

public class King extends Piece
{
    public King (boolean b)
    {
        pieceType = "King";
        isWhite = b;
        if (isWhite && (Chess.moveNum % 2 == 0))
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wking.gif");
            chessPiece = new ImageIcon("src/pieces/wking.gif");
        }
        else
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/bking.gif");
            chessPiece = new ImageIcon("src/pieces/bking.gif");
        }
    }
    public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
    {
        boolean movement = ((endX == startX) && (endY == startY + 1)) // Moving south
                || ((endX == startX) && (endY == startY - 1)) // Moving north
                || ((endY == startY) && (endX == startX + 1)) // Moving east
                || ((endY == startY) && (endX == startX - 1)) // Moving west
                || ((endX == startX + 1) && (endY == startY + 1)) // moving southeast
                || ((endX == startX - 1) && (endY == startY - 1)) // moving northwest
                || ((endY == startY - 1) && (endX == startX + 1)) // moving northeast
                || ((endY == startY + 1) && (endX == startX - 1) // moving southwest
        );

        if(isWhite && (Chess.moveNum % 2 == 0)) // If piece is white and is white's turn
        {
            if(movement)
            {
                return true;
            }
            return false;
        }

        else if(!isWhite && (Chess.moveNum % 2 != 0)) // If piece is black and is black's turn
        {
            if(movement)
            {
                return true;
            }
            return false;
        }
        return false;
    }
}
