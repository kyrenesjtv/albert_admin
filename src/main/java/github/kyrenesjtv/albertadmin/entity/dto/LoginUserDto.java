package github.kyrenesjtv.albertadmin.entity.dto;

import javax.validation.constraints.NotBlank;

/**
 * @ProjectName: albertadmin
 * @Author: AlbertW
 * @CreateDate: 2021/1/28 10:24
 */
public class LoginUserDto {

    @NotBlank(message="登录名不能为空")
    private String loginname;
    @NotBlank(message="密码不能为空")
    private String password;
    private Long deptId;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
