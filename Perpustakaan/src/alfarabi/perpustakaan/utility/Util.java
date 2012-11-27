package alfarabi.perpustakaan.utility;

import android.database.sqlite.SQLiteDatabase;

public class Util {
	
	public static boolean dbExists(){
		SQLiteDatabase checkDb = null;
		String path = Constant.DB.DB_NAME+Constant.DB.DB_LOCATION;
		try{
		checkDb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		if(checkDb==null){
			return false;
		}else{
			return true;
		}
		}catch(Exception e){
			return false;
		}
	}
}
