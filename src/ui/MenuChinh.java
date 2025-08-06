package ui;

import manager.taikhoan.QuanLyTaiKhoan;
import model.taikhoan.TaiKhoan;
import java.util.Scanner;

public class MenuChinh {
    private Scanner sc = new Scanner(System.in);
    private QuanLyTaiKhoan qltk = QuanLyTaiKhoan.getInstance();

    public void start() {
        TaiKhoan currentUser = null;
        boolean running = true;
        while (running) {
            printStartMenu();
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.print("Nhập username: ");
                    String user = sc.nextLine();
                    System.out.print("Nhập password: ");
                    String pass = sc.nextLine();
                    currentUser = qltk.login(user, pass);

                    if (currentUser == null) {
                        System.out.println("Sai tài khoản hoặc mật khẩu! Thử lại đi bạn ơi.");
                    } else {
                        System.out.println("Đăng nhập thành công! Xin chào, " + currentUser.getTenDangNhap() + " (" + currentUser.getRole() + ")");
                        // Menu chính theo quyền
                        boolean loggedIn = true;
                        while (loggedIn) {
                            if (currentUser.getRole().equals("ADMIN")) {
                                MenuAdmin.menu(sc, currentUser);
                                loggedIn = false;
                            } else if (currentUser.getRole().equals("USER")) {
                                MenuUser.menu(sc, currentUser);
                                loggedIn = false;
                            } else {
                                System.out.println("Role không xác định! Đăng xuất...");
                                loggedIn = false;
                            }
                        }
                    }
                    break;
                case "0":
                    System.out.println("Tạm biệt nhé! Hẹn gặp lại ở thư viện OOP :)");
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    public void printStartMenu() {
        System.out.println("==============================");
        System.out.println("=  ĐĂNG NHẬP HỆ THỐNG OOPLIB =");
        System.out.println("==============================");
        System.out.println("1. Đăng nhập");
        System.out.println("0. Thoát");
        System.out.print("Chọn đi bro: ");
    }
}