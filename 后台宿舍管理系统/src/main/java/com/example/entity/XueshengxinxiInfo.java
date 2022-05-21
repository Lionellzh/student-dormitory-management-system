package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "xueshengxinxi_info")
public class XueshengxinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "xuehao")	private String xuehao;	@Column(name = "mima")	private String mima;	@Column(name = "xingming")	private String xingming;	@Column(name = "xingbie")	private String xingbie;	@Column(name = "shenfenzheng")	private String shenfenzheng;	@Column(name = "dianhua")	private String dianhua;	@Column(name = "sushehao")	private String sushehao;	@Column(name = "banji")	private String banji;	@Column(name = "fangjianhao")	private String fangjianhao;	@Column(name = "jiankangma")	private String jiankangma;	@Column(name = "beizhu")	private String beizhu;	@Column(name = "level")	private String level;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//gextsexttpzidxuan

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getXuehao() {
        return xuehao;
    }
    public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }	public String getDianhua() {
        return dianhua;
    }
    public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
    }	public String getSushehao() {
        return sushehao;
    }
    public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
    }	public String getBanji() {
        return banji;
    }
    public void setBanji(String banji) {
		this.banji = banji;
    }	public String getFangjianhao() {
        return fangjianhao;
    }
    public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
    }	public String getJiankangma() {
        return jiankangma;
    }
    public void setJiankangma(String jiankangma) {
		this.jiankangma = jiankangma;
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
    }	public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
		this.level = level;
    }	

	public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

}