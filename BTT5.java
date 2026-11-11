import java.util.ArrayList; 
//cho phép ct sd class mà có thể chứa nhìu ptu và tự tăng kích thước khi thêm ptu
import java.util.List;
import java.util.Scanner;
public class BTT5 {
    private static void nhapNhieuSach() {
        int n;
        do {
            n = nhapSoNguyen("Nhap so sach n: ");
            if (n <= 0) {
                System.out.println("n phai lon hon 0!");
            }
        } 
        while (n <= 0);
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach thu " + (i + 1) + ":");
            String ma;
            do {
                ma = nhapChuoi("Ma sach: ");
                if (ma.isEmpty() || timSach(ma) != null) {
                    System.out.println("Ma sach khong hop le hoac da ton tai!");
                    ma = "";
                }
            } while (ma.isEmpty());
            String ten = nhapChuoi("Ten sach: ");
            int soLuong;
            do {
                soLuong = nhapSoNguyen("So luong: ");
                if (soLuong < 0) {
                    System.out.println("So luong khong am!");
                }
            } while (soLuong < 0);
            double donGia;
            do {
                donGia = nhapSoThuc("Don gia: ");
                if (donGia < 0) {
                    System.out.println("Don gia khong am!");
                }
            } while (donGia < 0);
            danhSach.add(new Sach(ma, ten, soLuong, donGia));
        }
    }
    private static void tinhTong() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (Sach sach : danhSach) {
            tongSoLuong += sach.soLuong;
            tongGiaTri += sach.soLuong * sach.donGia;
        }
        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.printf("Tong gia tri sach: %.2f%n", tongGiaTri);
    }
    private static void timTheoMa() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        Sach sach = timSach(ma);
        if (sach == null) {
            System.out.println("Khong tim thay sach co ma " + ma);
        } else {
            inSach(sach);
        }
    }
    private static Sach timSach(String ma) {
        for (Sach sach : danhSach) {
            if (sach.ma.equalsIgnoreCase(ma.trim())) {
                return sach;
            }
        }
        return null;
    }
    private static void inSach(Sach sach) {
        System.out.printf(
            "Ma: %s | Ten: %s | So luong: %d | Don gia: %.2f | Thanh tien: %.2f%n",
            sach.ma, sach.ten, sach.soLuong, sach.donGia,
            sach.soLuong * sach.donGia
        );
    }
    private static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }
    private static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le.");
            }
        }
    }
    private static double nhapSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc hop le.");
            }
        }
    }
    private static class Sach {
        String ma;
        String ten;
        int soLuong;
        double donGia;
        Sach(String ma, String ten, int soLuong, double donGia) {
            this.ma = ma;
            this.ten = ten;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }
    }
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Sach> danhSach = new ArrayList<>();//danh sách chứa các đối tượng Sách
    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("1. Nhap n sach: ");
            System.out.println("2. Tinh tong so luong va tong gia tri sach");
            System.out.println("3. Tim sach theo ma: ");
            System.out.println("4. Thoat");
            chon = nhapSoNguyen("Chon: ");
            switch (chon) {
                case 1:
                    nhapNhieuSach(); break;
                case 2:
                    tinhTong(); break;
                case 3:
                    timTheoMa(); break;
                case 4:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } 
        while (chon != 4);
    }
}