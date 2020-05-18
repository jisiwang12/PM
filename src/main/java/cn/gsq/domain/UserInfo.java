package cn.gsq.domain;

import java.util.List;

/**
 * 用户登录
 * @author mechrevo
 */
public class UserInfo {
    private String id;
    private String uName;
    private String uPass;
    private List<Role> roles;
    public int status;
    public String statusStr;

    public String getStatusStr() {
        if (this.getStatus() == 0) {
            this.statusStr = "关闭";
        }else {
            this.statusStr = "开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
