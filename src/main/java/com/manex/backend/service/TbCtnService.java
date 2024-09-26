package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCtnDAO;
import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class TbCtnService implements TbCtnDAO {

    @Autowired private TbCtnRepository tbCtnRepository;

    @Autowired private TbMmDAO tbMmDAO;

    @Override
    public XscResponse add(HttpServletRequest request, JSONObject payload) throws IOException {
        XscResponse response = new XscResponse();

        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        TbMm tbMm = new TbMm();
        if (file != null) {
            tbMm =
                    tbMmDAO.saveImageFileWithName(
                            "ctnImages", file, payload.get("ALIAS_NAME").toString(), null);
        }

        TbCtn tbCtn = new TbCtn();
        tbCtn.setAPP_CLIENT_ID(payload.getInt("APP_CLIENT_ID"));
        tbCtn.setALIAS_NAME(payload.getString("ALIAS_NAME"));
        tbCtn.setDESCRIPTION(payload.getString("DESCRIPTION"));
        tbCtn.setLENGTH(payload.getFloat("LENGTH"));
        tbCtn.setWIDTH(payload.getFloat("WIDTH"));
        tbCtn.setHEIGHT(payload.getFloat("HEIGHT"));
        tbCtn.setSIZE_UNIT(SizeUnit.valueOf(payload.getString("SIZE_UNIT").toUpperCase()));
        tbCtn.setVOLUME(payload.getFloat("VOLUME"));
        tbCtn.setVOLUME_UNIT(VolumeUnit.valueOf(payload.getString("VOLUME_UNIT").toUpperCase()));
        tbCtn.setMAX_WEIGHT_CAPACITY(payload.getFloat("MAX_WEIGHT_CAPACITY"));
        tbCtn.setMAX_WEIGHT_CAPACITY_UNIT(
                WeightUnit.valueOf(payload.getString("MAX_WEIGHT_CAPACITY_UNIT").toUpperCase()));
        tbCtn.setCTN_ICON(tbMm.getID());

        tbCtnRepository.save(tbCtn);

        response.setXscMessage("Carton added successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getCartons(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<TbCtn> tbCtnList =
                tbCtnRepository.findByAppClientId(payload.get("APP_CLIENT_ID").toString());

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();

        for (TbCtn tbCtn : tbCtnList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("ID", tbCtn.getID());
            jsonObject.addProperty("ALIAS_NAME", tbCtn.getALIAS_NAME());
            jsonArray.add(jsonObject);
        }

        data.add("CTN_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Container list updated.");
        response.setXscStatus(1);
        return response;
    }
}
