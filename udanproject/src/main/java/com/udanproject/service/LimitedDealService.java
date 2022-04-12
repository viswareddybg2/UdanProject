package com.udanproject.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udanproject.dto.UserDeal;
import com.udanproject.entity.Deal;
import com.udanproject.entity.Items;
import com.udanproject.entity.PurchaseHistory;
import com.udanproject.repo.DealRepo;
import com.udanproject.repo.ItemsRepo;
import com.udanproject.repo.PurchaseHistoryRepo;
import com.udanproject.repo.UserRepo;

@Service
public class LimitedDealService {

	@Autowired
	ItemsRepo itemsRepo;

	@Autowired
	UserRepo userRepo;
	@Autowired
	PurchaseHistoryRepo purchaseHistoryRepo;
	@Autowired
	DealRepo dealRepo;

	public Deal createDeal(com.udanproject.dto.Items items) {

		Deal deal = new Deal();
		deal.setCount(items.getCount());
		deal.setName(items.getName());

		deal.setPrice(items.getPrice());
		LocalDateTime date = LocalDateTime.now();
		date.plusHours(items.getTimeDuration());
		Date date1 = Date.valueOf(date.toLocalDate());
		deal.setDealTime(date1);
		deal.setDealStatus(true);

		return dealRepo.save(deal);

	}

	public Deal endDeal(com.udanproject.dto.Items items) {

		Deal deal = new Deal();

		deal.setDealStatus(false);

		return dealRepo.save(deal);

	}

	public String purchaseDeal(UserDeal userDeal) {

		if (userDeal.getQuantity() > 1) {
			return "Maximum allowed only one per item";
		}
		Optional<PurchaseHistory> purchaseHistory = purchaseHistoryRepo.findById(userDeal.getUserId());
		PurchaseHistory purchaseHistory2 = purchaseHistory.get();

		if (purchaseHistory2.getItems().contains(userDeal.getItemId())) {
			return "Maximum allowed per user one item only";
		}

		PurchaseHistory history = new PurchaseHistory();
		List<Items> items = purchaseHistory2.getItems();

		// items.add(item);
		history.setUserId(userDeal.getUserId());
		history.setItems(null);

		return null;

	}

}
