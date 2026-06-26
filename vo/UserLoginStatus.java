package com.peter.smartmedicalserver.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@Builder
public class UserLoginStatus {
    public boolean isLoggedIn;
    public String token;
    public String username;
    public String role;
    public String name;


    public UserLoginStatus(boolean isLoggedIn, String token, String username, String role) {
        this.isLoggedIn = isLoggedIn;
        this.token = token;
        this.username = username;
        this.role = role;
    }
}
