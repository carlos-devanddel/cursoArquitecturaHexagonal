package com.babel.bootcampBack.port.in.users.update.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UpdateUserOutput {
	private boolean result;
}
