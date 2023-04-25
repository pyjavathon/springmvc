package hello.springmvc.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {
	
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response)throws IOException{
		
		String username = request.getParameter("username");
		
		int age = Integer.parseInt(request.getParameter("age"));
		
		log.info("username={}, age={}", username, age);
		
		response.getWriter().write("ok");
	}

	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(@RequestParam("username")String memberName,
							   @RequestParam("age") int memberAge) {
		
		log.info("username={}, age={}", memberName, memberAge);
		return "ok";
	}
}
