package com.mark.data;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

    @Select("select * from t_admin ")
    public Admin selectAll();

}
