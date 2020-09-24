package com.stone.sbmc.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName: Test
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2020/09/24 09:45
 * @Version: 1.0
 * @Modified By:
 */
@Entity
@Table(name = "test")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "flag")
    private Integer flag;
}
