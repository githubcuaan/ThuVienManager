package model.taikhoan;

public class Admin extends TaiKhoan {
    public Admin() {}

    public Admin(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}
