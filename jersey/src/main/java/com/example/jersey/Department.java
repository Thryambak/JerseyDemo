package com.example.jersey;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department	{
private String departmentName;
private int departmentId;
}
