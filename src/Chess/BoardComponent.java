package Chess;

import java.awt.*;
import javax.swing.*;
public class BoardComponent extends JPanel
{
    private static final Color lightColor = new Color(233,172,95);
    private static final Color darkColor = new Color(38,23,4);
    int cols = 8;
    int row = 8;
    public BoardComponent()
    {
        this.setPreferredSize(new Dimension(cols*Chess.tileSize,row*Chess.tileSize));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Draw the squares and color
        for(int r = 0; r < row; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                if((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1 ))
                {
                    g2d.setColor(lightColor);
                }
                else
                {
                    g2d.setColor((c + r) % 2 == 0 ? lightColor : darkColor);
                }
                //fill the tiles
                g2d.fillRect(r * Chess.tileSize,c * Chess.tileSize, Chess.tileSize, Chess.tileSize);

                if (Chess.position[r][c] != null) // if the array index is not empty, then the piece is drawn
                {
                    Chess.position[r][c].drawPiece(r * Chess.tileSize,c * Chess.tileSize, g);
                }
            }
        }
    }
}
