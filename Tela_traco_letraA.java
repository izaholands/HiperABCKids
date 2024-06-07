package com.example.telainicial_hiper;


import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.graphics.Path;
import android.graphics.PathMeasure;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;


public class Tela_traco_letraA extends AppCompatActivity {


    private DrawingView drawingView;


    private VectorDrawable letraAPath;
    private ImageView imageView1, imageView2, maoimageview1, maoimageview2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_traco_letra_a);


        drawingView = findViewById(R.id.drawingView1);


        imageView1 = findViewById(R.id.ima_view_a_maiusculo); //referencia ao A maisculo da tela tracejada
        imageView2 = findViewById(R.id.ima_view_a_minusculo);
        maoimageview1 = findViewById(R.id.ima_view_mao_maiusculo);
        maoimageview2 = findViewById(R.id.ima_view_mao_minusculo);


        // Inicialmente, mostra a letra maiúscula A e oculta a minúscula a
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.VISIBLE);






















        // Passando as ImageView para o DrawingView
        // drawingView.setBoundViews(imageView1, imageView2); //, imageView2 quando colocar a segunda imagem




        //carrega o vetor drawable
        //letraAPath = (VectorDrawable) ContextCompat.getDrawable(this,R.drawable.letra_a_path);


        // Iniciar a animação da mão sobre a letra A automaticamente ao criar a atividade
        // animateHandOverLetterA();


        // }
       /*pra aparecer o slapsh comemorativo
       drawingView.setOnFillListener(new DrawingView.OnFillListener() {
           @Override
           public void onFillFinished(){
               if(isImageViewFilled(imageView1) && isImageViewFilled(imageView2)){
                   showSplashScreen();
           }


           }
           private boolean isImageViewFilled(ImageView imageView) {
               Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
               for (int x = 0; x < bitmap.getWidth(); x++) {
                   for (int y = 0; y < bitmap.getHeight(); y++) {
                       if (bitmap.getPixel(x, y) == Color.TRANSPARENT) {
                           return false;
                       }
                   }
               }
               return true;
           }




           private void showSplashScreen() {
               Intent intent = new Intent(Tela_traco_letraA.this, Tela_splash_comemorativo.class);
               startActivity(intent);
               finish();
           }
       });
   }*/


        // Post para garantir que o ImageView esteja organizado
        imageView1.post(() -> animateHandOverLetterA(imageView1));
        imageView2.post(() -> animateHandOverLettera(imageView2));
    }




    //animacao da letra A maiuscula
    private void animateHandOverLetterA(ImageView imageView) {


        // Obtém as dimensões e posição do ImageView
        float imageViewWidth = imageView.getWidth();
        float imageViewHeight = imageView.getHeight();
        float imageViewX = imageView.getX();
        float imageViewY = imageView.getY();


        // Fator de escala para converter coordenadas de caminho em coordenadas ImageView
        float scaleX = imageViewWidth / 164f; // 164 é a largura da porta de visualização no drawable vetorial
        float scaleY = imageViewHeight / 205f; // 205 é a largura da porta de visualização no drawable vetorial


        // Crie um caminho com base nos dados do drawable vetorial
        Path path = new Path();
        path.moveTo(29.6097f * scaleX + imageViewX, 146.738f * scaleY + imageViewY);
        path.lineTo(43.7692f * scaleX + imageViewX, 110.228f * scaleY + imageViewY);
        path.lineTo(64.8063f * scaleX + imageViewX, 46.2282f * scaleY + imageViewY);
        path.lineTo(71.886f * scaleX + imageViewX, 27.9732f * scaleY + imageViewY);
        path.lineTo(78.9658f * scaleX + imageViewX, 9.71812f * scaleY + imageViewY);
        path.lineTo(48.2194f * scaleX + imageViewX, 96.9128f * scaleY + imageViewY);
        path.lineTo(62.3789f * scaleX + imageViewX, 60.4027f * scaleY + imageViewY);
        path.lineTo(11f * scaleX + imageViewX, 194.416f * scaleY + imageViewY);
        path.lineTo(25.1595f * scaleX + imageViewX, 157.906f * scaleY + imageViewY);
        path.lineTo(118.613f * scaleX + imageViewX, 99.9195f * scaleY + imageViewY);
        path.lineTo(104.048f * scaleX + imageViewX, 59.5436f * scaleY + imageViewY);
        path.lineTo(135.604f * scaleX + imageViewX, 151.893f * scaleY + imageViewY);
        path.lineTo(121.04f * scaleX + imageViewX, 111.517f * scaleY + imageViewY);
        path.lineTo(100.003f * scaleX + imageViewX, 48.3758f * scaleY + imageViewY);
        path.lineTo(85.4387f * scaleX + imageViewX, 8f * scaleY + imageViewY);
        path.lineTo(153f * scaleX + imageViewX, 200f * scaleY + imageViewY);
        path.lineTo(138.436f * scaleX + imageViewX, 159.624f * scaleY + imageViewY);
        path.lineTo(90.2934f * scaleX + imageViewX, 151.893f * scaleY + imageViewY);
        path.lineTo(121.04f * scaleX + imageViewX, 151.893f * scaleY + imageViewY);
        path.lineTo(39.7236f * scaleX + imageViewX, 151.893f * scaleY + imageViewY);
        path.lineTo(70.4701f * scaleX + imageViewX, 151.893f * scaleY + imageViewY);







        // Use Path Measure para animar ao longo do caminho
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float pathLength = pathMeasure.getLength();


        ValueAnimator animator = ValueAnimator.ofFloat(0, pathLength);
        animator.setDuration(8000); // duração da animcao
        animator.addUpdateListener(animation -> {
            float distance = (float) animation.getAnimatedValue();
            float[] pos = new float[2];
            pathMeasure.getPosTan(distance, pos, null);
            maoimageview1.setX(pos[0] - maoimageview1.getWidth() / 2+10); // Centralizando a mão no caminho
            maoimageview1.setY(pos[1] - maoimageview1.getHeight() / 2+25);
        });


        animator.start();
    }




    //animacao da letra a minusucula


    private void animateHandOverLettera(ImageView imageView2) {
        if (imageView2 == null || maoimageview2 == null) return;


        float imageView2Width = imageView2.getWidth();
        float imageView2Height = imageView2.getHeight();
        float imageView2X = imageView2.getX();
        float imageView2Y = imageView2.getY();


        float scaleX = imageView2Width / 155f; //largura da letra a minuscula
        float scaleY = imageView2Height / 175f; //altura da letra A maiusucla


        Path path = new Path();
        path.moveTo(78.9679f * scaleX + imageView2X, 24.6456f * scaleY + imageView2Y);
        path.cubicTo(74.4029f * scaleX + imageView2X, 26.6336f * scaleY + imageView2Y,
                69.8817f * scaleX + imageView2X, 28.6023f * scaleY + imageView2Y,
                65.9636f * scaleX + imageView2X, 31.7447f * scaleY + imageView2Y);
        path.cubicTo(64.4175f * scaleX + imageView2X, 32.9847f * scaleY + imageView2Y,
                63.0672f * scaleX + imageView2X, 34.7568f * scaleY + imageView2Y,
                61.2043f * scaleX + imageView2X, 35.533f * scaleY + imageView2Y);
        path.moveTo(57.3363f * scaleX + imageView2X, 39.8306f * scaleY + imageView2Y);
        path.cubicTo(56.2821f * scaleX + imageView2X, 40.5807f * scaleY + imageView2Y,
                55.6267f * scaleX + imageView2X, 41.5308f * scaleY + imageView2Y,
                54.8532f * scaleX + imageView2X, 42.5843f * scaleY + imageView2Y);
        path.cubicTo(52.7615f * scaleX + imageView2X, 45.4334f * scaleY + imageView2Y,
                50.6621f * scaleX + imageView2X, 48.3031f * scaleY + imageView2Y,
                48.8206f * scaleX + imageView2X, 51.3228f * scaleY + imageView2Y);
        path.cubicTo(48.0346f * scaleX + imageView2X, 52.6116f * scaleY + imageView2Y,
                47.3811f * scaleX + imageView2X, 53.9402f * scaleY + imageView2Y,
                46.3057f * scaleX + imageView2X, 55.0156f * scaleY + imageView2Y);


        path.moveTo(43.1069f * scaleX + imageView2X, 60.7885f * scaleY +imageView2Y);
        path.cubicTo(43.1069f * scaleX + imageView2X,61.7805f* scaleY +imageView2Y, 43.1438f* scaleX + imageView2X, 61.4368f* scaleY +imageView2Y, 42.7957f * scaleX + imageView2X ,61.7805f* scaleY +imageView2Y);
        path.cubicTo(40.6958f* scaleX + imageView2X, 63.8538f* scaleY +imageView2Y, 39.6424f* scaleX + imageView2X, 67.0023f* scaleY +imageView2Y, 38.4579f * scaleX + imageView2X, 69.6391f* scaleY +imageView2Y);
        path.cubicTo(36.878f* scaleX + imageView2X, 73.1564f* scaleY +imageView2Y, 35.6574f * scaleX + imageView2X, 76.7743f* scaleY +imageView2Y, 34.3535f * scaleX + imageView2X, 80.3961f* scaleY +imageView2Y);


        path.moveTo(31.2877f * scaleX + imageView2X, 85.7263f* scaleY +imageView2Y);
        path.cubicTo(31.2877f* scaleX + imageView2X, 86.6894f* scaleY +imageView2Y, 31.0755f * scaleX + imageView2X, 87.2028f* scaleY +imageView2Y, 30.6532f * scaleX + imageView2X, 88.1498f* scaleY +imageView2Y);
        path.cubicTo(29.5095f * scaleX + imageView2X, 90.7146f* scaleY +imageView2Y, 28.5769f * scaleX + imageView2X,93.5659f* scaleY +imageView2Y, 28.4126f * scaleX + imageView2X, 96.3863f* scaleY +imageView2Y);
        path.cubicTo(28.307f * scaleX + imageView2X, 98.2002f* scaleY +imageView2Y, 28.2951f * scaleX + imageView2X, 100.023f* scaleY +imageView2Y, 28.1783f* scaleX + imageView2X, 101.833f* scaleY +imageView2Y);
        path.cubicTo(28.1394f * scaleX + imageView2X, 102.437f* scaleY +imageView2Y, 28.2655f * scaleX + imageView2X, 103.397f* scaleY +imageView2Y, 27.9954f * scaleX + imageView2X, 103.937f* scaleY +imageView2Y);


        path.moveTo(26.8293f* scaleX + imageView2X, 109.885f* scaleY +imageView2Y);
        path.cubicTo(26.8293f* scaleX + imageView2X, 113.145f* scaleY +imageView2Y, 26.8293f * scaleX + imageView2X, 116.404f* scaleY +imageView2Y, 26.8293f * scaleX + imageView2X, 119.664f* scaleY +imageView2Y);
        path.cubicTo(26.8293f * scaleX + imageView2X, 120.43f* scaleY +imageView2Y, 27.2997f * scaleX + imageView2X, 124.387f* scaleY +imageView2Y, 28.1536f * scaleX + imageView2X, 124.813f* scaleY +imageView2Y);


        path.moveTo(28.3945f* scaleX + imageView2X, 132.037f* scaleY +imageView2Y);
        path.cubicTo(28.3945f* scaleX + imageView2X, 132.919f* scaleY +imageView2Y, 28.3945f* scaleX + imageView2X, 133.802f* scaleY +imageView2Y, 28.3945f* scaleX + imageView2X, 134.685f* scaleY +imageView2Y);
        path.cubicTo(28.3945f* scaleX + imageView2X, 137.954f* scaleY +imageView2Y, 28.8424f* scaleX + imageView2X, 140.482f* scaleY +imageView2Y, 30.9226f* scaleX + imageView2X, 143.132f* scaleY +imageView2Y);
        path.cubicTo(33.2215f* scaleX + imageView2X, 146.061f* scaleY +imageView2Y, 35.9557f* scaleX + imageView2X, 146.483f* scaleY +imageView2Y, 39.4701f* scaleX + imageView2X, 146.483f* scaleY +imageView2Y);


        path.moveTo(45.8677f* scaleX + imageView2X, 148.487f* scaleY +imageView2Y);
        path.cubicTo(47.7158f* scaleX + imageView2X, 148.598f* scaleY +imageView2Y, 49.4372f* scaleX + imageView2X, 149.234f* scaleY +imageView2Y, 51.3447f* scaleX + imageView2X, 149.234f* scaleY +imageView2Y);
        path.cubicTo(53.5996f* scaleX + imageView2X, 149.234f* scaleY +imageView2Y, 56.0159f* scaleX + imageView2X, 148.58f* scaleY +imageView2Y, 57.9859f* scaleX + imageView2X, 147.469f* scaleY +imageView2Y);
        path.cubicTo(59.8983f* scaleX + imageView2X, 146.391f* scaleY +imageView2Y, 62.0442f* scaleX + imageView2X, 144.997f* scaleY +imageView2Y, 63.5288f* scaleX + imageView2X, 143.347f* scaleY +imageView2Y);


        path.moveTo(90.6987f* scaleX + imageView2X, 22.695f* scaleY +imageView2Y);
        path.cubicTo(90.6987f* scaleX + imageView2X, 23.9334f* scaleY +imageView2Y, 90.9994f* scaleX + imageView2X, 23.709f* scaleY +imageView2Y, 92.2499f* scaleX + imageView2X, 23.977f* scaleY +imageView2Y);
        path.cubicTo(95.849f* scaleX + imageView2X, 24.7482f* scaleY +imageView2Y, 99.58f* scaleX + imageView2X, 26.0004f* scaleY +imageView2Y, 102.724f* scaleX + imageView2X, 27.9511f* scaleY +imageView2Y);
        path.cubicTo(105.428f* scaleX + imageView2X, 29.6294f* scaleY +imageView2Y, 106.351f* scaleX + imageView2X, 32.1509f* scaleY +imageView2Y, 106.852f* scaleX + imageView2X, 35.1558f* scaleY +imageView2Y);


        path.moveTo(69.0571f* scaleX + imageView2X,136.607f* scaleY +imageView2Y);
        path.cubicTo(69.3339f* scaleX + imageView2X, 135.303f* scaleY +imageView2Y, 70.8316f* scaleX + imageView2X, 135.159f* scaleY +imageView2Y, 71.6354f* scaleX + imageView2X, 134.151f* scaleY +imageView2Y);
        path.cubicTo(74.6361f* scaleX + imageView2X, 130.39f* scaleY +imageView2Y, 77.0779f* scaleX + imageView2X, 126.048f* scaleY +imageView2Y, 79.7667f* scaleX + imageView2X, 122.053f* scaleY +imageView2Y);


        path.moveTo(85.8079f* scaleX + imageView2X, 115.188f* scaleY +imageView2Y);
        path.cubicTo(88.9861f* scaleX + imageView2X, 111.387f* scaleY +imageView2Y, 91.8187f* scaleX + imageView2X, 107.286f* scaleY +imageView2Y, 94.8698f* scaleX + imageView2X, 103.38f* scaleY +imageView2Y);


        path.moveTo(97.0228f* scaleX + imageView2X, 96.2805f* scaleY +imageView2Y);
        path.cubicTo(97.0228f* scaleX + imageView2X, 95.7707f* scaleY +imageView2Y, 96.9169f* scaleX + imageView2X, 95.3635f* scaleY +imageView2Y, 97.2975f* scaleX + imageView2X,94.9985f* scaleY +imageView2Y);
        path.cubicTo(100.087f* scaleX + imageView2X, 92.3241f* scaleY +imageView2Y, 102.027f* scaleX + imageView2X, 88.4935f* scaleY +imageView2Y, 103.581f* scaleX + imageView2X, 85.0062f* scaleY +imageView2Y);
        path.cubicTo(104.48f* scaleX + imageView2X, 82.9898f* scaleY +imageView2Y, 105.188f* scaleX + imageView2X, 81.3413f* scaleY +imageView2Y, 106.5f* scaleX + imageView2X, 79.5922f* scaleY +imageView2Y);


        path.moveTo(107.53f* scaleX + imageView2X, 73.4114f* scaleY +imageView2Y);
        path.cubicTo(107.53f* scaleX + imageView2X, 70.9497f* scaleY +imageView2Y, 109.488f* scaleX + imageView2X, 68.5295f* scaleY +imageView2Y, 110.392f* scaleX + imageView2X, 66.2691f* scaleY +imageView2Y);
        path.cubicTo(111.362f* scaleX + imageView2X, 63.8437f* scaleY +imageView2Y, 112.626f* scaleX + imageView2X, 61.5133f* scaleY +imageView2Y, 113.299f* scaleX + imageView2X, 58.9894f* scaleY +imageView2Y);




        path.moveTo(115.771f* scaleX + imageView2X, 49.5122f* scaleY +imageView2Y);
        path.cubicTo(115.771f* scaleX + imageView2X, 45.4912f* scaleY +imageView2Y, 117.983f* scaleX + imageView2X, 40.7991f* scaleY +imageView2Y, 119.686f* scaleX + imageView2X, 37.1505f* scaleY +imageView2Y);


        path.moveTo(122.57f, 28.7034f* scaleY +imageView2Y);
        path.cubicTo(122.57f* scaleX + imageView2X, 25.783f* scaleY +imageView2Y, 127.318f* scaleX + imageView2X, 25.4593f* scaleY +imageView2Y, 129.507f* scaleX + imageView2X, 26.0822f* scaleY +imageView2Y);
        path.cubicTo(132.441f* scaleX + imageView2X, 26.9172f* scaleY +imageView2Y, 133.007f* scaleX + imageView2X, 29.8365f* scaleY +imageView2Y, 133.49f* scaleX + imageView2X, 32.4119f* scaleY +imageView2Y);


        path.moveTo(123.806f* scaleX + imageView2X, 57.1352f* scaleY +imageView2Y);
        path.cubicTo(123.64f* scaleX + imageView2X, 58.9933f* scaleY +imageView2Y, 122.682f* scaleX + imageView2X, 60.2311f* scaleY +imageView2Y, 121.815f* scaleX + imageView2X, 61.8738f* scaleY +imageView2Y);
        path.cubicTo(120.501f* scaleX + imageView2X, 64.364f* scaleY +imageView2Y, 119.371f* scaleX + imageView2X, 66.921f* scaleY +imageView2Y, 118.244f* scaleX + imageView2X, 69.4969f* scaleY +imageView2Y);


        path.moveTo(116.183f* scaleX + imageView2X, 78.3561f* scaleY +imageView2Y);
        path.cubicTo(113.339f* scaleX + imageView2X, 82.4192f* scaleY +imageView2Y, 110.41f* scaleX + imageView2X, 87.6516f* scaleY +imageView2Y, 109.59f* scaleX + imageView2X, 92.572f* scaleY +imageView2Y);


        path.moveTo(107.942f* scaleX + imageView2X, 99.5769f* scaleY +imageView2Y);
        path.cubicTo(107.792f* scaleX + imageView2X, 101.101f* scaleY +imageView2Y, 106.937f* scaleX + imageView2X, 102.326f* scaleY +imageView2Y, 106.386f* scaleX + imageView2X, 103.743f* scaleY +imageView2Y);
        path.cubicTo(105.231f* scaleX + imageView2X, 106.709f* scaleY +imageView2Y, 104.564f* scaleX + imageView2X, 109.694f* scaleY +imageView2Y, 103.822f* scaleX + imageView2X, 112.763f* scaleY +imageView2Y);


        path.moveTo(130.189f* scaleX + imageView2X, 38.182f* scaleY +imageView2Y);
        path.cubicTo(130.189f* scaleX + imageView2X, 38.7921f* scaleY +imageView2Y, 130.067f* scaleX + imageView2X, 39.0995f* scaleY +imageView2Y, 129.802f* scaleX + imageView2X, 39.6897f+imageView2Y);
        path.cubicTo(128.502f* scaleX + imageView2X, 42.5849f* scaleY +imageView2Y, 127.253f* scaleX + imageView2X, 45.4999f* scaleY +imageView2Y, 126.014f * scaleX + imageView2X, 48.4212f+imageView2Y);


        path.moveTo(102.461f* scaleX + imageView2X, 118.01f+imageView2Y);
        path.cubicTo(102.461f* scaleX + imageView2X, 121.814f+imageView2Y, 102.812f* scaleX + imageView2X, 125.562f+imageView2Y, 103.248f* scaleX + imageView2X, 129.312f+imageView2Y);




        path.moveTo(103.794f* scaleX + imageView2X, 133.527f+imageView2Y);
        path.cubicTo(103.794f* scaleX + imageView2X, 134.333f+imageView2Y, 104.083f* scaleX + imageView2X, 134.925f+imageView2Y, 104.414f* scaleX + imageView2X, 135.703f+imageView2Y);
        path.cubicTo(105.134f* scaleX + imageView2X, 137.398f+imageView2Y, 105.863f* scaleX + imageView2X, 139.161f+imageView2Y, 106.911f* scaleX + imageView2X, 140.687f+imageView2Y);
        path.cubicTo(107.273f* scaleX + imageView2X, 141.213f+imageView2Y, 107.267f* scaleX + imageView2X, 141.131f+imageView2Y, 107.681f* scaleX + imageView2X, 141.302f+imageView2Y);


        path.moveTo(111.862f* scaleX + imageView2X, 143.136f+imageView2Y);
        path.cubicTo(114.633f* scaleX + imageView2X, 143.46f+imageView2Y, 117.457f* scaleX + imageView2X, 142.997f+imageView2Y, 120.224f* scaleX + imageView2X, 142.842f+imageView2Y);


        PathMeasure pathMeasure = new PathMeasure(path, false);
        float pathLength = pathMeasure.getLength();


        // Verificando se o comprimento do caminho está correto
        Log.d("PathLength", "Animation: " + pathLength);




        ValueAnimator animator = ValueAnimator.ofFloat(0, pathLength);
        animator.setDuration(5000); // Duration of the animation
        animator.addUpdateListener(animation -> {
            float distance = (float) animation.getAnimatedValue();
            float[] pos = new float[2];
            pathMeasure.getPosTan(distance, pos, null);
            Log.d("Animation", "Position: (" + pos[0] + ", " + pos[1] + ")");


            maoimageview2.setX(pos[0] - maoimageview2.getWidth() / 2+10); // Centering the hand on the path
            maoimageview2.setY(pos[1] - maoimageview2.getHeight() / 2+25);
        });


        animator.start();
    }
}
   /*private void animateHandOverLetterA() {
       /* Coordenadas iniciais da mão (posição inicial)
       float startX = maoimageview.getX();
       float startY = maoimageview.getY();


       //Criar um Path a partir dos dados do vetor
       Path path = new Path();
       path.moveTo(29.6097f, 146.738f);
       path.lineTo(43.7692f, 110.228f);
       path.moveTo(64.8063f, 46.2282f);
       path.lineTo(71.886f, 27.9732f);
       path.lineTo(78.9658f, 9.71812f);
       path.moveTo(48.2194f, 96.9128f);
       path.lineTo(62.3789f, 60.4027f);
       path.moveTo(11f, 194.416f);
       path.lineTo(25.1595f, 157.906f);
       path.moveTo(118.613f, 99.9195f);
       path.lineTo(104.048f, 59.5436f);
       path.moveTo(135.604f, 151.893f);
       path.lineTo(121.04f, 111.517f);
       path.moveTo(100.003f, 48.3758f);
       path.lineTo(85.4387f, 8f);
       path.moveTo(153f, 200f);
       path.lineTo(138.436f, 159.624f);
       path.moveTo(90.2934f, 151.893f);
       path.lineTo(121.04f, 151.893f);
       path.moveTo(39.7236f, 151.893f);
       path.lineTo(70.4701f, 151.893f);




       // Usar PathMeasure para animar ao longo do caminho
       PathMeasure pathMeasure = new PathMeasure(path, false);
       float pathLength = pathMeasure.getLength();


       ValueAnimator animator = ValueAnimator.ofFloat(0, pathLength);
       animator.setDuration(3000); // Duração da animação
       animator.addUpdateListener(animation -> {
           float distance = (float) animation.getAnimatedValue();
           float[] pos = new float[2];
           pathMeasure.getPosTan(distance, pos, null);
           maoimageview.setX(pos[0]);
           maoimageview.setY(pos[1]);
       });


       animator.start();
   }
}/






       /* Coordenadas finais da mão (posição final sobre a letra A)
       float finalX = imageView2.getX() + (imageView2.getWidth() - maoimageview.getWidth()) / 2;
       float finalY = imageView2.getY() + (imageView2.getHeight() - maoimageview.getHeight()) / 2;


       // Criar animação para mover a mão da posição inicial para a posição final
       ObjectAnimator animatorX = ObjectAnimator.ofFloat(maoimageview, "translationX", startX, finalX);
       ObjectAnimator animatorY = ObjectAnimator.ofFloat(maoimageview, "translationY", startY, finalY);


       // Combinar as animações de X e Y em um conjunto de animação
       AnimatorSet animatorSet = new AnimatorSet();
       animatorSet.playTogether(animatorX, animatorY);
       animatorSet.setDuration(1000); // Duração da animação em milissegundos (1 segundo)


       //Iniciar a animação
       animatorSet.start();
   }


   }*/
