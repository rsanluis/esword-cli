package com.codified.esword.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "wog")
public class WoG {
    @EmbeddedId
    private ScriptureId scriptureId;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "short_title")
    private String short_title;

    @NonNull
    @Column(name = "scripture")
    private String scripture;
}
