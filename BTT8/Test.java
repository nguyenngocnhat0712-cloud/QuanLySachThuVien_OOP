package BTT8;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class Test {
    public static void main(String[] args) {
        chayChuongTrinh();
    }

    public static void chayChuongTrinh() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\nQUAN LY SACH - BTT8");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("0. Thoat");
            luaChon = nhapSoNguyen(scanner, "Lua chon cua ban: ");

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Nhap tieu de: ");
                    String tieuDe = scanner.nextLine();
                    System.out.print("Nhap tac gia: ");
                    String tacGia = scanner.nextLine();
                    int namXuatBan = nhapNamXuatBan(scanner);
                    int soLuong = nhapSoLuong(scanner);

                    // Tao Sach bang constructor day du sau khi nhap du lieu hop le.
                    danhSachSach.add(new Sach(maSach, tieuDe, tacGia, namXuatBan, soLuong));
                    System.out.println("Da them sach.");
                    break;
                case 2:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach sach dang rong.");
                    } else {
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            System.out.println("\n--- Sach " + (i + 1) + " ---");
                            danhSachSach.get(i).hienThiThongTin();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (luaChon != 0);

        scanner.close();
    }

    private static int nhapSoNguyen(Scanner scanner, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen.");
            }
        }
    }

    private static int nhapNamXuatBan(Scanner scanner) {
        int namHienTai = Year.now().getValue();
        while (true) {
            int namXuatBan = nhapSoNguyen(scanner, "Nhap nam xuat ban: ");
            if (namXuatBan > 0 && namXuatBan <= namHienTai) {
                return namXuatBan;
            }
            System.out.println("Nam xuat ban phai tu 1 den " + namHienTai + ".");
        }
    }

    private static int nhapSoLuong(Scanner scanner) {
        while (true) {
            int soLuong = nhapSoNguyen(scanner, "Nhap so luong: ");
            if (soLuong >= 0) {
                return soLuong;
            }
            System.out.println("So luong khong duoc am.");
        }
    }
}
