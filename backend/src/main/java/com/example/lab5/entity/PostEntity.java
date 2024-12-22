package com.example.lab5.entity;

import org.springframework.data.annotation.Id;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostEntity {
    @Id private String id;
    @NonNull private String header;
    @NonNull private String content;
    @NonNull private String moderatorName;
}
