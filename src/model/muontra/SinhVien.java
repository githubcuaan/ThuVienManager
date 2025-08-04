package model.muontra;

public class SinhVien extends Nguoi{
    private String msv;
    private String email;

    public SinhVien() {}
    public SinhVien(String hoTen, String sdt, String msv, String email) {
        super(hoTen, sdt);
        this.msv = msv;
        this.email = email;
    }

    public String getMsv() {
        return msv;
    }
    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | msv: " + msv + " | email: " + email;
    }
}
