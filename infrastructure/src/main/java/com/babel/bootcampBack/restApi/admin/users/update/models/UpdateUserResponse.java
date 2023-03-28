package com.babel.bootcampBack.restApi.admin.users.update.models;

import com.babel.bootcampBack.port.in.users.update.models.UpdateUserOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateUserResponse {


	private boolean resultado;

	public static UpdateUserResponse fromApplicationModel(UpdateUserOutput applicationModel){
		return UpdateUserResponse. builder().resultado(applicationModel.isResult()).build();
	}

}
