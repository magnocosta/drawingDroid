package br.com.drawing;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import br.com.drawing.formas.Circulo;
import br.com.drawing.formas.Forma;
import br.com.drawing.formas.MaoLivre;
import br.com.drawing.formas.Reta;

public class DrawingDroidView extends View {

	Context thisContext = null;
	private static Bitmap mBitmap;
	private static Canvas mCanvas;
	private static Path mPath;
	private static Paint mBitmapPaint;
	private static Paint mPaint;

	private MaskFilter mEmboss;

	public DrawingDroidView(Context context) {
		super(context);

	}

	public DrawingDroidView(Context context, AttributeSet attrs) {
		super(context);
		setFocusable(true);
		thisContext = context;

		mBitmap = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
		mPath = new Path();
		mBitmapPaint = new Paint(Paint.DITHER_FLAG);
	}

	public DrawingDroidView(Context context, AttributeSet attrs,
			Map inflateParams) {
		super(context);

	}

	public static final int MAO_LIVRE = 0;
	public static final int RETA = 1;
	public static final int CIRCULO = 2;
	public static final int APAGAR = 9;

	static int modo = RETA;

	private float xi;
	private float yi;

	private float radius;

	Reta reta;
	Circulo circulo;
	MaoLivre maoLivre;

	private static ArrayList<Forma> listaDeFormas = new ArrayList<Forma>();

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	// Fundo da tela
	@Override
	protected void onDraw(Canvas canvas) {

		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		// mPaint.setColor(0xFFFF0000);
		switch (modo) {
		case MAO_LIVRE:
			mPaint.setColor(0xFF00FF00);
			break;
		case RETA:
			mPaint.setColor(0xFFFF0000);
			break;
		case CIRCULO:
			mPaint.setColor(0xFFFFFF00);
			break;
		}
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(4);

		mEmboss = new EmbossMaskFilter(new float[] { 1, 1, 1 }, 0.4f, 6, 3.5f);

		mPaint.setMaskFilter(mEmboss);

		canvas.drawColor(0xFFAAAAAA);
		canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
		canvas.drawPath(mPath, mPaint);
	}

	private static final float TOUCH_TOLERANCE = 4;

	private void touch_start(float x, float y) {
		mPaint.setXfermode(null);
		mPaint.setAlpha(0xFF);
		mPath.reset();
		mPath.moveTo(x, y);

		switch (modo) {
		case MAO_LIVRE:
			xi = x;
			yi = y;
			break;
		case RETA:
			reta = new Reta(x, y, x, y);
			break;
		case CIRCULO:
			circulo = new Circulo(x, y, 0);
			break;
		}

	}

	private void touch_move(float x, float y) {

		float dx = Math.abs(x - xi);
		float dy = Math.abs(y - yi);
		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
			switch (modo) {
			case MAO_LIVRE:
				desenharMaoLivre(x, y);
				break;
			case RETA:
				reta.setXf(x);
				reta.setYf(y);
				desenharReta(reta);
				// desenharReta(x, y);
				break;
			case CIRCULO:
				radius = (float) Math.sqrt(Math.pow((x - circulo.getXi()), 2)
						+ Math.pow((y - circulo.getYi()), 2));
				circulo.setRaio(radius);
				desenharCirculo(circulo);
				// desenharCirculo(x, y);
				break;
			/*
			 * case APAGAR: listaDeFormas.remove(listaDeFormas.size()-1);
			 * redraw(listaDeFormas); //apagar(x, y); break;
			 */
			}

		}

	}

	private void touch_up(float x, float y) {
		switch (modo) {
		case MAO_LIVRE:
			mPath.lineTo(xi, yi);
			// listaDeFormas.add(maoLivre);
			mCanvas.drawPath(mPath, mPaint);
			break;
		case RETA:
			listaDeFormas.add(reta);
			// mCanvas.drawLine(reta.getXi(), reta.getYi(), reta.getXf(),
			// reta.getYf(), mPaint);
			break;
		case CIRCULO:
			listaDeFormas.add(circulo);
			// mCanvas.drawCircle(xi, yi, radius, mPaint);
			break;
		}
		redraw(listaDeFormas);
		mPath.reset();

	}

	private void desenharMaoLivre(float x, float y) {
		// mPath.quadTo(xi, yi, (x + xi) / 2, (y + yi) / 2);
		mPath.quadTo(xi, yi, x, y);
		xi = x;
		yi = y;
	}

	/*
	 * private void desenharReta(float x, float y) { mPath.reset();
	 * mPath.moveTo(x, y); mPath.lineTo(xi, yi); }
	 */

	private void desenharReta(Reta reta) {
		mPath.reset();
		mPath.moveTo(reta.getXf(), reta.getYf());
		mPath.lineTo(reta.getXi(), reta.getYi());
	}

	/*
	 * private void desenharCirculo(float x, float y) { mPath.reset();
	 * mPath.moveTo(x, y); radius = (float) Math.sqrt(Math.pow((x - xi), 2) +
	 * Math.pow((y - yi), 2)); circulo.setRaio(radius); mPath.addCircle(xi, yi,
	 * radius, Path.Direction.CW); }
	 */

	private void desenharCirculo(Circulo circulo) {
		mPath.reset();
		mPath.moveTo(circulo.getXf(), circulo.getYf());
		mPath.addCircle(circulo.getXi(), circulo.getYi(), circulo.getRaio(),
				Path.Direction.CW);
	}

	/*private void apagar(float x, float y) {
		mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
	}*/

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			touch_start(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			touch_move(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			touch_up(x, y);
			invalidate();
			break;

		}
		return true;
	}

	public static void novoDesenho() {

		listaDeFormas.clear();
		redraw(listaDeFormas);

	}

	public static void apagarUltimo() {

		if (!listaDeFormas.isEmpty()) {
			listaDeFormas.remove(listaDeFormas.size() - 1);
			redraw(listaDeFormas);
			//mCanvas.drawLine(100, 100, 200, 200, mPaint);
		}

	}

	public static void redraw(ArrayList<Forma> listaDeFormas) {

		mBitmap = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);

		for (Forma forma : listaDeFormas) {

			mPaint.setColor(forma.getCor());

			switch (forma.getTipo()) {
			case MAOLIVRE:

				break;
			case RETA:
				mCanvas.drawLine(forma.getXi(), forma.getYi(), forma.getXf(),
						forma.getYf(), mPaint);
				break;
			case CIRCULO:
				mCanvas.drawCircle(forma.getXi(), forma.getYi(),
						forma.getRaio(), mPaint);
				break;

			}
		}

	}

}
