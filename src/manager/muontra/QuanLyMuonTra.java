package manager.muontra;

import file.FilePath;
import file.IOfile;
import model.muontra.MuonTra;
import model.muontra.SinhVien;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyMuonTra {
    private static QuanLyMuonTra instance;
    private ArrayList<MuonTra> danhSach;
    private final IOfile<MuonTra> docGhiFile;

    private QuanLyMuonTra() {
        docGhiFile = new IOfile<>();
        danhSach = docGhiFile.readFile(FilePath.MUONTRA_FILE);
        if (danhSach == null) danhSach = new ArrayList<>();
    }

    public static QuanLyMuonTra getInstance() {
        if (instance == null) instance = new QuanLyMuonTra();
        return instance;
    }

    // 📌 Thêm mượn mới
    public void them(MuonTra mt) {
        if (mt != null) {
            danhSach.add(mt);
            ghiFile();
        }
    }

    // 📌 Trả sách
    public boolean traSach(String idMuonTra, Date ngayTra) {
        for (MuonTra mt : danhSach) {
            if (mt.getIdSachBao().equalsIgnoreCase(idMuonTra) && !mt.isDaTra()) {
                mt.setDaTra(true);
                mt.setNgayTra(ngayTra);
                ghiFile();
                return true;
            }
        }
        return false;
    }

    // 📌 Tìm lịch sử mượn theo MSSV
    public List<MuonTra> timTheoMSSV(String mssv) {
        return danhSach.stream()
                .filter(mt -> mt.getSinhVien().getMsv().equalsIgnoreCase(mssv))
                .collect(Collectors.toList());
    }

    // 📌 Lọc các bản ghi chưa trả
    public List<MuonTra> chuaTra() {
        return danhSach.stream()
                .filter(mt -> !mt.isDaTra())
                .collect(Collectors.toList());
    }

    // 📌 Lọc các bản ghi đã trả
    public List<MuonTra> daTra() {
        return danhSach.stream()
                .filter(MuonTra::isDaTra)
                .collect(Collectors.toList());
    }

    // 📌 Tìm kiếm theo ID sách/báo
    public List<MuonTra> timTheoIdSachBao(String idSachBao) {
        return danhSach.stream()
                .filter(mt -> mt.getIdSachBao().equalsIgnoreCase(idSachBao))
                .collect(Collectors.toList());
    }

    // 📌 Tìm kiếm theo tên sách/báo
    public List<MuonTra> timTheoTenSachBao(String tenSachBao) {
        return danhSach.stream()
                .filter(mt -> mt.getTenSachBao().toLowerCase().contains(tenSachBao.toLowerCase()))
                .collect(Collectors.toList());
    }

    // 📌 Tìm kiếm theo ngày mượn
    public List<MuonTra> timTheoNgayMuon(Date ngayMuon) {
        return danhSach.stream()
                .filter(mt -> sameDate(mt.getNgayMuon(), ngayMuon))
                .collect(Collectors.toList());
    }

    // 📌 Xem toàn bộ danh sách
    public List<MuonTra> getAll() {
        return new ArrayList<>(danhSach);
    }

    // 📌 Xóa mượn trả
    public boolean xoa(String idSachBao) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getIdSachBao().equalsIgnoreCase(idSachBao)) {
                danhSach.remove(i);
                ghiFile();
                return true;
            }
        }
        return false;
    }

    // 📌 Sửa thông tin mượn trả
    public boolean sua(MuonTra muonTra) {
        if (muonTra == null) return false;
        
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getIdSachBao().equals(muonTra.getIdSachBao())) {
                danhSach.set(i, muonTra);
                ghiFile();
                return true;
            }
        }
        return false;
    }

    // 📌 Kiểm tra sách có đang được mượn không
    public boolean sachDangMuon(String idSachBao) {
        return danhSach.stream()
                .anyMatch(mt -> mt.getIdSachBao().equalsIgnoreCase(idSachBao) && !mt.isDaTra());
    }

    // 📌 Đếm số lượng mượn trả
    public int soLuong() {
        return danhSach.size();
    }

    // 📌 Đếm số lượng chưa trả
    public int soLuongChuaTra() {
        return (int) danhSach.stream().filter(mt -> !mt.isDaTra()).count();
    }

    // 📌 Đếm số lượng đã trả
    public int soLuongDaTra() {
        return (int) danhSach.stream().filter(MuonTra::isDaTra).count();
    }

    // 📌 Xóa tất cả
    public void xoaTatCa() {
        danhSach.clear();
        ghiFile();
    }

    // 📌 So sánh ngày
    private boolean sameDate(Date d1, Date d2) {
        if (d1 == null || d2 == null) return false;
        
        java.util.Calendar cal1 = java.util.Calendar.getInstance();
        java.util.Calendar cal2 = java.util.Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);

        return cal1.get(java.util.Calendar.YEAR) == cal2.get(java.util.Calendar.YEAR)
                && cal1.get(java.util.Calendar.MONTH) == cal2.get(java.util.Calendar.MONTH)
                && cal1.get(java.util.Calendar.DAY_OF_MONTH) == cal2.get(java.util.Calendar.DAY_OF_MONTH);
    }

    private void ghiFile() {
        docGhiFile.writeFile(danhSach, FilePath.MUONTRA_FILE);
    }
}
