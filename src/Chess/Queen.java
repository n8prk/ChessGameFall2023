package Chess;

import javax.swing.*;
public class Queen extends Piece
{
    public Queen (boolean b) {
        pieceType = "Queen";
        isWhite = b;
        if (isWhite) {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wqueen.gif");
            chessPiece = new ImageIcon("src/pieces/wqueen.gif");
        }
        else
        {
           //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/bqueen.gif");
           chessPiece = new ImageIcon("src/pieces/bqueen.gif");
        }
    }

    public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
    {
        int prevX, prevY;
        // All code is copy and pasted from the rooks and bishops
        if(isWhite && (Chess.moveNum % 2 == 0))
        {

            if((endX < startX) && (endY == startY)) //moving left
            {
                int numOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX - n; // initialized two variables, setting the coordinate equally lateral
                    System.out.println(" prev (" + prevX + "," + startY + ")"); // prints the initialized variable

                    if (pos[prevX][startY] != null) {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if((endX > startX) && (endY == startY)) //moving right
            {
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // initialized two variables, setting the coordinate equally lateral
                    System.out.println(" prev (" + prevX + "," + startY + ")"); // prints the initialized variable

                    if (pos[prevX][startY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

            else if((endX == startX) && (endY < startY))  //moving up
            {
                int numOfMoves = startY-endY;

                for (int n = 1; n < numOfMoves; n++)
                {
                    prevY = startY - n; // and equal to the starting position minus amount of spaces moved
                    System.out.println(" prev (" + startX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[startX][prevY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

            else if((endX == startX) && (endY > startY)) //moving down
            {
                int numOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevY = startY + n; // and equal to the starting position minus amount of spaces moved
                    System.out.println(" prev (" + startX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[startX][prevY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

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
        else if(!isWhite && (Chess.moveNum % 2 != 0))
        {
            if((endX < startX) && (endY == startY)) //moving left
            {
                int numOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX - n; // initialized two variables, setting the coordinate equally lateral
                    System.out.println(" prev (" + prevX + "," + startY + ")"); // prints the initialized variable

                    if (pos[prevX][startY] != null) {
                        System.out.println("There is a piece in the way"); // if the space is not empty then it cannot move.
                        return false;
                    }
                }
                return true;
            }

            else if((endX > startX) && (endY == startY)) //moving right
            {
                int numOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevX = startX + n; // initialized two variables, setting the coordinate equally lateral
                    System.out.println(" prev (" + prevX + "," + startY + ")"); // prints the initialized variable

                    if (pos[prevX][startY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

            else if((endX == startX) && (endY < startY))  //moving up
            {
                int numOfMoves = startY-endY;

                for (int n = 1; n < numOfMoves; n++)
                {
                    prevY = startY - n; // and equal to the starting position minus amount of spaces moved
                    System.out.println(" prev (" + startX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[startX][prevY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

            else if((endX == startX) && (endY > startY)) //moving down
            {
                int numOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

                for (int n = 1; n < numOfMoves; n++) // iterates through each space moved through
                {
                    prevY = startY + n; // and equal to the starting position minus amount of spaces moved
                    System.out.println(" prev (" + startX + "," + prevY + ")"); // prints the initialized variable

                    if (pos[startX][prevY] != null) {
                        System.out.println("There is a piece in the way");
                        return false;
                    } // if the space is not empty then it cannot move.
                }
                return true;
            }

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

    public boolean isChecked(int kingX, int kingY, Piece[][] pos) {
        return false;
    }
}
