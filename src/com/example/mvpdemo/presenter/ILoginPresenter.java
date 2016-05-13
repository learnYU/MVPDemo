package com.example.mvpdemo.presenter;

public interface ILoginPresenter {
	void clean();
	void login(String name,String password);
	void setProgressBarVisiblity(int visiblity);
}
