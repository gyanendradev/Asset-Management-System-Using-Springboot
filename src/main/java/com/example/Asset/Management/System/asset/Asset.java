package com.example.Asset.Management.System.asset;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Asset {
    @Id
    private String name;
    private LocalDate purchaseDate;
    private String conditionNotes;
    private String category;
    private String assignment;

    public Asset() {
    }
    public Asset(String name, LocalDate purchaseDate, String conditionNotes, String category, String assignment) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.conditionNotes = conditionNotes;
        this.category = category;
        this.assignment = assignment;
    }


    public Asset(LocalDate purchaseDate, String conditionNotes, String category, String assignment) {
        this.purchaseDate = purchaseDate;
        this.conditionNotes = conditionNotes;
        this.category = category;
        this.assignment = assignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getConditionNotes() {
        return conditionNotes;
    }

    public void setConditionNotes(String conditionNotes) {
        this.conditionNotes = conditionNotes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
