package com.babel.bootcampBack.persistence.mappers.usecase;

import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Update;@Mapper
public interface UpdateUserMapper {


	@Update(" UPDATE USER SET PHONE=#{newPhone}, MAIL = #{newMail} WHERE ID = #{id}")
	void updateUserData(Long id, String newPhone, String newMail);
}
