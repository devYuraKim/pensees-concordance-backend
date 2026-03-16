package com.yurakim.pensees_concordance.entity;

import jakarta.persistence.*;
import lombok.*;

//Edition "Brunschvicg", "Lafuma", "Le Guern"
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {
                        "edition",
                        "refNumber",
                        "refSuffix",
                        "sellier_fragment_id"
                }
        )
)
public class EditionReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Edition edition; // "BRU", "LAF", "LEG"
    private Integer refNumber;
    private String refSuffix; // "bis", "ter", null
    private String refRaw; // only populated for exceptions "828-829", "194 bis, ter", null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellier_fragment_id")
    private SellierFragment sellierFragment;

}
