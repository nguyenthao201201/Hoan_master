import java.util.List;
import java.util.ArrayList;

public class User {
    private String account;
    private String name;

    private String phoneNumber;

    private String password;

    List<GiaoDich> listGiaoDich = new ArrayList();

    private double soDu;

    private double tongThu;

    private double tongChi;

    public User(String account, String name, String phoneNumber, String password, double soDu, double tongThu, double tongChi) {
        this.account = account;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.soDu = soDu;
        this.tongThu = tongThu;
        this.tongChi = tongChi;
    }

    public User() {

    }

    public String getAccount() {
        return account;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getSoDu() {
        return soDu;
    }

    public double getTongThu() {
        return tongThu;
    }

    public double getTongChi() {
        return tongChi;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public void setTongThu(double tongThu) {
        this.tongThu = tongThu;
    }

    public void setTongChi(double tongChi) {
        this.tongChi = tongChi;
    }


}
