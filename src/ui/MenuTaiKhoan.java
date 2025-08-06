package ui;

import manager.taikhoan.QuanLyTaiKhoan;
import model.taikhoan.*;
import java.util.List;
import java.util.Scanner;

public class MenuTaiKhoan {
    private static QuanLyTaiKhoan qltk = QuanLyTaiKhoan.getInstance();

    public static void menu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ TÀI KHOẢN (ADMIN) =====");
            System.out.println("1. Thêm tài khoản admin");
            System.out.println("2. Thêm tài khoản user");
            System.out.println("3. Sửa tài khoản");
            System.out.println("4. Xóa tài khoản");
            System.out.println("5. Xem tất cả tài khoản");
            System.out.println("6. Tìm kiếm tài khoản");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    themAdmin(sc);
                    break;
                case "2":
                    themUser(sc);
                    break;
                case "3":
                    suaTaiKhoan(sc);
                    break;
                case "4":
                    xoaTaiKhoan(sc);
                    break;
                case "5":
                    xemTatCaTaiKhoan();
                    break;
                case "6":
                    timKiemTaiKhoan(sc);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    public static void menuUser(Scanner sc, TaiKhoan currentUser) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== THÔNG TIN TÀI KHOẢN CÁ NHÂN (USER) =====");
            System.out.println("1. Xem thông tin tài khoản");
            System.out.println("2. Sửa mật khẩu");
            System.out.println("3. Sửa thông tin cá nhân (nếu là user)");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    xemThongTinCaNhan(currentUser);
                    break;
                case "2":
                    suaMatKhau(sc, currentUser);
                    break;
                case "3":
                    suaThongTinCaNhan(sc, currentUser);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    // ========== CHỨC NĂNG ADMIN ==========
    private static void themAdmin(Scanner sc) {
        System.out.println("=== THÊM TÀI KHOẢN ADMIN ===");
        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        
        if (qltk.trungUsername(username)) {
            System.out.println("Username đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập password: ");
        String password = sc.nextLine();
        
        qltk.addAdmin(username, password);
        System.out.println("Thêm admin thành công!");
    }

    private static void themUser(Scanner sc) {
        System.out.println("=== THÊM TÀI KHOẢN USER ===");
        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        
        if (qltk.trungUsername(username)) {
            System.out.println("Username đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập password: ");
        String password = sc.nextLine();
        System.out.print("Nhập MSSV: ");
        String msv = sc.nextLine();
        
        qltk.addUser(username, password, msv);
        System.out.println("Thêm user thành công!");
    }

    private static void suaTaiKhoan(Scanner sc) {
        System.out.println("=== SỬA TÀI KHOẢN ===");
        System.out.print("Nhập username cần sửa: ");
        String username = sc.nextLine();
        
        TaiKhoan taiKhoan = qltk.usernameSearch(username);
        if (taiKhoan == null) {
            System.out.println("Không tìm thấy tài khoản!");
            return;
        }
        
        System.out.println("Thông tin tài khoản hiện tại:");
        System.out.println(taiKhoan);
        
        System.out.print("Nhập password mới: ");
        String newPassword = sc.nextLine();
        
        String newMsv = "";
        if (taiKhoan instanceof User) {
            System.out.print("Nhập MSSV mới: ");
            newMsv = sc.nextLine();
        }
        
        if (qltk.suaTaiKhoan(username, newPassword, newMsv)) {
            System.out.println("Sửa tài khoản thành công!");
        } else {
            System.out.println("Sửa tài khoản thất bại!");
        }
    }

    private static void xoaTaiKhoan(Scanner sc) {
        System.out.println("=== XÓA TÀI KHOẢN ===");
        System.out.print("Nhập username cần xóa: ");
        String username = sc.nextLine();
        
        if (qltk.xoaTaiKhoan(username)) {
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Không tìm thấy tài khoản để xóa!");
        }
    }

    private static void xemTatCaTaiKhoan() {
        System.out.println("=== DANH SÁCH TẤT CẢ TÀI KHOẢN ===");
        List<TaiKhoan> danhSach = qltk.getDanhSachTaiKhoan();
        if (danhSach.isEmpty()) {
            System.out.println("Chưa có tài khoản nào!");
        } else {
            for (TaiKhoan tk : danhSach) {
                System.out.println(tk);
            }
        }
    }

    private static void timKiemTaiKhoan(Scanner sc) {
        System.out.println("=== TÌM KIẾM TÀI KHOẢN ===");
        System.out.print("Nhập username: ");
        String username = sc.nextLine();
        
        TaiKhoan taiKhoan = qltk.usernameSearch(username);
        if (taiKhoan == null) {
            System.out.println("Không tìm thấy tài khoản!");
        } else {
            System.out.println("Thông tin tài khoản:");
            System.out.println(taiKhoan);
        }
    }

    // ========== CHỨC NĂNG USER ==========
    private static void xemThongTinCaNhan(TaiKhoan currentUser) {
        System.out.println("=== THÔNG TIN TÀI KHOẢN CÁ NHÂN ===");
        System.out.println("Username: " + currentUser.getTenDangNhap());
        System.out.println("Role: " + currentUser.getRole());
        
        if (currentUser instanceof User) {
            User user = (User) currentUser;
            System.out.println("MSSV: " + user.getMsv());
        }
        
        System.out.println("Thông tin đầy đủ:");
        System.out.println(currentUser);
    }

    private static void suaMatKhau(Scanner sc, TaiKhoan currentUser) {
        System.out.println("=== SỬA MẬT KHẨU ===");
        System.out.print("Nhập mật khẩu hiện tại: ");
        String currentPassword = sc.nextLine();
        
        if (!currentUser.getMatKhau().equals(currentPassword)) {
            System.out.println("Mật khẩu hiện tại không đúng!");
            return;
        }
        
        System.out.print("Nhập mật khẩu mới: ");
        String newPassword = sc.nextLine();
        System.out.print("Nhập lại mật khẩu mới: ");
        String confirmPassword = sc.nextLine();
        
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Mật khẩu xác nhận không khớp!");
            return;
        }
        
        String newMsv = "";
        if (currentUser instanceof User) {
            newMsv = ((User) currentUser).getMsv();
        }
        
        if (qltk.suaTaiKhoan(currentUser.getTenDangNhap(), newPassword, newMsv)) {
            System.out.println("Sửa mật khẩu thành công!");
            // Cập nhật lại thông tin currentUser
            currentUser.setMatKhau(newPassword);
        } else {
            System.out.println("Sửa mật khẩu thất bại!");
        }
    }

    private static void suaThongTinCaNhan(Scanner sc, TaiKhoan currentUser) {
        System.out.println("=== SỬA THÔNG TIN CÁ NHÂN ===");
        
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới có thể sửa thông tin cá nhân!");
            return;
        }
        
        User user = (User) currentUser;
        System.out.println("Thông tin hiện tại:");
        System.out.println("Username: " + user.getTenDangNhap());
        System.out.println("MSSV: " + user.getMsv());
        
        System.out.print("Nhập MSSV mới (Enter để giữ nguyên): ");
        String newMsv = sc.nextLine();
        
        if (!newMsv.isEmpty()) {
            if (qltk.suaTaiKhoan(user.getTenDangNhap(), user.getMatKhau(), newMsv)) {
                System.out.println("Sửa thông tin cá nhân thành công!");
                // Cập nhật lại thông tin currentUser
                user.setMsv(newMsv);
            } else {
                System.out.println("Sửa thông tin cá nhân thất bại!");
            }
        } else {
            System.out.println("Không có thay đổi nào!");
        }
    }
}