package com.helloworld.examples.persistence.h2.mappers.cruds;

import com.helloworld.examples.persistence.h2.models.UserEntity;import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsuarioMapper {

	@Select("SELECT * FROM USUARIO WHERE UID = #{id}")
	UserEntity getUserById(String id);

}
