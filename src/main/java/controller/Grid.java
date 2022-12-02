package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import view.FfPainter;

import java.net.MalformedURLException;


public class Grid extends Canvas implements Controller {
    int width, height;
     public int colCount;
    public int rowCount;
    public controller.Model model;
    public FfPainter painter;

    public Grid(int width, int height, int colCount, int rowCount) throws MalformedURLException {
        super(width,height);
        this.colCount = colCount;this.rowCount = rowCount;
        this.width = width;this.height = height;
        painter = new FfPainter(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new controller.Model(this);
        model.initialisation(10,8,5,10,20,20,10);
    }

    @Override
    public void restart(MouseEvent mouseEvent) {
        model = new controller.Model(this);
        model.initialisation(10,6,5,4,20,20,10);
        try {
            painter = new FfPainter(this);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        getGraphicsContext2D().clearRect(0,0,width, height);
        painter.repaint();
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        painter.repaint();
    }
}

