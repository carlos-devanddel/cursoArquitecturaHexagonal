package com.babel.bootcampBack.restApi.admin.users.update.models;

import com.babel.bootcampBack.port.in.users.update.models.UpdateUserInput;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserRequest {

	private String idUsuarioSolicitante;
	private String idUserToChange;

	private DatosContacto datosContacto;


	public UpdateUserInput toApplicationModel() {
		return UpdateUserInput.builder().uidUserRequestor(idUsuarioSolicitante).uidUserToChange(idUserToChange).newEmail(datosContacto.newMail).newPhone(datosContacto.newPhone).build();

	}

	private class DatosContacto {
		private String newPhone;
		private String newMail;

	}
}
