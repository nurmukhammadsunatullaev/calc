package uz.undp.calc.entities.content;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String typeName;
    private Double percent;

    @ManyToOne
    @JoinColumn(name="constant_id")
    private ConstantEntity constantEntity;
}