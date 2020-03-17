package com.example.reemory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Form {

    private Bitmap image;
    public Float x, y;
    private Float screenWidth = Float.valueOf(Resources.getSystem().getDisplayMetrics().widthPixels);
    private Float screenHeight = Float.valueOf(Resources.getSystem().getDisplayMetrics().heightPixels);

    public Form(Bitmap formImage) {

        image = formImage;
        x = screenWidth / 2 - 100;
        y = screenHeight - 300;
    }

    public void draw(Canvas canvas) {

        Bitmap b = Bitmap.createScaledBitmap(image, 300, 300, false);
        canvas.drawBitmap(b, x, y, null);
    }

    public void update() {

        if (GameView.xTouch != -1 && GameView.yTouch != -1) {

            x = GameView.xTouch;
            y = GameView.yTouch;
            //Sa nu se poata duce in dreapta si jos.


        }
    }



}

