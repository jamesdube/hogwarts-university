package com.jamesdube.hogwarts.subjectservice.api.response;

import lombok.Data;

@Data
public class SubjectResponse extends Response {

    private String code;

    private String name;
}