package model.taikhoan;

public class User extends TaiKhoan {
    public User() {}

    public User(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
    }

    @Override
    public String getRole() {
        return "USER";
    }
}
