package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import com.point.PointDAO;
import com.point.PointDTO;

public class DBConnectorTest {

	//@Test
	public void selectListTest() throws Exception {

		PointDAO pointDAO = new PointDAO();
		ArrayList<PointDTO> ar = pointDAO.selectList();
		assertEquals(0, ar.size());

	}

	// @Test
	public void selectOneTest() throws Exception {

		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = pointDAO.selectOne(1);
		assertNotNull(pointDTO);

	}

	// @Test
	public void deleteTest() throws Exception {

		PointDAO pointDAO = new PointDAO();
		int result = pointDAO.delete(1);
		assertEquals(1, result);
	}

	@Test
	public void test() throws Exception {

		PointDAO pointDAO = new PointDAO();
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {

			PointDTO pointDTO = new PointDTO();
			int num = pointDAO.getNum();
			pointDTO.setNum(num + 1);
			pointDTO.setSid("iu" + i);
			pointDTO.setKor(random.nextInt(101));
			pointDTO.setEng(random.nextInt(101));

			int result = pointDAO.insert(pointDTO);
		}
		
		//assertEquals(1, result);

	}

}
