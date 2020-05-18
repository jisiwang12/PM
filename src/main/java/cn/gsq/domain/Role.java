package cn.gsq.domain;

public class Role {
    public String role_Name;
    private int role_id;


    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(String roleName) {
        this.role_Name = roleName;
    }
}
