package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCountryDAO;
import com.manex.backend.DAO.TbDistrictDAO;
import com.manex.backend.entities.TbCountry;
import com.manex.backend.entities.TbDistrict;
import com.manex.backend.entities.TbState;
import com.manex.backend.repositories.TbCountryRepository;

import com.manex.backend.repositories.TbDistrictRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TbDistrictService implements TbDistrictDAO {

    @Autowired private TbDistrictRepository tbDistrictRepository;

	@Override
	public JsonObject getAllByState(String stateId, String searchKeyword) {
		List<TbDistrict> tbDistricts =
				tbDistrictRepository.findAllByStateIdAndKeyword(Integer.parseInt(stateId), searchKeyword);

		JsonObject stateObject = new JsonObject();
		JsonArray stateArray = new JsonArray();
		for (TbDistrict tbDistrict : tbDistricts) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("DISTRICT", tbDistrict.getDISTRICT());
			jsonObject.addProperty("ID", tbDistrict.getID());
			stateArray.add(jsonObject);
		}
		stateObject.add("DISTRICT_NAMES", stateArray);
		stateObject.addProperty("NEXT_PAGE", -1);

		return stateObject;
	}
}
