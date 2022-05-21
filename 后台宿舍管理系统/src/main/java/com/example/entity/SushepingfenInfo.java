package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "sushepingfen_info")
public class SushepingfenInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sushehao")	private String sushehao;	@Column(name = "pingfen")	private String pingfen;	@Column(name = "youxiusushe")	private String youxiusushe;	
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

	
	public String getSushehao() {
        return sushehao;
    }
    public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
    }	public String getPingfen() {
        return pingfen;
    }
    public void setPingfen(String pingfen) {
		this.pingfen = pingfen;
    }	public String getYouxiusushe() {
        return youxiusushe;
    }
    public void setYouxiusushe(String youxiusushe) {
		this.youxiusushe = youxiusushe;
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