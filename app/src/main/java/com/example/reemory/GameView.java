package com.example.reemory;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.util.Random;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    //FORM PARAMETERS
    private MyThread thread;
    private Form form;
    public String randomForm;
    private Canvas myCanvas;

    //EASY LEVEL PARAMETERS
    private String[] stringEzLvPlaces = new String[3];
    private Place[] placeEzLvPlaces = new Place[3];
    int ezFormsPlaces = 0;

    //MEDIUM LEVEL PARAMETERS
    private Place[] mediumLvPlaces = new Place[4];

    //HARD LEVEL PARAMETERS
    private Place[] hardLvPlaces = new Place[5];

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public static Float xTouch, yTouch = -1f;

    public GameView(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread = new MyThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.bluetriangle));
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        boolean retry = true;

        while (retry) {

            try {
                thread.setRunning(false);
                thread.join();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void update() {

        form.update();
        collision();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.myCanvas = canvas;

        if (canvas != null) {

            EzRandomLvGen();
            placeEzLvPlaces[0].draw(myCanvas);
            placeEzLvPlaces[1].draw(myCanvas);
            placeEzLvPlaces[2].draw(myCanvas);
            randomForm();
            form.draw(myCanvas);
            System.out.println(randomForm);

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        xTouch = event.getX();
        yTouch = event.getY();

        return true;
    }

    public void EzRandomLvGen() {

        stringEzLvPlaces[0] = "";
        stringEzLvPlaces[1] = "";
        stringEzLvPlaces[2] = "";

        Random random = new Random();
        String[] places = new String[5];
        places[0] = "redtriangleplace";
        places[1] = "greentriangleplace";
        places[2] = "orangetriangleplace";
        places[3] = "yellowtriangleplace";
        places[4] = "bluetriangleplace";

//        places[5] = "redcircleplace";
//        places[6] = "greencircleplace";
//        places[7] = "orangecircleplace";
//        places[8] = "yellowcircleplace";
//        places[9] = "bluecircleplace";
//
//        places[10] = "redsquareplace";
//        places[11] = "greensquareplace";
//        places[12] = "orangesquareplace";
//        places[13] = "yellowsquareplace";
//        places[14] = "bluesquareplace";


        while (ezFormsPlaces < 3) {

            String place = places[random.nextInt(places.length)];

            switch (place) {

                case "redtriangleplace":

                    if (stringEzLvPlaces[0].equals("") || stringEzLvPlaces[1].equals("") || stringEzLvPlaces[2].equals("")) {

                        if (stringEzLvPlaces[0].equals(place) || stringEzLvPlaces[1].equals(place))
                            continue;
                        else {

                            placeEzLvPlaces[ezFormsPlaces] = new Place(BitmapFactory.decodeResource(getResources(), R.drawable.redtriangleplace), screenWidth / 3f * ezFormsPlaces, 0f, screenWidth / 3, 500);
                            stringEzLvPlaces[ezFormsPlaces] = "redtriangleplace";
                            ezFormsPlaces++;
                            break;

                        }
                    }

                case "greentriangleplace":

                    if (stringEzLvPlaces[0].equals("") || stringEzLvPlaces[1].equals("") || stringEzLvPlaces[2].equals("")) {

                        if (stringEzLvPlaces[0].equals(place) || stringEzLvPlaces[1].equals(place))
                            continue;
                        else {

                            placeEzLvPlaces[ezFormsPlaces] = new Place(BitmapFactory.decodeResource(getResources(), R.drawable.greentriangleplace), screenWidth / 3f * ezFormsPlaces, 0f, screenWidth / 3, 500);
                            stringEzLvPlaces[ezFormsPlaces] = "greentriangleplace";
                            ezFormsPlaces++;
                            break;

                        }
                    }

                case "orangetriangleplace":

                    if (stringEzLvPlaces[0].equals("") || stringEzLvPlaces[1].equals("") || stringEzLvPlaces[2].equals("")) {

                        if (stringEzLvPlaces[0].equals(place) || stringEzLvPlaces[1].equals(place))
                            continue;
                        else {

                            placeEzLvPlaces[ezFormsPlaces] = new Place(BitmapFactory.decodeResource(getResources(), R.drawable.orangetriangleplace), screenWidth / 3f * ezFormsPlaces, 0f, screenWidth / 3, 500);
                            stringEzLvPlaces[ezFormsPlaces] = "orangetriangleplace";
                            ezFormsPlaces++;
                            break;

                        }
                    }

                case "yellowtriangleplace":

                    if (stringEzLvPlaces[0].equals("") || stringEzLvPlaces[1].equals("") || stringEzLvPlaces[2].equals("")) {


                        if (stringEzLvPlaces[0].equals(place) || stringEzLvPlaces[1].equals(place))
                            continue;
                        else {

                            placeEzLvPlaces[ezFormsPlaces] = new Place(BitmapFactory.decodeResource(getResources(), R.drawable.yellowtriangleplace), screenWidth / 3f * ezFormsPlaces, 0f, screenWidth / 3, 500);
                            stringEzLvPlaces[ezFormsPlaces] = "yellowtriangleplace";
                            ezFormsPlaces++;
                            break;

                        }
                    }

                case "bluetriangleplace":

                    if (stringEzLvPlaces[0].equals("") || stringEzLvPlaces[1].equals("") || stringEzLvPlaces[2].equals("")) {

                        if (stringEzLvPlaces[0].equals(place) || stringEzLvPlaces[1].equals(place))
                            continue;
                        else {

                            placeEzLvPlaces[ezFormsPlaces] = new Place(BitmapFactory.decodeResource(getResources(), R.drawable.bluetriangleplace), screenWidth / 3f * ezFormsPlaces, 0f, screenWidth / 3, 500);
                            stringEzLvPlaces[ezFormsPlaces] = "bluetriangleplace";
                            ezFormsPlaces++;
                            break;

                        }
                    }

                default:
                    System.out.println("Alo");
            }
        }

    }

    public void randomForm() {

        Random random = new Random();
        randomForm = stringEzLvPlaces[random.nextInt(stringEzLvPlaces.length)];

        switch (randomForm) {

            case "redtriangleplace":
                form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.redtriangle));
                break;
            case "greentriangleplace":
                form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.greentriangle));
                break;
            case "orangetriangleplace":
                form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.orangetriangle));
                break;
            case "yellowtriangleplace":
                form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.yellowtriangle));
                break;
            case "bluetriangleplace":
                form = new Form(BitmapFactory.decodeResource(getResources(), R.drawable.bluetriangle));
                break;
        }
    }

    public void collision() {

        if (stringEzLvPlaces[0] != null || stringEzLvPlaces[1] != null || stringEzLvPlaces[2] != null) {

            System.out.println("Nu ba!!!");
            System.out.println(stringEzLvPlaces[0] + "1");
            System.out.println(stringEzLvPlaces[1] + "2");
            System.out.println(stringEzLvPlaces[2] + "3");
            System.out.println(randomForm);
        } else {
            if (stringEzLvPlaces[0].equals(randomForm)) {
                System.out.println(" distanta1 = " + String.valueOf(placeEzLvPlaces[0].yCoord - form.y));
            }

            if (stringEzLvPlaces[1].equals(randomForm)) {
                System.out.println(" distanta2 = " + String.valueOf(placeEzLvPlaces[1].yCoord - form.x - 500));
            }


            if (stringEzLvPlaces[2].equals(randomForm)) {
                System.out.println(" distanta3 = " + String.valueOf(placeEzLvPlaces[2].yCoord - form.x - 500));
            }
        }


//
//        if (stringEzLvPlaces[0].equals(randomForm) && placeEzLvPlaces[0].yCoord.equals(form.x - 500) ||
//                stringEzLvPlaces[1].equals(randomForm) && placeEzLvPlaces[1].yCoord.equals(form.x - 500) ||
//                stringEzLvPlaces[2].equals(randomForm) && placeEzLvPlaces[2].yCoord.equals(form.x - 500))
//        {
//          randomForm(myCanvas);
//        }

    }


}
