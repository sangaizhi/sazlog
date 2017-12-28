package org.sangaizhi.blog.entity.dto;

/**
 * @author: saz
 * @date 2017/12/28 17:20
 */
public class LoginInfoDTO {

    private String account;
    private String password;
    private String redirectUrl;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
