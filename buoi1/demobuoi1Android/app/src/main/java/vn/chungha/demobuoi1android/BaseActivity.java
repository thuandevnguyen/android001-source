package vn.chungha.demobuoi1android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(this);
    }

    protected void showLoading() {
        loadingDialog.show();
    }

    protected void hideLoading() {
        loadingDialog.hide();
    }
}
