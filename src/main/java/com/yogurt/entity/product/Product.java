package com.yogurt.entity.product;

import com.yogurt.entity.BaseEntity;
import com.yogurt.entity.supplements.Supplement;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @ManyToOne
    private ProductType productType;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_supplement",
            joinColumns = @JoinColumn(name = "product_id"))
    private Set<Supplement> supplements;
}
