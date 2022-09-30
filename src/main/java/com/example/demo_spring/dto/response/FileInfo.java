package com.example.demo_spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileInfo{

  private String path;
  private String fileName;
  private long contentLength;
}