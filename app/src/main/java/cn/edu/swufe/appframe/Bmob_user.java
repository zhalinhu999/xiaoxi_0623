package cn.edu.swufe.appframe;

import cn.bmob.v3.BmobObject;

public class Bmob_user extends BmobObject {
    private String name;
    private String address;
    private String userid;
    private String userpwd;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

}
