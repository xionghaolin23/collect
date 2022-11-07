package com.xionghl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user1")
public class User {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
