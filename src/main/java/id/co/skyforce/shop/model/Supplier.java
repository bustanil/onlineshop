package id.co.skyforce.shop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "supplier_category", 
        joinColumns = { 
            @JoinColumn(name = "supplier_id", referencedColumnName = "id") 
        }, 
        inverseJoinColumns = { 
            @JoinColumn(name = "category_id", referencedColumnName = "id") 
        }
    )
    private Set<Category> categories = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Supplier [id=" + id + ", name=" + name + ", categories="
                + categories + "]";
    }

    public Product getCategory() {
        // TODO Auto-generated method stub
        return null;
    }
    
}