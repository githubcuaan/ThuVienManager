package ui;

import manager.muontra.QuanLyMuonTra;
import manager.anpham.*;
import model.muontra.*;
import model.taikhoan.User;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class MenuMuonTra {
    private static QuanLyMuonTra qlmt = QuanLyMuonTra.getInstance();
    private static QuanLySach qls = QuanLySach.getInstance();
    private static QuanLyBao qlb = QuanLyBao.getInstance();
    private static QuanLyTapChi qltc = QuanLyTapChi.getInstance();

    public static void menu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== QUẢN LÝ MƯỢN TRẢ (ADMIN) =====");
            System.out.println("1. Thêm mượn mới");
            System.out.println("2. Sửa thông tin mượn");
            System.out.println("3. Xóa mượn");
            System.out.println("4. Xem tất cả mượn trả");
            System.out.println("5. Tìm kiếm mượn trả");
            System.out.println("6. Lọc theo trạng thái");
            System.out.println("7. Thống kê mượn trả");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    themMuon(sc);
                    break;
                case "2":
                    suaMuon(sc);
                    break;
                case "3":
                    xoaMuon(sc);
                    break;
                case "4":
                    xemTatCaMuon();
                    break;
                case "5":
                    timKiemMuon(sc);
                    break;
                case "6":
                    locTheoTrangThai(sc);
                    break;
                case "7":
                    thongKeMuonTra();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nhập gì lạ vậy? Chọn lại đi!");
            }
        }
    }

    public static void menuUser(Scanner sc, model.taikhoan.TaiKhoan currentUser) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== MƯỢN/TRẢ/THEO DÕI (USER) =====");
            System.out.println("1. Mượn ấn phẩm");
            System.out.println("2. Trả ấn phẩm");
            System.out.println("3. Xem lịch sử mượn trả cá nhân");
            System.out.println("4. Xem ấn phẩm đang mượn");
            System.out.println("5. Tìm kiếm trong lịch sử cá nhân");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    muonAnPham(sc, currentUser);
                    break;
                case "2":
                    traAnPham(sc, currentUser);
                    break;
                case "3":
                    xemLichSuCaNhan(currentUser);
                    break;
                case "4":
                    xemDangMuon(currentUser);
                    break;
                case "5":
                    timKiemLichSuCaNhan(sc, currentUser);
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
    private static void themMuon(Scanner sc) {
        System.out.println("=== THÊM MƯỢN MỚI ===");
        System.out.print("Nhập ID sách/báo/tạp chí: ");
        String idAnPham = sc.nextLine();
        
        // Kiểm tra ấn phẩm có tồn tại không
        if (!kiemTraAnPhamTonTai(idAnPham)) {
            System.out.println("Không tìm thấy ấn phẩm với ID này!");
            return;
        }
        
        // Kiểm tra ấn phẩm có đang được mượn không
        if (qlmt.sachDangMuon(idAnPham)) {
            System.out.println("Ấn phẩm này đang được mượn!");
            return;
        }
        
        System.out.print("Nhập tên sinh viên: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();
        System.out.print("Nhập MSSV: ");
        String msv = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        
        // Lấy thông tin ấn phẩm
        String tenAnPham = layTenAnPham(idAnPham);
        if (tenAnPham == null) {
            System.out.println("Không thể lấy thông tin ấn phẩm!");
            return;
        }
        
        SinhVien sv = new SinhVien(hoTen, sdt, msv, email);
        MuonTra muonTra = new MuonTra(idAnPham, tenAnPham, sv, new Date());
        
        qlmt.them(muonTra);
        System.out.println("Thêm mượn thành công!");
    }

    private static void suaMuon(Scanner sc) {
        System.out.println("=== SỬA THÔNG TIN MƯỢN ===");
        System.out.print("Nhập ID sách/báo/tạp chí cần sửa: ");
        String idAnPham = sc.nextLine();
        
        List<MuonTra> danhSach = qlmt.timTheoIdSachBao(idAnPham);
        if (danhSach.isEmpty()) {
            System.out.println("Không tìm thấy mượn trả!");
            return;
        }
        
        MuonTra muonTra = danhSach.get(0);
        System.out.println("Thông tin mượn hiện tại:");
        System.out.println(muonTra);
        
        System.out.print("Nhập tên sinh viên mới (Enter để giữ nguyên): ");
        String hoTen = sc.nextLine();
        if (!hoTen.isEmpty()) {
            muonTra.getSinhVien().setHoTen(hoTen);
        }
        
        System.out.print("Nhập số điện thoại mới (Enter để giữ nguyên): ");
        String sdt = sc.nextLine();
        if (!sdt.isEmpty()) {
            muonTra.getSinhVien().setSdt(sdt);
        }
        
        System.out.print("Nhập email mới (Enter để giữ nguyên): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            muonTra.getSinhVien().setEmail(email);
        }
        
        System.out.print("Đã trả chưa? (y/n): ");
        String daTra = sc.nextLine();
        if (daTra.equalsIgnoreCase("y")) {
            muonTra.setDaTra(true);
            muonTra.setNgayTra(new Date());
        }
        
        qlmt.sua(muonTra);
        System.out.println("Sửa mượn thành công!");
    }

    private static void xoaMuon(Scanner sc) {
        System.out.println("=== XÓA MƯỢN ===");
        System.out.print("Nhập ID sách/báo/tạp chí cần xóa: ");
        String idAnPham = sc.nextLine();
        
        if (qlmt.xoa(idAnPham)) {
            System.out.println("Xóa mượn thành công!");
        } else {
            System.out.println("Không tìm thấy mượn để xóa!");
        }
    }

    private static void xemTatCaMuon() {
        System.out.println("=== DANH SÁCH TẤT CẢ MƯỢN TRẢ ===");
        List<MuonTra> danhSach = qlmt.getAll();
        if (danhSach.isEmpty()) {
            System.out.println("Chưa có mượn trả nào!");
        } else {
            for (MuonTra mt : danhSach) {
                System.out.println(mt);
            }
        }
    }

    private static void timKiemMuon(Scanner sc) {
        System.out.println("=== TÌM KIẾM MƯỢN TRẢ ===");
        System.out.println("1. Tìm theo MSSV");
        System.out.println("2. Tìm theo tên sách/báo");
        System.out.println("3. Tìm theo ID sách/báo");
        System.out.println("4. Tìm theo ngày mượn");
        System.out.print("Chọn cách tìm: ");
        String chon = sc.nextLine();
        switch (chon) {
            case "1":
                System.out.print("Nhập MSSV: ");
                String msv = sc.nextLine();
                List<MuonTra> ketQua = qlmt.timTheoMSSV(msv);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy mượn trả!");
                } else {
                    for (MuonTra mt : ketQua) {
                        System.out.println(mt);
                    }
                }
                break;
            case "2":
                System.out.print("Nhập tên sách/báo: ");
                String ten = sc.nextLine();
                ketQua = qlmt.timTheoTenSachBao(ten);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy mượn trả!");
                } else {
                    for (MuonTra mt : ketQua) {
                        System.out.println(mt);
                    }
                }
                break;
            case "3":
                System.out.print("Nhập ID sách/báo: ");
                String id = sc.nextLine();
                ketQua = qlmt.timTheoIdSachBao(id);
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy mượn trả!");
                } else {
                    for (MuonTra mt : ketQua) {
                        System.out.println(mt);
                    }
                }
                break;
            case "4":
                System.out.println("Tìm theo ngày mượn (hôm nay)");
                ketQua = qlmt.timTheoNgayMuon(new Date());
                if (ketQua.isEmpty()) {
                    System.out.println("Không tìm thấy mượn trả!");
                } else {
                    for (MuonTra mt : ketQua) {
                        System.out.println(mt);
                    }
                }
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
        }
    }

    private static void locTheoTrangThai(Scanner sc) {
        System.out.println("=== LỌC THEO TRẠNG THÁI ===");
        System.out.println("1. Đã trả");
        System.out.println("2. Chưa trả");
        System.out.print("Chọn trạng thái: ");
        String chon = sc.nextLine();
        List<MuonTra> ketQua;
        switch (chon) {
            case "1":
                ketQua = qlmt.daTra();
                System.out.println("=== DANH SÁCH ĐÃ TRẢ ===");
                break;
            case "2":
                ketQua = qlmt.chuaTra();
                System.out.println("=== DANH SÁCH CHƯA TRẢ ===");
                break;
            default:
                System.out.println("Chọn không hợp lệ!");
                return;
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("Không có mượn trả nào!");
        } else {
            for (MuonTra mt : ketQua) {
                System.out.println(mt);
            }
        }
    }

    private static void thongKeMuonTra() {
        System.out.println("=== THỐNG KÊ MƯỢN TRẢ ===");
        System.out.println("Tổng số mượn trả: " + qlmt.soLuong());
        System.out.println("Số đã trả: " + qlmt.soLuongDaTra());
        System.out.println("Số chưa trả: " + qlmt.soLuongChuaTra());
    }

    // ========== CHỨC NĂNG USER ==========
    private static void muonAnPham(Scanner sc, model.taikhoan.TaiKhoan currentUser) {
        System.out.println("=== MƯỢN ẤN PHẨM ===");
        
        // Kiểm tra user có phải là User không
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới được mượn ấn phẩm!");
            return;
        }
        
        User user = (User) currentUser;
        System.out.print("Nhập ID sách/báo/tạp chí muốn mượn: ");
        String idAnPham = sc.nextLine();
        
        // Kiểm tra ấn phẩm có tồn tại không
        if (!kiemTraAnPhamTonTai(idAnPham)) {
            System.out.println("Không tìm thấy ấn phẩm với ID này!");
            return;
        }
        
        // Kiểm tra ấn phẩm có đang được mượn không
        if (qlmt.sachDangMuon(idAnPham)) {
            System.out.println("Ấn phẩm này đang được mượn!");
            return;
        }
        
        // Lấy thông tin ấn phẩm
        String tenAnPham = layTenAnPham(idAnPham);
        if (tenAnPham == null) {
            System.out.println("Không thể lấy thông tin ấn phẩm!");
            return;
        }
        
        // Tạo sinh viên từ thông tin user
        SinhVien sv = new SinhVien(user.getTenDangNhap(), "Chưa cập nhật", user.getMsv(), "Chưa cập nhật");
        MuonTra muonTra = new MuonTra(idAnPham, tenAnPham, sv, new Date());
        
        qlmt.them(muonTra);
        System.out.println("Mượn ấn phẩm thành công!");
    }

    private static void traAnPham(Scanner sc, model.taikhoan.TaiKhoan currentUser) {
        System.out.println("=== TRẢ ẤN PHẨM ===");
        
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới được trả ấn phẩm!");
            return;
        }
        
        User user = (User) currentUser;
        System.out.print("Nhập ID sách/báo/tạp chí muốn trả: ");
        String idAnPham = sc.nextLine();
        
        if (qlmt.traSach(idAnPham, new Date())) {
            System.out.println("Trả ấn phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mượn trả hoặc đã trả rồi!");
        }
    }

    private static void xemLichSuCaNhan(model.taikhoan.TaiKhoan currentUser) {
        System.out.println("=== LỊCH SỬ MƯỢN TRẢ CÁ NHÂN ===");
        
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới có lịch sử mượn trả!");
            return;
        }
        
        User user = (User) currentUser;
        List<MuonTra> lichSu = qlmt.timTheoMSSV(user.getMsv());
        
        if (lichSu.isEmpty()) {
            System.out.println("Chưa có lịch sử mượn trả nào!");
        } else {
            for (MuonTra mt : lichSu) {
                System.out.println(mt);
            }
        }
    }

    private static void xemDangMuon(model.taikhoan.TaiKhoan currentUser) {
        System.out.println("=== ẤN PHẨM ĐANG MƯỢN ===");
        
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới có ấn phẩm đang mượn!");
            return;
        }
        
        User user = (User) currentUser;
        List<MuonTra> lichSu = qlmt.timTheoMSSV(user.getMsv());
        
        boolean coDangMuon = false;
        for (MuonTra mt : lichSu) {
            if (!mt.isDaTra()) {
                System.out.println(mt);
                coDangMuon = true;
            }
        }
        
        if (!coDangMuon) {
            System.out.println("Không có ấn phẩm nào đang mượn!");
        }
    }

    private static void timKiemLichSuCaNhan(Scanner sc, model.taikhoan.TaiKhoan currentUser) {
        System.out.println("=== TÌM KIẾM TRONG LỊCH SỬ CÁ NHÂN ===");
        
        if (!(currentUser instanceof User)) {
            System.out.println("Chỉ user mới có lịch sử mượn trả!");
            return;
        }
        
        User user = (User) currentUser;
        System.out.print("Nhập tên sách/báo/tạp chí: ");
        String ten = sc.nextLine();
        
        List<MuonTra> lichSu = qlmt.timTheoMSSV(user.getMsv());
        List<MuonTra> ketQua = lichSu.stream()
                .filter(mt -> mt.getTenSachBao().toLowerCase().contains(ten.toLowerCase()))
                .toList();
        
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy trong lịch sử!");
        } else {
            for (MuonTra mt : ketQua) {
                System.out.println(mt);
            }
        }
    }

    // ========== HÀM HỖ TRỢ ==========
    private static boolean kiemTraAnPhamTonTai(String id) {
        return qls.tonTai(id) || qlb.tonTai(id) || qltc.tonTai(id);
    }

    private static String layTenAnPham(String id) {
        // Tìm trong sách
        if (qls.tonTai(id)) {
            return qls.timKiemId(id).getTenAnPham();
        }
        // Tìm trong báo
        if (qlb.tonTai(id)) {
            return qlb.timKiemId(id).getTenAnPham();
        }
        // Tìm trong tạp chí
        if (qltc.tonTai(id)) {
            return qltc.timKiemId(id).getTenAnPham();
        }
        return null;
    }
}