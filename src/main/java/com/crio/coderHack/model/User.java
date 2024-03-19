package com.crio.coderHack.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@Document(collection="users")
public class User {

    @NonNull
    private String id;
    @NonNull
    private String userName;
    private Integer score;
    private List<String> badges;

    
}
