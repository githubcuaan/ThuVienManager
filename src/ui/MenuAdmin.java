package ui;

import model.taikhoan.TaiKhoan;
import java.util.Scanner;

public class MenuAdmin {
    public static void menu(Scanner sc, TaiKhoan currentUser) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Quản lý ấn phẩm");
            System.out.println("2. Quản lý mượn trả");
            System.out.println("3. Quản lý tài khoản");
            System.out.println("0. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            String chonAdmin = sc.nextLine();
            switch (chonAdmin) {
                case "1":
                    MenuAnPham.menu(sc);
                    break;
                case "2":
                    MenuMuonTra.menu(sc);
                    break;
                case "3":
                    MenuTaiKhoan.menu(sc);
                    break;
                case "0":
                    System.out.println("Đăng xuất thành công! Quay lại màn hình đăng nhập...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }
}