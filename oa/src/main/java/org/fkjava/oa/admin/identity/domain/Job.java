package org.fkjava.oa.admin.identity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 职位
 */
@Entity
@Table(name = "OA_ID_JOB")
public class Job implements Serializable {
	
	private static final long serialVersionUID = 459497377750274376L;

	/** 代码	PK主键由系统自动生成 (0001...0002)四位为模块 */
	@Id
	@Column(name = "CODE", length = 100)
	private String code;

	/** 名称 */
	@Column(name = "NAME", length = 50)
	private String name;

	/** 职位说明 */
	@Column(name = "REMARK", length = 300)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
