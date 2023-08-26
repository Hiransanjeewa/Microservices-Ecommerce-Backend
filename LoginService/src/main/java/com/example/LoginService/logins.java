package com.example.LoginService;


import jakarta.persistence.*;

@Entity
@Table(name = "logins")
public class logins {

    public void setId(int id) {
        this.id = id;
    }

    public logins() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getSession_token() {
        return session_token;
    }

    public void setSession_token(String session_token) {
        this.session_token = session_token;
    }

    @Column(name = "session_token",length = 5)
    private String session_token;





}
