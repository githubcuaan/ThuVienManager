package model.anpham;

import java.io.Serializable;

public abstract class AnPham implements Serializable {
    protected String id;
    protected String tenAnPham;
    protected int soLuong;
    protected int namXuatBan;
    protected String nhaXuatBan;
    protected double giaTien;

    // Constructor
    public AnPham() {}
    public AnPham(String id, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        this.id = id;
        this.tenAnPham = tenAnPham;
        this.soLuong = soLuong;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.giaTien = giaTien;
    }

    // Getter - Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTenAnPham() {
        return tenAnPham;
    }
    public void setTenAnPham(String tenAnPham) {
        this.tenAnPham = tenAnPham;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    // abstract method
    public abstract boolean tinhTrang();

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | SL: %d | NXB: %d | Giá: %.2f | Nhà XB: %s",
                id, tenAnPham, soLuong, namXuatBan, giaTien, nhaXuatBan);
    }
}
