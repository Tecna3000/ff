import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import java.io.File;
import java.net.MalformedURLException;

public class Painter extends Canvas {

    double width, height, colCount, rowCount;
    Model model;
    Grid grid;
    Image elementImage = new Image( new File("").toURI().toURL().toString());

    Image fireImage = new Image( new File("../firefighterstarter/src/main/images/flamme.png").toURI().toURL().toString());
    Image ffImage = new Image( new File("../firefighterstarter/src/main/images/firefighter.png").toURI().toURL().toString());
    public Painter(int width, int height, int colCount, int rowCount) throws MalformedURLException {

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

    public void paintFF(int row, int col) {
        getGraphicsContext2D().drawImage(ffImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintFire(int row, int col) {
        getGraphicsContext2D().drawImage(fireImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintElement(int row, int col) {
        getGraphicsContext2D().drawImage(elementImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }


}