import java.util.Scanner; //dùng để khai báo thư viện Scanner để nhập dữ liệu 
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
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
        sc.nextLine(); // xóa bộ nhớ đệm
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