package sample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class SampleController {
	
	
	@RequestMapping(value = "/sample")
	public String sample(){
		return ("Welcome");
	}
}
