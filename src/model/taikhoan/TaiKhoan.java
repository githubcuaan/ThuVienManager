package model.taikhoan;

import java.io.Serializable;

public abstract class TaiKhoan implements Serializable {
    protected String tenDangNhap;
    protected String matKhau;

    public TaiKhoan() {}

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("Tài khoản: %s | Vai trò: %s", tenDangNhap, getRole());
    }
}