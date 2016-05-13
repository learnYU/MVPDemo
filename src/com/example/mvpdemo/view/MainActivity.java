package com.example.mvpdemo.view;

import com.example.mvpdemo.R;
import com.example.mvpdemo.presenter.LoginPresenterCompl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * mvp 模式 ：https://segmentfault.com/a/1190000003927200
 * 
 * MVP模式的核心思想：
 * MVP把Activity中的UI逻辑抽象成View接口，
 * 把业务逻辑抽象成Presenter接口，
 * Model类还是原来的Model。
 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener ,ILoginView{

    private TextView passwordtv;
    private TextView usernametv;
	private LoginPresenterCompl compl;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //一个Activity可以包含一个以上的Presenter，总之，需要什么业务就 new什么样的Presenter，很灵活，这也是MVP的核心思想
        compl = new LoginPresenterCompl(this);
        
        initView();
    }

	private void initView() {
		passwordtv = (TextView) findViewById(R.id.editText1);
		usernametv = (TextView) findViewById(R.id.editText2);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			compl.clean();
			break;
		case R.id.button2:
			compl.login(usernametv.getText().toString(), 
					passwordtv.getText().toString());
			break;
		default:
			break;
		}
	}

	@Override
	public void OncleanText() {
		passwordtv.setText("");
		usernametv.setText("");
	}

	@Override
	public void OnLoginResult(String code, String result) {
        if (result=="success"){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        } else {
        	Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
        }
	}	
	

}
