package timestamps.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import timestamps.dao.impl.EntityDAOImpl;

@Controller
@RequestMapping("/collect")
public class StatisticsController {
	@Autowired
	EntityDAOImpl entityDAOImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {

		model.addAttribute("theme", entityDAOImpl.getByID(BigInteger.valueOf(1)));
		return "hello";
	}
}
