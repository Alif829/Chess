package board;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.concurrent.Callable;


public class BoardMain extends Application {
    Group root;
    double frameWidth = 1500, frameHeight = 750;
    double cameraX = 0, cameraY = 1000, cameraZ = -600;
    double cameraView = 30;
    double posX = 0, posY = 0, posZ = 0;
    double cameraAngle = 60;
    double rootAngle = 60;
    double dr = 1, dx = 10, dy = 10, dz = 10, dc=1;

    double boardWidth=100, boardHeight=100, boardDepth=20;

    Stage primaryStage;
        @Override
        public void start (Stage primaryStage) throws Exception {
            this.primaryStage = primaryStage;
            build();
        }

        private void build () {
            prepareRoot();
            for (int i = 4; i < 8; i++) {
                for (int j = 1; j < 11; j++) {
                    Color color;
                    if ((i + j) % 2 == 0)
                        color = Color.BLACK;
                    else
                        color = Color.WHITE;

                    drawBox(posX + i * boardWidth, posY + j * boardHeight, posZ, color);

                }
            }
            //player piece colors
            for (int i = 4; i < 8; i++) {
                for (int j = 1; j < 3; j++) {
                    drawPawnR(50, 30, posX + i * boardWidth, posY + j * boardHeight, -40);
                }
            }
            for (int i = 4; i < 8; i++) {
                for (int j = 9; j < 11; j++) {
                    drawPawnW(50, 30, posX + i * boardWidth, posY + j * boardHeight, -40);
                }
            }
            for (int i = 1; i < 3; i++) {
                for (int j = 4; j < 8; j++) {
                    drawPawnB(50, 30, posX + i * boardWidth, posY + j * boardHeight, -40);
                }
            }
            for (int i = 9; i < 11; i++) {
                for (int j = 4; j < 8; j++) {
                    drawPawnY(50, 30, posX + i * boardWidth, posY + j * boardHeight, -40);
                }
            }
            for (int i = 1; i < 4; i++) {
                for (int j = 4; j < 8; j++) {
                    Color color;
                    if ((i + j) % 2 == 0)
                        color = Color.BLACK;
                    else
                        color = Color.WHITE;

                    drawBox(posX + i * boardWidth, posY + j * boardHeight, posZ, color);
                }
            }
            for (int i = 8; i < 11; i++) {
                for (int j = 4; j < 8; j++) {
                    Color color;
                    if ((i + j) % 2 == 0)
                        color = Color.BLACK;
                    else
                        color = Color.WHITE;

                    drawBox(posX + i * boardWidth, posY + j * boardHeight, posZ, color);
                }
            }
            Box box = new Box();
            box.setWidth(1400);
            box.setHeight(1400);
            box.setDepth(300);
            box.setTranslateX(550);
            box.setTranslateY(550);
            box.setTranslateZ(160);
            root.getChildren().add(box);
            PhongMaterial material = new PhongMaterial(Color.YELLOW);
            box.setMaterial(material);

            prepareScene();
    }

    private void prepareRoot() {
        root = new Group();
        root.setRotationAxis(Rotate.Z_AXIS);
        root.setRotate(rootAngle);
    }

    private void drawBox(double x, double y, double z, Color color) {
        drawBox(x, y, z, color,boardWidth, boardHeight, boardDepth);
    }
    private void drawBox(double x, double y, double z, Color color, double width, double height, double depth) {
        Box box = new Box(width, height, depth);
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setTranslateZ(z);

        PhongMaterial material = new PhongMaterial(color);
        box.setMaterial(material);

        root.getChildren().add(box);
    }

    private void drawPawnR(int h,int r,double posX,double posY,double posZ)
    {
        Sphere sphere=new Sphere();
        sphere.setRadius(r);
        sphere.setTranslateX(posX);
        sphere.setTranslateY(posY);
        sphere.setTranslateZ(-90);

        Box box=new Box();
        box.setHeight(h);
        box.setDepth(h);
        box.setWidth(h);
        box.setTranslateX(posX);
        box.setTranslateY(posY);
        box.setTranslateZ(posZ);

        PhongMaterial material = new PhongMaterial(Color.RED);
        sphere.setMaterial(material);
        box.setMaterial(material);

        root.getChildren().add(box);
        root.getChildren().add(sphere);
    }

