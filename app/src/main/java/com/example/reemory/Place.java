package com.example.reemory;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Place {

    private Bitmap image;
    public Float xCoord, yCoord;
    private int xDim, yDim;

    public Place(Bitmap image, Float xCoord, Float yCoord, int xDim, int yDim) {
        this.image = image;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xDim = xDim;
        this.yDim = yDim;
    }

    public void draw(Canvas canvas) {

        Bitmap b = Bitmap.createScaledBitmap(image, xDim, yDim, false);
        canvas.drawBitmap(b, xCoord, yCoord, null);
    }
}
