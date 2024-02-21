import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class QuanLyGD {

        List<User> userList;
        List<GiaoDich> giaoDichList;

        private User currentUser;

        public QuanLyGD(){
            userList = new ArrayList<>();
            giaoDichList = new ArrayList<>();
        }
        public void registerUser(String phoneNumber, String name, String password, String role) {
            if (isUserExist(phoneNumber)) {
                System.out.println("Số điện thoại đã tồn tại, hãy thử lại với số điện thoại khác!");
            } else {
                User newUser = new User();

                newUser.setPhoneNumber(phoneNumber);
                newUser.setAccount(phoneNumber);
                newUser.setPassword(password);
                newUser.setName(name);
                newUser.setRole(role);
                userList.add(newUser);

                System.out.println("Đăng kí thành công!"+newUser.getAccount());
            }
        }

        public boolean isUserExist(String phoneNumber) {
            for (User user : userList) {
                if (user.getPhoneNumber().equals(phoneNumber)) {
                    return true;
                }
            }

            return false;
        }

    public boolean login(String phoneNumber, String password) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                currentUser = user; // Set the current user
             //  System.out.println("Đăng nhập thành công!");
                return true;

            }
        }

        return false; // Login failed
    }

    public void hienThiUser(){
            System.out.println("Danh sách user: ");
            if(userList.isEmpty()){
                System.out.println("Không có user nào!");
            }
            else {
                for (User user : userList) {

                    System.out.println("Số điện thoại: " + user.getPhoneNumber());
                    System.out.println("Tên: " + user.getName());
                    System.out.println(" Quyền: " + user.getRole());
                    System.out.println("Số dư: " + user.getSoDu());
                    System.out.println("Tổng thu: " + user.getTongThu());
                    System.out.println("Tổng chi: " + user.getTongChi());
                    System.out.println("--------------------");
                }
            }
    }

        public void thuTien(String title, String content, String loai, double amount, Date date, String relatedUnit) {
            if(currentUser != null){
                GiaoDich giaoDich = new GiaoDich();
                giaoDich.setLoai(loai);
                giaoDich.setTieuDe(title);
                giaoDich.setNoiDung(content);
                giaoDich.setSoTien(amount);
                giaoDich.setNgayGiaoDich(date);
                giaoDich.setDonViLienQuan(relatedUnit);
                giaoDich.setNguoiNhanTien(currentUser.getName());
                giaoDich.setUserId(currentUser.getAccount());
                giaoDichList.add(giaoDich);


                currentUser.setSoDu(currentUser.getSoDu() + amount);

                System.out.println("Giao dịch thành công!");
            }
            else {
                System.out.println("Vui lòng đăng nhập trước khi thực hiện giao dịch!");
            }
        }

        public void chiTien(String title, String content, String type, double amount, Date date, String relatedUnit, String receiver) {
            if(currentUser != null){
                if (amount > 0 && amount <= currentUser.getSoDu()) {
                    GiaoDich giaoDich = new GiaoDich();
                    giaoDich.setLoai(type);
                    giaoDich.setTieuDe(title);
                    giaoDich.setNoiDung(content);
                    giaoDich.setSoTien(amount);
                    giaoDich.setNgayGiaoDich(date);
                    giaoDich.setDonViLienQuan(relatedUnit);
                    giaoDich.setNguoiNhanTien(receiver);
                    giaoDich.setUserId(currentUser.getAccount());
                    giaoDichList.add(giaoDich);

                    currentUser.setSoDu(currentUser.getSoDu() - amount);
                    currentUser.setTongChi(currentUser.getTongChi() + amount);
                    System.out.println("Giao dịch thành công!");
                }
                else {
                    System.out.println("Hiện tại ngân quỹ chỉ còn" + currentUser.getSoDu() +" không đủ để chi");
                }
            }
            else {
                System.out.println("Vui lòng đăng nhập trước khi thực hiện giao dịch!");
            }
        }

        public void hienThiGiaoDich(
        ){
            System.out.println("Danh sách giao dịch: ");
            if(giaoDichList.isEmpty()){
                System.out.println("Không có giao dịch nào!");
            }
            else {
                if(currentUser.getRole().equals("ADMIN"))
                {
                    for (GiaoDich giaoDich : giaoDichList) {
                        System.out.println("Mã giao dịch: " + giaoDich.getMaGiaoDich());
                        System.out.println("Tiêu đề: " + giaoDich.getTieuDe());
                        System.out.println("Nội dung: " + giaoDich.getNoiDung());
                        System.out.println("Số tiền: " + giaoDich.getSoTien());
                        System.out.println("Ngày giao dịch: " + giaoDich.getNgayGiaoDich());
                        System.out.println("Đơn vị liên quan: " + giaoDich.getDonViLienQuan());
                        System.out.println("Người nhận tiền: " + giaoDich.getNguoiNhanTien());
                        System.out.println("--------------------");
                    }
                }
                else if(currentUser.getRole().equals("USER"))
                {
                    for (GiaoDich giaoDich : giaoDichList) {
                        if(giaoDich.getUserId().equals(currentUser.getAccount()))
                        {
                            System.out.println("Mã giao dịch: " + giaoDich.getMaGiaoDich());
                            System.out.println("Tiêu đề: " + giaoDich.getTieuDe());
                            System.out.println("Nội dung: " + giaoDich.getNoiDung());
                            System.out.println("Số tiền: " + giaoDich.getSoTien());
                            System.out.println("Ngày giao dịch: " + giaoDich.getNgayGiaoDich());
                            System.out.println("Đơn vị liên quan: " + giaoDich.getDonViLienQuan());
                            System.out.println("Người nhận tiền: " + giaoDich.getNguoiNhanTien());
                            System.out.println("--------------------");
                        }
//                        else {
//                            System.out.println("User không có giao dịch nào!");
//                        }
                    }
                }
            }
        }
        public void xoaGiaoDich(int transactionId) {
            for (GiaoDich giaoDich : giaoDichList) {
                if (giaoDich.getMaGiaoDich() == transactionId) {
                    if (giaoDich.getLoai().equals("Thu")) {
                        currentUser.setSoDu(currentUser.getSoDu() - giaoDich.getSoTien());
                        currentUser.setTongThu(currentUser.getTongThu() - giaoDich.getSoTien());
                    } else {
                        currentUser.setSoDu(currentUser.getSoDu() + giaoDich.getSoTien());
                        currentUser.setTongChi(currentUser.getTongChi() - giaoDich.getSoTien());
                    }
                    giaoDichList.remove(giaoDich);

                    System.out.println("Xóa giao dịch thành công!");
                    return;
                }
                System.out.println("Không tìm thấy giao dịch cần xóa!");
                }

            }
        public void timkiemGiaoDich(String keyword) {
            for (GiaoDich giaoDich : giaoDichList) {
                if (giaoDich.getTieuDe().contains(keyword) ||  String.valueOf(giaoDich.getSoTien()).contains(keyword)) {
                    System.out.println("Mã giao dịch: " + giaoDich.getMaGiaoDich());
                    System.out.println("Tiêu đề: " + giaoDich.getTieuDe());
                    System.out.println("Nội dung: " + giaoDich.getNoiDung());
                    System.out.println("Số tiền: " + giaoDich.getSoTien());
                    System.out.println("Ngày giao dịch: " + giaoDich.getNgayGiaoDich());
                    System.out.println("Đơn vị liên quan: " + giaoDich.getDonViLienQuan());
                    System.out.println("Người nhận tiền: " + giaoDich.getNguoiNhanTien());
                    System.out.println("--------------------");
                }
            }
        }
}
