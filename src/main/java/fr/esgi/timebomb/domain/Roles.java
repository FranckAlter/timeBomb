package fr.esgi.timebomb.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class Roles {

    @Id
    @GeneratedValue
    private Long player_id;
    private String roles;
}
