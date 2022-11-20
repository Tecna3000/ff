import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Painter extends Canvas {

    double width, height, colCount, rowCount;

    public Painter(double width, double height, double colCount, double rowCount)  {
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;

    }
    void repaint(){
        for(int col=0; col<colCount; col++)
            getGraphicsContext2D().strokeLine(0, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            getGraphicsContext2D().strokeLine(row*height/rowCount,0,row*height/rowCount, width);

    }

    void paint(int row, int col){
        getGraphicsContext2D().setFill(Color.WHITE);
        getGraphicsContext2D().fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintElement(Image image, int row, int col) {
        getGraphicsContext2D().drawImage(image,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }


}
