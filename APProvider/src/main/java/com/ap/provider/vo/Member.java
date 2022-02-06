package com.ap.provider.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String mb_id;
	private String mb_pw;
	private String mb_name;
	private String mb_mail;
}
