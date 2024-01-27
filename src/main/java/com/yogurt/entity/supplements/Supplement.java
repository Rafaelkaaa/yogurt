package com.yogurt.entity.supplements;


import com.yogurt.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
