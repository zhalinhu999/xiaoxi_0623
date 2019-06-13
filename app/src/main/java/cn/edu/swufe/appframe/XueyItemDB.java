package cn.edu.swufe.appframe;

public class XueyItemDB {

    private int id;
    private String curName;
    private String curHttp;

    public XueyItemDB() {
        this.curName = "";
        this.curHttp = "";
    }

    public XueyItemDB(String curName, String curHttp) {
        this.curName = curName;
        this.curHttp = curHttp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public String getCurHttp() {
        return curHttp;
    }

    public void setCurHttp(String curHttp) {
        this.curHttp = curHttp;
    }
}
