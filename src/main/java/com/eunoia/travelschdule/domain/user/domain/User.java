package com.eunoia.travelschdule.domain.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Table(name = "\"user\"")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 20)
    @Column(name = "nickname")
    private String nickname;

    @Size(max = 20)
    @Column(name = "country")
    private String country;

    @Column(name = "profile_img")
    private String profileImg;

    @Size(max = 1)
    @Column(name = "gender")
    private String gender;

    @Column(name = "id_deleted")
    private boolean isDeleted;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "crate_date")
    @CreatedDate
    private LocalDate createDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private LocalDate updateDate;

    @Builder
    public User(UUID id, String email, String nickname, String country, String profileImg, String gender,
                boolean isDeleted, LocalDate birthDate, LocalDate createDate, LocalDate updateDate) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.country = country;
        this.profileImg = profileImg;
        this.gender = gender;
        this.isDeleted = isDeleted;
        this.birthDate = birthDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
