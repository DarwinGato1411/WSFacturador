package com.ec.deckxel.payphon.pay;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.ec.deckxel.util.json.Status;

public class PayPhone {
	public Status gestionarPago(String urlpayphone, RequestPayPhone datos) {

		Status status = new Status();
		String respuesta = "";
//		String URL = "https://pay.payphonetodoesposible.com/api/Links";
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
//        [{"key":"Authorization","value":"Bearer QGTKs_RZtu5TKSJbMaqWHEFE1_dWC0MmfrcCUS5ZofLe2eS1zDzFTdfOKwC2cxgZYtom0oQ21hF-hOIv1oz6z-tuezGEEz2HJuPwd15xHZb5Wg-ufAOwza__Iz0Nmzh-l8IGXFkXwmrD4AVW1Z3O0YU7TUf6bZIJcGYVYzjU-VOyX_sxi-EqRQOpU_1pUtU9eFQSK9b_X7Y4Rva7BmIQTo2QIfBcDV7ytoOCkUwJZnoyWqJZ959-SEvEI9gK8MwiJ3FXG_ZuogOiW52ELtTWkIqFgtvwzx-el-sFfkqruCzfzlX9w3oHLHSB5iGo9ybam3rvjQ\n","description":""}]
		headers.set("Authorization",
				"Bearer eI_zqrq44FsmZGUHWxn_NUDB591LWvZ3r7z3V6VjxQ1-b0w2F387PJ0ubNll7qwtBBB-iH_hqcQLR-x4vnd3EOzgW-DbXuu-wfXxmRB-agEFXrrQkMJiYpnQeCyrfXy6pq_G-I2blizJNWvCgpuvciB5629LUEl3Ocbx1npgbLztzG4PsyIh6a0NSRoI7x7tG0CLiPvXdlgMBM8CEiwo2Ey5ZDpkKA7xViD1P5BQrL8xeB0h6AVp4fNFVoEDu5td9yy-OGAVEwLpnoZVX0-hbVPLaq84kGa9vOn2k_HsW6ygNpb4Sdq_H3pIwGnZRM4Da-Pjlw");

		RestTemplate restTemplate = new RestTemplate();

		try {
			// Data attached to the request.
			HttpEntity<RequestPayPhone> requestBody = new HttpEntity<>(datos, headers);

			// Send request with POST method.
			respuesta = restTemplate.postForObject(urlpayphone, requestBody, String.class);
			if (respuesta != null) {

				System.out.println("Employee created: " + respuesta);
			} else {
				System.out.println("Something error!");
			}

			status.setCodigo(HttpStatus.OK.toString());
			status.setDescripcion(respuesta.replace("\"", ""));
			status.setEntidad(PayPhone.class.getName());
			status.setStatus(HttpStatus.OK.toString());

		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println("ERROR WS " + e2.getMessage());
			/* ERROR DE PAGO */

			status.setCodigo(HttpStatus.BAD_REQUEST.toString());
			status.setDescripcion("ERROR EN LA COMUNICACION CON PAYPHONE");
			status.setEntidad(PayPhone.class.getName());
			status.setStatus(HttpStatus.BAD_REQUEST.toString());
		}

		return status;
	}

	
}
