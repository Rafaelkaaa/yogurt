package com.yogurt.entity.supplements;


import com.yogurt.entity.BaseEntity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Supplement extends BaseEntity {
    private String name;

    private Integer weight;

    @Column(length = 2000)
    private String image;

    @Enumerated(EnumType.STRING)
    private SupplementType type;
}
