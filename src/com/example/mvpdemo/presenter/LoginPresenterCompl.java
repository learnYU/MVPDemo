package com.example.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.mvpdemo.model.UserBean;
import com.example.mvpdemo.view.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter {

	private ILoginView iLoginView;
	private Handler handler;
	private UserBean userBean;
	public LoginPresenterCompl( ILoginView iLoginView) {
		this.iLoginView = iLoginView;
		initUser();
		handler = new Handler(Looper.getMainLooper());
	}
	
	private void initUser() {
		userBean = new UserBean();
		userBean.setName("jack");
		userBean.setPassword("1234");
	}

	@Override
	public void clean() {
		iLoginView.OncleanText();
	}

	@Override
	public void login(final String name, final String password) {
		System.err.println(userBean);
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if (name.equals(userBean.getName()) && password.equals(userBean.getPassword())) {
					iLoginView.OnLoginResult("1", "success");
				} else {
					iLoginView.OnLoginResult("0", "fail");
				}
			}
		}, 1000);
	}

	@Override
	public void setProgressBarVisiblity(int visiblity) {
		
	}

}
