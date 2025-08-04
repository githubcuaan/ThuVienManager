package model.anpham;

import java.util.Date;

public class Bao extends AnPham {
    private Date ngayPhatHanh;
    private String bienTapVien;

    public Bao() {}

    public Bao(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien,
               Date ngayPhatHanh, String bienTapVien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.ngayPhatHanh = ngayPhatHanh;
        this.bienTapVien = bienTapVien;
    }

    public Date getNgayPhatHanh() { return ngayPhatHanh; }
    public void setNgayPhatHanh(Date ngayPhatHanh) { this.ngayPhatHanh = ngayPhatHanh; }

    public String getBienTapVien() { return bienTapVien; }
    public void setBienTapVien(String bienTapVien) { this.bienTapVien = bienTapVien; }

    @Override
    public boolean tinhTrang() {
        return this.soLuong > 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | BTV: %s | Ngày phát hành: %s", bienTapVien, ngayPhatHanh);
    }
}
