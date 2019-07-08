package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import java.util.ArrayList;
import java.util.List;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Entity.BanksEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Entity.TimeWorkEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.BanksModel;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Model.TimeWorkModel;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.TimeWorkResponse;

public class BanksMapperImpl implements BanksMapper {

    public List<BanksEntity> transformResponseBankList(List<BankResponse> bankResponseList){
        if (bankResponseList == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        List<BanksEntity> banksEntities = new ArrayList<>();
        if (!bankResponseList.isEmpty()){
            for (BankResponse bankResponse : bankResponseList){
                banksEntities.add(transformResponseBankToEntity(bankResponse, bankResponse.hashCode()));
            }
        }
        return banksEntities;
    }

    public List<BanksModel> transformEntityBankList(List<BanksEntity> banksEntities){
        if (banksEntities == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        List<BanksModel> banksModels = new ArrayList<>();
        if (!banksEntities.isEmpty()){
            for (BanksEntity banksEntity : banksEntities){
                banksModels.add(transformEntityBankToModel(banksEntity));
            }
        }
        return banksModels;
    }

    @Override
    public BanksEntity transformResponseBankToEntity(BankResponse bankResponse, int hashCode) {
        if (bankResponse == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final BanksEntity banksEntity = new BanksEntity();

        banksEntity.setId(hashCode);
        banksEntity.setType(bankResponse.getType());
        banksEntity.setCityRU(bankResponse.getCityRU());
        banksEntity.setCityUA(bankResponse.getCityUA());
        banksEntity.setCityEN(bankResponse.getCityEN());
        banksEntity.setFullAddressRu(bankResponse.getCityRU());
        banksEntity.setFullAddressUa(bankResponse.getFullAddressUa());
        banksEntity.setFullAddressEn(bankResponse.getFullAddressEn());
        banksEntity.setPlaceRu(bankResponse.getPlaceRu());
        banksEntity.setPlaceUa(bankResponse.getPlaceUa());
        banksEntity.setLatitude(bankResponse.getLatitude());
        banksEntity.setLongitude(bankResponse.getLongitude());
        banksEntity.setTw(transformResponseBankTimeWorkToEntity(bankResponse.getTw()));

        return banksEntity;
    }

    @Override
    public BanksModel transformEntityBankToModel(BanksEntity banksEntity) {
        if (banksEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final BanksModel banksModel= new BanksModel();

        banksModel.setId(banksEntity.getId());
        banksModel.setType(banksEntity.getType());
        banksModel.setCityRU(banksEntity.getCityRU());
        banksModel.setCityUA(banksEntity.getCityUA());
        banksModel.setCityEN(banksEntity.getCityEN());
        banksModel.setFullAddressRu(banksEntity.getCityRU());
        banksModel.setFullAddressUa(banksEntity.getFullAddressUa());
        banksModel.setFullAddressEn(banksEntity.getFullAddressEn());
        banksModel.setPlaceRu(banksEntity.getPlaceRu());
        banksModel.setPlaceUa(banksEntity.getPlaceUa());
        banksModel.setLatitude(banksEntity.getLatitude());
        banksModel.setLongitude(banksEntity.getLongitude());
        banksModel.setTw(transformEntityBankTimeWorkToModel(banksEntity.getTw()));

        return banksModel;
    }

    @Override
    public TimeWorkEntity transformResponseBankTimeWorkToEntity(TimeWorkResponse timeWorkResponse) {
        final TimeWorkEntity timeWorkEntity = new TimeWorkEntity();
        if (timeWorkResponse != null) {
            timeWorkEntity.setFri(timeWorkResponse.getFri());
            timeWorkEntity.setHol(timeWorkResponse.getHol());
            timeWorkEntity.setMon(timeWorkResponse.getMon());
            timeWorkEntity.setSat(timeWorkResponse.getSat());
            timeWorkEntity.setSun(timeWorkResponse.getSun());
            timeWorkEntity.setThu(timeWorkResponse.getThu());
            timeWorkEntity.setTue(timeWorkResponse.getTue());
            timeWorkEntity.setWed(timeWorkResponse.getWed());
        }
        return timeWorkEntity;
    }

    @Override
    public TimeWorkModel transformEntityBankTimeWorkToModel(TimeWorkEntity timeWorkEntity) {
        final TimeWorkModel timeWorkModel= new TimeWorkModel();
        if (timeWorkEntity != null) {
            timeWorkModel.setFri(timeWorkEntity.getFri());
            timeWorkModel.setHol(timeWorkEntity.getHol());
            timeWorkModel.setMon(timeWorkEntity.getMon());
            timeWorkModel.setSat(timeWorkEntity.getSat());
            timeWorkModel.setSun(timeWorkEntity.getSun());
            timeWorkModel.setThu(timeWorkEntity.getThu());
            timeWorkModel.setTue(timeWorkEntity.getTue());
            timeWorkModel.setWed(timeWorkEntity.getWed());
        }
        return timeWorkModel;
    }
}