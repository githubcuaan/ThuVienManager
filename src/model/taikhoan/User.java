package model.taikhoan;

public class User extends TaiKhoan {
    private String msv;
    public User() {}

    public User(String tenDangNhap, String matKhau, String msv) {

        super(tenDangNhap, matKhau);
        this.msv = msv;
    }

    public String getMsv() {
        return msv;
    }
    public void setMsv(String msv) {
        this.msv = msv;
    }
    @Override
    public String getRole() {
        return "USER";
    }

    @Override
    public String toString() {
        return super.toString() + " | MSSV: " + msv;
    }
}
