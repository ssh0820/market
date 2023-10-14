package com.zerobase.market.user.domain;

import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.product.domain.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User{

    @Id
    @Comment("사용자ID")
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("사용자명")
    @Column(unique = true)
    private String username;

    @Comment("비밀번호")
    private String password;

    @Comment("이메일")
    @Column(unique = true)
    private String email;

    @Comment("성별")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Comment("휴대폰 번호")
    private String phoneNumber;

    @Comment("생년월일")
    private LocalDate birthDate;

    @Comment("등록일")
    private LocalDateTime registDate;

    @Comment("수정일")
    private LocalDateTime updateDate;

    @Comment("권한")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Basket> basketList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Product> productList = new ArrayList<>();

    public void updateUser(String username, String phoneNumber, String email, Gender gender, LocalDate birthDate, LocalDateTime updateDate){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.updateDate = updateDate;
    }

    public void updatePassword(String username, String password){
        this.username = username;
        this.password = password;
    }
}
