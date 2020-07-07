package com.keepgoing.apm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MainMapper {

	public String getUserInfo();
}
