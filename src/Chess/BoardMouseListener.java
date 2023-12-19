package Chess;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{
    int startX;
    int startY;
    int endX;
    int endY;

    @Override
    public void mousePressed(MouseEvent e)
    {
        System.out.println("Mouse is being pressed");

        int tryStartX = e.getX()/Chess.tileSize - 1; // Get appropriate tile coordinates
        int tryStartY = e.getY()/Chess.tileSize - 1;

        if (tryStartX > 7 || tryStartY > 7) // Ensures that the mouse is not out of bounds
        {
            System.out.println("Cannot print outside the bounds of the board");
            return;
        }

        if(Chess.position[tryStartX][tryStartY] != null) // Verifies that mouse is clicking on piece
        {
            startX = tryStartX; // Confirms the starting coordinates
            startY = tryStartY;
            System.out.println("Staring coords: " + (startX) + ", " + (startY)
                    + ". The selected piece is: " + Chess.position[startX][startY].pieceType);
        }
        else
        {
            System.out.println("There is not a piece there!");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        System.out.println("The mouse was released");

        int tryEndX = e.getX()/Chess.tileSize - 1; // Get appropriate tile coordinates
        int tryEndY = e.getY()/Chess.tileSize - 1;

        if(tryEndX > 7 || tryEndY > 7) // Ensures that the end coordinates are not out of bounds
        {
            System.out.println("Cannot move to " + "(" + (tryEndX) + ", "+(tryEndY)+")" + "it's outside the board.");
            return;
        }

        if((tryEndX == startX) && (tryEndY == startY)) // Ensures end coordinates are not the start coordinates
        {
            System.out.println("SAME SQUARE");
            return;
        }

        if(Chess.position[tryEndX][tryEndY] == null) // if the space is empty
        {
            System.out.println("(" + tryEndX + "," + tryEndY + "): EMPTY");
            // Checks if the move is valid
            if(Chess.position[startX][startY].canMove(startX, startY, tryEndX, tryEndY, Chess.position))
            {
                endX = tryEndX; // Confirms the coordinates
                endY = tryEndY;
                Chess.moveNum++; // adds up the move counts
                movePiece();
                findValidMove(); // runs the computer player method
            }
            return;
        }

        if(Chess.position[tryEndX][tryEndY] != null) // if space has piece on it
        {
            System.out.println("(" + tryEndX + "," + tryEndY + "): FULL");

            if(Chess.position[startX][startY].isWhite
                    == Chess.position[tryEndX][tryEndY].isWhite) // checks if pieces are the same color
            {
                System.out.println("Cannot capture same color piece");
                return;
            }

            if(Chess.position[startX][startY].canMove(startX, startY, tryEndX, tryEndY, Chess.position))
            {
                endX = tryEndX;
                endY = tryEndY;
                Chess.moveNum++;
                movePiece();
                findValidMove();
            }
        }
    }

    public void findValidMove() // searches for a valid move for the bot
    {
        int tryStartX, tryStartY, tryEndX, tryEndY;
        int i=1; // initialized a condition that allows iteration

        while (i>0)
        {
            tryStartX = (int)(Math.random() * 8); // generates two random coordinates
            tryStartY = (int)(Math.random() * 8);
            tryEndX = (int)(Math.random() * 8);
            tryEndY = (int)(Math.random() * 8);
            // Makes sure start coord is not empty, that it's not moving to the same square
            if((Chess.position[tryStartX][tryStartY] == null) || ((tryStartX == tryEndX) && (tryStartY == tryEndY))
                || (Chess.position[tryStartX][tryStartY].isWhite)) // makes sure selected piece isn't white
            {
                continue;
            }
            else if(Chess.position[tryEndX][tryEndY] != null) // makes sure that the end coordinate is not empty
            {
                if(Chess.position[tryEndX][tryEndY].isWhite) // makes sure captured piece is white
                {
                    if(Chess.position[tryStartX][tryStartY].canMove(tryStartX,tryStartY,tryEndX,tryEndY,Chess.position))
                    {
                        System.out.println("Moving the " + Chess.position[tryStartX][tryStartY].pieceType);
                        i = -1; // breaks loop
                        Chess.moveNum++; // counts up the amount of moves that were moved
                        startY = tryStartY; // confirms the valid coordinates
                        startX = tryStartX;
                        endY = tryEndY;
                        endX = tryEndX;
                        movePiece(); // moves the piece
                    }
                }
                else
                {
                    continue;
                }
            }
            else if (Chess.position[tryEndX][tryEndY] == null)
            {
                if (Chess.position[tryStartX][tryStartY].canMove(tryStartX, tryStartY, tryEndX, tryEndY, Chess.position))
                {
                    System.out.println("Moving the " + Chess.position[tryStartX][tryStartY].pieceType);
                    i = -1; // breaks loop
                    Chess.moveNum++; // counts up the amount of moves that were moved
                    startY = tryStartY; // confirms the valid coordinates
                    startX = tryStartX;
                    endY = tryEndY;
                    endX = tryEndX;
                    movePiece(); // moves the piece
                }
                else
                {
                    continue;
                }
            }
        }
    }

    public void movePiece()
    {
        Chess.position[endX][endY] = Chess.position[startX][startY]; //sets the end position equal to the start position
        Chess.position[startX][startY] = null; // gets rid of original piece
        System.out.println("Piece was moved to (" + endX + "," + endY + ")");
        Chess.board.repaint(); // repaints board to visually show the move
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}