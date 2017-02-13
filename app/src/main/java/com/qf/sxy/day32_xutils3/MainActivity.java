package com.qf.sxy.day32_xutils3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    //get请求
//    private String pathGet = "http://app.vmoiver.com/apiv3/post/getPostInCate?cateid=0&p=1";
    private String pathGet ="http://news-at.zhihu.com/api/4/story/8955123";
            //"http://app.vmoiver.com/apiv3/post/getPostInCate?cateid=0&p=1";

    @ViewInject(R.id.tv)
    private TextView tv;

    @ViewInject(R.id.btn)
    private Button btn;

    @ViewInject(R.id.iv)
    private ImageView iv;

//    @StringRes(R.string.app_name)
//    private String str ;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
        //注入注解工具
        x.view().inject(this);

        tv.setText("");
        btn.setText("点击事件");
   //图片
        x.image().bind(iv,"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1635701860,2641345197&fm=116&gp=0.jpg");
     //网络

        /**
         * 请求数据成功
         * onSuccess->onFinished
         * 如果onSuccess有异常
         * onSuccess->onError->onFinished
         * 网址错误
         * onError->onFinished
         */
        RequestParams params = new RequestParams(pathGet);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("AAA","==onSuccess=>"+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("AAA","==onError=>");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("AAA","==onCancelled=>");
            }

            @Override
            public void onFinished() {
                Log.e("AAA","==onFinished=>");
            }
        });

        //数据库
//        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
//                .setDbName("x3.db")//名称
//                .setDbDir("")//路径
//                .setAllowTransaction(true)//是否开启事务
//                .setDbVersion(1)
//                .setDbOpenListener(this)
//                .setDbUpgradeListener(this);
//        DbManager db =  x.getDb(daoConfig);
//        db.save();
//        db.update();
//        db.execNonQuery();
//        db.delete()

    }

    /**
     * 私有类型   private    参数和之前的保存一致
     * @param v
     */
    @Event(value = {R.id.btn},type = View.OnClickListener.class)
    private void MyClick(View v){
        Toast.makeText(MainActivity.this,"哈哈",Toast.LENGTH_SHORT).show();
    }
}
