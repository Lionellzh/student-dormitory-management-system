package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "gonggongcaiwuxinxi_info")
public class GonggongcaiwuxinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "wupinbianhao")	private String wupinbianhao;	@Column(name = "wupinmingcheng")	private String wupinmingcheng;	@Column(name = "wupinleixing")	private String wupinleixing;	@Column(name = "zhaopian")	private String zhaopian;	@Column(name = "beizhu")	private String beizhu;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Transient private List<Long> zhaopianflst;	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long>  getZhaopianflst() {
        return zhaopianflst;
    }
    public void setZhaopianflst(List<Long> zhaopianflst) {
		this.zhaopianflst = zhaopianflst;
    }

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getWupinbianhao() {
        return wupinbianhao;
    }
    public void setWupinbianhao(String wupinbianhao) {
		this.wupinbianhao = wupinbianhao;
    }	public String getWupinmingcheng() {
        return wupinmingcheng;
    }
    public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
    }	public String getWupinleixing() {
        return wupinleixing;
    }
    public void setWupinleixing(String wupinleixing) {
		this.wupinleixing = wupinleixing;
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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