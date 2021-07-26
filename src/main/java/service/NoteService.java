package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NoteDAO;
import vo.NoteVO;
@Service
public class NoteService {

	@Autowired
	NoteDAO notedao;
	
	public int insert(String memo) {
		return notedao.insert(memo);
		
	}

	public List<NoteVO> getList() {
		return notedao.getList();
	}

	public NoteVO select(int id) {
		return notedao.select(id);
		
	}

	public int delete(int id) {
		return notedao.delete(id);
		
	}

	public int update(int id, String memo) {
		return notedao.update(id, memo);
		
	}

	public List<NoteVO> searchList(String search) {
		return notedao.searchList(search);
		
	}
}
