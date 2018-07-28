package org.fkjava.oa.admin.identity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 部门
 */
@Entity
@Table(name = "OA_ID_DEPT")
public class Dept implements Serializable {

	private static final long serialVersionUID = 7477473487065606251L;

	/** 编号	PK主键自增长 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // 根据方言选择，自增长策略
	@Column(name="ID")
	private Long id;

	/** 部门名称  */
	@Column(name="NAME", length=50)
	private String name;

	/** 备注  */
	@Column(name="REMARK", length=500)
	private String remark;

	/** 修改人与用户存在N-1关系  FK(OA_ID_USER) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="MODIFIER", referencedColumnName="USER_ID", foreignKey=@ForeignKey(name="FK_DEPT_MODIFIER"))  // 外键列，指定外键，引用主表的主键列，更改外键约束名
	private User modifier;
	
	/** 修改时间 */
	@Column(name="MODIFY_DATE", length=50)
	@Temporal(TemporalType.TIMESTAMP) // 有年月日时分秒
	private Date modifierDate;

	/** 创建人与用户存在N-1关系  FK(OA_ID_USER) */
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="CREATER", referencedColumnName="USER_ID", foreignKey=@ForeignKey(name="FK_DEPT_CREATER"))  // 外键列，指定外键，引用主表的主键列，更改外键约束名
	private User creater;
	
	/** 创建时间 */
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP) // 有年月日时分秒
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public Date getModifierDate() {
		return modifierDate;
	}

	public void setModifierDate(Date modifierDate) {
		this.modifierDate = modifierDate;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
