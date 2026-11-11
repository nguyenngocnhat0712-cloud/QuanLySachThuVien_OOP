import java.util.ArrayList;
import java.util.Scanner;
public class BTT5 {
    private static final Scanner sc = new Scanner(System.in);
    // ArrayList co the tu tang/giam kich thuoc khi them hoac xoa sach
    private static final ArrayList<Sach> danhSachSach = new ArrayList<>();

    // Bài 4: Hiển thị menu và gọi chức năng tương ứng cho đến khi người dùng chọn thoát
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            chon = nhapSoNguyen("Chon: ");

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSachTheoMa();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 8);
    }

    // Bài 3, 4: Nhập thông tin và thêm một cuốn sách mới vào danh sách.
    private static void themSach() {
        System.out.println("\n--- Them sach ---");
        String ma;
        do {
            ma = nhapChuoi("Ma sach: ");
            if (ma.isEmpty() || timTheoMa(ma) != null) {
                System.out.println("Ma sach khong hop le hoac da ton tai.");
                ma = "";
            }
        } while (ma.isEmpty());

        String ten = nhapChuoi("Ten sach: ");
        while (ten.isEmpty()) {
            System.out.println("Ten sach khong duoc de trong.");
            ten = nhapChuoi("Ten sach: ");
        }

        int soLuong = nhapSoKhongAm("So luong: ");
        double donGia = nhapGia();
        danhSachSach.add(new Sach(ma, ten, soLuong, donGia));
        System.out.println("Da them sach.");
    }

    // Bài 3, 4: Duyệt danh sách để hiển thị toàn bộ sách hiện có.
    private static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }

        System.out.println("\n--- Danh sach sach ---");
        for (Sach sach : danhSachSach) {
            inSach(sach);
        }
    }
    // Bài 2, 3, 4: Tìm một cuốn sách dựa trên mã sách.
    private static void timSachTheoMa() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        Sach sach = timTheoMa(ma);
        if (sach == null) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
        } else {
            inSach(sach);
        }
    }

    // Bài 3, 4: Tìm sách theo mã trước, sau đó xóa sách khỏi ArrayList.
    private static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        Sach sach = timTheoMa(ma);
        if (sach == null) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
            return;
        }
        danhSachSach.remove(sach);
        System.out.println("Da xoa sach.");
    }

    // Bài 3, 4: Cập nhật tên, số lượng và đơn giá của sách đã tìm thấy.
    private static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        Sach sach = timTheoMa(ma);
        if (sach == null) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
            return;
        }
        String ten = nhapChuoi("Ten sach moi: ");
        while (ten.isEmpty()) {
            System.out.println("Ten sach khong duoc de trong.");
            ten = nhapChuoi("Ten sach moi: ");
        }
        sach.ten = ten;
        sach.soLuong = nhapSoKhongAm("So luong moi: ");
        sach.donGia = nhapGia();
        System.out.println("Da cap nhat sach.");
    }

    // Bài 4: Cộng số lượng của tất cả sách trong danh sách.
    private static void tinhTongSoLuong() {
        long tongSoLuong = 0;
        for (Sach sach : danhSachSach) {
            tongSoLuong += sach.soLuong;
        }
        System.out.println("Tong so luong sach: " + tongSoLuong);
    }

    // Bài 4: Tính tổng giá trị tồn kho bằng số lượng nhân đơn giá của từng sách.
    private static void tinhTongGiaTri() {
        double tongGiaTri = 0;
        for (Sach sach : danhSachSach) {
            tongGiaTri += sach.soLuong * sach.donGia;
        }
        System.out.printf("Tong gia tri sach: %.2f%n", tongGiaTri);
    }

    // Hàm dùng chung để tìm đối tượng sách theo mã, không phân biệt chữ hoa/thường.
    private static Sach timTheoMa(String ma) {
        for (Sach sach : danhSachSach) {
            if (sach.ma.equalsIgnoreCase(ma.trim())) {
                return sach;
            }
        }
        return null;
    }   

    // In thông tin của một sách, bao gồm cả thành tiền.
    private static void inSach(Sach sach) {
        System.out.printf(
            "Ma: %s | Ten: %s | So luong: %d | Don gia: %.2f | Thanh tien: %.2f%n",
            sach.ma, sach.ten, sach.soLuong, sach.donGia, sach.soLuong * sach.donGia
        );
    }

    // Các hàm nhập liệu dùng chung giúp chuẩn hóa dữ liệu và kiểm tra đầu vào.
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

    private static int nhapSoKhongAm(String thongBao) {
        int so;
        do {
            so = nhapSoNguyen(thongBao);
            if (so < 0) {
                System.out.println("Gia tri khong duoc am.");
            }
        } while (so < 0);
        return so;
    }

    private static double nhapGia() {
        while (true) {
            System.out.print("Don gia: ");
            try {
                double donGia = Double.parseDouble(sc.nextLine().trim());
                if (!Double.isNaN(donGia) && !Double.isInfinite(donGia) && donGia >= 0) {
                    return donGia;
                }
                System.out.println("Don gia phai la so khong am hop le.");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap don gia hop le.");
            }
        }
    }

    // Lớp mô tả một cuốn sách; mã là cố định, các thông tin còn lại có thể sửa.
    private static class Sach {
        private final String ma;
        private String ten;
        private int soLuong;
        private double donGia;

        private Sach(String ma, String ten, int soLuong, double donGia) {
            this.ma = ma;
            this.ten = ten;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }
    }
}
