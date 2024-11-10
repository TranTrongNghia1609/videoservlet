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
@Table(name = "Videos")

public class Videos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "VideoId", columnDefinition = "nvarchar(50) not null")
    private String VideoId;
    @Column(name="Title", columnDefinition = "nvarchar(200) null")
    private String Title;
    @Column(name = "Poster", columnDefinition = "nvarchar(50) null")
    private String Poster;
    @Column(name ="Views", columnDefinition = "int null")
    private String Views;
    @Column(name = "Description", columnDefinition = "nvarchar(500) null")
    private String Description;
    @Column(name = "Active", columnDefinition = "int null")
    private int Active;
    /*@Column(name = "CategoryId", columnDefinition = "int null")
    private int CategoryId;*/
    // Quan hệ N-1 với bảng Category
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    // Quan hệ 1-N với bảng Favorites
    @OneToMany(mappedBy = "video")
    private List<Favorites> favorites;

    // Quan hệ 1-N với bảng Shares
    @OneToMany(mappedBy = "video")
    private List<Shares> shares;
}
