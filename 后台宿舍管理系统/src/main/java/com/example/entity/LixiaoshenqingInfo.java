package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "lixiaoshenqing_info")
public class LixiaoshenqingInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "xuehao")	private String xuehao;	@Column(name = "xingming")	private String xingming;	@Column(name = "sushehao")	private String sushehao;	@Column(name = "banji")	private String banji;	@Column(name = "fangjianhao")	private String fangjianhao;	@Column(name = "shenqingleixing")	private String shenqingleixing;	@Column(name = "shenqingliyou")	private String shenqingliyou;	@Column(name = "shenqingriqi")	private String shenqingriqi;	
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
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
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
    }	public String getShenqingleixing() {
        return shenqingleixing;
    }
    public void setShenqingleixing(String shenqingleixing) {
		this.shenqingleixing = shenqingleixing;
    }	public String getShenqingliyou() {
        return shenqingliyou;
    }
    public void setShenqingliyou(String shenqingliyou) {
		this.shenqingliyou = shenqingliyou;
    }	public String getShenqingriqi() {
        return shenqingriqi;
    }
    public void setShenqingriqi(String shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
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