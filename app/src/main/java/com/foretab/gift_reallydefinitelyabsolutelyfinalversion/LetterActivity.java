package com.foretab.gift_reallydefinitelyabsolutelyfinalversion;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;


public class LetterActivity extends AppCompatActivity {

    private PrinterTextView mPrinterTextView;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);
        final Rect droidTarget = new Rect(1850, 0,0, 300);
        TapTargetView.showFor(this, TapTarget.forBounds(droidTarget,"点击左边，拆开信封\n点击右边，合上信封")
                .cancelable(false)
                .targetCircleColor(R.color.white)
                .transparentTarget(true)
                .drawShadow(false)
                .targetRadius(66)
                .tintTarget(false), new TapTargetView.Listener() {
            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                Log.d("TapTargetViewSample", "You dismissed me :(");
            }
        });
        getSupportActionBar().show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#795548")));
        getSupportActionBar().setTitle("信");
        getWindow().setStatusBarColor((Color.parseColor("#795548")));
        Resources res = getResources();
        Drawable color = res.getDrawable(R.color.colorLetter);
        this.getWindow().setBackgroundDrawable(color);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.open:
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/mama.ttf");
                mPrinterTextView = (PrinterTextView) findViewById(R.id.letter);
                mPrinterTextView.setTypeface(typeface);
                mPrinterTextView.setPrintText("妈妈：      \n怡博，今天是你的生日。生日快乐！\n妈妈看着你长大成人，现在，你也成为了你儿子的母亲，有一天他也会像你一样慢慢长大，你会发现这是一个既漫长又短暂的过程。"
                        + "在这个过程中，你会有辛苦，更多的是甜蜜。我希望你不辞辛苦，收获甜蜜，永远健健康康，快快乐乐。"+"\n        \n        \n"
                        + "爸爸：      \n闺女，伴随着时间的流动，岁月把你从原来的那个小宝贝乖乖女，随着星转斗移，"
                        + "慢慢地把你变成了年长老爸老妈的贴心小棉袄了。今天是你的生日，特送上鲜花一束，祝福你永远幸福美丽！天天开心快乐！"+"\n        \n        \n"
                        + "孩子他爸：      \n媳妇儿。今天是你的生日，我不会说什么高上大的话，但是谢谢你为这个家辛苦忙碌，"
                        + "也谢谢你给于我的包容和理解。希望日后我们这个家随着孩子的逐渐长大充满着更多的欢声笑语，生日快乐！"+"\n        \n        \n"
                        + "小叔：      \n祝福晶晶姑娘生日快乐！！"+"\n        \n        \n"
                        + "张琪：      \n哎生日快乐！别减肥了，多吃点肉，胖了有福身体好。"+"\n        \n        \n"
                        + "大舅：      \n我的祝福是：外甥女天天快乐，就是我的祝福。你和怡博就是我的最亲，你们快乐就是我最大的安慰。平时唠叨不多，但是是最贴心的小辈。你妈妈给我们兄弟姐妹的关心都是知道的。"
                        + "你们一定要学习的。你们要满满体会。满满吸收，转化成自己的意识。咱们家族不善言谈，但家风还是很好的。多向父母学习，多多感悟。我平时和你们交流很少，距离较远，没办法，但咱们心是近的，"
                        + "有事没事都可以聊。你爸爸妈妈可能不善言谈，但要理解。舅舅也是可以依靠的后盾。我们过年可能回老家，咱们畅聊啊。最后，祝外甥女生日快乐，家庭幸福，工作顺利，永葆快乐，常回家看看。"+"   \n"
                        + "（PS：...大舅喝酒了）"+"\n        \n        \n"
                        + "小舅：      \n晶晶小老虎变成大老虎了。新的一年祝愿你别因为太在意别人的看法而过的畏手畏脚。因为无论你做得多好都会有人对你指手画脚的。最后，生日快乐啊！"+"\n        \n"
                        + "完",180, "|");
                mPrinterTextView.startPrint();
                break;
            case R.id.close:
                finish();
                break;
            default:
        }
        return true;
    }
}