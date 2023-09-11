package com.example.Asset.Management.System.assetCategory;

import jakarta.persistence.*;

@Entity
@Table(name = "AssetCategory")
public class AssetCategory {
    @Id
    @SequenceGenerator(
            name = "assetCategory_sequence",
            sequenceName = "assetCategory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "assetCategory_sequence"
    )
    private Integer id;
    private String name;
    private String description;

    public AssetCategory(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public AssetCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AssetCategory() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AssetCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
