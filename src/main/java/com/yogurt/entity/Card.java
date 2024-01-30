package com.yogurt.entity;

import com.yogurt.entity.product.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity{
    private BigDecimal cost;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "card_product",
            joinColumns = @JoinColumn(name = "card_id"))
    private Set<Product> products;
}
