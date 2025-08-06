package ui;

import manager.anpham.*;
import model.anpham.*;
import java.util.List;
import java.util.Scanner;

public class MenuAnPham {
    private static QuanLySach qls = QuanLySach.getInstance();
    private static QuanLyBao qlb = QuanLyBao.getInstance();
    private static QuanLyTapChi qltc = QuanLyTapChi.getInstance();

    public static void menu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ ẤN PHẨM (ADMIN) =====");
            System.out.println("1. Quản lý Sách");
            System.out.println("2. Quản lý Báo");
            System.out.println("3. Quản lý Tạp chí");
            System.out.println("0. Quay lại");
            System.out.print("Chọn loại ấn phẩm: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    menuSach(sc, true);
                    break;
                case "2":
                    menuBao(sc, true);
                    break;
                case "3":
                    menuTapChi(sc, true);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    public static void menuUser(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== XEM/TÌM KIẾM ẤN PHẨM (USER) =====");
            System.out.println("1. Xem/tìm kiếm Sách");
            System.out.println("2. Xem/tìm kiếm Báo");
            System.out.println("3. Xem/tìm kiếm Tạp chí");
            System.out.println("0. Quay lại");
            System.out.print("Chọn loại ấn phẩm: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    menuSach(sc, false);
                    break;
                case "2":
                    menuBao(sc, false);
                    break;
                case "3":
                    menuTapChi(sc, false);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    // Menu quản lý Sách
    private static void menuSach(Scanner sc, boolean isAdmin) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ SÁCH =====");
            if (isAdmin) {
                System.out.println("1. Thêm sách mới");
                System.out.println("2. Sửa sách");
                System.out.println("3. Xóa sách");
            }
            System.out.println("4. Xem tất cả sách");
            System.out.println("5. Tìm kiếm sách");
            System.out.println("6. Sắp xếp sách");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    if (isAdmin) themSach(sc);
                    else System.out.println("Bạn không có quyền thêm sách!");
                    break;
                case "2":
                    if (isAdmin) suaSach(sc);
                    else System.out.println("Bạn không có quyền sửa sách!");
                    break;
                case "3":
                    if (isAdmin) xoaSach(sc);
                    else System.out.println("Bạn không có quyền xóa sách!");
                    break;
                case "4":
                    xemTatCaSach();
                    break;
                case "5":
                    timKiemSach(sc);
                    break;
                case "6":
                    sapXepSach(sc);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    // Menu quản lý Báo
    private static void menuBao(Scanner sc, boolean isAdmin) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ BÁO =====");
            if (isAdmin) {
                System.out.println("1. Thêm báo mới");
                System.out.println("2. Sửa báo");
                System.out.println("3. Xóa báo");
            }
            System.out.println("4. Xem tất cả báo");
            System.out.println("5. Tìm kiếm báo");
            System.out.println("6. Sắp xếp báo");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    if (isAdmin) themBao(sc);
                    else System.out.println("Bạn không có quyền thêm báo!");
                    break;
                case "2":
                    if (isAdmin) suaBao(sc);
                    else System.out.println("Bạn không có quyền sửa báo!");
                    break;
                case "3":
                    if (isAdmin) xoaBao(sc);
                    else System.out.println("Bạn không có quyền xóa báo!");
                    break;
                case "4":
                    xemTatCaBao();
                    break;
                case "5":
                    timKiemBao(sc);
                    break;
                case "6":
                    sapXepBao(sc);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    // Menu quản lý Tạp chí
    private static void menuTapChi(Scanner sc, boolean isAdmin) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ TẠP CHÍ =====");
            if (isAdmin) {
                System.out.println("1. Thêm tạp chí mới");
                System.out.println("2. Sửa tạp chí");
                System.out.println("3. Xóa tạp chí");
            }
            System.out.println("4. Xem tất cả tạp chí");
            System.out.println("5. Tìm kiếm tạp chí");
            System.out.println("6. Sắp xếp tạp chí");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    if (isAdmin) themTapChi(sc);
                    else System.out.println("Bạn không có quyền thêm tạp chí!");
                    break;
                case "2":
                    if (isAdmin) suaTapChi(sc);
                    else System.out.println("Bạn không có quyền sửa tạp chí!");
                    break;
                case "3":
                    if (isAdmin) xoaTapChi(sc);
                    else System.out.println("Bạn không có quyền xóa tạp chí!");
                    break;
                case "4":
                    xemTatCaTapChi();
                    break;
                case "5":
                    timKiemTapChi(sc);
                    break;
                case "6":
                    sapXepTapChi(sc);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    // ========== CHỨC NĂNG SÁCH ==========
    private static void themSach(Scanner sc) {
        System.out.println("=== THÊM SÁCH MỚI ===");
        System.out.print("Nhập ID sách: ");
        String id = sc.nextLine();
        if (qls.tonTai(id)) {
            System.out.println("ID sách đã tồn tại!");
            return;
        }
        System.out.print("Nhập tên sách: ");
        String ten = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhập thể loại: ");
        String theLoai = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập năm xuất bản: ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        String nhaXuatBan = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        double gia = Double.parseDouble(sc.nextLine());
        
        Sach sach = new Sach(id, ten, soLuong, nam, nhaXuatBan, gia, tacGia, theLoai);
        qls.them(sach);
        System.out.println("Thêm sách thành công!");
    }

    private static void suaSach(Scanner sc) {
        System.out.println("=== SỬA SÁCH ===");
        System.out.print("Nhập ID sách cần sửa: ");
        String id = sc.nextLine();
        Sach sach = qls.timKiemId(id);
        if (sach == null) {
            System.out.println("Không tìm thấy sách!");
            return;
        }
        System.out.println("Thông tin sách hiện tại:");
        System.out.println(sach);
        System.out.print("Nhập tên sách mới (Enter để giữ nguyên): ");
        String ten = sc.nextLine();
        if (!ten.isEmpty()) sach.setTenAnPham(ten);
        System.out.print("Nhập tác giả mới (Enter để giữ nguyên): ");
        String tacGia = sc.nextLine();
        if (!tacGia.isEmpty()) sach.setTacGia(tacGia);
        System.out.print("Nhập thể loại mới (Enter để giữ nguyên): ");
        String theLoai = sc.nextLine();
        if (!theLoai.isEmpty()) sach.setTheLoai(theLoai);
        System.out.print("Nhập số lượng mới (Enter để giữ nguyên): ");
        String soLuongStr = sc.nextLine();
        if (!soLuongStr.isEmpty()) sach.setSoLuong(Integer.parseInt(soLuongStr));
        System.out.print("Nhập năm xuất bản mới (Enter để giữ nguyên): ");
        String namStr = sc.nextLine();
        if (!namStr.isEmpty()) sach.setNamXuatBan(Integer.parseInt(namStr));
        System.out.print("Nhập nhà xuất bản mới (Enter để giữ nguyên): ");
        String nhaXuatBan = sc.nextLine();
        if (!nhaXuatBan.isEmpty()) sach.setNhaXuatBan(nhaXuatBan);
        System.out.print("Nhập giá tiền mới (Enter để giữ nguyên): ");
        String giaStr = sc.nextLine();
        if (!giaStr.isEmpty()) sach.setGiaTien(Double.parseDouble(giaStr));
        
        qls.sua(sach);
        System.out.println("Sửa sách thành công!");
    }

    private static void xoaSach(Scanner sc) {
        System.out.println("=== XÓA SÁCH ===");
        System.out.print("Nhập ID sách cần xóa: ");
        String id = sc.nextLine();
        if (qls.xoa(id)) {
            System.out.println("Xóa sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách để xóa!");
        }
    }

    private static void xemTatCaSach() {
        System.out.println("=== DANH SÁCH TẤT CẢ SÁCH ===");
        List<Sach> danhSach = qls.getAll();
        if (danhSach.isEmpty()) {
            System.out.println("Chưa có sách nào!");
        } else {
            for (Sach sach : danhSach) {
                System.out.println(sach);
            }
        }
    }

    private static void timKiemSach(Scanner sc) {
        System.out.println("=== TÌM KIẾM SÁCH ===");
        System.out.println("1. Tìm theo tên sách");
        System.out.println("2. Tìm theo tác giả");
        System.out.println("3. Tìm theo thể loại");
        System.out.println("4. Tìm theo khoảng giá");
        System.out.print("Chọn cách tìm: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                System.out.print("Nhập tên sách: ");
                String ten = sc.nextLine();
                List<Sach> ketQua = qls.timKiemTheoTen(ten);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy sách!");
                } else {
                    for (Sach sach : ketQua) {
                        System.out.println(sach);
                    }
                }
                break;
            case "2":
                System.out.print("Nhập tên tác giả: ");
                String tacGia = sc.nextLine();
                ketQua = qls.tacGiaSearch(tacGia);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy sách!");
                } else {
                    for (Sach sach : ketQua) {
                        System.out.println(sach);
                    }
                }
                break;
            case "3":
                System.out.print("Nhập thể loại: ");
                String theLoai = sc.nextLine();
                ketQua = qls.theLoaiSearch(theLoai);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy sách!");
                } else {
                    for (Sach sach : ketQua) {
                        System.out.println(sach);
                    }
                }
                break;
            case "4":
                System.out.print("Nhập giá tối thiểu: ");
                double min = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập giá tối đa: ");
                double max = Double.parseDouble(sc.nextLine());
                ketQua = qls.timKiemTheoKhoangGia(min, max);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy sách!");
                } else {
                    for (Sach sach : ketQua) {
                        System.out.println(sach);
                    }
                }
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    private static void sapXepSach(Scanner sc) {
        System.out.println("=== SẮP XẾP SÁCH ===");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo giá");
        System.out.println("3. Sắp xếp theo năm");
        System.out.print("Chọn cách sắp xếp: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                qls.nameSort();
                System.out.println("Đã sắp xếp theo tên!");
                break;
            case "2":
                qls.priceSort();
                System.out.println("Đã sắp xếp theo giá!");
                break;
            case "3":
                qls.yearSort();
                System.out.println("Đã sắp xếp theo năm!");
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    // ========== CHỨC NĂNG BÁO ==========
    private static void themBao(Scanner sc) {
        System.out.println("=== THÊM BÁO MỚI ===");
        System.out.print("Nhập ID báo: ");
        String id = sc.nextLine();
        if (qlb.tonTai(id)) {
            System.out.println("ID báo đã tồn tại!");
            return;
        }
        System.out.print("Nhập tên báo: ");
        String ten = sc.nextLine();
        System.out.print("Nhập biên tập viên: ");
        String btv = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập năm xuất bản: ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        String nhaXuatBan = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập ngày phát hành (dd/MM/yyyy): ");
        String ngayStr = sc.nextLine();
        // TODO: Parse ngày phát hành - tạm thời dùng ngày hiện tại
        java.util.Date ngayPhatHanh = new java.util.Date();
        
        Bao bao = new Bao(id, ten, soLuong, nam, nhaXuatBan, gia, ngayPhatHanh, btv);
        qlb.them(bao);
        System.out.println("Thêm báo thành công!");
    }

    private static void suaBao(Scanner sc) {
        System.out.println("=== SỬA BÁO ===");
        System.out.print("Nhập ID báo cần sửa: ");
        String id = sc.nextLine();
        Bao bao = qlb.timKiemId(id);
        if (bao == null) {
            System.out.println("Không tìm thấy báo!");
            return;
        }
        System.out.println("Thông tin báo hiện tại:");
        System.out.println(bao);
        System.out.print("Nhập tên báo mới (Enter để giữ nguyên): ");
        String ten = sc.nextLine();
        if (!ten.isEmpty()) bao.setTenAnPham(ten);
        System.out.print("Nhập biên tập viên mới (Enter để giữ nguyên): ");
        String btv = sc.nextLine();
        if (!btv.isEmpty()) bao.setBienTapVien(btv);
        System.out.print("Nhập số lượng mới (Enter để giữ nguyên): ");
        String soLuongStr = sc.nextLine();
        if (!soLuongStr.isEmpty()) bao.setSoLuong(Integer.parseInt(soLuongStr));
        System.out.print("Nhập năm xuất bản mới (Enter để giữ nguyên): ");
        String namStr = sc.nextLine();
        if (!namStr.isEmpty()) bao.setNamXuatBan(Integer.parseInt(namStr));
        System.out.print("Nhập nhà xuất bản mới (Enter để giữ nguyên): ");
        String nhaXuatBan = sc.nextLine();
        if (!nhaXuatBan.isEmpty()) bao.setNhaXuatBan(nhaXuatBan);
        System.out.print("Nhập giá tiền mới (Enter để giữ nguyên): ");
        String giaStr = sc.nextLine();
        if (!giaStr.isEmpty()) bao.setGiaTien(Double.parseDouble(giaStr));
        
        qlb.sua(bao);
        System.out.println("Sửa báo thành công!");
    }

    private static void xoaBao(Scanner sc) {
        System.out.println("=== XÓA BÁO ===");
        System.out.print("Nhập ID báo cần xóa: ");
        String id = sc.nextLine();
        if (qlb.xoa(id)) {
            System.out.println("Xóa báo thành công!");
        } else {
            System.out.println("Không tìm thấy báo để xóa!");
        }
    }

    private static void xemTatCaBao() {
        System.out.println("=== DANH SÁCH TẤT CẢ BÁO ===");
        List<Bao> danhSach = qlb.getAll();
        if (danhSach.isEmpty()) {
            System.out.println("Chưa có báo nào!");
        } else {
            for (Bao bao : danhSach) {
                System.out.println(bao);
            }
        }
    }

    private static void timKiemBao(Scanner sc) {
        System.out.println("=== TÌM KIẾM BÁO ===");
        System.out.println("1. Tìm theo tên báo");
        System.out.println("2. Tìm theo biên tập viên");
        System.out.println("3. Tìm theo khoảng giá");
        System.out.print("Chọn cách tìm: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                System.out.print("Nhập tên báo: ");
                String ten = sc.nextLine();
                List<Bao> ketQua = qlb.timKiemTheoTen(ten);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy báo!");
                } else {
                    for (Bao bao : ketQua) {
                        System.out.println(bao);
                    }
                }
                break;
            case "2":
                System.out.print("Nhập tên biên tập viên: ");
                String btv = sc.nextLine();
                ketQua = qlb.timKiemTheoBienTapVien(btv);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy báo!");
                } else {
                    for (Bao bao : ketQua) {
                        System.out.println(bao);
                    }
                }
                break;
            case "3":
                System.out.print("Nhập giá tối thiểu: ");
                double min = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập giá tối đa: ");
                double max = Double.parseDouble(sc.nextLine());
                ketQua = qlb.timKiemTheoKhoangGia(min, max);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy báo!");
                } else {
                    for (Bao bao : ketQua) {
                        System.out.println(bao);
                    }
                }
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    private static void sapXepBao(Scanner sc) {
        System.out.println("=== SẮP XẾP BÁO ===");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo giá");
        System.out.println("3. Sắp xếp theo năm");
        System.out.print("Chọn cách sắp xếp: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                qlb.nameSort();
                System.out.println("Đã sắp xếp theo tên!");
                break;
            case "2":
                qlb.priceSort();
                System.out.println("Đã sắp xếp theo giá!");
                break;
            case "3":
                qlb.yearSort();
                System.out.println("Đã sắp xếp theo năm!");
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    // ========== CHỨC NĂNG TẠP CHÍ ==========
    private static void themTapChi(Scanner sc) {
        System.out.println("=== THÊM TẠP CHÍ MỚI ===");
        System.out.print("Nhập ID tạp chí: ");
        String id = sc.nextLine();
        if (qltc.tonTai(id)) {
            System.out.println("ID tạp chí đã tồn tại!");
            return;
        }
        System.out.print("Nhập tên tạp chí: ");
        String ten = sc.nextLine();
        System.out.print("Nhập chuyên đề: ");
        String chuyenDe = sc.nextLine();
        System.out.print("Nhập tháng phát hành: ");
        int thang = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số phát hành: ");
        int so = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập năm xuất bản: ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        String nhaXuatBan = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        double gia = Double.parseDouble(sc.nextLine());
        
        TapChi tapChi = new TapChi(id, ten, soLuong, nam, nhaXuatBan, gia, so, thang, chuyenDe);
        qltc.them(tapChi);
        System.out.println("Thêm tạp chí thành công!");
    }

    private static void suaTapChi(Scanner sc) {
        System.out.println("=== SỬA TẠP CHÍ ===");
        System.out.print("Nhập ID tạp chí cần sửa: ");
        String id = sc.nextLine();
        TapChi tapChi = qltc.timKiemId(id);
        if (tapChi == null) {
            System.out.println("Không tìm thấy tạp chí!");
            return;
        }
        System.out.println("Thông tin tạp chí hiện tại:");
        System.out.println(tapChi);
        System.out.print("Nhập tên tạp chí mới (Enter để giữ nguyên): ");
        String ten = sc.nextLine();
        if (!ten.isEmpty()) tapChi.setTenAnPham(ten);
        System.out.print("Nhập chuyên đề mới (Enter để giữ nguyên): ");
        String chuyenDe = sc.nextLine();
        if (!chuyenDe.isEmpty()) tapChi.setChuyenDe(chuyenDe);
        System.out.print("Nhập tháng phát hành mới (Enter để giữ nguyên): ");
        String thangStr = sc.nextLine();
        if (!thangStr.isEmpty()) tapChi.setThangPhatHanh(Integer.parseInt(thangStr));
        System.out.print("Nhập số phát hành mới (Enter để giữ nguyên): ");
        String soStr = sc.nextLine();
        if (!soStr.isEmpty()) tapChi.setSoPhatHanh(Integer.parseInt(soStr));
        System.out.print("Nhập số lượng mới (Enter để giữ nguyên): ");
        String soLuongStr = sc.nextLine();
        if (!soLuongStr.isEmpty()) tapChi.setSoLuong(Integer.parseInt(soLuongStr));
        System.out.print("Nhập năm xuất bản mới (Enter để giữ nguyên): ");
        String namStr = sc.nextLine();
        if (!namStr.isEmpty()) tapChi.setNamXuatBan(Integer.parseInt(namStr));
        System.out.print("Nhập nhà xuất bản mới (Enter để giữ nguyên): ");
        String nhaXuatBan = sc.nextLine();
        if (!nhaXuatBan.isEmpty()) tapChi.setNhaXuatBan(nhaXuatBan);
        System.out.print("Nhập giá tiền mới (Enter để giữ nguyên): ");
        String giaStr = sc.nextLine();
        if (!giaStr.isEmpty()) tapChi.setGiaTien(Double.parseDouble(giaStr));
        
        qltc.sua(tapChi);
        System.out.println("Sửa tạp chí thành công!");
    }

    private static void xoaTapChi(Scanner sc) {
        System.out.println("=== XÓA TẠP CHÍ ===");
        System.out.print("Nhập ID tạp chí cần xóa: ");
        String id = sc.nextLine();
        if (qltc.xoa(id)) {
            System.out.println("Xóa tạp chí thành công!");
        } else {
            System.out.println("Không tìm thấy tạp chí để xóa!");
        }
    }

    private static void xemTatCaTapChi() {
        System.out.println("=== DANH SÁCH TẤT CẢ TẠP CHÍ ===");
        List<TapChi> danhSach = qltc.getAll();
        if (danhSach.isEmpty()) {
            System.out.println("Chưa có tạp chí nào!");
        } else {
            for (TapChi tapChi : danhSach) {
                System.out.println(tapChi);
            }
        }
    }

    private static void timKiemTapChi(Scanner sc) {
        System.out.println("=== TÌM KIẾM TẠP CHÍ ===");
        System.out.println("1. Tìm theo tên tạp chí");
        System.out.println("2. Tìm theo chuyên đề");
        System.out.println("3. Tìm theo tháng phát hành");
        System.out.println("4. Tìm theo số phát hành");
        System.out.println("5. Tìm theo khoảng giá");
        System.out.print("Chọn cách tìm: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                System.out.print("Nhập tên tạp chí: ");
                String ten = sc.nextLine();
                List<TapChi> ketQua = qltc.timKiemTheoTen(ten);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy tạp chí!");
                } else {
                    for (TapChi tapChi : ketQua) {
                        System.out.println(tapChi);
                    }
                }
                break;
            case "2":
                System.out.print("Nhập chuyên đề: ");
                String chuyenDe = sc.nextLine();
                ketQua = qltc.chuyenDeSearch(chuyenDe);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy tạp chí!");
                } else {
                    for (TapChi tapChi : ketQua) {
                        System.out.println(tapChi);
                    }
                }
                break;
            case "3":
                System.out.print("Nhập tháng phát hành: ");
                int thang = Integer.parseInt(sc.nextLine());
                ketQua = qltc.thangPhatHanhSearch(thang);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy tạp chí!");
                } else {
                    for (TapChi tapChi : ketQua) {
                        System.out.println(tapChi);
                    }
                }
                break;
            case "4":
                System.out.print("Nhập số phát hành: ");
                int so = Integer.parseInt(sc.nextLine());
                ketQua = qltc.soPhatHanhSearch(so);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy tạp chí!");
                } else {
                    for (TapChi tapChi : ketQua) {
                        System.out.println(tapChi);
                    }
                }
                break;
            case "5":
                System.out.print("Nhập giá tối thiểu: ");
                double min = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập giá tối đa: ");
                double max = Double.parseDouble(sc.nextLine());
                ketQua = qltc.timKiemTheoKhoangGia(min, max);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy tạp chí!");
                } else {
                    for (TapChi tapChi : ketQua) {
                        System.out.println(tapChi);
                    }
                }
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    private static void sapXepTapChi(Scanner sc) {
        System.out.println("=== SẮP XẾP TẠP CHÍ ===");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo giá");
        System.out.println("3. Sắp xếp theo năm");
        System.out.print("Chọn cách sắp xếp: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                qltc.nameSort();
                System.out.println("Đã sắp xếp theo tên!");
                break;
            case "2":
                qltc.priceSort();
                System.out.println("Đã sắp xếp theo giá!");
                break;
            case "3":
                qltc.yearSort();
                System.out.println("Đã sắp xếp theo năm!");
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }
}