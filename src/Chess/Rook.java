package Chess;

import javax.swing.*;

public class Rook extends Piece
{
    public Rook (boolean b)
    {
        pieceType = "Rook";
        isWhite = b;
        if (isWhite)
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/wrook.gif");
            chessPiece = new ImageIcon("src/pieces/wrook.gif");
        }
        else
        {
            //chessPiece = new ImageIcon("/Users/n8prk/IdeaProjects/newpkg/ChessGame/src/pieces/brook.gif");
            chessPiece = new ImageIcon("src/pieces/brook.gif");
        }
    }
   public boolean canMove(int startX, int startY, int endX, int endY, Piece[][] pos)
   {
       int prevX, prevY;

       if(isWhite && (Chess.moveNum % 2 == 0))
       {

            if((endX < startX) && (endY == startY)) //moving left
           {
               int NumOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
               int NumOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
               int NumOfMoves = startY-endY;

               for (int n = 1; n < NumOfMoves; n++)
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
               int NumOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
       }

       else if(!isWhite && (Chess.moveNum % 2 != 0))
       {
           if((endX < startX) && (endY == startY)) //moving left
           {
               int NumOfMoves = startX-endX; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
               int NumOfMoves = endX-startX; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
               int NumOfMoves = startY-endY;

               for (int n = 1; n < NumOfMoves; n++)
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
               int NumOfMoves = endY-startY; // initializes a variable equal to the amount of spaces moved

               for (int n = 1; n < NumOfMoves; n++) // iterates through each space moved through
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
       }
       System.out.println("Rooks cannot move diagonally");
       return false;
   }
}
