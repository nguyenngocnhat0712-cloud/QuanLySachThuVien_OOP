package BTT8;

import java.time.Year;

public class Sach {
    // Yeu cau 1(BTT8): Tat ca thuoc tinh duoc khai bao private.
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Yeu cau 4(BTT8): Constructor day du, khoi tao tat ca thuoc tinh.
    // Su dung setter de dam bao du lieu hop le ngay khi tao doi tuong.
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        setMaSach(maSach);
        setTieuDe(tieuDe);
        setTacGia(tacGia);
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yeu cau 2(BTT8): Getter va setter public cho maSach.
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    // Yeu cau 2(BTT8): Getter va setter public cho tieuDe.
    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    // Yeu cau 2(BTT8): Getter va setter public cho tacGia.
    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    // Yeu cau 2 va 3(BTT8): Getter; setter chi chap nhan nam tu 1 den nam hien tai.
    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan <= 0 || namXuatBan > currentYear) {
            throw new IllegalArgumentException(
                    "Nam xuat ban phai nam trong khoang tu 1 den " + currentYear + ".");
        }
        this.namXuatBan = namXuatBan;
    }

    // Yeu cau 2 va 3(BTT8): Getter; setter chi chap nhan so luong khong am.
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong < 0) {
            throw new IllegalArgumentException("So luong khong duoc am.");
        }
        this.soLuong = soLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }
}
