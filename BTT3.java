import java.util.Scanner; //dùng để khai báo thư viện Scanner để nhập dữ liệu 
import java.time.Year;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach;
    //private Scanner scanner = new Scanner(System.in);
    // Constructor có tham số đầy đủ
    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    //get - set
    //maSach
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    //tenSach
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    //tacGia
    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    //namXuatBan
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    //donGia    
    public double getDonGia() {
        return donGia;
    }   
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    //soLuong
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    //nhập thông tin sách (BT1)
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = sc.nextInt();
        System.out.print("Nhap don gia: ");
        this.donGia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        System.out.println("Chon loai sach:");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Lua chon cua ban: ");
        this.loaiSach = sc.nextInt();
        sc.nextLine(); // xóa bộ nhớ đệm
    }
    //kiểm tra thông tin sách (Bài 1)
    public boolean kiemTraNamXuatBanHopLe() {
        return this.namXuatBan >= 1 && this.namXuatBan <= Year.now().getValue();
    }
    public boolean kiemTraThongTinHopLe() {
        return this.donGia > 0 && this.soLuong >= 0 && kiemTraNamXuatBanHopLe();
    }
    //phân loại giá sách (Bài 2)
    public String phanLoaiGia() {
        if (this.donGia < 50000) {
            return "Sach gia thap";
        } else if (this.donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (this.donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }
    //phân loại tồn kho (Bài 3)
    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Het sach";
        } else if (this.soLuong <= 5) {
            return "Sap het";
        } else if (this.soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }
    //chọn loại sách bằng switch (Bài 4)
    public String tenLoaiSach() {
        switch (this.loaiSach) {
            case 1:
                return "Sach giao khoa";
            case 2:
                return "Sach tham khao";
            case 3:
                return "Sach chuyen nganh";
            case 4:
                return "Sach khac";
            default:
                return "Loai sach khong hop le";
        }
    }
    //tính thành tiền (BT2)
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }
    //tính phí vận chuyển (BT3)
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    //tính tổng tiền nhập (BT4)
    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    //hiển thị thông tin sách 
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Ten sach: " + this.tenSach);
        System.out.println("Tac gia: " + this.tacGia);
        System.out.println("Nam xuat ban: " + this.namXuatBan);
        System.out.println("Don gia: " + this.donGia);
        System.out.println("So luong: " + this.soLuong);
        System.out.println("Loai sach: " + tenLoaiSach());
        System.out.println("Kiem tra don gia (> 0): " + (this.donGia > 0 ? "Hop le" : "Khong hop le"));
        System.out.println("Kiem tra so luong (>= 0): " + (this.soLuong >= 0 ? "Hop le" : "Khong hop le"));
        System.out.println("Kiem tra nam xuat ban: " + (kiemTraNamXuatBanHopLe() ? "Hop le" : "Khong hop le"));
        System.out.println("Thong tin sach: " + (kiemTraThongTinHopLe() ? "Hop le" : "Khong hop le"));
        System.out.println("Phan loai gia: " + phanLoaiGia());
        System.out.println("Tinh trang ton kho: " + phanLoaiTonKho());
        System.out.println("Thanh tien: " + tinhThanhTien());
        System.out.println("Phi van chuyen: " + tinhPhiVanChuyen());
        System.out.println("Tong tien nhap: " + tinhTongTienNhap());
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach sach = new Sach("", "", "", 0, 0.0, 0);
        sach.nhapThongTin(sc);
        sach.hienThiThongTin();
        sc.close();
    }
}