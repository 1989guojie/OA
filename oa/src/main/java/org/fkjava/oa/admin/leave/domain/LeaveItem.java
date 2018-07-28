package org.fkjava.oa.admin.leave.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.fkjava.oa.admin.identity.domain.User;
/**
 * 假期明细实体
 */
@Entity 
@Table(name="OA_LEAVE_ITEM")
public class LeaveItem implements Serializable {

	private static final long serialVersionUID = -9112038856826694159L;

	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// 假期明细与假期类型存在多对一关联
	@ManyToOne(targetEntity=LeaveType.class, fetch=FetchType.LAZY)
	@JoinColumn(name="TYPE_CODE", referencedColumnName="CODE", 
			foreignKey=@ForeignKey(name="FK_LEAVE_ITEM_TYPE"))
	private LeaveType leaveType;
	
	/** 开始日期 */
	@Column(name="BEGIN_DATE")
	private Date beginDate;
	
	/** 结束日期 */
	@Column(name="END_DATE")
	private Date endDate;
	
	/** 请假小时 */
	@Column(name="LEAVE_HOUR")
	private Float leaveHour;
	
	/** 请假原因 */
	@Column(name="LEAVE_CASE", length=300)
	private String leaveCase;
	
	/** 状态 */
	@Column(name="STATUS")
	private Integer status;
	
	/** 备注 */
	@Column(name="REMARK", length=500)
	private String remark;
	
	/** 修改日期 */
	@Column(name="MODIFY_DATE")
	private Date modifyDate;
	
	/** 修改人 */
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="MODIFIER", referencedColumnName="USER_ID",
			foreignKey=@ForeignKey(name="FK_LEAVE_ITEM_MODIFIER"))
	private User modifier;
	
	/** 审核日期 */
	@Column(name="CHECK_DATE")
	private Date checkDate;
	
	/** 审核人 */
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="CHECKER", referencedColumnName="USER_ID",
			foreignKey=@ForeignKey(name="FK_LEAVE_ITEM_CHECKER"))
	private User checker;
	
	/** 创建日期 */
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	/** 创建人 */
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY)
	@JoinColumn(name="CREATER", referencedColumnName="USER_ID",
			foreignKey=@ForeignKey(name="FK_LEAVE_ITEM_CREATER"))
	private User creater;
	
	@Column(name="PI_ID", length=100)
	private String piId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Float getLeaveHour() {
		return leaveHour;
	}
	public void setLeaveHour(Float leaveHour) {
		this.leaveHour = leaveHour;
	}
	public String getLeaveCase() {
		return leaveCase;
	}
	public void setLeaveCase(String leaveCase) {
		this.leaveCase = leaveCase;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public User getModifier() {
		return modifier;
	}
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public User getChecker() {
		return checker;
	}
	public void setChecker(User checker) {
		this.checker = checker;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	public String getPiId() {
		return piId;
	}
	public void setPiId(String piId) {
		this.piId = piId;
	}
}