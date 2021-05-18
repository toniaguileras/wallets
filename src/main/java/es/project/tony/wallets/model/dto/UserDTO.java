package es.project.tony.wallets.model.dto;

import java.util.List;

public class UserDTO {

    private Integer id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private List<WalletDTO> wallets;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String name, String surname, String email, List<WalletDTO> wallets) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.wallets = wallets;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<WalletDTO> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletDTO> wallets) {
        this.wallets = wallets;
    }
}
