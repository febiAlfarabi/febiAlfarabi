package alfarabi.perpustakaan.activity;

import alfarabi.perpustakaan.utility.GlobalVar;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivationActivity extends Activity implements OnClickListener {

	private Button buttonBack, buttonBatal, buttonSetuju;
	private TextView headerText;
	private WebView informasiWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);
		
		LinearLayout linearLay = (LinearLayout) findViewById(R.id.linearLayoutBasePage);
		View v = null;
		if(v==null){
			LayoutInflater li = getLayoutInflater();
			v = li.inflate(R.layout.activation_activity, null);
		}
		linearLay.addView(v);
				
		buttonBack = (Button) findViewById(R.id.buttonKembali);
		buttonSetuju = (Button) findViewById(R.id.buttonSetuju);
		buttonBatal = (Button) findViewById(R.id.buttonBatal);
		
		headerText = (TextView)findViewById(R.id.headerText);
		informasiWebView = (WebView) findViewById(R.id.aktifasiWebView);
		
		if(GlobalVar.getInstance().getAppContext()==null){
			buttonBack.setText("Kembali");	
		}else{
			buttonBack.setText("Keluar");		
		}
		
		headerText.setText("Aktifasi");
		buttonBack.setOnClickListener(this);
		buttonSetuju.setOnClickListener(this);
		buttonBatal.setOnClickListener(this);
		
		informasiWebView.loadUrl("file:///android_asset/informasi.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activation_activity, menu);
		return true;
	}
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonSetuju:
			Intent intent = new Intent(ActivationActivity.this, ActivationProcess.class);
			startActivity(intent);
			break;
		case R.id.buttonBatal:
			if(GlobalVar.getInstance().getAppContext()==null){
				ActivationActivity.this.finish();
			}else if(GlobalVar.getInstance()!=null){
				for(int i = 0; i<GlobalVar.getInstance().getAppContext().size(); i++){
					((Activity) GlobalVar.getInstance().getAppContext().get(i)).finish();
				}
			}
			break;
		
		case R.id.buttonKembali:
			if(buttonBack.getText().toString().equals("Kembali")) onBackPressed();
			if(buttonBack.getText().toString().equals("Keluar")) ActivationActivity.this.finish();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

}
