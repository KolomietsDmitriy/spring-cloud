package ru.ubrr.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@ToString
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class ProcessingEntity implements Processing{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @NonNull String card;
    @NonNull Integer accountId;


}
