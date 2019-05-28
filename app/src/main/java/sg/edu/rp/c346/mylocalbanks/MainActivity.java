package sg.edu.rp.c346.mylocalbanks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbsTv, ocbcTv, uobTv;
    Integer view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbsTv = findViewById(R.id.dbsTextView);
        ocbcTv = findViewById(R.id.ocbcTextView);
        uobTv = findViewById(R.id.uobTextView);

        registerForContextMenu(dbsTv);
        registerForContextMenu(ocbcTv);
        registerForContextMenu(uobTv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_bank, menu);

        view = v.getId();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (view == R.id.dbsTextView) {
            if (id == R.id.websiteBank) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactBank) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"180011"+"11111"));
                startActivity(intentCall);
                return true;
            }
        }
        else if (view == R.id.ocbcTextView) {
            if (id == R.id.websiteBank) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/group-home.html"));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactBank) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+121274933));
                startActivity(intentCall);
                return true;
            }
        }
        else if (view == R.id.uobTextView){
            if (id == R.id.websiteBank) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(intent);
                return true;
            } else if (id == R.id.contactBank) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+121274933));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbsTv.setText("DBS");
            ocbcTv.setText("OCBC");
            uobTv.setText("UOB");
            return true;
        }else if (id == R.id.ChineseSelection) {
            dbsTv.setText("星展银行");
            ocbcTv.setText("侨银行");
            uobTv.setText("大华银行有限公司");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
