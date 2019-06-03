package com.dtxw.entity;

public class Reserve_Multiple {
    String PATH;
    long CURRENT_NO;
    long TOTAL_NO;
    long TYPE;
    long TYPE_2;
    long TYPE_4;
    long TYPE_6;
    long TYPE_8;
    long TYPE_MORE;
    String NAME;

    public Reserve_Multiple plusCurrent_NO()
    {
        this.CURRENT_NO++;
        return this;
    }

    public Reserve_Multiple plusTotal_NO()
    {
        this.TOTAL_NO++;
        return this;
    }

    public long GET_TYPE(int number)
    {
        switch (number)
        {
            case 0 :
                return this.TYPE_2;
            case 1:
                return this.TYPE_4;
            case 2:
                return this.TYPE_6;
            case 3:
                return this.TYPE_8;
            default:
                return this.TYPE_MORE;
        }
    }

    public int testNULL(int type)
    {
        return (int)GET_TYPE(type);
    }

    public Reserve_Multiple Process_TYPE_VALUE(int type)
    {
        switch (type)
        {
            case 0 :
                this.TYPE_2--;
                break;
            case 1:
                this.TYPE_4--;
                break;
            case 2:
                this.TYPE_6--;
                break;
            case 3:
                this.TYPE_8--;
                break;
            default:
                this.TYPE_MORE--;
                break;
        }
        return this;
    }

    public Reserve_Multiple setTYPE_VALUE(int type)
    {
        switch (type)
        {
            case 0 :
                this.TYPE_2++;
                break;
            case 1:
                this.TYPE_4++;
                break;
            case 2:
                this.TYPE_6++;
                break;
            case 3:
                this.TYPE_8++;
                break;
                default:
                    this.TYPE_MORE++;
                    break;
        }
        return this;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public long getCURRENT_NO() {
        return CURRENT_NO;
    }

    public void setCURRENT_NO(long CURRENT_NO) {
        this.CURRENT_NO = CURRENT_NO;
    }

    public long getTOTAL_NO() {
        return TOTAL_NO;
    }

    public void setTOTAL_NO(long TOTAL_NO) {
        this.TOTAL_NO = TOTAL_NO;
    }

    public long getTYPE() {
        return TYPE;
    }

    public void setTYPE(long TYPE) {
        this.TYPE = TYPE;
    }

    public long getTYPE_2() {
        return TYPE_2;
    }

    public void setTYPE_2(long TYPE_2) {
        this.TYPE_2 = TYPE_2;
    }

    public long getTYPE_4() {
        return TYPE_4;
    }

    public void setTYPE_4(long TYPE_4) {
        this.TYPE_4 = TYPE_4;
    }

    public long getTYPE_6() {
        return TYPE_6;
    }

    public void setTYPE_6(long TYPE_6) {
        this.TYPE_6 = TYPE_6;
    }

    public long getTYPE_8() {
        return TYPE_8;
    }

    public void setTYPE_8(long TYPE_8) {
        this.TYPE_8 = TYPE_8;
    }

    public long getTYPE_MORE() {
        return TYPE_MORE;
    }

    public void setTYPE_MORE(long TYPE_MORE) {
        this.TYPE_MORE = TYPE_MORE;
    }

    @Override
    public String toString() {
        return "Reserve_Multiple{" +
                "PATH='" + PATH + '\'' +
                ", CURRENT_NO=" + CURRENT_NO +
                ", TOTAL_NO=" + TOTAL_NO +
                ", TYPE=" + TYPE +
                ", TYPE_2=" + TYPE_2 +
                ", TYPE_4=" + TYPE_4 +
                ", TYPE_6=" + TYPE_6 +
                ", TYPE_8=" + TYPE_8 +
                ", TYPE_MORE=" + TYPE_MORE +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
