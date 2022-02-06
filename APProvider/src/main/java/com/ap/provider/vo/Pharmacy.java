package com.ap.provider.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pharmacy {
	
	//오픈API명세서 참고
	private String SIGUN_NM; 		//시군명
	private String BIZPLC_NM; 		//사업장명
	private String BSN_STATE_NM;	//영업상태명
	private String ROADNM_ZIP_CD;	//도로명우편번호
	private String REFINE_ROADNM_ADDR;//소재지도로명주소
	private String X_CRDNT_VL; 		//X좌표
	private String Y_CRDNT_VL;		//Y좌표
}
