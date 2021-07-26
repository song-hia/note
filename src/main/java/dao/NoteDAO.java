package dao;

import java.util.List;

import vo.NoteVO;

public interface NoteDAO {

	int insert(String memo);
	List<NoteVO> getList();
	NoteVO select(int id);
	int delete(int id);
	int update(int id, String memo);
	List<NoteVO> searchList(String search);


}
