package yuandong.headline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HeadLineView headLineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headLineView = findViewById(R.id.headline);
        initData();
    }

    private void initData() {
        List<String> news = new ArrayList<>();
        news.add("魅族_魅蓝note5_新品上市，赶快拥有");
//        news.add("亲，你的健康周报来了，请查看");
//        news.add("今天天气温度稍高，请适当减少衣物");
        headLineView.setData(news);
    }
}
