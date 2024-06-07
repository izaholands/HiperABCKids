package com.example.telainicial_hiper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class DrawingView extends View {
    private Paint paint;
    private Path path;

    public DrawingView(Context context){
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();

    }

    public DrawingView(Context context, AttributeSet attrs, int defStuleAttr){
        super(context, attrs, defStuleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        path= new Path();
    }

    public void setPath(Path path){
        this.path = path;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (path != null) {
            canvas.drawPath(path, paint);
        }
    }

}













    /*

    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private OnFillListener fillListener;//ouvinte
    private ImageView imageView1, imageView2;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing() {
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(Color.RED); //cor do traco
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(70); //largura do traço
        drawPaint.setStyle(Paint.Style.STROKE); //estilo do traço
        drawPaint.setStrokeJoin(Paint.Join.ROUND); //uniao das linhas
        drawPaint.setStrokeCap(Paint.Cap.ROUND); //extremidade das linhas
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        //if (isTouchWithinBounds(touchX, touchY)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    drawPath.moveTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    drawPath.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
                    checkIfFilled(); // Verifica se as áreas foram preenchidas
                    //  if (fillListener != null) {
                    //    fillListener.onFillFinished();
                    //}
                    break;
                default:
                    return false;
            }
            invalidate();
        //}
        return true;
    }

    private void checkIfFilled() {
        // Verifica se as áreas foram preenchidas
        if (fillListener != null) {
            fillListener.onFillFinished();
        }
    }



    private boolean isTouchWithinBounds(float x, float y) {
        if (imageView1 != null && imageView2 != null) {
            int[] location1 = new int[2];
            imageView1.getLocationOnScreen(location1);
            int left1 = location1[0];
            int top1 = location1[1];
            int right1 = left1 + imageView1.getWidth();
            int bottom1 = top1 + imageView1.getHeight();

            int[] location2 = new int[2];
            imageView2.getLocationOnScreen(location2);
            int left2 = location2[0];
            int top2 = location2[1];
            int right2 = left2 + imageView2.getWidth();
            int bottom2 = top2 + imageView2.getHeight();

            return (x > left1 && x < right1 && y > top1 && y < bottom1) ||
                    (x > left2 && x < right2 && y > top2 && y < bottom2);
        }
        return false;
    }

    public void setBoundViews(ImageView iv1, ImageView iv2) {
        this.imageView1 = iv1;
        this.imageView2 = iv2;
    }

  /* public void clearDrawing() {
        drawCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    // Método para notificar quando o preenchimento for concluído
    public void setOnFillListener(OnFillListener listener) {

        this.fillListener = listener;
    }

    public interface OnFillListener {
        void onFillFinished();
    }
}*/
