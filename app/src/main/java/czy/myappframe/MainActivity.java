package czy.myappframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bigkoo.svprogresshud.listener.OnDismissListener;
import java.util.ArrayList;
import java.util.List;
import czy.myappframe.http.HttpResultSubscriber;
import czy.myappframe.http.ServiceCreator;
import czy.myappframe.model.PieData;
import czy.myappframe.view.PieView;

/**
 * 自定义网络连接的使用方法
 *
 */

public class MainActivity extends AppCompatActivity {


    private PieView myview ;
    private SVProgressHUD mSVProgressHUD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
myview = (PieView) findViewById(R.id.my_view);

        ArrayList<PieData> list = new ArrayList<>();
        list.add(new PieData(20,20));
        list.add(new PieData(30,30));
        list.add(new PieData(10,10));
        list.add(new PieData(40,40));

        myview.setData(list);

        mSVProgressHUD = new SVProgressHUD(this);
        mSVProgressHUD.dismiss();
        mSVProgressHUD.setOnDismissListener(new OnDismissListener(){
            @Override
            public void onDismiss(SVProgressHUD hud) {
                // todo something, like: finish current activity
                Toast.makeText(getApplicationContext(),"dismiss",Toast.LENGTH_SHORT).show();
            }
        });

        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SVProgressHUD(MainActivity.this).showInfoWithStatus("这是提示", SVProgressHUD.SVProgressHUDMaskType.None);
            }
        });


//        ServiceCreator.getInstance()
//                .createService(DescService.class)
//                .getdesc(new Request())
//                .subscribe(new HttpResultSubscriber<List<DescInfo>>() {
//                    @Override
//                    public void onSuccess(List<DescInfo> descInfos) {
//
//                    }
//
//                    @Override
//                    public void _onError(Throwable e) {
//
//                    }
//                });






    }

    public void show(View view){
        mSVProgressHUD.show();
    }
    public void showWithMaskType(View view){
        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.ClearCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }
    public void showWithStatus(View view){
        mSVProgressHUD.showWithStatus("加载中...");
    }
    public void showInfoWithStatus(View view){
        mSVProgressHUD.showInfoWithStatus("这是提示", SVProgressHUD.SVProgressHUDMaskType.None);
    }
    public void showSuccessWithStatus(View view){
        mSVProgressHUD.showSuccessWithStatus("恭喜，提交成功！");
    }
    public void showErrorWithStatus(View view){
        mSVProgressHUD.showErrorWithStatus("不约，叔叔我们不约～", SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
    }




}
