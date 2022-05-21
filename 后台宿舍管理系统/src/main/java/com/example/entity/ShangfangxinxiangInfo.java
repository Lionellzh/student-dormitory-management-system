package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "shangfangxinxiang_info")
public class ShangfangxinxiangInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "shangfangbianhao")	private String shangfangbianhao;	@Column(name = "shangfangbiaoti")	private String shangfangbiaoti;	@Column(name = "shangfangneirong")	private String shangfangneirong;	
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

	
	public String getShangfangbianhao() {
        return shangfangbianhao;
    }
    public void setShangfangbianhao(String shangfangbianhao) {
		this.shangfangbianhao = shangfangbianhao;
    }	public String getShangfangbiaoti() {
        return shangfangbiaoti;
    }
    public void setShangfangbiaoti(String shangfangbiaoti) {
		this.shangfangbiaoti = shangfangbiaoti;
    }	public String getShangfangneirong() {
        return shangfangneirong;
    }
    public void setShangfangneirong(String shangfangneirong) {
		this.shangfangneirong = shangfangneirong;
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