package manager.anpham;

import file.FilePath;
import model.anpham.Bao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class QuanLyBao extends QuanLyAnPham<Bao> {
    private static QuanLyBao instance;

    public QuanLyBao() {
        super(FilePath.BAO_FILE);
    }

    public static QuanLyBao getInstance() {
        if (instance == null) {
            instance = new QuanLyBao();
        }
        return instance;
    }

    // SEARCHING method
    public List<Bao> timKiemTheoBienTapVien(String btv) {
        return danhsach.stream()
                .filter(b -> b.getBienTapVien().toLowerCase().contains(btv.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Bao> timKiemTheoNgay(Date ngayCanTim) {
        return danhsach.stream()
                .filter(b -> sameDate(b.getNgayPhatHanh(), ngayCanTim))
                .collect(Collectors.toList());
    }

    private boolean sameDate(Date d1, Date d2) {
        // So sánh theo ngày - tháng - năm
        java.util.Calendar cal1 = java.util.Calendar.getInstance();
        java.util.Calendar cal2 = java.util.Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);

        return cal1.get(java.util.Calendar.YEAR) == cal2.get(java.util.Calendar.YEAR)
                && cal1.get(java.util.Calendar.MONTH) == cal2.get(java.util.Calendar.MONTH)
                && cal1.get(java.util.Calendar.DAY_OF_MONTH) == cal2.get(java.util.Calendar.DAY_OF_MONTH);
    }
}
