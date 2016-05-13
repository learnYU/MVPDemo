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
 * mvp ģʽ ��https://segmentfault.com/a/1190000003927200
 * 
 * MVPģʽ�ĺ���˼�룺
 * MVP��Activity�е�UI�߼������View�ӿڣ�
 * ��ҵ���߼������Presenter�ӿڣ�
 * Model�໹��ԭ����Model��
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
        
        //һ��Activity���԰���һ�����ϵ�Presenter����֮����Ҫʲôҵ��� newʲô����Presenter��������Ҳ��MVP�ĺ���˼��
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
