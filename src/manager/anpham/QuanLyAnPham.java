package manager.anpham;

//List<T> danhSach
//
//Thêm/xoá/sửa/tìm kiếm cơ bản
//
//Hàm sắp xếp theo giá, năm, tên
//
//Hàm ghiFile(), docFile()

import file.IOfile;
import interfaces.CRUD.ICRUD;
import model.anpham.AnPham;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class QuanLyAnPham<T extends AnPham> implements ICRUD<T> {
    protected ArrayList<T> danhsach = new ArrayList<>();
    protected IOfile<T> docGhiFile = new IOfile<>();
    protected String pathFile;

    // CONSTRUCTOR
    public  QuanLyAnPham(String pathFile) {
        this.pathFile = pathFile;
        this.danhsach = docGhiFile.readFile(pathFile);
    }

    // IO method
    public void ghiFile() {
        docGhiFile.writeFile(danhsach, pathFile);
    }
    public void docFile() {
        danhsach = docGhiFile.readFile(pathFile);
    }

    // CRUD method
    @Override
    public void them(T obj) {
        if (obj != null) {
            danhsach.add(obj);
            ghiFile();
        }
    }

    @Override
    public void sua(T obj) {
        if (obj == null) {
            return;
        }
        for (int i = 0; i < danhsach.size(); i++) {
            if (danhsach.get(i).getId().equals(obj.getId())) {
                danhsach.set(i, obj);
                ghiFile();
                break;
            }
        }
    }

    @Override
    public boolean xoa(String id) {
        if (id == null) {
            return false;
        }
        for (int i = 0; i < danhsach.size(); i++) {
            if (danhsach.get(i).getId().equals(id)) {
                danhsach.remove(i);
                ghiFile();
                break;
            }
        }
        return true;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(danhsach);
    }

    @Override
    public List<T> timKiemTheoTen(String ten) {
        return danhsach.stream()
                .filter(item -> item.getTenAnPham().toLowerCase().contains(ten.toLowerCase()))
                .collect(Collectors.toList());
    }

    // SORT method
    public void nameSort() {
        danhsach.sort(Comparator.comparing(AnPham::getTenAnPham));
    }
    public void priceSort() {
        danhsach.sort(Comparator.comparing(AnPham::getGiaTien));
    }
    public void yearSort() {
        danhsach.sort(Comparator.comparing(AnPham::getNamXuatBan));
    }

    // SEARCHING method - using stream
    public T timKiemId(String id) {
        return danhsach.stream()
                .filter(anPham -> anPham.getId().equals(id)).findFirst().orElse(null);
    }
    public List<T> timKiemTheoKhoangGia(double min, double max) {
        return danhsach.stream()
                .filter(item -> item.getGiaTien() >= min && item.getGiaTien() <= max)
                .collect(Collectors.toList());
    }

    // Checking method
    public boolean tonTai(String id) {
        return danhsach.stream().anyMatch(item -> item.getId().equals(id));
    }

    // LIST SIZE
    public int soLuong(){
        return danhsach.size();
    }

    // DELETE ALL
    public void xoaTatCa() {
        danhsach.clear();
        ghiFile();
    }
}
