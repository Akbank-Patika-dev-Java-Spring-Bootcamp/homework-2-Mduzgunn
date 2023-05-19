package com.md.hw2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.md.hw2.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    private String message;

    @ManyToOne
    @JsonIgnoreProperties(value = { "comments" })
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnoreProperties(value = { "comments" })
    private User user;

}
