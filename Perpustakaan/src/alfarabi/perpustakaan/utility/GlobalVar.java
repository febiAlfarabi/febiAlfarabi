package alfarabi.perpustakaan.utility;

import java.io.Serializable;
import java.util.List;

import android.content.Context;

public class GlobalVar implements Serializable{

	private static GlobalVar instance;
	private List<Context> appContext;
	
	private GlobalVar() {}
	
	public void setAppContext(List<Context> appContext) {
		this.appContext = appContext;
	}
	public List<Context> getAppContext() {
		return appContext;
	}
	
	static{
		instance = new GlobalVar();
	}
	
	public static GlobalVar getInstance() {
		return instance;
	}
}
