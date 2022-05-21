package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jiaofeixinxi_info")
public class JiaofeixinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "xuehao")	private String xuehao;	@Column(name = "xingming")	private String xingming;	@Column(name = "sushehao")	private String sushehao;	@Column(name = "jiaofeileixing")	private String jiaofeileixing;	@Column(name = "feiyong")	private String feiyong;	@Column(name = "iszf")	private String iszf;	
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
    }	public String getJiaofeileixing() {
        return jiaofeileixing;
    }
    public void setJiaofeileixing(String jiaofeileixing) {
		this.jiaofeileixing = jiaofeileixing;
    }	public String getFeiyong() {
        return feiyong;
    }
    public void setFeiyong(String feiyong) {
		this.feiyong = feiyong;
    }	public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
		this.iszf = iszf;
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