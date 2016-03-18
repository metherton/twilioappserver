package com.martinetherton;

/**
 * Created by martin on 18/03/16.
 */
public class FeedbackMessage {

//    vm.customerDetails = {
//        id: "1234567",
//                department: "ROSETTA",
//                channelType: "CALL",
//                corpKey: "DT10DW"
//    };

    private String id;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;
    private String channelType;

    public String getCorpKey() {
        return corpKey;
    }

    public void setCorpKey(String corpKey) {
        this.corpKey = corpKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    private String corpKey;

}
