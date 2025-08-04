package model.muontra;

import java.io.Serializable;
import java.util.Date;

public class MuonTra implements Serializable {
    private String idSachBao;
    private String tenSachBao;
    private SinhVien sinhVien;
    private Date ngayMuon;
    private Date ngayTra;
    private boolean daTra;

    public MuonTra() {}
    public MuonTra(String idSachBao, String tenSachBao, SinhVien sinhVien, Date ngayMuon) {
        this.idSachBao = idSachBao;
        this.tenSachBao = tenSachBao;
        this.sinhVien = sinhVien;
        this.ngayMuon = ngayMuon;
        this.daTra = false;
    }

    // Getters & Setters
    public String getIdSachBao() { return idSachBao; }
    public String getTenSachBao() { return tenSachBao; }
    public SinhVien getSinhVien() { return sinhVien; }
    public Date getNgayMuon() { return ngayMuon; }
    public Date getNgayTra() { return ngayTra; }
    public boolean isDaTra() { return daTra; }

    public void setNgayTra(Date ngayTra) { this.ngayTra = ngayTra; }
    public void setDaTra(boolean daTra) { this.daTra = daTra; }

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | %s | Ngày mượn: %s | Trạng thái: %s",
                idSachBao, tenSachBao, sinhVien.toString(), ngayMuon,
                daTra ? "Đã trả" : "Chưa trả");
    }
}
