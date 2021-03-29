package uz.undp.calc.entities.content;



import javax.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public ConstantEntity getConstantEntity() {
        return constantEntity;
    }

    public void setConstantEntity(ConstantEntity constantEntity) {
        this.constantEntity = constantEntity;
    }
}
