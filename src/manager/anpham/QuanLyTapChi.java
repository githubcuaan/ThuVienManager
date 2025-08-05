package manager.anpham;

import file.FilePath;
import model.anpham.TapChi;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyTapChi extends QuanLyAnPham<TapChi> {
    private static QuanLyTapChi instance;

    public QuanLyTapChi() {
        super(FilePath.TAPCHI_FILE);
    }

    public static QuanLyTapChi getInstance() {
        if (instance == null) {
            instance = new QuanLyTapChi();
        }
        return instance;
    }

    // SEARCHING method
    public List<TapChi> chuyenDeSearch(String chuyenDe) {
        return danhsach.stream()
                .filter(TapChi -> TapChi.getChuyenDe().toLowerCase().equals(chuyenDe.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<TapChi> thangPhatHanhSearch(int thangPhatHanh) {
        return danhsach.stream()
                .filter(TapChi -> TapChi.getThangPhatHanh() == thangPhatHanh)
                .collect(Collectors.toList());
    }

    public List<TapChi> soPhatHanhSearch(int soPhatHanh) {
        return danhsach.stream()
                .filter(TapChi -> TapChi.getSoPhatHanh() == soPhatHanh)
                .collect(Collectors.toList());
    }
}
