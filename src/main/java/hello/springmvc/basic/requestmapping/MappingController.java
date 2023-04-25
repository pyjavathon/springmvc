package hello.springmvc.basic.requestmapping;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value={"/hello-basic" ,"/hello-go"}, method=RequestMethod.GET)
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}
	
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId")String data) {
		log.info("mappingPath userId={}",data);
		return "ok";
	}
	/**
	 * 
	 * pathVariable 다중 사용
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
		log.info("mappingPath userId{}, orderId{}", userId, orderId);
		return "ok";
	}
	
	
	/**
	 * 파라미터로 추가 매핑
	 * params="mode",
	 * params="!mode",
	 * params="mode=debug",
	 * params="mode != debug",
	 * params={"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}
	
	/**
	 * 특정 헤더로 추가 매핑
	 * headers="mode",
	 * headers="!mode",
	 * headers="mode=debug",
	 * headers="mode != debug"
	 */
	@GetMapping(value="/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}
	//컨트롤러 입장에서 소비하는 , content-type 헤더 기반 추가 매핑
	/**
	 * MediaType.APPLICATION_JSON_VALUE
	 * @return
	 */
	@PostMapping(value = "/mapping-consume", consumes = "application/json")
	public String mappingConsumes() {
		log.info("mappingConsumes");
		return "ok";
	}
	
	
	// 클라이언트가 받아들이는 타입, accept 기반 , MediaType.TEXT_HTML_VALUE
	@PostMapping(value = "/mapping-produce", produces = "application/json")
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
		
	
	
	
}
