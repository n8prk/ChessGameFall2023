package Chess;

import javax.swing.*;

public class Pawn extends Piece
{
    public Pawn (boolean b)
    {
        pieceType = "Pawn";
        isWhite = b;
        if (isWhite)
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wpawn.gif");
            chessPiece = new ImageIcon("src/pieces/wpawn.gif");
        }
        else
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/bpawn.gif");
            chessPiece = new ImageIcon("src/pieces/bpawn.gif");
        }
    }
    public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
    {
        int prevX, prevY;

        if(isWhite && (Chess.moveNum % 2 == 0)) // If the piece is white
        {
            if(endX == startX // checks if pieces are moving laterally
                    // if piece is @ row 7 or ahead, it can move up 1, if @ row 7 only it can move up 2
                    && ((startY <= 6 && endY == startY - 1) || (startY == 6 && endY == startY - 2)
                    ))
            {
                int numOfMoves = startY-endY; // initializes a variable equal to the amount of spaces moved

                for(int n = 1; n <= numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX; // initialized two variables, setting the coordinate equally lateral
                    prevY = startY - n; // and equal to the starting position minus amount of spaces moved
                    System.out.println(" prevX (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null) {return false;} // if the space is not empty then it cannot move.
                }
                return true; // if space is empty then return true
            }

            // Check diagonal contains black piece and allow capture
            if(((endX == startX + 1) // if the endX is to the right and up or to the left and up
                    && (endY == startY - 1)) || ((endX == startX - 1) && (endY == startY - 1)
            ))
            {
                System.out.println("Pawn capture attempt: (" + endY + "," + endX + ")");
                if(pos[endX][endY]!=null && (!pos[endX][endY].isWhite)) // if the end position is not empty and the end piece is white it can move
                {
                    System.out.println("Valid Pawn Cap");
                    return true;
                }
                return false;
            }
        }
        else if (!isWhite && (Chess.moveNum % 2 != 0))// If the piece is black
        {
            if(endX == startX // Checks if pieces are moving laterally this is what they need to do
                    && ((startY >= 1 && endY == startY + 1 ) || (startY == 1 && endY == startY + 2)
            ))
            {
                int numOfMoves = endY - startY;
                for(int n=1; n<=numOfMoves; n++)
                {
                    prevX = startX;
                    prevY = startY + n;
                    System.out.println("prevX (" + prevX +"," + prevY + ")");

                    if (pos[prevX][prevY]!= null) {return false;}
                }
                return true;
            }
            // Check diagonal contains white piece and allow capture
            if(((endX == startX + 1)
                    && (endX == startY + 1)) || ((endX == startX-1) && (endY == startY+1)
            ))
            {
                if(pos[endX][endY]!=null && pos[endX][endY].isWhite) // if position contains enemy piece it may be captured
                {
                    System.out.println("Valid Pawn Cap");
                    return true;
                }
            }
        }
        return false;
    }
}
