package model.anpham;

public class Sach extends AnPham {
    private String tacGia;
    private String theLoai;

    public Sach() {}

    public Sach(String id, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien,
                String tacGia, String theLoai) {
        super(id, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.tacGia = tacGia;
        this.theLoai = theLoai;
    }

    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }

    public String getTheLoai() { return theLoai; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }

    @Override
    public boolean tinhTrang() {
        return this.soLuong > 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tác giả: %s | Thể loại: %s", tacGia, theLoai);
    }
}
