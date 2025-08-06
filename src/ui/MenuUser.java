package ui;

import model.taikhoan.TaiKhoan;
import java.util.Scanner;

public class MenuUser {
    public static void menu(Scanner sc, TaiKhoan currentUser) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n===== MENU USER =====");
            System.out.println("1. Xem/tìm kiếm ấn phẩm");
            System.out.println("2. Mượn/trả/theo dõi mượn trả");
            System.out.println("3. Xem thông tin tài khoản cá nhân");
            System.out.println("0. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            String chonUser = sc.nextLine();
            switch (chonUser) {
                case "1":
                    MenuAnPham.menuUser(sc);
                    break;
                case "2":
                    MenuMuonTra.menuUser(sc, currentUser);
                    break;
                case "3":
                    MenuTaiKhoan.menuUser(sc, currentUser);
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