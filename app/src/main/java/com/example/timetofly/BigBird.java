package com.example.timetofly;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.function.BiFunction;

import static com.example.timetofly.GameView.screenRatioX;
import static com.example.timetofly.GameView.screenRatioY;
import static com.example.timetofly.GameView.score;

public class BigBird extends Bird{
    public BigBird(Resources res){
        bird1 = BitmapFactory.decodeResource(res, R.drawable.bird1);
        bird2 = BitmapFactory.decodeResource(res, R.drawable.bird2);
        bird3 = BitmapFactory.decodeResource(res, R.drawable.bird3);
        bird4 = BitmapFactory.decodeResource(res, R.drawable.bird4);
        width = bird1.getWidth();
        height = bird1.getHeight();
        width/=3;
        height/=3;
        width = (int)(width*screenRatioX);
        height = (int)(height*screenRatioY);
        bird1 = Bitmap.createScaledBitmap(bird1, width, height, false);
        bird2 = Bitmap.createScaledBitmap(bird2, width, height, false);
        bird3 = Bitmap.createScaledBitmap(bird3, width, height, false);
        bird4 = Bitmap.createScaledBitmap(bird4, width, height, false);

        y = -height;
    }

    Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
}
