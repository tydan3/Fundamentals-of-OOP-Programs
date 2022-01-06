// this is the class that takes care of the actual display grid

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WorldPanel extends JPanel {
    private SimModel myModel;
    private Font myFont;

    public static final int FONT_SIZE = 16;

    public WorldPanel(SimModel model) {
        myModel = model;
        // construct font and compute char width once in constructor
        // for efficiency
        myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE);
        setBackground(new Color(245,222,179));
        setPreferredSize(new Dimension(FONT_SIZE * model.getWidth() / 2 + 200,
                                       FONT_SIZE * model.getHeight() + 25));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(myFont);
        int height = myModel.getHeight();
        int width = myModel.getWidth();
        // because font is monospaced, all widths should be the same;
        // so we can get char width from any char (in this case x)
        int charWidth = g.getFontMetrics().charWidth('x');
        int extraX = getWidth() - (width + 1) * charWidth;
        int extraY = getHeight() - (height - 1) * FONT_SIZE;
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                g.drawString("" + myModel.getChar(i, j),
                             extraX/2 + i * charWidth,
                             extraY/2 + j * FONT_SIZE);
    }
}
