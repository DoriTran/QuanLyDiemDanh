package entity;

public class TaiKhoan {
    private String UserName;
    private String AcPassWord;
    private String AccountType;

    // Constructor
    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String acPassWord, String accountType) {
        UserName = userName;
        AcPassWord = acPassWord;
        AccountType = accountType;
    }

    // Getter & Setter
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAcPassWord() {
        return AcPassWord;
    }
    public void setAcPassWord(String acPassWord) {
        AcPassWord = acPassWord;
    }

    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
}
