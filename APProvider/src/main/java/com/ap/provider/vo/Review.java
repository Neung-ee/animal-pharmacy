package com.ap.provider.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {
	private String mb_id;			//사용자ID
	private String SIGUN_NM; 		//시군명
	private String BIZPLC_NM; 		//사업장명
	private int rv_score;			//사용자 평점
	private String rv_comment;		//사용자 댓글(코멘트)
}
