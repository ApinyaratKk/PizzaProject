package com.example.tester;

public class Users {

    private String username,password,cardno,image;

    public Users(){

    }

    public Users(String username, String password, String cardno, String image) {
        this.username = username;
        this.password = password;
        this.cardno = cardno;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
