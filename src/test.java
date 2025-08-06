import manager.taikhoan.QuanLyTaiKhoan;
import model.taikhoan.*;

public class test {
    public static void main(String[] args) {
        testQuanLyTaiKhoan();
    }

    public static void testQuanLyTaiKhoan() {
        QuanLyTaiKhoan qltk = QuanLyTaiKhoan.getInstance();

        System.out.println("===== TEST THÊM TÀI KHOẢN =====");
        qltk.addAdmin("admin01", "adminpass");
        qltk.addUser("sv01", "123456", "PH12345");
        qltk.addUser("sv02", "654321", "PH67890");

        System.out.println("\n===== TEST KIỂM TRA TRÙNG =====");
        System.out.println("Trùng 'admin01'? " + qltk.trungUsername("admin01")); // true
        System.out.println("Trùng 'not_exist'? " + qltk.trungUsername("not_exist")); // false

        System.out.println("\n===== TEST ĐĂNG NHẬP =====");
        TaiKhoan tk1 = qltk.login("admin01", "adminpass");
        System.out.println(tk1 != null ? "Login admin OK" : "Login admin FAIL");

        TaiKhoan tk2 = qltk.login("sv01", "123456");
        System.out.println(tk2 != null ? "Login sv01 OK" : "Login sv01 FAIL");

        TaiKhoan tkFail = qltk.login("sv01", "sai"); // sai mật khẩu
        System.out.println(tkFail != null ? "Login sai mật khẩu OK" : "Login sai mật khẩu FAIL");

        System.out.println("\n===== TEST SỬA TÀI KHOẢN =====");
        qltk.suaTaiKhoan("sv01", "newpass", "PH99999");

        TaiKhoan tkUpdate = qltk.login("sv01", "newpass");
        System.out.println(tkUpdate != null ? "Sửa mật khẩu OK" : "Sửa mật khẩu FAIL");
        if (tkUpdate instanceof User) {
            System.out.println("MSSV mới: " + ((User) tkUpdate).getMsv());
        }

        System.out.println("\n===== TEST XÓA TÀI KHOẢN =====");
        System.out.println("Xóa sv02: " + (qltk.xoaTaiKhoan("sv02") ? "OK" : "FAIL"));
        System.out.println("Xóa không tồn tại: " + (qltk.xoaTaiKhoan("noname") ? "OK" : "FAIL"));

        System.out.println("\n===== DANH SÁCH HIỆN TẠI =====");
        for (TaiKhoan tk : qltk.getDanhSachTaiKhoan()) {
            System.out.print(tk.getTenDangNhap() + " | Role: " + tk.getRole());
            if (tk instanceof User user) {
                System.out.print(" | MSSV: " + user.getMsv());
            }
            System.out.println();
        }

        System.out.println("===== TEST DONE =====");
    }
}
