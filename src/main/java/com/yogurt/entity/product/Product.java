package com.yogurt.entity.product;

import com.yogurt.entity.BaseEntity;
import com.yogurt.entity.supplements.Supplement;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private BigDecimal cost;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_supplement",
            joinColumns = @JoinColumn(name = "product_id"))
    private List<Supplement> supplements;
}
