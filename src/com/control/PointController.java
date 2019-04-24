package com.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.input.PointInput;
import com.point.PointDAO;
import com.point.PointDTO;
import com.view.PointView;

public class PointController {

	// 1. 정보 추가 기능
	// 2. 정보 삭제
	// 3. 정보 번호 조회
	// 4. 정보 전체 조회
	// 5. 종료

	public void start() throws Exception {

		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = new PointDTO();
		PointInput pi = new PointInput();
		PointView pv = new PointView();
		ArrayList<PointDTO> ar = null;
		Scanner sc = new Scanner(System.in);
		int result = 0;

		boolean check = true;

		while (check) {

			System.out.println("1. 정보 추가");
			System.out.println("2. 정보 삭제");
			System.out.println("3. 정보 번호 조회");
			System.out.println("4. 정보 전체 조회");
			System.out.println("5. 종료");
			int select = sc.nextInt();

			switch (select) {

			case 1:

				pointDTO = pi.setPoint();
				int num = pointDAO.getNum();
				pointDTO.setNum(num+1);
				select = pointDAO.insert(pointDTO);
				String message = "추가 실패";
				if (select > 0) {

					message = "추가 성공";

				}

				pv.view(message);
				
				break;

			case 2:

				select = pi.setNum("삭제");
				select = pointDAO.delete(select);
				
				String message2 = "삭제 실패";
				if (select > 0) {

					message2 = "삭제 성공";

				}

				pv.view(message2);
				
				break;

			case 3:

				select = pi.setNum("조회");
				pointDTO = pointDAO.selectOne(select);
				
				if(pointDTO != null) {
					
					pv.view(pointDTO);
					
				} else {
					
					pv.view("없는 번호");
				}
				
				break;

			case 4:
				
				ar = pointDAO.selectList();
				pv.view(ar);
				break;

			default:
				System.out.println("종료합니다");
				check = !check;

			}

		}

	}

}
