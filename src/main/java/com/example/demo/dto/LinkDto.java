package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class LinkDto {

    @NotEmpty
    private String link;

    public LinkDto() {
    }

    public LinkDto(@NotEmpty String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
