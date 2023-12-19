package Chess;

import javax.swing.*;

public class Bishop extends Piece
{
    public Bishop (boolean b)
    {
        pieceType = "Bishop";
        isWhite = b;
        if (isWhite)
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wbishop.gif");
            chessPiece = new ImageIcon("src/pieces/wbishop.gif");
        }
        else
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/bbishop.gif");
            chessPiece = new ImageIcon("src/pieces/bbishop.gif");
        }
    }

    public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
    {
        int prevX, prevY;

        if(isWhite && (Chess.moveNum % 2 == 0))
        {
           if(startY > endY && ((startY-endY) == (startX-endX))) // moving NW
            {
                int numOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    System.out.println("Moving NW");
                    prevX = startX - n; // moving left
                    prevY = startY - n; // moving up

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if(startY > endY && ((startY-endY) == (endX-startX))) // moving NE
            {
                System.out.println("Moving NE");
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // moving right
                    prevY = startY - n; // moving up

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }
            // NOTE: The first comparison operators are to determine direction as the first ways are mathematically
            else if(endY > startY && ((endY-startY) == (endX-startX))) // moving SE
            {
                System.out.println("Moving SE");
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // moving right
                    prevY = startY + n; // moving down

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if(endY > startY && ((endY-startY) == (startX-endX))) // moving SW
            {

                int numOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX - n; // moving left
                    prevY = startY + n; // moving down

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }
        }

        else if(!isWhite && (Chess.moveNum % 2 != 0))
        {
            if(startY > endY && ((startY-endY) == (startX-endX))) // moving NW
            {
                int numOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    System.out.println("Moving NW");
                    prevX = startX - n; // moving left
                    prevY = startY - n; // moving up

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if(startY > endY && ((startY-endY) == (endX-startX))) // moving NE
            {
                System.out.println("Moving NE");
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // moving right
                    prevY = startY - n; // moving up

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if(endY > startY && ((endY-startY) == (endX-startX))) // moving SE
            {
                System.out.println("Moving SE");
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // moving right
                    prevY = startY + n; // moving down

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if(endY > startY && ((endY-startY) == (startX-endX))) // moving SW
            {

                int numOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX - n; // moving left
                    prevY = startY + n; // moving down

                    System.out.println(" prev (" + prevX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[prevX][prevY] != null)
                    {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
