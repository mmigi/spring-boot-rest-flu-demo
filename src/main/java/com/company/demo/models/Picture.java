package com.company.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String description;

    @Lob
    @Column(name = "picture_file", length = 1000000)
    private byte[] pictureFile;

    public Picture() {
    }


    public Picture(String name, byte[] pictureFile) {
        this.description = name;
        this.pictureFile = pictureFile;
    }


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(byte[] pictureFile) {
        this.pictureFile = pictureFile;
    }
}
