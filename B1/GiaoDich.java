import java.util.Date;

public class GiaoDich {
    private int maGiaoDich;
    private Date ngayGiaoDich;

    private String loai;

    private String tieuDe;

    private String noiDung;

    private double soTien;

    private String donViLienQuan;

    private String nguoiNhanTien;

    public GiaoDich(int maGiaoDich,Date ngayGiaoDich, String tieuDe, String loai,String noiDung, double soTien, String donViLienQuan, String nguoiNhanTien) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loai = loai;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.soTien = soTien;
        this.donViLienQuan = donViLienQuan;
        this.nguoiNhanTien = nguoiNhanTien;
    }

    public GiaoDich() {

    }


    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getLoai() {
        return loai;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public double getSoTien() {
        return soTien;
    }

    public String getDonViLienQuan() {
        return donViLienQuan;
    }

    public String getNguoiNhanTien() {
        return nguoiNhanTien;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public void setDonViLienQuan(String donViLienQuan) {
        this.donViLienQuan = donViLienQuan;
    }

    public void setNguoiNhanTien(String nguoiNhanTien) {
        this.nguoiNhanTien = nguoiNhanTien;
    }


}
