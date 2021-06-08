package com.cloud.api.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Department implements Serializable {
    private Long id;

    private String name;

    // db source, 一个服务对应一个数据库
    private String dbSource;

    private LocalDateTime createTime;

    /**
     * 链式写法
     * Dept dept = new Dept();
     * dept.setName("name").setDbSource("source");
     */

}

