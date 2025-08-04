package model.anpham;

public class TapChi extends AnPham {
    private int soPhatHanh;
    private int thangPhatHanh;
    private String chuyenDe;

    //Constructor
    public TapChi() {}

    public TapChi(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien,
                  int soPhatHanh, int thangPhatHanh, String chuyenDe) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.chuyenDe = chuyenDe;
    }

    // Getter - Setter
    public int getSoPhatHanh() { return soPhatHanh; }
    public void setSoPhatHanh(int soPhatHanh) { this.soPhatHanh = soPhatHanh; }

    public int getThangPhatHanh() { return thangPhatHanh; }
    public void setThangPhatHanh(int thangPhatHanh) { this.thangPhatHanh = thangPhatHanh; }

    public String getChuyenDe() { return chuyenDe; }
    public void setChuyenDe(String chuyenDe) { this.chuyenDe = chuyenDe; }

    @Override
    public boolean tinhTrang() {
        return this.soLuong > 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Số phát hành: %d | Tháng: %d | Chuyên đề: %s",
                soPhatHanh, thangPhatHanh, chuyenDe);
    }
}
