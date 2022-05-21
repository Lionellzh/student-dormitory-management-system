package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "baoxiuxinxi_info")
public class BaoxiuxinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "baoxiuhao")	private String baoxiuhao;	@Column(name = "xuehao")	private String xuehao;	@Column(name = "xingming")	private String xingming;	@Column(name = "sushehao")	private String sushehao;	@Column(name = "baoxiuneirong")	private String baoxiuneirong;	@Column(name = "huifu")	private String huifu;	
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

	
	public String getBaoxiuhao() {
        return baoxiuhao;
    }
    public void setBaoxiuhao(String baoxiuhao) {
		this.baoxiuhao = baoxiuhao;
    }	public String getXuehao() {
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
    }	public String getBaoxiuneirong() {
        return baoxiuneirong;
    }
    public void setBaoxiuneirong(String baoxiuneirong) {
		this.baoxiuneirong = baoxiuneirong;
    }	public String getHuifu() {
        return huifu;
    }
    public void setHuifu(String huifu) {
		this.huifu = huifu;
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