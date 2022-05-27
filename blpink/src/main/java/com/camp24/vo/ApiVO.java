package com.camp24.vo;
/**
 * 캠핑장정보 api 에 필요한 VO 클래스
 * @author	정선우
 * @since	2022.05.26			
 *
 *			addr1			주소
 *			lctCl			입지구분
 *			eqpmnLendCl		캠핑장비대여
 *			firstImageUrl	대표이미지
 *			tel				전화번호
 *			mapX			경도
 *			mapY			위도
 *			animalCmgCl		애완동물출입
 *			homepage		홈페이지
 *			induty			업종
 *			facltNm			야영장명
 */
public class ApiVO {
	private String addr1, lctCl, eqpmnLendCl, firstImageUrl, tel, mapX, mapY, animalCmgCl, homepage, induty, facltNm;

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getLctCl() {
		return lctCl;
	}

	public void setLctCl(String lctCl) {
		this.lctCl = lctCl;
	}

	public String getEqpmnLendCl() {
		return eqpmnLendCl;
	}

	public void setEqpmnLendCl(String eqpmnLendCl) {
		this.eqpmnLendCl = eqpmnLendCl;
	}

	public String getFirstImageUrl() {
		return firstImageUrl;
	}

	public void setFirstImageUrl(String firstImageUrl) {
		this.firstImageUrl = firstImageUrl;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMapX() {
		return mapX;
	}

	public void setMapX(String mapX) {
		this.mapX = mapX;
	}

	public String getMapY() {
		return mapY;
	}

	public void setMapY(String mapY) {
		this.mapY = mapY;
	}

	public String getAnimalCmgCl() {
		return animalCmgCl;
	}

	public void setAnimalCmgCl(String animalCmgCl) {
		this.animalCmgCl = animalCmgCl;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getInduty() {
		return induty;
	}

	public void setInduty(String induty) {
		this.induty = induty;
	}

	public String getFacltNm() {
		return facltNm;
	}

	public void setFacltNm(String facltNm) {
		this.facltNm = facltNm;
	}
	
}
