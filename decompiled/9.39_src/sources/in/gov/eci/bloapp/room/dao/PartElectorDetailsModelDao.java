package in.gov.eci.bloapp.room.dao;

import in.gov.eci.bloapp.model.ElectroleDeatils.PartElectorDetailsModel;
import in.gov.eci.bloapp.model.app_model.HouseModel;
import in.gov.eci.bloapp.model.app_model.ViewFamilyMemberListModel;
import java.util.List;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public interface PartElectorDetailsModelDao {
    void addPartElecorDetails(PartElectorDetailsModel.Items partElectorDetailsModel);

    void deletePartElecorDetails(String partNo, String bloId);

    List<PartElectorDetailsModel.Items> getAllElectorDetails(String partNo, String bloId);

    List<HouseModel> getAllElectorDetails1(String partNumber);

    List<HouseModel> getAllSearchElectorDetails1(String partNumber);

    List<HouseModel> getAllVerifiedElectorDetails(String partNumber);

    List<HouseModel> getAllVerifiedSearchElectorDetails1(String partNumber);

    List<ViewFamilyMemberListModel> getElectorDetails(String epicNo);

    List<PartElectorDetailsModel.Items> getLastModifiedDate(String partNo, String bloId);

    List<ViewFamilyMemberListModel> getNonVerifiedElectorDetails(String houseno, String secNo);

    List<PartElectorDetailsModel.Items> getNonVerifiedElectorDetails22(String epicNo);

    void insertElecorDetails(PartElectorDetailsModel.Items partElectorDetailsModel);

    void updatePartElecorDetails(PartElectorDetailsModel.Items partElectorDetailsModel);
}
