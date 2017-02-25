package com.soully.work4.Gson;

/**
 * Created by Soully on 2017/2/9.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cond {

    @SerializedName("code_d")
    @Expose
    private String codeD;
    @SerializedName("code_n")
    @Expose
    private String codeN;
    @SerializedName("txt_d")
    @Expose
    private String txtD;
    @SerializedName("txt_n")
    @Expose
    private String txtN;

    public String getCodeD() {
        return codeD;
    }

    public void setCodeD(String codeD) {
        this.codeD = codeD;
    }

    public String getCodeN() {
        return codeN;
    }

    public void setCodeN(String codeN) {
        this.codeN = codeN;
    }

    public String getTxtD() {
        return txtD;
    }

    public void setTxtD(String txtD) {
        this.txtD = txtD;
    }

    public String getTxtN() {
        return txtN;
    }

    public void setTxtN(String txtN) {
        this.txtN = txtN;
    }

}
