package com.codified.esword.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Context")
public class Context {
    @Id
    @NonNull
    @Column(name = "id")
    private Integer id;    
    
    @NonNull
    @Column(name = "context")
    private String context; 

    @NonNull
    @Column(name = "context_desc")
    private String contextDesc; 

    @NonNull
    @Column(name = "start_id")
    private Integer startId;
    
    @NonNull
    @Column(name = "end_id")
    private Integer endId;
}
