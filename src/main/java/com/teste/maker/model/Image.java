package com.teste.maker.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tbl_image")
@EqualsAndHashCode
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 255)
    @Column(name = "url")
    private String url;

    @Size(max = 100)
    @Column(name = "fileName")
    private String fileName;

    @JoinColumn(name = "id_produto", referencedColumnName = "id", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @JoinColumn(name = "id_produto_sku", referencedColumnName = "id", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSku productSky;

    @Transient
    private MultipartFile file;

}
