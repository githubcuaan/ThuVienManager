package manager.taikhoan;

import file.*;
import model.taikhoan.*;

import java.util.ArrayList;

public class QuanLyTaiKhoan {
    private static QuanLyTaiKhoan instance;
    private IOfile<TaiKhoan> docGhiFile;
    private ArrayList<TaiKhoan> danhSachTaiKhoan;

    public QuanLyTaiKhoan() {
        docGhiFile = new IOfile<TaiKhoan>();
        danhSachTaiKhoan = docGhiFile.readFile(FilePath.NGUOIDUNG_FILE);
        if (danhSachTaiKhoan.isEmpty()) {
            danhSachTaiKhoan = new ArrayList<>();
        }
    }

    public static QuanLyTaiKhoan getInstance() {
        if (instance == null) {
            instance = new QuanLyTaiKhoan();
        }
        return instance;
    }

    // write
    public void ghiFile() {
        docGhiFile.writeFile(danhSachTaiKhoan, FilePath.NGUOIDUNG_FILE);
    }

    // Login
    public TaiKhoan login(String username, String password) {
        return danhSachTaiKhoan.stream()
                .filter(taiKhoan -> taiKhoan.getTenDangNhap().equals(username) && taiKhoan.getMatKhau().equals(password))
                .findFirst()
                .orElse(null);
    }

    /// CRUD method

    // Register - create
    public void register(TaiKhoan taiKhoan) {
        danhSachTaiKhoan.add(taiKhoan);
        ghiFile();
    }

    // add admin acc
    public void addAdmin(String username, String password) {
        TaiKhoan adminAcc = new Admin(username, password);
        register(adminAcc);
    }
    // add user acc
    public void addUser(String username, String password, String msv) {
        TaiKhoan userAcc = new User(username, password, msv);
        register(userAcc);
    }

    // taiKhoanSearch - read
    public TaiKhoan usernameSearch(String username) {
        return danhSachTaiKhoan.stream()
                .filter(taiKhoan -> taiKhoan.getTenDangNhap().equals(username))
                .findFirst()
                .orElse(null);
    }

    // Sua tai khoan - Update
    public boolean suaTaiKhoan(String Username, String newPassword, String newMsv) {
        TaiKhoan acc = usernameSearch(Username);
        if (acc == null) {return false;}

        acc.setMatKhau(newPassword);
        if (acc instanceof User) {
            ((User) acc).setMsv(newMsv);
        }

        ghiFile();
        return true;
    }

    // Xoa tai khoan - Delete
    public boolean xoaTaiKhoan(String Username) {
        boolean removed = danhSachTaiKhoan.removeIf(taiKhoan ->  taiKhoan.getTenDangNhap().equals(Username));
        if (removed) {ghiFile();}

        return removed;
    }

    // lay toan bo tk
    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    // check Username is valid?
    public boolean trungUsername(String username) {
        return danhSachTaiKhoan.stream()
                .anyMatch(taiKhoan -> taiKhoan.getTenDangNhap().equals(username));
    }
}
