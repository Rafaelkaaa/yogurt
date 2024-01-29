package com.yogurt.entity.user;

import com.yogurt.entity.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
