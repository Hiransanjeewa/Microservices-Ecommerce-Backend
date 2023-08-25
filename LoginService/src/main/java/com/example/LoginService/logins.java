package com.example.LoginService;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logins")
public class logins {

    public void setId(int id) {
        this.id = id;
    }

    public logins() {
    }

    @Id
    @Column(name = "login_id",length = 5)
    private int id;

    @Column(name = "user_id",length = 5)
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSession_token() {
        return session_token;
    }

    public void setSession_token(int session_token) {
        this.session_token = session_token;
    }

    @Column(name = "session_token",length = 5)
    private int session_token;





}
