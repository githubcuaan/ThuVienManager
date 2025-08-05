package manager.anpham;

import model.anpham.Sach;
import file.FilePath;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLySach extends QuanLyAnPham<Sach> {
    private static QuanLySach instance;

    public QuanLySach() {
        super(FilePath.SACH_FILE);
    }

    public static QuanLySach getInstance() {
        if (instance == null) {
            instance = new QuanLySach();
        }
        return instance;
    }

    // SEARCHING method
    public List<Sach> tacGiaSearch(String tenTacGia) {
        return danhsach.stream()
                .filter(Sach -> Sach.getTacGia().toLowerCase().equals(tenTacGia.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Sach> theLoaiSearch(String TheLoai) {
        return danhsach.stream()
                .filter(Sach -> Sach.getTheLoai().toLowerCase().equals(TheLoai.toLowerCase()))
                .collect(Collectors.toList());
    }
}
