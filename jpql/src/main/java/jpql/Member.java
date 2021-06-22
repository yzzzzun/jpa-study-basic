/**
* FileName : MEmber.java
* Created  : 2021. 1. 17.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/ 
package jpql;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author youngjun.jin
 */
@Entity
public class Member {

	@Id @GeneratedValue
	private Long id;
	
	private String username;
	
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}

	/**
	 * id를 반환합니다.
	 * @author youngjun.jin
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * id 초기화 합니다.
	 * @author youngjun.jin
	 * @param id 초기화 값
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * username를 반환합니다.
	 * @author youngjun.jin
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * username 초기화 합니다.
	 * @author youngjun.jin
	 * @param username 초기화 값
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * age를 반환합니다.
	 * @author youngjun.jin
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * age 초기화 합니다.
	 * @author youngjun.jin
	 * @param age 초기화 값
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member{" +
			"id=" + id +
			", username='" + username + '\'' +
			", age=" + age +
			'}';
	}
}
