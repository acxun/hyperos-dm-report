package g1;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f2671b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f2672c = "systemhelper";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2673d = "dmregister";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f2674e = "typef";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AtomicInteger f2675f = new AtomicInteger();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static e f2676g = null;

    private e(Context context, String str, int i2) {
        this(context, str, null, i2);
    }

    private e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public static synchronized e a(Context context, String str, int i2) {
        f2675f.incrementAndGet();
        if (f2676g == null) {
            f2676g = new e(context, str, i2);
        }
        return f2676g;
    }

    public synchronized void b(String str) {
        h.a("HistoryDatabaseHelper", "insertRecord:" + str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("create table if not exists dmregister (ID integer primary key autoincrement, jsonString text)");
        Cursor cursorQuery = writableDatabase.query(f2673d, new String[]{"COUNT(*)"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        int i2 = cursorQuery.getInt(0);
        cursorQuery.close();
        int iMax = Math.max(0, i2 - 10);
        h.a("HistoryDatabaseHelper", "row count :" + i2 + ", deletecount: " + iMax);
        if (iMax > 0) {
            Cursor cursorQuery2 = writableDatabase.query(f2673d, new String[]{"ID"}, null, null, null, null, "ID ASC", String.valueOf(iMax));
            if (cursorQuery2.moveToFirst()) {
                do {
                    int i3 = cursorQuery2.getInt(cursorQuery2.getColumnIndex("ID"));
                    h.a("HistoryDatabaseHelper", "idToDelete : " + i3);
                    writableDatabase.delete(f2673d, "ID=?", new String[]{String.valueOf(i3)});
                } while (cursorQuery2.moveToNext());
            }
            cursorQuery2.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("jsonString", str);
        writableDatabase.insert(f2673d, null, contentValues);
    }

    public synchronized JSONObject c() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("create table if not exists dmregister (ID integer primary key autoincrement, jsonString text)");
        Cursor cursorQuery = writableDatabase.query(f2673d, new String[]{"ID", "jsonString"}, null, null, null, null, null);
        CursorWindow cursorWindow = new CursorWindow("queryWindow", 20971520L);
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        abstractWindowedCursor.setWindow(cursorWindow);
        if (abstractWindowedCursor.getCount() > 0) {
            abstractWindowedCursor.moveToLast();
            String string = abstractWindowedCursor.getString(abstractWindowedCursor.getColumnIndex("jsonString"));
            h.a("HistoryDatabaseHelper", "queryOldestRecord:" + string);
            try {
                writableDatabase.delete(f2673d, "ID=?", new String[]{abstractWindowedCursor.getString(abstractWindowedCursor.getColumnIndex("ID"))});
                return new JSONObject(string);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        abstractWindowedCursor.close();
        cursorWindow.close();
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        if (f2675f.decrementAndGet() == 0) {
            f2676g = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        h.a("HistoryDatabaseHelper", "onCreate table-->");
        sQLiteDatabase.execSQL("create table if not exists dmregister (ID integer primary key autoincrement, jsonString text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
