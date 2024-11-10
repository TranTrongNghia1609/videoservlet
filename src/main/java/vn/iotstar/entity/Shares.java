package iotstar.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Shares")
public class Shares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId")
    private int ShareId;
    @Column(name = "Emails", columnDefinition = "nvarchar(50) null")
    private String Emails;
    @Column(name = "ShareDate", columnDefinition = "date null")
    private Date ShareDate;

    // Quan hệ N-1 với bảng Users
    @ManyToOne
    @JoinColumn(name = "Username")
    private Users user;

    // Quan hệ N-1 với bảng Videos
    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Videos video;
}
