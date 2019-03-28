package com.betulerdogan.gesturedetection;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gDetect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gDetect=new GestureDetectorCompat(this,new GestureListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener{
        private float flingMin=100;
        private float velocityMin=100;

        //Kullanıcı yukarı veya sola doğru mesajlar arasında ilerleyebilecek.
        boolean forward=false;
        //Kullanıcı aşağı veya sağa doğru mesajlar arasında ilerleyebilecek.
        boolean backward=false;

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            System.out.println("Tek Tıklama");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            System.out.println("Uzun Tıklama");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            System.out.println("Kaydırma");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //kaydırma hareketindeki x pozisyonundaki değişimi hesapla
            float horizontalDiff = e2.getX() - e1.getX();
            //kaydırma hareketindeki y pozisyonundaki değişimi hesapla
            float verticalDiff = e2.getY() - e1.getY();

            float absHDiff = Math.abs(horizontalDiff);
            float absVDiff = Math.abs(verticalDiff);
            float absVelocityX = Math.abs(velocityX);
            float absVelocityY = Math.abs(velocityY);

            if (absHDiff > absVDiff && absHDiff > flingMin && absVelocityX > velocityMin) {
                //ileri veya geriye hareket et
                if (horizontalDiff > 0) {
                    backward = true;
                } else if (absVDiff > flingMin && absVelocityY > velocityMin) {
                    if (verticalDiff > 0) {
                        backward = true;
                    } else {
                        forward = true;
                    }
                }
            }
            //ileriye doğru mesajlarda dolaş
            if (forward) {
                System.out.println("kullanıcı ileriye doğru mesajlarda dolaşıyor");
            }
            //geriye doğru dolaş
            else if (backward) {
                System.out.println("kullanıcı geriye doğru mesajlarda dolaşıyor");
            }

            return true;
        }


        @Override
        public boolean onDown(MotionEvent e) {
            System.out.println("Aşağı");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            System.out.println("Çift Tıklama");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            System.out.println("Tek Tıklama");
            return super.onSingleTapConfirmed(e);
        }
    }
}
