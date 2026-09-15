package in.gov.eci.bloapp.repository;

import in.gov.eci.bloapp.BuildConfig;
import in.gov.eci.bloapp.network.ApiInterface;
import in.gov.eci.bloapp.room.database.DatabaseHelper;
import java.util.Date;
import javax.inject.Inject;
import net.sqlcipher.Cursor;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BloNotificationRepo {
    ApiInterface apiInterface;

    @Inject
    DatabaseHelper dbHandler;

    @Inject
    public BloNotificationRepo(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public int getCount(String partNo) {
        Cursor cursorRawQuery = this.dbHandler.getReadableDatabase(BuildConfig.DEFAULT_KEY).rawQuery("SELECT COUNT FROM BLO_NOTIFICATION WHERE PART_NO  = '" + partNo + "'", (String[]) null);
        if (cursorRawQuery.getCount() <= 0) {
            return 0;
        }
        cursorRawQuery.moveToFirst();
        return cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("COUNT"));
    }

    public void updateCount(String partNo, int count) {
        this.dbHandler.getWritableDatabase(BuildConfig.DEFAULT_KEY).execSQL("Update BLO_NOTIFICATION set PART_NO='" + partNo + "',COUNT='" + count + "' ,DATE='" + new Date() + "'");
    }
}
