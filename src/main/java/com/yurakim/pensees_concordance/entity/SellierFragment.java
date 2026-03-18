package com.yurakim.pensees_concordance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Edition "Sellier" being the single source of truth for concordance
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SellierFragment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fragNumber;

    // fragment categorization
    private String section; // ex. "A.Le projet de juin 1658"
    private String bundle; // LIASSE ex. "I.[La liasse-table de juin 1658]"
    private String indexWord; // ex. "Abaissement"

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "sellierFragment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EditionReference> refs;

    //* Helper method to maintain bidirectional relationship.
    public void addReference(EditionReference ref) {
        if (this.refs == null) {
            this.refs = new java.util.ArrayList<>();
        }
        this.refs.add(ref);
        ref.setSellierFragment(this);
    }

}
