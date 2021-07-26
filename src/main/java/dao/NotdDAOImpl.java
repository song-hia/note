package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import vo.NoteVO;

@Repository
public class NotdDAOImpl implements NoteDAO{

	@Autowired
	DriverManagerDataSource ds;
	
	@Override
	public int insert(String memo) {
		String sql="insert into note values(note_id_seq.nextval,?,sysdate)";
		try {
		PreparedStatement pstmt=ds.getConnection().prepareStatement(sql);
		pstmt.setString(1,memo);
		int rs=pstmt.executeUpdate();
		return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<NoteVO> getList() {
		String sql="select * from note order by id desc";
		try {
			PreparedStatement pstmt=
					ds.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			List<NoteVO> list=new ArrayList<NoteVO>();
			while(rs.next()) {
				NoteVO note=new NoteVO();
				note.setId(rs.getInt("id"));
				note.setMemo(rs.getString("memo"));
				note.setWrite_date(rs.getDate("write_date"));
				list.add(note);
			}
			rs.close();
			pstmt.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NoteVO select(int id) {
		String sql="select * from note where id=?";
		try {
			PreparedStatement pstmt=ds.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				NoteVO note=new NoteVO();
				note.setId(rs.getInt("id"));
				note.setMemo(rs.getString("memo"));
				rs.close();
				pstmt.close();
				return note;	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(int id) {
		String sql="delete from note where id=?";
		try {
		PreparedStatement pstmt=ds.getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		int result=pstmt.executeUpdate();
		return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(int id, String memo) {
		String sql="update note set memo=? where id=?";
		try {
		PreparedStatement pstmt=ds.getConnection().prepareStatement(sql);
		pstmt.setString(1, memo);
		pstmt.setInt(2, id);
		int result=pstmt.executeUpdate();
		return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<NoteVO> searchList(String search) {
		String sql="select * from note where memo like '%"+search+"%'";
		try {
			PreparedStatement pstmt=ds.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			List<NoteVO> list=new ArrayList<NoteVO>();
			while(rs.next()) {
				NoteVO note=new NoteVO();
				note.setId(rs.getInt("id"));
				note.setMemo(rs.getString("memo"));
				note.setWrite_date(rs.getDate("write_date"));
				list.add(note);
			}
			rs.close();
			pstmt.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
