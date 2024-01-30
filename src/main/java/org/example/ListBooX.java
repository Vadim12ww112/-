package org.example;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
public class ListBooX {
    private List<Staff> data;


    public ListBooX() {
        this.data = new ArrayList<>();
    }
}

