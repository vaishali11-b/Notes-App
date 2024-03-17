package org.example.Entity;

import lombok.*;

import javax.persistence.Entity;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    private String name;
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