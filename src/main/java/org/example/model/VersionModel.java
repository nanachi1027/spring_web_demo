package org.example.model;

import lombok.Data;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:21 上午
 */
@Data
public class VersionModel {
    private String version = null;
    private Integer major = null;
    private Integer minotr = null;
    private Integer patch = null;
}
