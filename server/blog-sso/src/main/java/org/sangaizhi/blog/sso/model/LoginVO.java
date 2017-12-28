package org.sangaizhi.blog.sso.model;

/**
 * @author sangaizhi
 * @date 2017/8/26
 */
public class LoginVO {
    private String account;
    private String password;
    private Short remmber;
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

    public Short getRemmber() {
        return remmber;
    }

    public void setRemmber(Short remmber) {
        this.remmber = remmber;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
