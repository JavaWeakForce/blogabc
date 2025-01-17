/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class SpecialTalk implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String attachment;
	private Date createTime;
	//作业
	private String exercise;
	//介绍
	private String howto;
	//引入
	private String introduction;

	private String persons;

	public String getAttachment() {
		return attachment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getExercise() {
		return exercise;
	}

	public String getHowto() {
		return howto;
	}

	public Long getId() {
		return id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getPersons() {
		return persons;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public void setHowto(String howto) {
		this.howto = howto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setPersons(String persons) {
		this.persons = persons;
	}
}
