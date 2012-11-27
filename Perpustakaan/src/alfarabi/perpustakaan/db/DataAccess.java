package alfarabi.perpustakaan.db;

import alfarabi.perpustakaan.utility.Constant;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccess extends SQLiteOpenHelper{

	/*
	 * 	T = Table
	 * 	F = Field
	 * 
	 */
	
	public static final String T_IDENTIFIKASI_USER = "identifikasi_user";
	public static final String[] F_IDENTIFIKASI_USER = {"no_anggota", "user_id", "tggl_aktifasi", "device_id", "device_type"};
	
	public static final String T_BUKU = "buku";
	public static final String[] F_BUKU = {"kode_buku", "judul", "pengarang", "penerbit", "tggl_terbit", "stock", "harga"};	
	
	private SQLiteDatabase db ;
	
	public DataAccess(Context context) {
		super(context, Constant.DB.DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	public static void createTable(String tableName, String[] column){
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
	private void initDb(){
		db = getWritableDatabase();
	}
	
}
