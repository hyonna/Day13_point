package com.view;

import java.util.ArrayList;

import com.point.PointDTO;

public class PointView {

	public void view(String message) {

		System.out.println(message);

	}
	
	public void view(PointDTO pointDTO) {
		
		
		System.out.println("학생번호 : " + pointDTO.getNum());
		System.out.println("학생이름 : " + pointDTO.getSid());
		System.out.println("국어점수 : " + pointDTO.getKor());
		System.out.println("영어점수 : " + pointDTO.getEng());
		System.out.println("수학점수 : " + pointDTO.getMath());
		System.out.println("총점점수 : " + pointDTO.getTotal());
		System.out.println("평균점수 : " + pointDTO.getAvg());
		System.out.println("반번호 : " + pointDTO.getBnum());
		
		
		
	}
	
	
	public void view(ArrayList<PointDTO> ar) {
		
		for(PointDTO pointDTO : ar) {
			this.view(pointDTO);
		}
		
		
	}

}
