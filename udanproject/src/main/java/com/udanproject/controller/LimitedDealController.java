package com.udanproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udanproject.dto.Items;
import com.udanproject.dto.UserDeal;
import com.udanproject.entity.Deal;
import com.udanproject.service.LimitedDealService;

@RestController
@RequestMapping("/api")
public class LimitedDealController {

	@Autowired
	LimitedDealService limitedDealService;

	@PostMapping("limiteddeal/createdeal")
	public Deal createDeal(@RequestBody Items items) {

		return limitedDealService.createDeal(items);

	}

	@PostMapping("limiteddeal/enddeal")
	public String endDeal(@RequestBody Items items) {
		limitedDealService.endDeal(items);
		return "Deal is ended";

	}

	@PostMapping("limiteddeal/purchasedeal")
	public String purchaseDeal(@RequestBody UserDeal userDeal) {
		limitedDealService.purchaseDeal(userDeal);
		return "Deal is ended";

	}

}
