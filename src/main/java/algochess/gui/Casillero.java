package algochess.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public  class Casillero extends StackPane {
    private final int fila;
    private final int columna;

    Casillero(int fila_, int columna_, int tamanio, Paint color){
        super();
        setBackground(new Background(new BackgroundFill(color,CornerRadii.EMPTY,Insets.EMPTY)));
        setPrefSize(tamanio,tamanio);
        fila = fila_;
        columna = columna_;

        setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                Rectangle rectangulo = new Rectangle(tamanio,tamanio);
                //Image image = new Image("images/CaballoPink.png");
                //rectangulo.setFill(new ImagePattern(image));
                getChildren().add(rectangulo);


            }
        });

    }


    /*Casillero(int fila_, int columna_, int tamanio, javafx.scene.paint.Color color){
        super();
        fila = fila_;
        columna = columna_;
        setWidth(tamanio);
        setHeight(tamanio);
        setFill(color);

        /*setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(fila_+", "+columna_);
                Image image = new Image("sample/dog.jpg");
                setFill(new ImagePattern(image));
            }
        });*/

    public int getFila() { return fila;}

    public int getColumna() { return columna;}

}
