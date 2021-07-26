package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.NoteService;
import vo.NoteVO;

@Controller
public class IndexController {

	@Autowired
	NoteService noteservice;
	
	@RequestMapping("index")
	public ModelAndView index() {
		String page="section.jsp";
		ModelAndView mv=new ModelAndView();
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("section",page);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("writeForm")
	public ModelAndView writeForm() {
		String page="writeForm.jsp";
		ModelAndView mv=new ModelAndView();
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("section",page);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("insert")
	public ModelAndView insert(String memo) {
		String page="section.jsp";
		ModelAndView mv=new ModelAndView();
		noteservice.insert(memo);
		
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("section",page);
	    mv.setViewName("index");
		return mv;
	}
	@RequestMapping("read")
	public ModelAndView read(int id) {
		String page="read.jsp";
		ModelAndView mv=new ModelAndView();
		
		NoteVO memo=noteservice.select(id);
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("memo",memo);
		mv.addObject("section",page);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("delete")
	public ModelAndView delete(int id) {
		String page="section.jsp";
		ModelAndView mv=new ModelAndView();
		noteservice.delete(id);
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("section",page);
	    mv.setViewName("index");
		return mv;
	}
	@RequestMapping("update")
	public ModelAndView update(int id, String memo) {
		String page="section.jsp";
		ModelAndView mv=new ModelAndView();
		noteservice.update(id, memo);
		List<NoteVO> list=noteservice.getList();
		mv.addObject("list",list);
		mv.addObject("section",page);
	    mv.setViewName("index");
		return mv;

	}
	@RequestMapping("searchlist")
	public ModelAndView searchlist(String search) {
		String page="section.jsp";
		ModelAndView mv=new ModelAndView();
		List<NoteVO> list=noteservice.searchList(search);
		mv.addObject("list",list);
		mv.addObject("section",page);
	    mv.setViewName("index");
		return mv;
	}
}
