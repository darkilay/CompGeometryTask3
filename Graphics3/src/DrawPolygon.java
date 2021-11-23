import java.awt.*;

public class DrawPolygon {
    public void paint(Graphics g, int[][] matrix, NullPoint nullPoint) {
        g.setColor(Color.green);
        int[] x = new int[matrix.length];
        int[] y = new int[matrix.length];
        int[] z = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            z[i] = (int) Math.round(Math.sqrt((Math.pow(matrix[i][2], 2))/2));
            if (matrix[i][2] >= 0) {
                x[i] = matrix[i][0] + nullPoint.coordinateNullPoint[0] - z[i];
                y[i] = matrix[i][1] + nullPoint.coordinateNullPoint[1] + z[i];
            } else {
                x[i] = matrix[i][0] + nullPoint.coordinateNullPoint[0] + z[i];
                y[i] = matrix[i][1] + nullPoint.coordinateNullPoint[1] - z[i];
            }
        }
        int[] x1 = new int[matrix.length / 2];
        int[] x2 = new int[matrix.length / 2];
        int[] y1 = new int[matrix.length / 2];
        int[] y2 = new int[matrix.length / 2];
        for (int i = 0; i < matrix.length / 2; i++) {
            x1[i] = x[i];
            y1[i] = y[i];
            x2[i] = x[matrix.length / 2 + i];
            y2[i] = y[matrix.length / 2 + i];
        }


        g.drawPolygon(x1, y1, matrix.length / 2);
        g.drawPolygon(x2, y2, matrix.length / 2);
        for (int i = 0; i < matrix.length / 2; i++) {
            g.drawLine(x1[i], y1[i], x2[i], y2[i]);
        }
    }
}
