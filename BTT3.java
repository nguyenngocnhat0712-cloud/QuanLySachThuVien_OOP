import java.util.Scanner; //dùng để khai báo thư viện Scanner để nhập dữ liệu 
import java.time.Year; //dùng để khai báo thư viện Year để lấy năm hiện tại
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private String loaiSach;
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
    //nhập thông tin sách (BT1_tuan3)
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
        //Dùng switch chọn loại sách. Ví dụ 1. Sách giáo khoa 2. Sách tham khảo 3. Sách chuyên ngành 4. Sách khác (BT4_tuan4)
        System.out.println("Chon loai sach: 1. Sach giao khoa  2. Sach tham khao  3. Sach chuyen nganh  4. Sach khac");
        System.out.print("Lua chon: ");
        int luaChon = sc.nextInt();
        sc.nextLine();
        switch (luaChon) {
            case 1:
                this.loaiSach = "Sach giao khoa";
                break;
            case 2:
                this.loaiSach = "Sach tham khao";
                break;
            case 3:
                this.loaiSach = "Sach chuyen nganh";
                break;
            case 4:
                this.loaiSach = "Sach khac";
                break;
            default:
                this.loaiSach = "Loai sach khong hop le";
        }
    }
    //tính thành tiền (BT2_tuan3)
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }
    //tính phí vận chuyển (BT3_tuan3)
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    //tính tổng tiền nhập (BT4_tuan3)
    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    //Phân loại giá: thấp, trung bình, cao, đặc biệt. 
    // Giá < 50.000 → Sách giá thấp, 50.000–100.000 → Sách giá trung bình, 
    // 100.000–200.000 → Sách giá cao,  >200.000 → Sách giá đặc biệt
    public String phanLoaiGia() {
        if (donGia < 50000) {
            return "Sach gia thap";
        } 
        else 
            if (donGia >= 50000 && donGia < 100000) {
                return "Sach gia trung binh";
            } 
            else 
                if (donGia >= 100000 && donGia <= 200000) {
                    return "Sach gia cao";
                } 
                else {
                    return "Sach gia dac biet";
                }
    }
    //Phân loại tồn kho: hết, sắp hết, còn ít, còn nhiều. 
    // Số lượng = 0 → Hết sách, 1–5 → Sắp hết, 6–20 → Còn ít, >20 → Còn nhiều
    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Het sach";
        } 
        else 
            if (soLuong >= 1 && soLuong <= 5) {
                return "Sap het";
            } 
            else 
                if (soLuong >= 6 && soLuong <= 20) {
                    return "Con it";
                } 
                else {
                    return "Con nhieu";
                }
    }
    //Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ
    public boolean thongTinHopLe() {
        int namHienTai = Year.now().getValue();
        boolean giaHopLe = donGia > 0;
        boolean soLuongHopLe = soLuong >= 0;
        boolean namHopLe = namXuatBan >= 1 && namXuatBan <= namHienTai;
        System.out.println("Gia sach hop le: " + (giaHopLe ? "Co" : "Khong"));
        System.out.println("So luong hop le: " + (soLuongHopLe ? "Co" : "Khong"));
        System.out.println("Nam xuat ban hop le (1-" + namHienTai + "): " + (namHopLe ? "Co" : "Khong"));
        return giaHopLe && soLuongHopLe && namHopLe;
    }
    //hiển thị thông tin sách 
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Ten sach: " + this.tenSach);
        System.out.println("Tac gia: " + this.tacGia);
        System.out.println("Nam xuat ban: " + this.namXuatBan);
        System.out.println("Don gia: " + this.donGia);
        System.out.println("So luong: " + this.soLuong);
        System.out.println("Sach hop le: " + (thongTinHopLe() ? "Co" : "Khong"));
        System.out.println("Phan loai gia: " + phanLoaiGia());
        System.out.println("Phan loai ton kho: " + phanLoaiTonKho());
        System.out.println("Loai sach: " + this.loaiSach);
        System.out.println("Thanh tien: " + tinhThanhTien());
        System.out.println("Phi van chuyen: " + tinhPhiVanChuyen());
        System.out.println("Tong tien nhap: " + tinhTongTienNhap());
    }
}
public class BTT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach sach = new Sach("", "", "", 0, 0.0, 0);
        sach.nhapThongTin(sc);
        sach.hienThiThongTin();
        sc.close();
    }
}