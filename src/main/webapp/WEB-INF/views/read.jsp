<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
    <form method="post" name="form">
	    <nav>
	        <div>
	            <input type="submit" value="저장" onclick="javascript: form.action='update?id=${memo.id}'">
	            <input type="submit" value="삭제" onclick="javascript: form.action='delete?id=${memo.id}'">
	        </div>
	    </nav>
	    <div id="memo">
	        <textarea name="memo">${memo.memo}</textarea>
	    </div>
    </form>
</section>
