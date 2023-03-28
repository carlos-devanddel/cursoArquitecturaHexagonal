package com.babel.bootcampBack.persistence.mappers.cruds;

import com.babel.bootcampBack.persistence.models.UserEntity;import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsuarioMapper {

	@Select("SELECT * FROM USUARIO WHERE UID = #{id}")
	UserEntity getUserById(String id);

}
