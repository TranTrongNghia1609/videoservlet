package iotstar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private int CategoryId;
    @Column(name = "Categoryname", columnDefinition = "nvarchar(100) null")
    private String categoryname;
    @Column(name = "Images", columnDefinition = "nvarchar(500) null")
    private String Imgaes;
    @Column(name = "Status",columnDefinition = "int null")
    private int Status;
    // Quan hệ 1-N với bảng Videos
    @OneToMany(mappedBy = "category")
    private List<Videos> videos;
}
