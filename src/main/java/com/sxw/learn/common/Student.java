package com.sxw.learn.common;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@RequiredArgsConstructor(staticName = "of")
public class Student {
    @NonNull
    private String name;
    private Integer age;
    private String address;
}
