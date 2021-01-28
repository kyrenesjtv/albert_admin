package github.kyrenesjtv.albertadmin.entity.po;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/22 17:13
 */
public class UserPO {
    private Long id;
    private String loginName;
    private String password;
//    private int isAdmin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getIsAdmin() {
//        return isAdmin;
//    }
//
//    public void setIsAdmin(int isAdmin) {
//        this.isAdmin = isAdmin;
//    }
}
