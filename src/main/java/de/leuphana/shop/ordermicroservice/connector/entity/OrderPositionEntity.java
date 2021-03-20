package de.leuphana.shop.ordermicroservice.connector.entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Embeddable
public class OrderPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer articleId;
    Integer quantity;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

