package in.gov.eci.bloapp.utils;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class DataManager {
    private static DataManager instance;
    private List<String> listOne = new ArrayList();
    private List<String> listTwo = new ArrayList();

    private DataManager() {
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<String> getListOne() {
        return this.listOne;
    }

    public void setListOne(List<String> listOne) {
        this.listOne = listOne;
    }

    public List<String> getListTwo() {
        return this.listTwo;
    }

    public void setListTwo(List<String> listTwo) {
        this.listTwo = listTwo;
    }

    public void clear() {
        List<String> list = this.listOne;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.listTwo;
        if (list2 != null) {
            list2.clear();
        }
    }
}
