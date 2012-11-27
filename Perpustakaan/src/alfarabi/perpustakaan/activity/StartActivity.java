package alfarabi.perpustakaan.activity;

import alfarabi.perpustakaan.utility.Util;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		new AsyncStart().execute((Integer)null);
	}
	
	private class AsyncStart extends AsyncTask<Integer, Void, Intent>{

		Intent intent ;
		@Override
		protected Intent doInBackground(Integer... params) {

				if(Util.dbExists()){
					intent = new Intent(StartActivity.this, null);
				}else{
					intent = new Intent(StartActivity.this, ActivationActivity.class);
				}				

		return intent;
		}
	@Override
	protected void onPostExecute(Intent result) {
		startActivity(result);
		finish();
	}	
	}
}
