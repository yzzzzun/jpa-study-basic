package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 테이블은 연관관계의 방향성이 없지만 객체는 방향성이 있다.
 * 
 * */
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@Column(name = "username")
	private String username;

	//연관관계의 주인이다. 
	//외래키가 있는곳을 주인으로 정해라
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
