import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        QuanLyGD quanLyGD = new QuanLyGD();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Chọn dịch vụ:");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Chi tiền");
            System.out.println("4. Thu tiền");
            System.out.println("5. Xem lịch sử giao dịch");
            System.out.println("6. Hiển thị User");
            System.out.println("7. Xóa giao dịch");
            System.out.println("8. TÌm kiếm giao dịch");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register(quanLyGD, scanner);
                    break;
                case 2:
                    login(quanLyGD, scanner);
                    break;
                case 3:
                    chiTien(quanLyGD, scanner);
                    break;
                case 4:
                    thuTien(quanLyGD, scanner);
                    break;
                    case 5:
                    quanLyGD.hienThiGiaoDich();
                case 6:
                    quanLyGD.hienThiUser();
                    break;
                case 7:
                    xoaGiaoDich(quanLyGD, scanner);
                    break;
                    case 8:
                    timkiemGiaoDich(quanLyGD, scanner);
                default:
                    System.out.println("Chức năng không tồn tại!");
            }
        }
    }
    public static void register(QuanLyGD quanLyGD, Scanner scanner) {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        System.out.println("Nhập role:");
        String role = scanner.nextLine();
        quanLyGD.registerUser(phoneNumber, name, password, role);
    }

    public static void login (QuanLyGD quanLyGD, Scanner scanner) {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        if(quanLyGD.login(phoneNumber, password)){
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Đăng nhập thất bại!");
        };
    }

    public static void chiTien(QuanLyGD quanLyGD, Scanner scanner) {
        System.out.println("Nhập loại giao dịch:");
        String loai = scanner.nextLine();
        System.out.println("Nhập tiêu đề: ");
        String tieuDe = scanner.nextLine();
        System.out.println("Nhập nội dung: ");
        String noiDung = scanner.nextLine();
        System.out.println("Nhập số tiền: ");
        double soTien = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập ngày giao dịch: ");
        String ngayGiaoDichStr = scanner.nextLine();
        System.out.println("Nhập đơn vị liên quan: ");
        String donViLienQuan = scanner.nextLine();
        System.out.println("Nhập người nhận tiền: ");
        String nguoiNhanTien = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayGiaoDich;
        try {
            ngayGiaoDich = dateFormat.parse(ngayGiaoDichStr);
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Sử dụng định dạng dd/MM/yyyy.");
            return;
        }
        quanLyGD.chiTien(tieuDe, noiDung, loai, soTien, ngayGiaoDich, donViLienQuan, nguoiNhanTien);
    }

    public static void thuTien(QuanLyGD quanLyGD, Scanner scanner) {
        System.out.println("Nhập loại giao dịch:");
        String loai = scanner.nextLine();
        System.out.println("Nhập tiêu đề: ");
        String tieuDe = scanner.nextLine();
        System.out.println("Nhập nội dung: ");
        String noiDung = scanner.nextLine();
        System.out.println("Nhập số tiền: ");
        double soTien = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập ngày giao dịch: ");
        String ngayGiaoDichStr = scanner.nextLine();
        System.out.println("Nhập đơn vị liên quan: ");
        String donViLienQuan = scanner.nextLine();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayGiaoDich;
        try {
            ngayGiaoDich = dateFormat.parse(ngayGiaoDichStr);
        } catch (ParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Sử dụng định dạng dd/MM/yyyy.");
            return;
        }
        quanLyGD.thuTien(tieuDe, noiDung, loai, soTien, ngayGiaoDich, donViLienQuan);
    }

    public static void xoaGiaoDich(QuanLyGD quanLyGD, Scanner scanner){
        System.out.println("Nhập mã giao dịch cần xóa: ");
        int maGiaoDich = scanner.nextInt();
        quanLyGD.xoaGiaoDich(maGiaoDich);
    }

    public static void timkiemGiaoDich(QuanLyGD quanLyGD, Scanner scanner){
        System.out.println("Nhập từ khóa cần tìm kiếm: ");
        String keyword = scanner.nextLine();
        quanLyGD.timkiemGiaoDich(keyword);
    }
}