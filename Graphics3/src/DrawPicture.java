import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPicture extends JFrame {

    private JPanel myJPanel;
    private JButton drawButton;
    private JButton clearButton;
    private JButton movingButton;
    private JTextPane movingText;
    private JButton scalingButton;
    private JButton compressionButton;
    private JButton reflectionOxButton;
    private JTextPane scalingText;
    private JTextPane compressionText;
    private JButton rotationOyButton;
    private JTextPane rotationText;
    private JButton reflectionOyButton;
    private JButton reflectionOzButton;
    private JButton rotationOxButton;
    private JButton rotationOzButton;


    public void repaintPicture(Graphics graphics, NullPoint nullPoint, NullPoint nullPointPolygon, int[][] matrix) {
        graphics.setColor(Color.white);
        int[] x = new int[]{0, 1100, 1100, 0};
        int[] y = new int[]{0, 0, 660, 660};
        graphics.fillPolygon(x, y, 4);
        CoordinateAxe coordinateAxe = new CoordinateAxe();
        coordinateAxe.paint(getGraphics(), nullPoint);
        DrawPolygon drawPolygon = new DrawPolygon();
        drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
    }

    public DrawPicture() {
        add(myJPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 660);
        this.setTitle("drawPicture");
        NullPoint nullPoint = new NullPoint(new int[]{550, 330});
        NullPoint nullPointPolygon = new NullPoint(new int[]{550, 330});
        int[][] matrix = {
                {50,0,0},
                {50,50,0},
                {0,50,0},
                {0,0,0},
                {50,0,50},
                {50,50,50},
                {0,50,50},
                {0,0,50}
        };


        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                CoordinateAxe coordinateAxe = new CoordinateAxe();
                coordinateAxe.paint(getGraphics(), nullPoint);
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validate();
                repaint();
            }
        });
        movingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] newCoordinate = Main.toInt(movingText.getText());
                matrix[0][0] = matrix[0][0] + newCoordinate[0];
                matrix[0][1] = matrix[0][1] - newCoordinate[1];
                matrix[0][2] = matrix[0][2] + newCoordinate[2];
                matrix[1][0] = matrix[1][0] + newCoordinate[0];
                matrix[1][1] = matrix[1][1] - newCoordinate[1];
                matrix[1][2] = matrix[1][2] + newCoordinate[2];
                matrix[2][0] = matrix[2][0] + newCoordinate[0];
                matrix[2][1] = matrix[2][1] - newCoordinate[1];
                matrix[2][2] = matrix[2][2] + newCoordinate[2];
                matrix[3][0] = matrix[3][0] + newCoordinate[0];
                matrix[3][1] = matrix[3][1] - newCoordinate[1];
                matrix[3][2] = matrix[3][2] + newCoordinate[2];
                matrix[4][0] = matrix[4][0] + newCoordinate[0];
                matrix[4][1] = matrix[4][1] - newCoordinate[1];
                matrix[4][2] = matrix[4][2] + newCoordinate[2];
                matrix[5][0] = matrix[5][0] + newCoordinate[0];
                matrix[5][1] = matrix[5][1] - newCoordinate[1];
                matrix[5][2] = matrix[5][2] + newCoordinate[2];
                matrix[6][0] = matrix[6][0] + newCoordinate[0];
                matrix[6][1] = matrix[6][1] - newCoordinate[1];
                matrix[6][2] = matrix[6][2] + newCoordinate[2];
                matrix[7][0] = matrix[7][0] + newCoordinate[0];
                matrix[7][1] = matrix[7][1] - newCoordinate[1];
                matrix[7][2] = matrix[7][2] + newCoordinate[2];
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        scalingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newCoordinate = Main.toIntOneCount(scalingText.getText());
                matrix[0][0] = matrix[0][0] + newCoordinate;
                matrix[0][1] = matrix[0][1] - newCoordinate;
                matrix[0][2] = matrix[0][2] - newCoordinate;

                matrix[1][0] = matrix[1][0] + newCoordinate;
                matrix[1][2] = matrix[1][2] - newCoordinate;

                matrix[2][2] = matrix[2][2] - newCoordinate;

                matrix[3][1] = matrix[3][1] - newCoordinate;
                matrix[3][2] = matrix[3][2] - newCoordinate;

                matrix[4][0] = matrix[4][0] + newCoordinate;
                matrix[4][1] = matrix[4][1] - newCoordinate;

                matrix[5][0] = matrix[5][0] + newCoordinate;

                matrix[7][1] = matrix[7][1] - newCoordinate;
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });

        compressionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] amendment = Main.toInt(compressionText.getText());

                matrix[0][0] = matrix[0][0] + amendment[0];
                matrix[0][1] = matrix[0][1] - amendment[1];
                matrix[0][2] = matrix[0][2] - amendment[2];

                matrix[1][0] = matrix[1][0] + amendment[0];
                matrix[1][2] = matrix[1][2] - amendment[2];

                matrix[2][2] = matrix[2][2] - amendment[2];

                matrix[3][1] = matrix[3][1] - amendment[1];
                matrix[3][2] = matrix[3][2] - amendment[2];

                matrix[4][0] = matrix[4][0] + amendment[0];
                matrix[4][1] = matrix[4][1] - amendment[1];

                matrix[5][0] = matrix[5][0] + amendment[0];

                matrix[7][1] = matrix[7][1] - amendment[1];
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });

        reflectionOxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrix[0][2] = matrix[0][2] * -1;
                matrix[1][2] = matrix[1][2] * -1;
                matrix[2][2] = matrix[2][2] * -1;
                matrix[3][2] = matrix[3][2] * -1;
                matrix[4][2] = matrix[4][2] * -1;
                matrix[5][2] = matrix[5][2] * -1;
                matrix[6][2] = matrix[6][2] * -1;
                matrix[7][2] = matrix[7][2] * -1;
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        reflectionOyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrix[0][0] = matrix[0][0] * (-1);
                matrix[1][0] = matrix[1][0] * (-1);
                matrix[2][0] = matrix[2][0] * (-1);
                matrix[3][0] = matrix[3][0] * (-1);
                matrix[4][0] = matrix[4][0] * (-1);
                matrix[5][0] = matrix[5][0] * (-1);
                matrix[6][0] = matrix[6][0] * (-1);
                matrix[7][0] = matrix[7][0] * (-1);
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        reflectionOzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matrix[0][1] = matrix[0][1] * (-1);
                matrix[1][1] = matrix[1][1] * (-1);
                matrix[2][1] = matrix[2][1] * (-1);
                matrix[3][1] = matrix[3][1] * (-1);
                matrix[4][1] = matrix[4][1] * (-1);
                matrix[5][1] = matrix[5][1] * (-1);
                matrix[6][1] = matrix[6][1] * (-1);
                matrix[7][1] = matrix[7][1] * (-1);
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        rotationOxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radian = Main.toIntOneCount(rotationText.getText());
                double[] trigonometricMatrix = new double[3];
                trigonometricMatrix[0] = Math.cos(Math.toRadians(radian));
                trigonometricMatrix[1] = Math.sin(Math.toRadians(radian));
                trigonometricMatrix[2] = -Math.sin(Math.toRadians(radian));
                for (int i = 0; i < 8; i++) {
                    matrix[i][1] = (int)(trigonometricMatrix[0]*matrix[i][1] + trigonometricMatrix[2]*matrix[i][2]);
                    matrix[i][2] = (int)(trigonometricMatrix[1]*matrix[i][1] + trigonometricMatrix[0]*matrix[i][2]);
                }
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        rotationOyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radian = Main.toIntOneCount(rotationText.getText());
                double[] trigonometricMatrix = new double[3];
                trigonometricMatrix[0] = Math.cos(Math.toRadians(radian));
                trigonometricMatrix[1] = Math.sin(Math.toRadians(radian));
                trigonometricMatrix[2] = -Math.sin(Math.toRadians(radian));
                for (int i = 0; i < 8; i++) {
                    matrix[i][0] = (int)(trigonometricMatrix[0]*matrix[i][0] + trigonometricMatrix[1]*matrix[i][2]);
                    matrix[i][2] = (int)(trigonometricMatrix[2]*matrix[i][0] + trigonometricMatrix[0]*matrix[i][2]);
                }
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
        rotationOzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radian = Main.toIntOneCount(rotationText.getText());
                double[] trigonometricMatrix = new double[3];
                trigonometricMatrix[0] = Math.cos(Math.toRadians(radian));
                trigonometricMatrix[1] = Math.sin(Math.toRadians(radian));
                trigonometricMatrix[2] = -Math.sin(Math.toRadians(radian));
                for (int i = 0; i < 8; i++) {
                    matrix[i][0] = (int)(trigonometricMatrix[0]*matrix[i][0] + trigonometricMatrix[1]*matrix[i][1]);
                    matrix[i][1] = (int)(trigonometricMatrix[2]*matrix[i][0] + trigonometricMatrix[0]*matrix[i][1]);
                }
                DrawPolygon drawPolygon = new DrawPolygon();
                drawPolygon.paint(getGraphics(), matrix, nullPointPolygon);
                repaintPicture(getGraphics(), nullPoint, nullPointPolygon, matrix);
            }
        });
    }



}

