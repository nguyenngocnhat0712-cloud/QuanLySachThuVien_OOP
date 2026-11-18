import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Sach {
    protected String maSach;
    protected String ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public void nhap(Scanner sc) {
        System.out.println("Nhap thong tin sach:");
        maSach = nhapChuoi(sc, "Nhap ma sach: ");
        ngayNhap = nhapNgay(sc, "Nhap ngay nhap (dd/MM/yyyy): ");
        donGia = nhapSoThuc(sc, "Nhap don gia: ");
        soLuong = nhapSoNguyen(sc, "Nhap so luong: ");
        nhaXuatBan = nhapChuoi(sc, "Nhap nha xuat ban: ");
    }

    protected String nhapChuoi(Scanner sc, String noiDungHienThi) {
        while (true) {
            System.out.print(noiDungHienThi);
            String giaTri = sc.nextLine();
            if (!giaTri.isEmpty()) {
                return giaTri;
            }
            System.out.println("Khong duoc de trong! Vui long nhap lai.");
        }
    }

    protected String nhapNgay(Scanner sc, String noiDungHienThi) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(noiDungHienThi);
            String giaTri = sc.nextLine();
            try {
                sdf.parse(giaTri);
                return giaTri;
            } catch (ParseException e) {
                System.out.println("Ngay nhap khong hop le (dinh dang dd/MM/yyyy)! Vui long nhap lai.");
            }
        }
    }

    protected double nhapSoThuc(Scanner sc, String noiDungHienThi) {
        while (true) {
            System.out.print(noiDungHienThi);
            double giaTri = Double.parseDouble(sc.nextLine());
            if (giaTri >= 0) {
                return giaTri;
            }
            System.out.println("Gia tri khong duoc am! Vui long nhap lai.");
        }
    }

    protected int nhapSoNguyen(Scanner sc, String noiDungHienThi) {
        while (true) {
            System.out.print(noiDungHienThi);
            int giaTri = Integer.parseInt(sc.nextLine());
            if (giaTri >= 0) {
                return giaTri;
            }
            System.out.println("Gia tri khong duoc am! Vui long nhap lai.");
        }
    }

    public double thanhTien() {
        return 0;
    }

    public void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.printf("Don gia: %.2f%n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }

    // Yeu cau 1: Lop con SachGiaoKhoa ke thua lop Sach
    public class SachGiaoKhoa extends Sach {
        protected String tinhTrang;

        public SachGiaoKhoa() {
            super();
        }

        public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong,
                String nhaXuatBan, String tinhTrang) {
            super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
            this.tinhTrang = tinhTrang;
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc);
            while (true) {
                tinhTrang = nhapChuoi(sc, "Nhap tinh trang (moi / cu): ");
                if ("moi".equalsIgnoreCase(tinhTrang) || "cu".equalsIgnoreCase(tinhTrang)) {
                    break;
                }
                System.out.println("Tinh trang chi nhan 'moi' hoac 'cu'.");
            }
        }

        @Override
        public double thanhTien() {
            if ("moi".equalsIgnoreCase(tinhTrang)) {
                return soLuong * donGia;
            } else if ("cu".equalsIgnoreCase(tinhTrang)) {
                return soLuong * donGia * 0.5;
            }
            return 0;
        }

        @Override
        public void xuat() {
            System.out.println("\n--- Sach giao khoa ---");
            super.xuat();
            System.out.println("Tinh trang: " + tinhTrang);
            System.out.printf("Thanh tien: %.2f%n", thanhTien());
        }
    }

    // Yeu cau 1: Lop con SachThamKhao ke thua lop Sach
    public class SachThamKhao extends Sach {
        protected double thue;

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc);
            thue = nhapSoThuc(sc, "Nhap thue: ");
        }

        @Override
        public double thanhTien() {
            return soLuong * donGia + thue;
        }

        @Override
        public void xuat() {
            System.out.println("\n--- Sach tham khao ---");
            super.xuat();
            System.out.printf("Thue: %.2f%n", thue);
            System.out.printf("Thanh tien: %.2f%n", thanhTien());
        }
    }

    public static void main(String[] args) {
        Sach chuongTrinh = new Sach();
        chuongTrinh.chayChuongTrinh();
    }

    private void chayChuongTrinh() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        // Nhap danh sach sach
        int soLuongSach = nhapSoNguyen(sc, "Nhap so luong sach can quan ly: ");

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println("\n--- Nhap thong tin sach thu " + (i + 1) + " ---");
            int loaiSach = nhapLoaiSach(sc);

            Sach sach;
            if (loaiSach == 1) {
                sach = new SachGiaoKhoa();
            } else {
                sach = new SachThamKhao();
            }

            sach.nhap(sc);
            danhSachSach.add(sach);
        }

        if (danhSachSach.isEmpty()) {
            System.out.println("\nDanh sach rong.");
            sc.close();
            return;
        }

        // Xuat danh sach sach
        System.out.println("\n==================== DANH SACH CAC LOAI SACH ====================");
        for (Sach sach : danhSachSach) {
            sach.xuat();
        }

        // Yeu cau 3: Tinh tong thanh tien cho tung loai
        // Yeu cau 4: Tinh trung binh cong don gia cua cac sach tham khao
        double tongTienSachGiaoKhoa = 0;
        double tongTienSachThamKhao = 0;
        double tongDonGiaSachThamKhao = 0;
        int soSachThamKhao = 0;

        for (Sach sachHienTai : danhSachSach) {
            if (sachHienTai instanceof SachGiaoKhoa) {
                tongTienSachGiaoKhoa += sachHienTai.thanhTien();
            } else if (sachHienTai instanceof SachThamKhao) {
                tongTienSachThamKhao += sachHienTai.thanhTien();
                tongDonGiaSachThamKhao += sachHienTai.donGia;
                soSachThamKhao++;
            }
        }

        System.out.println("\n==================== THONG KE ====================");
        System.out.printf("Tong thanh tien Sach Giao Khoa: %.2f%n", tongTienSachGiaoKhoa);
        System.out.printf("Tong thanh tien Sach Tham Khao: %.2f%n", tongTienSachThamKhao);

        if (soSachThamKhao > 0) {
            System.out.printf("Trung binh cong don gia Sach Tham Khao: %.2f%n",
                    tongDonGiaSachThamKhao / soSachThamKhao);
        } else {
            System.out.println("Khong co Sach Tham Khao nao de tinh trung binh cong don gia.");
        }

        // Yeu cau 5: Xuat ra cac sach giao khoa cua nha xuat ban X
        String nxbCanTim = nhapChuoi(sc,
                "\nNhap ten nha xuat ban X can tim (Sach Giao Khoa): ");
        System.out.println("=== DANH SACH SACH GIAO KHOA CUA NXB '" + nxbCanTim + "' ===");
        boolean timThay = false;
        for (Sach s : danhSachSach) {
            if (s instanceof SachGiaoKhoa && nxbCanTim.equalsIgnoreCase(s.nhaXuatBan)) {
                s.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Sach Giao Khoa nao cua NXB: " + nxbCanTim);
        }

        sc.close();
    }

    private int nhapLoaiSach(Scanner sc) {
        while (true) {
            int loaiSach = nhapSoNguyen(sc,
                    "Chon loai sach (1 - Sach Giao Khoa, 2 - Sach Tham Khao): ");
            if (loaiSach == 1 || loaiSach == 2) {
                return loaiSach;
            }
            System.out.println("Lua chon khong hop le! Chi chon 1 hoac 2.");
        }
    }
}