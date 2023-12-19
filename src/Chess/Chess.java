package Chess;

import java.awt.*;
import javax.swing.*;

public class Chess
{
    // Dimensions of full board and each tile.
    public static final int boardSize = 800, tileSize = boardSize / 8;
    //Define board variable here.
    public static int moveNum = 0;
    // public static Player player = new Player();
    public static BoardComponent board;
    public static Piece[][] position = new Piece[8][8];

    public static void main(String[] args)
    {
        // Queens
        position[3][7] = new Queen(true);
        position[3][0] = new Queen(false);

        // Kings
        position[4][7] = new King(true);
        position[4][3] = new Queen(false);

        position[5][2] = new Rook(true);
        position[5][3] = new Rook(true);
        position[5][4] = new Rook(true);
        position[3][2] = new Rook(true);
        position[3][3] = new Rook(true);
        position[3][4] = new Rook(true);
        position[4][2] = new Rook(true);
        position[4][4] = new Rook(true);
/*
        // Pawns
        for(int i = 0; i <= 7; i++)
        {
            //position[i][1] = new Pawn(false);
            position[i][6] = new Pawn(true);
        }
        // Knights
        position[1][7] = new Knight(true);
        position[6][7] = new Knight(true);

        position[1][0] = new Knight(false);
        position[6][0] = new Knight(false);

        // Rooks
        position[0][7] = new Rook(true);
        position[7][7] = new Rook(true);

        position[0][0] = new Rook(false);
        position[7][0] = new Rook(false);

        // Bishops
        position[2][7] = new Bishop(true);
        position[5][7] = new Bishop(true);

        position[2][0] = new Bishop(false);
        position[5][0] = new Bishop(false);  */

        //Start making board
        JFrame frame = new JFrame("Chess");
        
        frame.setLayout(new GridBagLayout()); // creates grid layout to center the board
        frame.getContentPane().setBackground(Color.black);

        frame.setMinimumSize(new Dimension(1000, 1000)); // sets the dimensions of the board
        frame.setSize(1000, 1000);

        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new BoardComponent(); // creates JPanel
        frame.add(board);
        frame.setVisible(true);

        BoardMouseListener m = new BoardMouseListener(); // adds the mouse listener to the frame
        frame.addMouseListener(m);

    }
}