    private void drawPawnW(int h,int r,double posX,double posY,double posZ)
    {
        Sphere sphere=new Sphere();
        sphere.setRadius(r);
        sphere.setTranslateX(posX);
        sphere.setTranslateY(posY);
        sphere.setTranslateZ(-90);

        Box box=new Box();
        box.setHeight(h);
        box.setDepth(h);
        box.setWidth(h);
        box.setTranslateX(posX);
        box.setTranslateY(posY);
        box.setTranslateZ(posZ);

        PhongMaterial material = new PhongMaterial(Color.BEIGE);
        sphere.setMaterial(material);
        box.setMaterial(material);

        root.getChildren().add(box);
        root.getChildren().add(sphere);
    }
    private void drawPawnB(int h,int r,double posX,double posY,double posZ)
    {
        Sphere sphere=new Sphere();
        sphere.setRadius(r);
        sphere.setTranslateX(posX);
        sphere.setTranslateY(posY);
        sphere.setTranslateZ(-90);

        Box box=new Box();
        box.setHeight(h);
        box.setDepth(h);
        box.setWidth(h);
        box.setTranslateX(posX);
        box.setTranslateY(posY);
        box.setTranslateZ(posZ);

        PhongMaterial material = new PhongMaterial(Color.BLUEVIOLET);
        sphere.setMaterial(material);
        box.setMaterial(material);

        root.getChildren().add(box);
        root.getChildren().add(sphere);
    }

    private void drawPawnY(int h,int r,double posX,double posY,double posZ)
    {
        Sphere sphere=new Sphere();
        sphere.setRadius(r);
        sphere.setTranslateX(posX);
        sphere.setTranslateY(posY);
        sphere.setTranslateZ(-90);

        Box box=new Box();
        box.setHeight(h);
        box.setDepth(h);
        box.setWidth(h);
        box.setTranslateX(posX);
        box.setTranslateY(posY);
        box.setTranslateZ(posZ);

        PhongMaterial material = new PhongMaterial(Color.YELLOWGREEN);
        sphere.setMaterial(material);
        box.setMaterial(material);

        root.getChildren().add(box);
        root.getChildren().add(sphere);
    }

    private PerspectiveCamera prepareCamera() {
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(cameraX);
        camera.setTranslateY(cameraY);
        camera.setTranslateZ(cameraZ);

        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(cameraAngle);

        camera.setFieldOfView(cameraView);

        return camera;
    }
    private void prepareScene() {
        primaryStage.setScene(new Scene(root, frameWidth, frameHeight, true));
        primaryStage.setTitle("Four Pillars");
        primaryStage.getScene().setCamera(prepareCamera());

        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.LEFT)) {
                    root.setRotate(rootAngle += dr);
                }
                else if (event.getCode().equals(KeyCode.RIGHT)) {
                    root.setRotate(rootAngle -= dr);
                }

                else if (event.getCode().equals(KeyCode.UP)) {
                    primaryStage.getScene().getCamera().setRotate(cameraAngle+=dc);
                }
                else if (event.getCode().equals(KeyCode.DOWN)) {
                    primaryStage.getScene().getCamera().setRotate(cameraAngle-=dc);
                }

                else if (event.getCode().equals(KeyCode.A)) {
                    primaryStage.getScene().getCamera().setTranslateX(cameraX-=dx);
                }
                else if (event.getCode().equals(KeyCode.D)) {
                    primaryStage.getScene().getCamera().setTranslateX(cameraX+=dx);
                }

                else if (event.getCode().equals(KeyCode.W)) {
                    primaryStage.getScene().getCamera().setTranslateY(cameraY-=dy);
                }
                else if (event.getCode().equals(KeyCode.S)) {
                    primaryStage.getScene().getCamera().setTranslateY(cameraY+=dy);
                }

                else if (event.getCode().equals(KeyCode.Q)) {
                    primaryStage.getScene().getCamera().setTranslateZ(cameraZ-=dz);
                }
                else if (event.getCode().equals(KeyCode.E)) {
                    primaryStage.getScene().getCamera().setTranslateZ(cameraZ+=dz);
                }
            }

        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}