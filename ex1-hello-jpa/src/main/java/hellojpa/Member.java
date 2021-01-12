package hellojpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 테이블은 연관관계의 방향성이 없지만 객체는 방향성이 있다.
 * 
 */
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Embedded
	private Period workPeriod;

	@Embedded
	private Address homeAddress;

	/**
	 * id를 반환합니다.
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * id 초기화 합니다.
	 * 
	 * @param id 초기화 값
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * username를 반환합니다.
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * username 초기화 합니다.
	 * 
	 * @param username 초기화 값
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * workPeriod를 반환합니다.
	 * 
	 * @return workPeriod
	 */
	public Period getWorkPeriod() {
		return this.workPeriod;
	}

	/**
	 * workPeriod 초기화 합니다.
	 * 
	 * @param workPeriod 초기화 값
	 */
	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	/**
	 * homeAddress를 반환합니다.
	 * 
	 * @return homeAddress
	 */
	public Address getHomeAddress() {
		return this.homeAddress;
	}

	/**
	 * homeAddress 초기화 합니다.
	 * 
	 * @param homeAddress 초기화 값
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

}
