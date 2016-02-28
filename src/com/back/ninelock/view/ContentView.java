package com.back.ninelock.view;

import java.util.ArrayList;
import java.util.List;

import com.back.ninelock.R;
import com.back.ninelock.model.Point;
import android.content.Context;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * @Author Back
 * @Date 2016/1
 * @Des 绘制底层的九个点
 */
public class ContentView extends ViewGroup {
	private List<Point> list;
	private int width;
	private int d; // width 的三分之一
	private Context context;
	private int row;// 第几行
	private int col;// 第几列
	private int baseNum = 6;
	private Line line;

	public ContentView(Context context) {
		super(context);
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		width = wm.getDefaultDisplay().getWidth();
		d = width / 3;
		this.list = new ArrayList<Point>();
		this.context = context;
		addChild();

		line = new Line(context, list,width);

	}

	private void addChild() {
		for (int i = 0; i < 9; i++) {
			ImageView iv = new ImageView(context);
			iv.setBackgroundResource(R.drawable.gesture_node_normal);
			this.addView(iv);
			row = i / 3;
			col = i % 3;
			// 定义点的每个属性
			int leftX = col * d + d / baseNum;
			int topY = row * d + d / baseNum;
			int rightX = col * d + d - d / baseNum;
			int bottomY = row * d + d - d / baseNum;

			Point point = new Point(leftX, rightX, topY, bottomY, iv, i + 1);

			this.list.add(point);

		}

	}

	public void setParentView(ViewGroup parent) {
		LayoutParams layoutParams = new LayoutParams(width, width);

		this.setLayoutParams(layoutParams);
		line.setLayoutParams(layoutParams);

		parent.addView(this);
		parent.addView(line);

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		for (int i = 0; i < getChildCount(); i++) {
			row = i / 3;
			col = i % 3;
			getChildAt(i).layout(col * d + d / baseNum, row * d + d / baseNum,
					col * d + d - d / baseNum, row * d + d - d / baseNum);

		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
