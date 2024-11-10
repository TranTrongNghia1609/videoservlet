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
@Table(name ="Favorites")
public class Favorites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private int FavoriteId;
    @Column(name = "LikedDate", columnDefinition = "date null")
    private Date LikedDate;


    @ManyToOne
    @JoinColumn(name = "VideoId", nullable = false) // Khóa ngoại videoId
    private Videos video;
    // Quan hệ N-1 với bảng Users
    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;
}
