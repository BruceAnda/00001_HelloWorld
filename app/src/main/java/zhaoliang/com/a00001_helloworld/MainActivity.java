package zhaoliang.com.a00001_helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * <pre>
 *     需求：Android第一个项目
 *     收获：
 *          1. 学会使用Android Studio创建Android项目
 * </pre>
 */
public class MainActivity extends Activity {

    private AdView mAdView;
    private RelativeLayout mRlMainRoot;
    private int[] mBackgroundBgIds = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg4, R.mipmap.bg5};
    private int mCurrentBgId;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mRlMainRoot.setBackgroundResource(mBackgroundBgIds[mCurrentBgId]);
            sendEmptyMessageDelayed(0, 5000);
            mCurrentBgId++;
            if (mCurrentBgId >= mBackgroundBgIds.length)
                mCurrentBgId = 0;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // capture our View elements
        mAdView = (AdView) findViewById(R.id.adView);
        mRlMainRoot = (RelativeLayout) findViewById(R.id.rl_main_root);
        mHandler.sendEmptyMessageDelayed(0, 2000);
      /*  AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
                .build();
        mAdView.loadAd(request);*/
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
