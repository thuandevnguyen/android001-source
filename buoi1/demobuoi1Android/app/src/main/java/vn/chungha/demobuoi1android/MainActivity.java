package vn.chungha.demobuoi1android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

class OnClickTextViewListener implements View.OnClickListener {

    private final CallBackTextViewClicked callBackTextViewClicked;

    OnClickTextViewListener(CallBackTextViewClicked callBackTextViewClicked) {
        this.callBackTextViewClicked = callBackTextViewClicked;
    }

    @Override
    public void onClick(View v) {
        callBackTextViewClicked.onClickFromTextView("Click From TextView");
    }
}

public class MainActivity extends BaseActivity implements CallBackTextViewClicked {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate");
        initView();
        initData();
    }

    private void initData() {
        Animal cat = new Cat("Meo", 10);
        cat.printAnimal();
        tvName.setText(cat.name);

        tvName.setOnClickListener(new OnClickTextViewListener(this));
    }

    private void initView() {
        tvName = findViewById(R.id.tvName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

    @Override
    public void onClickFromTextView(String text) {
        Log.d(Constant.TAG_ANIMAL, text);
    }
}