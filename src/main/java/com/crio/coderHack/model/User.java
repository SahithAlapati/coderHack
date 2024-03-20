package com.crio.coderHack.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@NoArgsConstructor
@Data
@Document(collection="users")
public class User {

    @NonNull
    private String id;
    @NonNull
    private String userName;
    @Min(value = 0,message = "Score must be equal or greater than zero")
    @Max(value=100,message="Score must be equal or lesser than hundred ")
    private Integer score;
    private List<String> badges;

    
}
