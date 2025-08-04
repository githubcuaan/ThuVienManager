package model.muontra;

import java.io.Serializable;

public abstract class Nguoi implements  Serializable{
    protected String hoTen;
    protected String sdt;

    public Nguoi() {}
    public Nguoi(String hoTen, String sdt) {
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public abstract void hienThiThongTin();

    @Override
    public String toString() {
        return "Name: " + hoTen + " | Tel: " + sdt;
    }
}
