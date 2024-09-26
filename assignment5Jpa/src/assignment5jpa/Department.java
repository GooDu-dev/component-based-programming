package assignment5jpa;

import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")
@NamedQueries({
        @NamedQuery(name = "Department.findAll", query = "SELECT d FROM department d"),
        @NamedQuery(name = "Department.findByID", query = "SELECT d FROM department d WHERE d.id = :id"),
})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEPARTMENTID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    return serialVersionUID;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "assignment6jpa.Department[ id=" + id + " ]";
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}