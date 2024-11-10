package iotstar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Username", columnDefinition = "nvarchar(50) not null")
    private String Username;
    @Column(name = "Password", columnDefinition = "nvarchar(50) null")
    private String Password;
    @Column(name = "Phone", columnDefinition = "nvarchar(15) null")
    private String Phone;
    @Column(name = "Fullname", columnDefinition = "nvarchar(50) null")
    private String Fullname;
    @Column(name = "Email", columnDefinition = "nvarchar(150) null")
    private String Email;
    @Column(name = "Admin", columnDefinition = "int null")
    private Boolean Admin;
    @Column(name = "Active", columnDefinition = "int null")
    private Boolean Active;
    @Column(name = "Images", columnDefinition = "nvarchar(500)")
    private String Images;

    @OneToMany(mappedBy = "user")
    private List<Favorites> favorites;

    // Quan hệ 1-N với bảng Shares
    @OneToMany(mappedBy = "user")
    private List<Shares> shares;
}
