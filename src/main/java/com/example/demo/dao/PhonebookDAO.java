package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PhonebookVO;

@Repository
public class PhonebookDAO {

	@Autowired
	private DataSource dataSource;

	/**
	 * 작동
	 * 
	 * @param phonebook
	 * @return 성공 : 1 , 실패 0
	 */
	public int insert(PhonebookVO phonebook) {
		String sql = "INSERT INTO phonebook (id, name, hp, memo) VALUES (phonebook_id_seq.NEXTVAL, ?, ?, ?)";

		try {

			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, phonebook.getName());
			pstmt.setString(2, phonebook.getHp());
			pstmt.setString(3, phonebook.getMemo());

			int result = pstmt.executeUpdate(); // 성공 1

			pstmt.close();
			conn.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0; // 실패 0
	}

	/**
	 * 작동
	 * 
	 * @return List
	 */
	public List<PhonebookVO> selectAll() {

		String sql = "SELECT * FROM phonebook";
		List<PhonebookVO> phonebookList = new ArrayList<>();

		try {
			Connection conn = dataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				phonebookList.add(new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("hp"),
						rs.getString("memo")));
			}

			rs.close();
			pstmt.close();
			conn.close();

			return phonebookList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 작동
	 * 
	 * @param _search
	 * @return
	 */
	public List<PhonebookVO> search(String _search) {
		
	    List<PhonebookVO> phonebookList = new ArrayList<>();
	    String sql = "SELECT * FROM phonebook WHERE name LIKE ?";

	    try {
	        Connection conn = dataSource.getConnection(); // Method to get database connection
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        // Add wildcards to the search term for the LIKE query
	        String searchTerm = "%" + _search + "%";

	        pstmt.setString(1, searchTerm); // Set the parameter value

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            PhonebookVO phonebook = new PhonebookVO(
	                rs.getInt("id"), 
	                rs.getString("name"), 
	                rs.getString("hp"),
	                rs.getString("memo")
	            );
	            
	            phonebookList.add(phonebook);
	        }

	        rs.close();
	        pstmt.close();
	        conn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle exceptions appropriately
	    }

	    return phonebookList;
	}

	/**
	 * 작동
	 * 
	 * @param id
	 * @return 성공 : 폰북 , 실패 : null
	 */
	public PhonebookVO selectById(int id) {

		String sql = "SELECT * FROM phonebook WHERE id = ?";
		PhonebookVO phonebook = null;

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				phonebook = new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("hp"),
						rs.getString("memo"));
			}

			rs.close();
			pstmt.close();
			conn.close();

			return phonebook;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
    public int update(PhonebookVO phonebook) {
        String sql = "UPDATE phonebook SET name = ?, hp = ?, memo = ? WHERE id = ?";
        try {
        	Connection conn = dataSource.getConnection();       
            PreparedStatement pstmt = conn.prepareStatement(sql); 

            pstmt.setString(1, phonebook.getName());
            pstmt.setString(2, phonebook.getHp());
            pstmt.setString(3, phonebook.getMemo());
            pstmt.setInt(4, phonebook.getId());

			int result = pstmt.executeUpdate(); // 성공 1

			pstmt.close();
			conn.close();

			return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // 실패 시 0 반환
        }
    }

	/**
	 * 작동
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		
		String sql = "DELETE FROM phonebook WHERE id = ?";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate(); // 성공적으로 삭제된 행 수 반환
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}