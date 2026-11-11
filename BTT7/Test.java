package BTT7;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Yeu cau 4(BTT7): Tao ArrayList de luu va quan ly danh sach Sach.
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon;

        // Menu cho phep them sach, hien thi danh sach hoac thoat chuong trinh.
        do {
            System.out.println("\nQUAN LY SACH");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Nhap tieu de: ");
                    String tieuDe = scanner.nextLine();
                    System.out.print("Nhap tac gia: ");
                    String tacGia = scanner.nextLine();
                    System.out.print("Nhap nam xuat ban: ");
                    int namXuatBan = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhap so luong: ");
                    int soLuong = Integer.parseInt(scanner.nextLine());

                    // Yeu cau 3(BTT7): Tao doi tuong Sach tu thong tin vua nhap.
                    // Yeu cau 4(BTT7): Them doi tuong Sach vao ArrayList.
                    danhSachSach.add(new Sach(maSach, tieuDe, tacGia, namXuatBan, soLuong));
                    System.out.println("Da them sach.");
                    break;
                case 2:
                    // Yeu cau 4(BTT7): Duyet danh sach va goi hienThiThongTin() cho tung sach.
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
}
