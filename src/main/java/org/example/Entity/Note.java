package org.example.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}