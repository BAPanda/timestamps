package timestamps.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import timestamps.dao.impl.EntityDAOImpl;
import timestamps.kafkaintegration.Producer;
import timestamps.models.Statistics;


@Controller
@RequestMapping("/collect")
public class StatisticsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(@RequestParam("entId") BigInteger entId,
			                 @RequestParam("timestamp") long timestamp,
			                 @RequestParam("temper") double temper,
			                 @RequestParam("space") double space,
			                 @RequestParam("ram") double ram,
			                 ModelMap model) throws FileNotFoundException, IOException {
		
		Statistics stat = new Statistics(entId, timestamp, temper, space, ram);
		
		Producer prod = new Producer();
		prod.send(stat);
		
		return "hello";
	}
}
