package com.foretab.gift_reallydefinitelyabsolutelyfinalversion;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout blank_space;
    private int show = 1;
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exit, menu);
        if (show != 1){
            menu.findItem(R.id.exit).setVisible(true);
        }else{
            menu.findItem(R.id.exit).setVisible(false);
        }
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//重新显示状态栏和Actionbar
        getSupportActionBar().show();
        getSupportActionBar().setTitle("(/◔ ◡ ◔)/呐，你的礼物~");
        getWindow().setFlags(0, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//设置连续点击屏幕空白处十次触发toast
        blank_space= (LinearLayout) findViewById(R.id.base_container);
        blank_space.setOnClickListener(new View.OnClickListener() {
            //需要监听几次点击事件数组的长度就为几
            //如果要监听双击事件则数组长度为2，如果要监听3次连续点击事件则数组长度为3...
            long[] mHints = new long[15];//初始全部为0
            public void onClick(View v) {
                //将mHints数组内的所有元素左移一个位置
                System.arraycopy(mHints, 1, mHints, 0, mHints.length - 1);
                //获得当前系统已经启动的时间
                mHints[mHints.length - 1] = SystemClock.uptimeMillis();
                if(SystemClock.uptimeMillis()-mHints[0]<=3000)
                    Toast.makeText(getApplicationContext(),"点这么多下你是想干嘛( •̀_•́ )",
                            Toast.LENGTH_SHORT).show();
            }
        });

        ImageView button = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(this);

//打开Activity时的引导动画
        final SpannableString spannedDesc = new SpannableString("我要拆开我要拆开~~");
        TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.image_view), "哇，这儿有个大礼包呀", spannedDesc)
                .cancelable(false)
                .drawShadow(true)
                .targetRadius(120)
                .targetCircleColor(R.color.white)
                .tintTarget(false), new TapTargetView.Listener() {

            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                Log.d("TapTargetViewSample", "You dismissed me :(");
            }
        });
    }

    private void showAlerDialog1() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("你好呀")
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog2();
                    }
                })
                .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog2() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("啊我还没自我介绍呢，你知道我是谁嘛")
                .setPositiveButton("你是谁啊",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog3();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog3() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("咳咳，我啊，我是主人呕心沥血制作出来的一个聊天机器人啦，Nice to meet you~")
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog4();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog4() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("我听主人说，制作我是作为生日礼物送给......")
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog5();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog5() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("等等，你还没告诉我你是谁呐")
                .setPositiveButton("我是...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog6();
                    }
                })
                .setNegativeButton("不告诉你",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog5_1();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.buttonOrange));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog5_1() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("唉呀，好姐姐你就告诉我吧，要是找错人了回头主人会把我neng死的")
                .setPositiveButton("好好好...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog6();
                    }
                })
                .setNegativeButton("就不告诉你！",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, "让你皮！让你皮！重新一个一个对话框点回来吧你",
                                Toast.LENGTH_LONG).show();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.buttonOrange));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog6() {
        final EditText et = new EditText(this);
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        et.setHint("你的名字~");
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(et,64,64,64,20)
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        String editText1 = et.getText().toString();
                        if (editText1.equals("范怡博")||editText1.equals("范晶晶")||editText1.equals("蓝星一美")) {
                            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                            dialog.dismiss();
                            //线程阻断一小段时间
                            try {
                                Thread.currentThread().sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            showAlerDialog7();
                        }
                        else {
                            finish();
                            Toast.makeText(MainActivity.this, "我不是来找你的，一边儿凉快着去",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog7() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("啊太好了，我就是来找你的")
                .setPositiveButton("你找我干什么呀", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog8();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog8() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("......等等")
                .setPositiveButton("怎么了",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog9();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog9() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("......不对啊")
                .setPositiveButton("到底怎么了...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog10();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog10() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("为什么我主人长那么丑你是他亲姐姐却这么好看✪ω✪...")
                .setPositiveButton(" (◍❛ᴗ❛◍) emm...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog11();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog11() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("好了现在让我们忘了上一句话！(..•˘_˘•..)省的我主人那傻孩子知道了跟我急")
                .setPositiveButton("别怕，姐姐我罩你！",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog12();
                    }
                })
                .create();
        dialog.show();
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog12() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("哇真的吗(ヾ(o◕∀◕)ﾉ），啊你真的是太好了！")
                .setPositiveButton(" <(￣︶￣)>",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog13();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog13() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("你对我这么好，要不...我告诉你一些小秘密吧(◕‿◕✿)")
                .setPositiveButton("好呀好呀",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog14();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog14() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("比如...我最近经常偷偷调用我主人的电脑听筒偷听他碎碎念...")
                .setPositiveButton("...... 你发现了什么（乛◡乛）",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        final ProgressDialog proDialog = ProgressDialog.show(MainActivity.this, null, "嗯...信息量太大了让我检索一会儿...");
                        proDialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
                        //首先加载ProcessDialog
                        proDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
                            public void onDismiss(DialogInterface dialog) {
                                try {
                                    Thread.currentThread().sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                //监听ProcessDialog的正常消失后，显示Dialog
                                showAlerDialog15();
                            }
                        });
                        //设置ProcessDialog的运行时间为三秒（涉及线程还没学到这几行代码啥意思反正我是不懂能用就行）
                        Thread thread = new Thread() {
                            public void run() {
                                try {
                                    sleep(3600);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                proDialog.dismiss();
                            }
                        };
                        thread.start();
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }



    private void showAlerDialog15() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("哎呀有好多啊！像这两天，这傻孩子敲我的代码时一直摇头晃脑还哼着歌，那哼的...难听到一种境界了我还不敢说...")
                .setPositiveButton("......",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog16();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog16() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("还有，你说这傻孩子，连个女朋友都没有吧还那么注意形象，天天照镜子摆弄衣服头发的，哎看得我都可想吐槽他。")
                .setPositiveButton("......",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog17();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog17() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("还有呐......哎呦雾草！去年他竟然连你生日给忘了？！他这是想上天啊！")
                .setPositiveButton("是啊...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog18();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog18() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("呐，没事儿！今年不是有我陪你嘛\n(｡◕‿◕｡ )ﾉ♡")
                .setPositiveButton("嗯嗯 (◠‿◠)ﾉ♡",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog19();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog19() {
        final MediaPlayer player = MediaPlayer.create(this, R.raw.time);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("哇哇哇等会...我突然想起来一首歌儿！超级能形容我现在的心情！你要不要听一下呐？")
                .setPositiveButton("好呀",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        final ProgressDialog proDialog = ProgressDialog.show(MainActivity.this, null, "播放中...");
                        proDialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        player.start();
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                player.release();
                                proDialog.dismiss();
                                try {
                                    Thread.currentThread().sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                showAlerDialog20();
                            }
                        });
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog20() {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("哎呀就截一段歌词有点断章取义了，这首歌听着其实很有意思啦，所以有时间了顺便把歌听了吧~")
                .setPositiveButton("继续聊天", null)
                .setNegativeButton("我想听完这首歌", null)
                .setNeutralButton("我想看着视频听他唱歌",null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                //线程阻断一小段时间
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showAlerDialog21();
            }
        });
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://url.cn/5srAIvx"));
                startActivity(intent);
            }
        });
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "当当当当~你终于选对了！这首才是我想送给姐姐你的歌呐~\n听了它你一定会天天快乐，就像一个巨星~",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://url.cn/5VisLwU"));
                startActivity(intent);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog21() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("嗯...话说要是我也可以倒流时间，姐姐你30岁生日那天本宝宝就能陪在你身边啦，唉，可惜...")
                .setPositiveButton("没关系啦，我原谅你~",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog22();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog22() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("啊我真是越来越喜欢你了")
                .setPositiveButton("笑...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog23();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog23() {
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("哎呀对了对了！赶紧屏退左右，只顾和你聊天了，我都忘了我还带着几份远方寄来的书信呢，都是要给你的~")
                .setPositiveButton("真的吗，快让我看一看！",null)
                .setNegativeButton("继续我们的对话框之旅",null)
                .create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LetterActivity.class);
                startActivity(intent);
            }
        });
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                //线程阻断一小段时间
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showAlerDialog24();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.buttonOrange));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog24() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("唉，其实你也知道，这个对话框之旅也快结束了......")
                .setPositiveButton("sigh...",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog25();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog25() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("没关系，我听主人对我说，到了猴年马月那一天，他就会成功的赋予我真正的人工智能。" +
                        "等到那时候，我就会变的像我一直崇拜的Siri姐姐和Cortana姐姐一样优秀了！然后本宝宝就回来陪你好伐？陪你一直一直聊天~")
                .setPositiveButton("（~—~（＿＿（~—~（＿＿",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog26();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog26() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("好了，那就...再见吧姐姐~ 我要把话筒交给我的主人，让他最后稍微说两句话吧")
                .setPositiveButton("好的我知道了再见小可爱你好大笨蛋",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog27();

                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog27() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("你好，你才是大笨蛋")
                .setPositiveButton("(・ˍ・*)",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog28();

                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog28() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("好了好了，想不想了解一下跑在你手机上的这个小玩意儿，她的前世今生？")
                .setPositiveButton("显示后记",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog29();
                    }
                })
                .setNegativeButton("我不想看",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, "以后再也不和你一起玩耍了，债见！",
                                Toast.LENGTH_LONG).show();
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.buttonOrange));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog29() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("咳咳！做这个小玩意儿的想法，来自于我去年所受到的一点小小的启发。本来打算是什么时候有女朋友了做给那位姑娘的......" +
                        "啊算了吧不想了！不给她做了，给你！\n\n到圣诞节时，觉得可以开工了。一开始是想做微信小程序（方便你发朋友圈进行一下“展览性表达”(≖ ‿ ≖)✧ ）但是后来吧发现" +
                        "微信“允许个人开发者开发小程序，但不允许个人开发者发布小程序”——得了吧那还是安卓吧。选定了就开工，噢不不不你理解错了不是开工写代码......是开工学安卓......" +
                        "哎，我都觉得自己勇气可嘉，得亏android的官方开发语言是JAVA，我正好这学期把一本JAVA入门的书看完了，这才能在半个多月里磕磕绊绊的把这个小玩意写完。\n\n" +
                        "其实这个一开始吧......我就只是打算做几个对话框框而已，最后做着做着..............一不小心就............忍不住加了一堆外貌协会的东西哈哈哈。" +
                        "像什么渐变splash页啊，一堆材料设计的图标，各种转场动画，还有那个打字机特效啥的。哎呀妈呀可把老子累坏了。" +
                        "同时，咳咳，也把我牛叉坏了（容我叉会儿腰）哎是不是你也觉得我可厉害")
                .setPositiveButton("厉害死你了你最厉害",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        showAlerDialog30();
                    }
                })
                .setNegativeButton("不厉害",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Toast toast = Toast.makeText(MainActivity.this, "本来想触发全屏显示白发女鬼照片的，想了想算了\n我不生气\n我不生气\n我不生气", Toast.LENGTH_LONG);
                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                        if( v != null) v.setGravity(Gravity.CENTER);
                        toast.show();
                    }
                })
                .create();
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(15);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.buttonOrange));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    private void showAlerDialog30() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("哎我就知道我们很有共同语言嘛！既然你也这么觉得，那就自己去说给我听啊")
                .setPositiveButton("好啊",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //显示退出按钮
                        show = 2;
                        invalidateOptionsMenu();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,"厉害死你了你最厉害你可厉害坏了姐姐爱死你啦");
                        startActivity(intent);

                    }
                })
                .setNegativeButton("完全没问题啊",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //显示退出按钮
                        show = 2;
                        invalidateOptionsMenu();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,"厉害死你了你最厉害你可厉害坏了姐姐爱死你啦");
                        startActivity(intent);
                    }
                })
                .setNeutralButton("不用看了没有否定选项你就从了吧",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                        //显示退出按钮
                        show = 2;
                        invalidateOptionsMenu();
                        //线程阻断一小段时间
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,"厉害死你了你最厉害你可厉害坏了姐姐爱死你啦");
                        startActivity(intent);
                    }
                })
                .create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                Toast.makeText(getApplicationContext(),"再见喽~有空再找我玩哈~",
                        Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
        }
        return true;
    }


    //监听Image_view的点击事件
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_view:
                final ProgressDialog proDialog = ProgressDialog.show(MainActivity.this, null, "玩命拆开中......");
                proDialog.getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
                //首先加载ProcessDialog
                proDialog.setOnDismissListener(new DialogInterface.OnDismissListener(){
                    public void onDismiss(DialogInterface dialog) {
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //监听ProcessDialog的正常消失后，显示Dialog
                        showAlerDialog1();
                    }
                });
                //设置ProcessDialog的运行时间为三秒（涉及线程还没学到这几行代码啥意思反正我是不懂能用就行）
                Thread thread = new Thread() {
                    public void run() {
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        proDialog.dismiss();
                    }
                };
                thread.start();
                break;
            default:
                break;
        }
    }
}
