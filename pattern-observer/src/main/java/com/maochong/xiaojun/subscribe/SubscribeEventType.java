package com.maochong.xiaojun.subscribe;

/**
 * @author jokin
 * @date 2018/6/3 0003 11:48
 * 事件枚举
 */
public enum  SubscribeEventType {
    /**
     * 新增
     * */
    ON_ADD("add"),
    /**
     * 删除
     * */
    ON_REMOVE("remove"),
    /**
     * 编辑
     * */
    ON_EDIT("edit"),
    /**
     * 查询
     * */
    ON_QUERY("query"),
    /**
     * 所有方法都监听
     * */
    ON_ALL("all");

    private String name;

    SubscribeEventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
