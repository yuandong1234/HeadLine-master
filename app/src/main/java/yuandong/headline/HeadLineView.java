package yuandong.headline;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * 仿淘宝头条View
 * Created by yuandong on 2018/3/4.
 */

public class HeadLineView extends LinearLayout {
    private Context mContext;
    private ViewFlipper flipper;
    private List<String> data;


    public HeadLineView(Context context) {
        this(context, null);
    }

    public HeadLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.layout_news, null);
        flipper = view.findViewById(R.id.marquee_view);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(4000);
        flipper.startFlipping();
        flipper.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = flipper.getDisplayedChild();
                if (data != null && data.size() != 0) {
                    Log.e("MainActivity ", data.get(position));
                }
            }
        });
        addView(view);
    }

    public void setData(List<String> data) {
        if (flipper == null || data == null || data.size() == 0) return;
        this.data = data;
        flipper.removeAllViews();
        if (data.size() == 1) {
            this.data.add(data.get(0));
            flipper.setOutAnimation(mContext, R.anim.anim_out_h);
            flipper.setInAnimation(mContext, R.anim.anim_in_h);
        } else {
            flipper.setOutAnimation(mContext, R.anim.anim_out);
            flipper.setInAnimation(mContext, R.anim.anim_in);
        }
        for (int i = 0; i < data.size(); i++) {
            View view = View.inflate(mContext, R.layout.layout_news_item, null);
            TextView text = view.findViewById(R.id.text);
            text.setText(data.get(i));
            flipper.addView(view);
        }
    }

}
