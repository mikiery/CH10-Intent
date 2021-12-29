package tw.tcnr05.m1000;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class M1001 extends AppCompatActivity  implements View.OnClickListener {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Button b005;
    private Button b006;
    private Intent it;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableStrictMode(this);
        setContentView(R.layout.m1001);
        
        setupViewConpoment();

    }

    //**********************************************************
    private void enableStrictMode(Context context) {
        //-------------抓取遠端資料庫設定執行續------------------------------
        StrictMode.setThreadPolicy(new
                StrictMode.ThreadPolicy.Builder().
                detectDiskReads().
                detectDiskWrites().
                detectNetwork().
                penaltyLog().
                build());
        StrictMode.setVmPolicy(
                new
                        StrictMode.
                                VmPolicy.
                                Builder().
                        detectLeakedSqlLiteObjects().
                        penaltyLog().
                        penaltyDeath().
                        build());
    }

    //**********************************************************

    private void enableStrictMode(M1001 m1001) {
    }

    private void setupViewConpoment() {
        b001 = (Button) findViewById(R.id.m1001_b001);
        b002 = (Button) findViewById(R.id.m1001_b002);
        b003 = (Button) findViewById(R.id.m1001_b003);
        b004 = (Button) findViewById(R.id.m1001_b004);
        b005 = (Button) findViewById(R.id.m1001_b005);
        b006 = (Button) findViewById(R.id.m1001_b006);
        b001.setOnClickListener(this);
        b002.setOnClickListener(this);
        b003.setOnClickListener(this);
        b004.setOnClickListener(this);
        b005.setOnClickListener(this);
        b006.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

//-----------------------------------1 顯示網頁

            case R.id.m1001_b001:
//                Uri uri = Uri.parse("http://google.com");
//                Intent it = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(it);
                break;

            case R.id.m1001_b002:
//                Uri uri = Uri.parse("geo:38.899533,-77.036476");
//                Intent it = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(it);

                break;
//------------------------------------------3 路徑規劃

            case R.id.m1001_b003:
//
//                double startLat=24.163225538345028;
//                double startLng= 120.65931224007588;
//                double endLat=24.1707975667992;
//                double endLng=120.61017664192211;
//                Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr="+startLat+"%20"+startLng+"&daddr="+endLat+"%20"+endLng+"&hl=tw");
//                Intent it = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(it);
                break;

            case R.id.m1001_b004:
                        //4 撥打電話
//---------------------------------------------------------叫出撥號程式
//                    Uri uri = Uri.parse("tel:0800000123");
//                    Intent it = new Intent(Intent.ACTION_DIAL, uri);
//                    startActivity(it);
//----------------------------------------------------------直接打電話出去
//                    Uri uri = Uri.parse("tel:0800000123");
//                    Intent it = new Intent(Intent.ACTION_CALL, uri);
//                    startActivity(it);
//用這個，要在 AndroidManifest.xml 中，加上
//<uses-permission id="android.permission.CALL_PHONE" />
                    break;

            case R.id.m1001_b005:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"Search");
                startActivity(intent);

                break;

            case R.id.m1001_b006:
                 it = new Intent(Intent.ACTION_VIEW);
                 uri = Uri.parse("file:///sdcard/song.mp3");
                it.setDataAndType(uri, "audio/mp3");
                startActivity(it);

               uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
           it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);

                break;


        }






    }
}