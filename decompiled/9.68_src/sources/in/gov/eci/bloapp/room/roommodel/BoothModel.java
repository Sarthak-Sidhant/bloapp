package in.gov.eci.bloapp.room.roommodel;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class BoothModel {
    public Integer aeroMobileNo;
    public String aeroName;
    public String assemblyConstituency;
    public Integer bloMobNo;
    public String bloName;
    public String boothID;
    public Integer deoMobNo;
    public String deoName;
    public String electionType;
    public Integer electionYear;
    public Integer eroMobNo;
    public String eroName;
    public Long id;
    public String parliamentConstituency;
    public String pollingStation;

    public BoothModel(Long id, String boothID, String aeroName, Integer aeroMobileNo, String bloName, Integer bloMobNo, String eroName, Integer eroMobNo, String deoName, Integer deoMobNo, String assemblyConstituency, String parliamentConstituency, String pollingStation, String electionType, Integer electionYear) {
        this.id = id;
        this.boothID = boothID;
        this.aeroName = aeroName;
        this.aeroMobileNo = aeroMobileNo;
        this.bloName = bloName;
        this.bloMobNo = bloMobNo;
        this.eroName = eroName;
        this.eroMobNo = eroMobNo;
        this.deoName = deoName;
        this.deoMobNo = deoMobNo;
        this.assemblyConstituency = assemblyConstituency;
        this.parliamentConstituency = parliamentConstituency;
        this.pollingStation = pollingStation;
        this.electionType = electionType;
        this.electionYear = electionYear;
    }

    public Long getId() {
        return this.id;
    }

    public String getBoothID() {
        return this.boothID;
    }

    public String getAeroName() {
        return this.aeroName;
    }

    public Integer getAeroMobileNo() {
        return this.aeroMobileNo;
    }

    public String getBloName() {
        return this.bloName;
    }

    public Integer getBloMobNo() {
        return this.bloMobNo;
    }

    public String getEroName() {
        return this.eroName;
    }

    public Integer getEroMobNo() {
        return this.eroMobNo;
    }

    public String getDeoName() {
        return this.deoName;
    }

    public Integer getDeoMobNo() {
        return this.deoMobNo;
    }

    public String getAssemblyConstituency() {
        return this.assemblyConstituency;
    }

    public String getParliamentConstituency() {
        return this.parliamentConstituency;
    }

    public String getPollingStation() {
        return this.pollingStation;
    }

    public String getElectionType() {
        return this.electionType;
    }

    public Integer getElectionYear() {
        return this.electionYear;
    }
}
